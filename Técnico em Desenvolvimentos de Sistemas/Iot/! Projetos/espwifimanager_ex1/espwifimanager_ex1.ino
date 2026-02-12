#include <WiFi.h>
#include <WiFiManager.h>

#define RESET_BUTTON 0
#define STATUS_LED 25

WiFiManager wm;

void configModeCallback(WiFiManager *myWiFiManager);
void saveConfigCallback();
void resetConfigCallback();

void setup() {
  Serial.begin(115200);
  delay(1000);
  Serial.println("\n=== Iniciando ESP32 com WiFiManager ===");

  pinMode(RESET_BUTTON, INPUT_PULLUP);
  pinMode(STATUS_LED, OUTPUT);
  digitalWrite(STATUS_LED, 0);

  wm.setAPCallback(configModeCallback);
  wm.setSaveConfigCallback(saveConfigCallback);
  wm.setConfigResetCallback(resetConfigCallback);

  if(digitalRead(RESET_BUTTON) == 0) {
    Serial.println("Botão pressionado na inicialização!");
    Serial.println("Limpando credenciais Wi-Fi...");
    wm.resetSettings();
    delay(2000);
  }

  if(!wm.autoConnect("RedeLaudo", "12345678")) {
    Serial.println("Falha ao conectar e tempo limite esgotado");
    Serial.println("Reiniciando RedeLaudo...");
    ESP.restart();
    delay(1000);
  }

  Serial.println("Conectado ao WiFi com sucesso!");
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());
  Serial.print("IP: ");
  Serial.println(WiFi.localIP());
  digitalWrite(STATUS_LED, 1);
}

void loop() {
  if(WiFi.status() != WL_CONNECTED) {
    digitalWrite(STATUS_LED, !digitalRead(STATUS_LED));
    Serial.println("Tentando reconectar...");
    delay(500);
  } else {
    digitalWrite(STATUS_LED, 1);
  }

  if(digitalRead(RESET_BUTTON) == 0){
    Serial.println("Botão pressionado durante execução!");
    Serial.println("Limpando credenciais e reiniciando portal...");
    wm.resetSettings();
    ESP.restart();
  }

  delay(1000);
}


void configModeCallback(WiFiManager *myWiFiManager) {
  Serial.println("Entrou no modo AP (Configuração)");
  Serial.print("SSID do AP: ");
  Serial.println(myWiFiManager->getConfigPortalSSID());
  Serial.print("IP do AP: ");
  Serial.println(WiFi.softAPIP());
}

void saveConfigCallback() {
  Serial.println("Novas credenciais Wi-Fi salvas na memória!");
}

void resetConfigCallback() {
  Serial.println("Credenciais Wi-Fi apagadas (resetConfigCallback)");
}