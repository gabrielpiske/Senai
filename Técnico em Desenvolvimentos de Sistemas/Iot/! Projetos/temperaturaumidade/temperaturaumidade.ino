#include "DHT.h"

// Define o pino do DHT e o tipo do sensor
#define DHTPIN 15       // Pino digital onde o DHT está conectado
#define DHTTYPE DHT11   // Tipo do sensor (DHT11 ou DHT22)

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(115200);
  Serial.println("Iniciando leitura do DHT11...");
  dht.begin();
}

void loop() {
  float umidade = dht.readHumidity();
  float temperatura = dht.readTemperature();
  float temperaturaF = dht.readTemperature(true);

  // Verifica a leitura
  if (isnan(umidade) || isnan(temperatura) || isnan(temperaturaF)) {
    Serial.println ("Falha ao ler sensor DHT!");
    delay(2000);
    return;
  }

  Serial.print("Umidade: ");
  Serial.print(umidade);
  Serial.print(" %\t");
  Serial.print("Temperatura: ");
  Serial.print(temperatura);
  Serial.print(" ºC");
  Serial.print("\t");
  Serial.print("Temperatura Fahrenheit: ");
  Serial.print(temperaturaF);
  Serial.println(" ºF");

  delay(2000);

}
