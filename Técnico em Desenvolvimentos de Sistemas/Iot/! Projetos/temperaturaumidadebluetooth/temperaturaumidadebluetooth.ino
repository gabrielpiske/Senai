#include "DHT.h"
#include "BluetoothSerial.h"
#include <LiquidCrystal.h>

#if !defined(CONFIG_BT_ENABLED) || !defined(CONFIG_BLUEDROID_ENABLED)
#error Bluetooth não está habilitado! Por favor verifique as configurações.
#endif

BluetoothSerial SerialBT;

// Define o pino do DHT e o tipo do sensor
#define DHTPIN 15      // Pino digital onde o DHT está conectado
#define DHTTYPE DHT11  // Tipo do sensor (DHT11 ou DHT22)

#define LED_R 25
#define LED_G 26
#define LED_B 27

DHT dht(DHTPIN, DHTTYPE);
LiquidCrystal lcd(32, 33, 23, 22, 21, 18);

bool modoManual = false;

float aletaA = 30;
float aletaB = 32;
float aletaC = 34;

void setup() {
  lcd.begin(16, 2);
  Serial.begin(115200);
  Serial.println("Iniciando leitura do DHT11...");

  SerialBT.begin("JULISKE");
  Serial.println("Bluetooth iniciado. Aguarde emparelhamento...");
  dht.begin();

  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);

  digitalWrite(LED_R, LOW);
  digitalWrite(LED_G, LOW);
  digitalWrite(LED_B, LOW);

  lcd.setCursor(0, 0);
  lcd.print("Controle-Estufa");
  delay(2000);
  lcd.clear();
}

void loop() {
  float umidade = dht.readHumidity();
  float temperatura = dht.readTemperature();
  float temperaturaF = dht.readTemperature(true);

  // Verifica a leitura
  if (isnan(umidade) || isnan(temperatura) || isnan(temperaturaF)) {
    Serial.println("Falha ao ler sensor DHT!");
    delay(2000);
    return;
  }

  Serial.print("Umidade: ");
  Serial.print(umidade);
  Serial.print(" %\t");
  Serial.print("Temperatura: ");
  Serial.print(temperatura);
  Serial.print(" C");
  Serial.print("\t");
  Serial.print("Temperatura Fahrenheit: ");
  Serial.print(temperaturaF);
  Serial.println(" F");

  String temperaturaBluetooth = ("*T" + String(temperatura) + "*");
  SerialBT.print(temperaturaBluetooth);

  String umidadeBluetooth = ("*U" + String(umidade) + "*");
  SerialBT.print(umidadeBluetooth);

  if (SerialBT.available()) {
    String comando = "";

    while (SerialBT.available()) {
      char c = SerialBT.read();
      comando += c;
      delay(2);
    }

    comando.trim();
    Serial.print("Comando recebido: ");
    Serial.println(comando);

    if (comando.length() >= 1 && comando.length() <= 3) {
      char inicial = comando.charAt(0);
      String estado = comando.substring(1);

      bool valor = (estado == "1") ? 1 : 0;

      if (inicial == 'M') {
        modoManual = valor;
        Serial.print("Modo: ");
        Serial.println(valor == 1 ? "Ativado" : "Desativado");
      }

      if (modoManual) {
        lcd.setCursor(15, 0);
        lcd.print("M");
        lcd.setCursor(0, 1);
        if (inicial == 'A') {
          lcd.print("Aleta: 30");
          Serial.println("Aleta: 30");
          setLEDColor(1, 0, 0);
        } else if (inicial == 'B') {
          lcd.print("Aleta: 60");
          Serial.println("Aleta: 60");
          setLEDColor(0, 1, 0);
        } else if (inicial == 'C') {
          lcd.print("Aleta: 90");
          Serial.println("Aleta: 90");
          setLEDColor(0, 0, 1);
        }
      }
    }
  }

  if (!modoManual) {
    lcd.setCursor(15, 0);
    lcd.print("A");
    lcd.setCursor(0, 0);
    if (temperatura >= aletaA) {
      lcd.print("TEMP ALTA");
    }
    lcd.setCursor(0, 1);
    if (temperatura >= aletaA && temperatura < aletaB) {
      lcd.print("Aleta: 30");
      setLEDColor(1, 0, 0);
    } else if (temperatura >= aletaB && temperatura < aletaC) {
      lcd.print("Aleta: 60");
      setLEDColor(0, 1, 0);
    } else if (temperatura >= aletaC) {
      lcd.print("Aleta: 90");
      setLEDColor(0, 0, 1);
    }
  }

  delay(2000);
}

void setLEDColor(bool r, bool g, bool b) {
  digitalWrite(LED_R, r ? HIGH : LOW);
  digitalWrite(LED_G, g ? HIGH : LOW);
  digitalWrite(LED_B, b ? HIGH : LOW);
}