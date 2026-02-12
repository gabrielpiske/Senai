#include <WiFi.h>
#include <WebServer.h>
#include <LiquidCrystal.h>

const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

IPAddress local_IP(10, 74, 241, 207);
IPAddress gateway(10, 74, 241, 254);
IPAddress subnet(255, 255, 255, 0);

WebServer server(80);

WiFiClient client;

LiquidCrystal lcd(32, 33, 23, 22, 21, 18);

const int LED_R = 25;
const int LED_G = 26;
const int LED_B = 27;

const int DIR = 22;
const int STEP = 5;

const int BUTTON_P = 0;
const int BUTTON_V = 4;
const int BUTTON_A = 16; // 17

bool moving = false;

int lastPos = 0;
int pos = 0;

void handleMovePos() {
  if (server.hasArg("pos")) {
    pos = server.arg("pos").toInt();
    if (pos >= 1 && pos <= 3) {
      Serial.print("Posição recebida: ");
      Serial.println(pos);

      Serial.print("Última posição registrada: ");
      Serial.println(lastPos);
      Serial.print("Posição desejada: ");
      Serial.println(pos);

      moveMotor(pos);

      server.send(200, "text/plain", "Movimento concluido");
    } else {
      server.send(400, "text/plain", "Parametro 'pos' inválido: "+ String(pos));
    }

  } else {
    server.send(400, "text/plain", "Parametro 'pos' faltando");
  }
}

void handleLastPos() {
  server.send(200, "text/plain", "Ultima posicao: " + String(lastPos));
}

void moveMotor(int posDesejada) {
  if (lastPos == posDesejada) {
    Serial.println("Já está na posição desejada!");

    lcd.clear();

    lcd.setCursor(0,0);
    lcd.print("STEP-MOTOR_STOP");
    lcd.setCursor(0, 1);
    lcd.print("JA NA POSICAO");

    server.send(200, "text/plain", "Ja na posicao: " + String(posDesejada));

    return;
  }

  moving = true;

  digitalWrite(LED_B, LOW);
  digitalWrite(LED_G, HIGH);

  int steps = 0;
  lcd.clear();

  while (lastPos != posDesejada) {
    steps++;
    digitalWrite(STEP, 1);  
    delayMicroseconds(100);
    digitalWrite(STEP, 0);   
    delayMicroseconds(100); 

    lcd.setCursor(0,0);
    lcd.print("STEP-MOTOR_MOVE");
    lcd.setCursor(0, 1);
    lcd.print("Passos:      ");
    lcd.setCursor(8, 1);
    lcd.print(steps);

    lastPos = getCurrentPos();
    delayMicroseconds(50);
  }


  moving = false;
  digitalWrite(LED_G, 0);
  if (WiFi.status() == WL_CONNECTED) {
    digitalWrite(LED_B, 1);
  } else {
    digitalWrite(LED_R, 1);
  }

  lcd.setCursor(0,0);
  lcd.print("STEP-MOTOR_STOP");
}

void setup() {
  Serial.begin(115200);
  lcd.begin(16,2);

  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);

  pinMode(DIR, OUTPUT);
  pinMode(STEP, OUTPUT);

  pinMode(BUTTON_P, INPUT_PULLUP);
  pinMode(BUTTON_V, INPUT_PULLUP);
  pinMode(BUTTON_A, INPUT_PULLUP);


  Serial.print("Conectando ao Wi-Fi");

  if (!WiFi.config(local_IP, gateway, subnet)) {
    Serial.println("Falha ao configurar IP estático");
  }

  WiFi.begin(ssid, password);

  while(WiFi.status() != WL_CONNECTED) {
    digitalWrite(LED_R, 1);
    Serial.print(".");
  }

  Serial.println("\nWi-Fi conectado!");
  Serial.print("IP do ESP32: ");
  Serial.println(WiFi.localIP());

  digitalWrite(LED_R, 0);
  digitalWrite(LED_B, 1);

  digitalWrite(DIR, 0);

  server.on("/api/move_pos", HTTP_POST, handleMovePos);
  server.on("/api/last_result", HTTP_GET, handleLastPos);

  server.begin();
  Serial.println("Servidor HTTP iniciado!");
}

int getCurrentPos() {
  if (digitalRead(BUTTON_P) == LOW) return 1;
  if (digitalRead(BUTTON_V) == LOW) return 2;
  if (digitalRead(BUTTON_A) == LOW) return 3;
  return 0;
}

void loop() {
  server.handleClient();
}