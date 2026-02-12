#include <WiFi.h>
#include <WebServer.h>
#include <DHT.h>

const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

WebServer server(80);

#define DHTPIN 15
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

#define TRIG_PIN 13
#define ECHO_PIN 35   

float lerDistancia();

void handleRoot() {
  server.send(200, "text/plain", "API REST ESP32 Ativa!");
}

void handleDHT() {
  float temperatura = dht.readTemperature();
  float umidade     = dht.readHumidity();

  if (isnan(temperatura) || isnan(umidade)) {
    server.send(500, "application/json", "{\"status\":\"Erro na leitura do DHT11\"}");
    return;
  }

  String json = "{";
  json += "\"temperatura\":" + String(temperatura, 1) + ",";
  json += "\"umidade\":" + String(umidade, 1);
  json += "}";

  server.send(200, "application/json", json);
}

void handleDistancia() {
  float distancia = lerDistancia();

  if (distancia <= 0 || distancia > 400) {
    server.send(500, "application/json", "{\"status\":\"Erro na leitura do HC-SR04\"}");
    return;
  }

  String json = "{";
  json += "\"distancia_cm\":" + String(distancia, 1);
  json += "}";

  server.send(200, "application/json", json);
}

void setup() {
  Serial.begin(115200);

  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);

  dht.begin();

  Serial.println("Conectando ao WiFi...");
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("\nWiFi conectado!");
  Serial.print("IP do ESP32: ");
  Serial.println(WiFi.localIP());

  server.on("/", handleRoot);
  server.on("/dht", HTTP_GET, handleDHT);
  server.on("/distancia", HTTP_GET, handleDistancia);

  server.begin();
  Serial.println("Servidor HTTP iniciado!");
}

void loop() {
  server.handleClient();
}

float lerDistancia() {
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);

  unsigned long duracao = pulseIn(ECHO_PIN, HIGH, 30000UL);
  if (duracao == 0) return -1.0;

  return (duracao * 0.0343f) / 2.0f;
}
