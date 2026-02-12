#include "BluetoothSerial.h"
#include <LiquidCrystal.h>

#if !defined(CONFIG_BT_ENABLED) || !defined(CONFIG_BLUEDROID_ENABLED)
#error Bluetooth não está habilitado! Por favor verifique as configurações.
#endif

BluetoothSerial SerialBT;
LiquidCrystal lcd(32, 33, 23, 22, 21, 18);

#define LED_R 25
#define LED_G 26
#define LED_B 27

#define TRIGPIN 13
#define ECHOPIN 35

long duration;
float distanceCm;
int bloco_c = 5;
int bloco_b = 10;
int bloco_a = 15;

bool modoManual = false;

void setup() {
  lcd.begin(16, 2);
  Serial.begin(115200);

  SerialBT.begin("JULISKE");
  Serial.println("Bluetooth iniciado. Aguarde emparelhamento...");

  pinMode(TRIGPIN, OUTPUT);
  pinMode(ECHOPIN, INPUT);

  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);

  digitalWrite(LED_R, LOW);
  digitalWrite(LED_G, LOW);
  digitalWrite(LED_B, LOW);
}

void loop() {
  if (Serial.available()) {
    SerialBT.write(Serial.read());
  }

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

    if (comando.length() == 2) {
      char inicial = comando.charAt(0);
      char estado = comando.charAt(1);

      if (inicial == 'M') {
        modoManual = !modoManual;
        Serial.println("Modo Alterado");
        lcd.clear();
      }

      if (modoManual) {
        lcd.setCursor(0, 0);
        lcd.print("Modo: Manual");
        lcd.setCursor(0, 1);

        if (inicial == 'A') {
          lcd.print("Recipiente: A ");
          Serial.println("Recipiente: A");
          setLEDColor(1, 0, 0);
        } else if (inicial == 'B') {
          lcd.print("Recipiente: B ");
          Serial.println("Recipiente: B");
          setLEDColor(0, 1, 0);
        } else if (inicial == 'C') {
          lcd.print("Recipiente: C ");
          Serial.println("Recipiente: C");
          setLEDColor(0, 0, 1);
        }
      }
    }
  }

  if (!modoManual) {
    distancia();

    lcd.setCursor(0, 0);
    lcd.print("Modo: Auto     ");
    lcd.setCursor(0, 1);

    if (distanceCm >= (bloco_c - 1) && distanceCm <= (bloco_c + 1)) {
      lcd.print("Recipiente: C ");
      setLEDColor(0, 0, 1);
    } else if (distanceCm >= (bloco_b - 1) && distanceCm <= (bloco_b + 1)) {
      lcd.print("Recipiente: B ");
      setLEDColor(0, 1, 0);
    } else if (distanceCm >= (bloco_a - 1) && distanceCm <= (bloco_a + 1)) {
      lcd.print("Recipiente: A ");
      setLEDColor(1, 0, 0);
    }

    delay(500);
  }
}

void distancia() {
  digitalWrite(TRIGPIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIGPIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIGPIN, LOW);

  duration = pulseIn(ECHOPIN, HIGH);

  distanceCm = (duration / 2.0) / 29.1;

  if (modoManual == false) {
    Serial.print("Distancia: ");
    Serial.print(distanceCm);
    Serial.println(" cm");
  }
}

void setLEDColor(bool r, bool g, bool b) {
  digitalWrite(LED_R, r ? HIGH : LOW);
  digitalWrite(LED_G, g ? HIGH : LOW);
  digitalWrite(LED_B, b ? HIGH : LOW);
}
