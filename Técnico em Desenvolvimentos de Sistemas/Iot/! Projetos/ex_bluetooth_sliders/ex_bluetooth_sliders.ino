#include "BluetoothSerial.h"

#if !defined(CONFIG_BT_ENABLED) || !defined(CONFIG_BLUEDROID_ENABLED)
  #error Bluetooth não está habilitado! Por favor verifique as configurações.
#endif

#define LED_R 25
#define LED_G 26
#define LED_B 27

BluetoothSerial SerialBT;

void setup() {
  Serial.begin(115200);

  SerialBT.begin("ESP32_TECDES_PISKE");
  Serial.println("Bluetooth iniciado. Aguarde emparelhamento...");

  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);

  digitalWrite(LED_R, LOW);
  digitalWrite(LED_G, LOW);
  digitalWrite(LED_B, LOW);
}

void loop() {
  // Se houver dados recebidos pela porta serial USB, encaminha-os para o Bluetooth
  if (Serial.available()) {
    SerialBT.write(Serial.read());
  }

  // Verifica se há dados recebidos via Bluetooth
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
      char led = comando.charAt(0);     // Primeiro caractere indica o LED (R, G ou B)
      char estado = comando.charAt(1);  // Segundo caractere indica se liga (1) ou desliga (0)

      int valor = (estado == '1') ? HIGH : LOW;

      if (led == 'R') {
        Serial.println(valor);  // (1 ou 0)
        digitalWrite(LED_R, valor);
        Serial.println(valor == HIGH ? "LED VERMELHO ligado" : "LED VERMELHO desligado");
      } else if (led == 'G') {
        Serial.println(valor);
        digitalWrite(LED_G, valor);
        Serial.println(valor == HIGH ? "LED VERDE ligado" : "LED VERDE desligado");
      } else if (led == 'B') {
        Serial.println(valor);
        digitalWrite(LED_B, valor);
        Serial.println(valor == HIGH ? "LED AZUL ligado" : "LED AZUL desligado");
      } else {
        Serial.println("Comando inválido! Use R, G ou B.");
      }
    } else {
      Serial.println("Formato de comando inválido. Use por exemplo: R1, G0, B1");
    }
  }
  delay(20);  
}
