#include <WiFi.h>
#include "DHT.h"

// Configuração da rede WiFi
const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

// Servidor TCP na porta 555
WiFiServer server(555);
WiFiClient client;

#define DHTPIN 15
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

// Variáveis simulando sensores
void setup() {
  Serial.begin(115200);
  dht.begin();

    // Conecta o ESP32 como cliente de rede Wi-Fi
    WiFi.begin(ssid, password);
  Serial.print("Conectando-se à rede WiFi: ");
  Serial.println(ssid);

  // Aguarda conexão
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("\nConectado com sucesso!");
  Serial.print("Endereço IP: ");
  Serial.println(WiFi.localIP());

  // Inicia o servidor TCP
  server.begin();
  Serial.println("Servidor TCP iniciado na porta 555.");
}

void loop() {
  // Aceita novos clientes se não houver nenhum conectado
  float umidade = dht.readHumidity();
  float temperatura = dht.readTemperature();

  if (!client.connected()) {
    client = server.available();
  }

  if (client && client.connected()) {
    float umidade = dht.readHumidity();
    float temperatura = dht.readTemperature();

    if (isnan(umidade) || isnan(temperatura)) {
      Serial.println("Falha ao ler do sensor DHT!");
      return;
    }

    client.println("TEMP=" + String(temperatura, 2));
    client.println("UMID=" + String(umidade, 1));
    Serial.println("Dados enviados ao cliente TCP.");

    delay(2000);
  }

  delay(10);
}
