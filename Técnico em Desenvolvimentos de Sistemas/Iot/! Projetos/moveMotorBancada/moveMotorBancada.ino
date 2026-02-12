#include <WiFi.h>
#include <WebServer.h>
#include <LiquidCrystal.h>

const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

IPAddress local_IP(10, 74, 241, 207);
IPAddress gateway(10, 74, 241, 254);
IPAddress subnet(255, 255, 255, 0);

WebServer server(80);

#define RGB_R 25
#define RGB_G 26
#define RGB_B 27
#define BTN_1 0
#define BTN_2 4
#define BTN_3 17
#define STEP 5   
#define DIR 22    
#define TRIG_PIN 13 
#define ECHO_PIN 12 

volatile bool moving = false;

int lastPos = 0;
int posDesejada = 0;
int passos = 0;

int lerPos() {
  if (digitalRead(BTN_1) == 0) return 1;
  if (digitalRead(BTN_2) == 0) return 2;
  if (digitalRead(BTN_3) == 0) return 3;
  return 0;
}

bool atingiuPos() {
  return (lerPos() == posDesejada);
}

void tarefaMoveMotor(void *pvParameters) {
  while(true) {
    if (moving && !atingiuPos()) {
      digitalWrite(STEP, 1);
      delayMicroseconds(400);
      digitalWrite(STEP, 0);
      delayMicroseconds(400);
      passos++;
    }
    vTaskDelay(1);
  }
}

void tarefaControl(void *pvParameters) {
  Serial.print("Movendo motor: ");
  Serial.println(posDesejada);

  while(true) {
    if (moving && !atingiuPos()) {
      digitalWrite(RGB_G, 1);
      digitalWrite(RGB_R, 0);
      digitalWrite(RGB_B, 0);

      bool fimCursoAlcancado = (!digitalRead(BTN_1) || !digitalRead(BTN_2) || !digitalRead(BTN_3));

      if (fimCursoAlcancado && passos > 50) {
        moving = false;
        lastPos = posDesejada;

        Serial.print("Posição atingida: ");
        Serial.println(lastPos);
        Serial.print("Passos: ");
        Serial.println(passos);

        passos = 0;

        server.send(200, "text/plain", "Ok. Posição selecionada.");
      }
    }
    vTaskDelay(10);
  }
}

void handleRoot() {
  server.send(200, "text/plain", "API REST ESP32 Ativa!");
}

void handleLastResult() {
  String jsonResponse = "{";
    jsonResponse += "\"status\": \"" + String(moving ? "MOVENDO" : "PARADO") + "\",";
    jsonResponse += "\"pos_solicitada\": " + String(posDesejada) + ",";
    jsonResponse += "\"pos_atual\": " + String(lastPos) + ",";
    jsonResponse += "\"fim_curso1\": " + String(!digitalRead(BTN_1) ? 1 : 0) + ",";
    jsonResponse += "\"fim_curso2\": " + String(!digitalRead(BTN_2) ? 1 : 0) + ",";
    jsonResponse += "\"fim_curso3\": " + String(!digitalRead(BTN_3) ? 1 : 0);
    jsonResponse += "}";
  server.send(200, "application/json", jsonResponse);
}

void handleMovePos() {
  if (server.hasArg("pos")) {
    String posStr = server.arg("pos");
    int pos = posStr.toInt();

    Serial.print("Recebi posicao: ");
    Serial.println(pos);

    if (moving) {
      server.send(423, "text/plain", "Sistema ocupado - movimento em andamento");
      return;
    }

    if (pos <= 0 || pos >= 4) {
      server.send(400, "text/plain", "Posição inválida: " + String(pos));
      return;
    }

    posDesejada = pos;

    if (lastPos != posDesejada) {
      moving = true;
      passos = 0;
      server.send(200, "text/plain", "Movendo para posição: " + String(posDesejada));
    } else {
      server.send(200, "text/plain", "Ja na posicao desejada: " + String(posDesejada));
    }
    
  } else {
    server.send(400, "text/plain", "Parametro nao enviado");
  }
}

void setup() {
  pinMode(STEP, OUTPUT);     
  pinMode(DIR, OUTPUT);      
  pinMode(TRIG_PIN, OUTPUT); 
  pinMode(ECHO_PIN, INPUT);  
  pinMode(RGB_R, OUTPUT);
  pinMode(RGB_G, OUTPUT);
  pinMode(RGB_B, OUTPUT);
  pinMode(BTN_1, INPUT_PULLUP);
  pinMode(BTN_2, INPUT_PULLUP);
  pinMode(BTN_3, INPUT_PULLUP);

  Serial.begin(115200);

  digitalWrite(DIR, LOW);
  digitalWrite(STEP, LOW);

  digitalWrite(RGB_R, 1);
  digitalWrite(RGB_G, 0);
  digitalWrite(RGB_B, 0);

  Serial.print("Conectando ao Wi-Fi");
  WiFi.begin(ssid, password);

  if(!WiFi.config(local_IP, gateway, subnet)) {
    Serial.println("Falha ao carregar IP fixo");
  }

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
    digitalWrite(RGB_R, !digitalRead(RGB_R));
    digitalWrite(RGB_G, 0);
    digitalWrite(RGB_B, 0);
  }

  if (WiFi.status() == WL_CONNECTED) {
    Serial.println("\nWi-Fi conectado");
    Serial.print("IP do ESP: ");
    Serial.println(WiFi.localIP());
    digitalWrite(RGB_R, 0);
    digitalWrite(RGB_G, 0);
    digitalWrite(RGB_B, 1);
  } else {
    Serial.println("\nFalha ao conectar. Rodando em modo OFFLINE...");
    digitalWrite(RGB_R, 1);
    digitalWrite(RGB_G, 0);
    digitalWrite(RGB_B, 0);
  }

  xTaskCreatePinnedToCore(tarefaMoveMotor, "Task_MoveMotor", 4096, NULL, 2, NULL, 0);
  xTaskCreatePinnedToCore(tarefaControl, "Task_Control", 4096, NULL, 1, NULL, 1);

  server.on("/", handleRoot);
  server.on("/api/move_pos", HTTP_GET, handleMovePos);
  server.on("/api/move_pos", HTTP_POST, handleMovePos);
  server.on("/api/last_result", HTTP_GET, handleLastResult);

  server.begin();
  Serial.println("Servidor HTTP iniciado!");
}

void loop() {
  server.handleClient();
}
