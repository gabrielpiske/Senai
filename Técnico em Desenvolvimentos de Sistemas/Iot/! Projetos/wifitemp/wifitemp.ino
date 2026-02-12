#include <WiFi.h>
#include <WiFiServer.h>
#include <LiquidCrystal.h>
#include "DHT.h"

LiquidCrystal lcd(32, 33, 23, 22, 21, 18);

#define DHTPIN 15
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

WiFiServer sv(555);
WiFiClient cl;

void setup() {
  Serial.begin(115200);
  lcd.begin(16, 2);
  dht.begin();

  WiFi.mode(WIFI_AP);
  WiFi.softAP("RedeLaudo", "");
  sv.begin();

  Serial.println("Servidor TCP iniciado");
  Serial.print("IP do servidor: ");
  Serial.println(WiFi.softAPIP());
}

void loop() {
  tcp();
}

void tcp() {
  if (cl.connected()) {
    if (cl.available() > 0) {
      String req = "";
      while (cl.available() > 0) {
        char z = cl.read();
        req += z;
        delay(1);
      }

      req.trim();

      Serial.println("\n Mensagem recebida:");
      Serial.print("Cliente IP: ");
      Serial.println(cl.remoteIP());
      Serial.print("Conteúdo: ");
      Serial.println(req);

      lcd.clear();

      if (req.equalsIgnoreCase("TEMP")) {
        float umidade = dht.readHumidity();
        float temperatura = dht.readTemperature();

        if (isnan(umidade) || isnan(temperatura)) {
          Serial.println("Erro na leitura do DHT11");
          cl.println("Erro ao ler sensor DHT");
          lcd.print("Erro DHT!");
          return;
        }

        Serial.printf("Temp: %.1f °C, Umidade: %.1f %%\n", temperatura, umidade);

        cl.print("Temperatura: ");
        cl.print(temperatura);
        cl.print(" °C | Umidade: ");
        cl.print(umidade);
        cl.println(" %");

        lcd.setCursor(0, 0);
        lcd.print("Temp: ");
        lcd.print(temperatura);
        lcd.print(" C");

        lcd.setCursor(0, 1);
        lcd.print("Umid: ");
        lcd.print(umidade);
        lcd.print(" %");

      } else {
        lcd.setCursor(0, 0);
        lcd.print(req);
      }
    }
  } else {
    cl = sv.available();
    delay(1);
  }
}
