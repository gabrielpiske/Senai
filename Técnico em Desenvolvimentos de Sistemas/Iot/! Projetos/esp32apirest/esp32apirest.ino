#include <WiFi.h>
#include <WebServer.h>
#include <DHT.h>
#include <ESP32Servo.h>

const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

WebServer server(80);

#define DHTPIN 15
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

Servo myServo;
#define SERVO_PIN 13

void handleRoot() {
  server.send (200, "text/plain", "API REST ESP32 Ativa!");
}

void handleDHT() {
  float temperatura = dht.readTemperature();
  float umidade = dht.readHumidity();

  if(isnan(temperatura) || isnan (umidade)) {
    server.send(500, "application/json", "{\"status\":\"Erro na leitura do DHT11\"}");
    return;
  }

  String json = "{";
  json += "\"temperatura\":" + String(temperatura, 1) + ",";
  json += "\"umidade\":" + String (umidade , 1);
  json += "}";

  server.send(200, "application/json", json);
}

void handleServo() {
  if (server.hasArg("angle")) {
    int angle = server.arg("angle").toInt();

    if (angle < 0) angle = 0;
    if (angle > 180) angle = 180;

    myServo.write(angle);

    String json = "{";
    json += "\"status\":\"OK\",";
    json += "\"angle\":" + String(angle);
    json += "}";

    server.send(200, "application/json", json);
  } else {
    server.send(400, "application/json", "{\"status\":\"Erro\",\"mensagem\":\"Parametro angle faltando\"}");
  }
}

void setup() {
  Serial.begin(115200);

  Serial.println("Conectando ao Wi-Fi...");
  WiFi.begin(ssid, password);
  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("\nWi-Fi conectado!");
  Serial.print("IP do ESP32: ");
  Serial.println(WiFi.localIP());

  dht.begin();

  myServo.attach(SERVO_PIN);
  myServo.write(90);

  server.on("/", handleRoot);
  server.on("/dht", HTTP_GET, handleDHT);
  server.on("/servo", HTTP_POST, handleServo);

  server.begin();
  Serial.println("Servidor HTTP iniciado!");
}

void loop() {
  server.handleClient();
}