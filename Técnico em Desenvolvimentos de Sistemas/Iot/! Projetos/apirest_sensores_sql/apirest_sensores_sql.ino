#include <WiFi.h>
#include <WebServer.h>
#include <DHT.h>

const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

IPAddress local_IP(10, 74, 241, 207);   // IP desejado para o ESP32
IPAddress gateway(10, 74, 241, 254);    // Normalmente o IP do roteador
IPAddress subnet(255, 255, 255, 0);     // Máscara de rede
IPAddress primaryDNS(8, 8, 8, 8);       // DNS primário
IPAddress secondaryDNS(8, 8, 4, 4);     // DNS secundário

WebServer server(80);

WiFiClient client;

#define DHTPIN 15
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

#define TRIG_PIN 13
#define ECHO_PIN 35

#define LED_PIN 26

void handleRoot() {
  server.send(200, "text/plain", "API REST ESP32 - Sistema de Monitoramento");
}

void handleDHT() {
  float temperatura = dht.readTemperature();
  float umidade = dht.readHumidity();

  if(isnan(temperatura) || isnan(umidade)) {
    server.send(500, "application/json", "{\"status\":\"Erro na leitura do DHT11\"}");
    return;
  }

  String json = "{";
  json += "\"temperatura\":" + String(temperatura, 1) + ",";
  json += "\"umidade\":" + String(umidade, 1);
  json += "}";

  server.send(200, "application/json", json);
}

void handleDistance() {
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
 
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);
 
  long duration = pulseIn(ECHO_PIN, HIGH);
  float distancia = duration * 0.034 / 2;

  String json = "{";
  json += "\"distancia_cm\":" + String(distancia, 1);
  json += "}";

  server.send(200, "application/json", json);
}

void handleAllData() {
  float temperatura = dht.readTemperature();
  float umidade = dht.readHumidity();
 
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);
  long duration = pulseIn(ECHO_PIN, HIGH);
  float distancia = duration * 0.034 / 2;

  if(isnan(temperatura) || isnan(umidade)) {
    server.send(500, "application/json", "{\"status\":\"Erro na leitura dos sensores\"}");
    return;
  }

  String json = "{";
  json += "\"temperatura\":" + String(temperatura, 1) + ",";
  json += "\"umidade\":" + String(umidade, 1) + ",";
  json += "\"distancia_cm\":" + String(distancia, 1);
  json += "}";

  server.send(200, "application/json", json);
}

void handleLEDOn() {
  Serial.println("LED ON request recebido");
  digitalWrite(LED_PIN, HIGH);
  server.send(200, "text/plain", "LED ligado");
}

void handleLEDOff() {
  Serial.println("LED OFF request recebido");
  digitalWrite(LED_PIN, LOW);
  server.send(200, "text/plain", "LED desligado");
}


void setup() {
  Serial.begin(115200);

  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
  pinMode(LED_PIN, OUTPUT);

  Serial.print("Conectando ao Wi-Fi");

  if (!WiFi.config(local_IP, gateway, subnet, primaryDNS, secondaryDNS)) {
    Serial.println("Falha ao configurar IP estático");
  }

  WiFi.begin(ssid, password);

  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("\nWi-Fi conectado!");
  Serial.print("IP do ESP32: ");
  Serial.println(WiFi.localIP());

  dht.begin();

  server.on("/", handleRoot);
  server.on("/dht", HTTP_GET, handleDHT);
  server.on("/distance", HTTP_GET, handleDistance);
  server.on("/alldata", HTTP_GET, handleAllData);
  server.on("/led/on", HTTP_POST, handleLEDOn);
  server.on("/led/off", HTTP_POST, handleLEDOff);

  server.begin();
  Serial.println("Servidor HTTP iniciado!");
}

void loop() {
  server.handleClient();
  delay(100);
}