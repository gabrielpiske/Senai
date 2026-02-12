// Controle de Motor de Passo bipolar Minebea com ESP32 + A4988
// Três botões: Start/Stop, Horário, Anti-horário
// API REST para rotacionar X passos horário/anti-horário usando WebServer padrão
// 2270 passos -> Giro de 120°
// Monte no Postman a URL http://<ip>/api/rotate?passos=XXXX&direcao=Y.
// Exemplo: URL http://10.74.241.245/api/rotate?passos=2270&direcao=1.

// Como funciona:
// /api/rotate?passos=100&direcao=-1 → gira o motor a quantidade de passos definida.
// /api/move_pos?pos=2 → move apenas anti-horário até atingir a condição de fim-de-curso 2 ativo.
// BTN_START_STOP a cada toque avança para a próxima posição.
//----------------------- Código corrigido para rampa de aceleração no início do movimento --------------------------------------------
#include <Arduino.h>
#include <WiFi.h>
#include <WebServer.h>

// ---- Pinos Driver A4988 ----
#define STEP_PIN 5
#define DIR_PIN  22

// ---- Pinos LED RGB ----
#define LED_R 25
#define LED_G 26
#define LED_B 27

// ---- Botões ----
#define BTN_START_STOP   15   // agora = POS1
#define BTN_HORARIO      16   // agora = POS2
#define BTN_ANTIHORARIO  19   // agora = POS3

// ---- Fim-de-curso ----
#define FIM_CURSO1 0
#define FIM_CURSO2 4
#define FIM_CURSO3 17

// ---- Motor ----
int delayPasso = 500; // microssegundos entre pulsos
volatile int direcaoAtual = -1; // sempre anti-horário
volatile bool moverParaPOS = false;
volatile int POS = 0;

// ---- Controle de rampa ----
int delayInicial = 2000;
int delayFinal   = 1000;
int passosRampa  = 150;

// ---- WiFi e Servidor ----
const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

IPAddress local_IP(10, 74, 241, 245);
IPAddress gateway(10, 74, 241, 254);
IPAddress subnet(255, 255, 255, 0);
IPAddress primaryDNS(8,8,8,8);
IPAddress secondaryDNS(8,8,4,4);

WebServer server(80);

// ---- Resultado JSON ----
String lastMoveResult = "{}";

// ---- RTOS ----
TaskHandle_t handleTaskMotor;

// ---- Debounce ----
volatile unsigned long lastInterruptTime = 0;
const unsigned long debounceDelay = 200;

// ------------------- Funções Auxiliares ----------------
void setLedStatus(int r, int g, int b) {
  digitalWrite(LED_R, r);
  digitalWrite(LED_G, g);
  digitalWrite(LED_B, b);
}

int lerPOSAtual() {
  if (digitalRead(FIM_CURSO1) == LOW) return 1;
  if (digitalRead(FIM_CURSO2) == LOW) return 2;
  if (digitalRead(FIM_CURSO3) == LOW) return 3;
  return 0;
}

bool atingiuPosicaoDesejada() {
  return (lerPOSAtual() == POS);
}

// ------------------- Movimento ----------------
void moverComRampa(int dir) {
  digitalWrite(DIR_PIN, (dir == 1) ? HIGH : LOW);

  int delayAtual = delayInicial;
  int decremento = (delayInicial - delayFinal) / passosRampa;

  bool emAceleracao = true;
  int passosDados = 0;

  while (!atingiuPosicaoDesejada() && moverParaPOS) {
    digitalWrite(STEP_PIN, HIGH);
    delayMicroseconds(delayAtual);
    digitalWrite(STEP_PIN, LOW);
    delayMicroseconds(delayAtual);

    passosDados++;

    if (emAceleracao) {
      if (passosDados < passosRampa) {
        delayAtual -= decremento;
        if (delayAtual < delayFinal) delayAtual = delayFinal;
      } else {
        delayAtual = delayFinal;
        emAceleracao = false;
      }
    } else {
      delayAtual = delayFinal;
    }
  }
}

// ------------------- Interrupções Botões ----------------
void IRAM_ATTR botaoPos1ISR() {
  unsigned long now = millis();
  if (now - lastInterruptTime > debounceDelay) {
    POS = 1;
    moverParaPOS = true;
    direcaoAtual = -1;
    setLedStatus(LOW, HIGH, LOW);
    lastInterruptTime = now;
    Serial.println("Botão POS1 pressionado");
  }
}

void IRAM_ATTR botaoPos2ISR() {
  unsigned long now = millis();
  if (now - lastInterruptTime > debounceDelay) {
    POS = 2;
    moverParaPOS = true;
    direcaoAtual = -1;
    setLedStatus(LOW, HIGH, LOW);
    lastInterruptTime = now;
    Serial.println("Botão POS2 pressionado");
  }
}

void IRAM_ATTR botaoPos3ISR() {
  unsigned long now = millis();
  if (now - lastInterruptTime > debounceDelay) {
    POS = 3;
    moverParaPOS = true;
    direcaoAtual = -1;
    setLedStatus(LOW, HIGH, LOW);
    lastInterruptTime = now;
    Serial.println("Botão POS3 pressionado");
  }
}

// ------------------- Fim-de-curso ----------------
void IRAM_ATTR fimCursoISR() {
  // Placeholder
}

// ------------------- API REST ----------------
void handleMovePos() {
  if (server.hasArg("pos")) {
    POS = server.arg("pos").toInt();
    if (POS < 1 || POS > 3) {
      server.send(400, "application/json", "{\"error\":\"POS deve ser 1, 2 ou 3\"}");
      return;
    }
    moverParaPOS = true;
    direcaoAtual = -1;
    setLedStatus(LOW, HIGH, LOW);
    server.send(200, "application/json", "{\"status\":\"Ok. Posição selecionada\"}");
    Serial.printf("API move_pos -> POS=%d\n", POS);
  } else {
    server.send(400, "application/json", "{\"error\":\"Parametro faltando (pos)\"}");
  }
}

void handleLastResult() {
  server.send(200, "application/json", lastMoveResult);
}

// ------------------- Task Motor ----------------
void taskMotorCode(void *pvParameters) {
  for (;;) {
    if (moverParaPOS) {
      moverComRampa(direcaoAtual);

      moverParaPOS = false;

      int posAtual = lerPOSAtual();
      lastMoveResult = "{";
      lastMoveResult += "\"status\":\"POS atingida\",";
      lastMoveResult += "\"pos_solicitada\":" + String(POS) + ",";
      lastMoveResult += "\"pos_atual\":" + String(posAtual) + ",";
      lastMoveResult += "\"fim_curso1\":" + String(digitalRead(FIM_CURSO1) == LOW ? 1 : 0) + ",";
      lastMoveResult += "\"fim_curso2\":" + String(digitalRead(FIM_CURSO2) == LOW ? 1 : 0) + ",";
      lastMoveResult += "\"fim_curso3\":" + String(digitalRead(FIM_CURSO3) == LOW ? 1 : 0);
      lastMoveResult += "}";

      Serial.println(lastMoveResult);

      setLedStatus(LOW, LOW, HIGH); // azul = finalizado
    }
    vTaskDelay(1);
  }
}

// ------------------- Setup ----------------
void setup() {
  Serial.begin(115200);

  pinMode(STEP_PIN, OUTPUT);
  pinMode(DIR_PIN, OUTPUT);

  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);
  setLedStatus(HIGH, LOW, LOW);

  pinMode(BTN_START_STOP, INPUT_PULLUP);
  pinMode(BTN_HORARIO, INPUT_PULLUP);
  pinMode(BTN_ANTIHORARIO, INPUT_PULLUP);

  pinMode(FIM_CURSO1, INPUT_PULLUP);
  pinMode(FIM_CURSO2, INPUT_PULLUP);
  pinMode(FIM_CURSO3, INPUT_PULLUP);

  attachInterrupt(digitalPinToInterrupt(BTN_START_STOP), botaoPos1ISR, FALLING);
  attachInterrupt(digitalPinToInterrupt(BTN_HORARIO), botaoPos2ISR, FALLING);
  attachInterrupt(digitalPinToInterrupt(BTN_ANTIHORARIO), botaoPos3ISR, FALLING);

  attachInterrupt(digitalPinToInterrupt(FIM_CURSO1), fimCursoISR, FALLING);
  attachInterrupt(digitalPinToInterrupt(FIM_CURSO2), fimCursoISR, FALLING);
  attachInterrupt(digitalPinToInterrupt(FIM_CURSO3), fimCursoISR, FALLING);

  if (!WiFi.config(local_IP, gateway, subnet, primaryDNS, secondaryDNS)) {
    Serial.println("Falha ao configurar IP estático");
  }
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("\nConectado! IP: ");
  Serial.println(WiFi.localIP());
  setLedStatus(LOW, LOW, HIGH);

  server.on("/api/move_pos", HTTP_GET, handleMovePos);
  server.on("/api/last_result", HTTP_GET, handleLastResult);
  server.begin();

  xTaskCreatePinnedToCore(taskMotorCode, "TaskMotor", 4096, NULL, 1, &handleTaskMotor, 1);
}

// ------------------- Loop ----------------
void loop() {
  server.handleClient();
}
