#include <WiFi.h>
#include <WiFiManager.h>

#define RESET_BUTTON 0
#define STATUS_LED_BLUE 27
#define STATUS_LED_RED 25

WiFiManager wm;

unsigned long buttonPressStart = 0;
bool apModeActive = false;

void configModeCallback(WiFiManager *myWiFiManager);
void saveConfigCallback();
void resetConfigCallback();
void setLEDColor(bool blue, bool red);

void setup() {
  Serial.begin(115200);
  delay(1000);
  Serial.println("\n=== Iniciando ESP32 com WiFiManager ===");

  pinMode(RESET_BUTTON, INPUT_PULLUP);
  pinMode(STATUS_LED_BLUE, OUTPUT);
  pinMode(STATUS_LED_RED, OUTPUT);

  setLEDColor(false, false);

  wm.setAPCallback(configModeCallback);
  wm.setSaveConfigCallback(saveConfigCallback);
  wm.setConfigResetCallback(resetConfigCallback);

  if (digitalRead(RESET_BUTTON) == 0) {
    Serial.println("Botão pressionado na inicialização!");
    Serial.println("Limpando credenciais Wi-Fi...");
    wm.resetSettings();
    delay(2000);
  }

  if (!wm.autoConnect("RedeLaudo", "12345678")) {
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

  setLEDColor(true, false);
}

void loop() {
  // Se conectado ao Wi-Fi, LED azul aceso
  if (WiFi.status() != WL_CONNECTED && !apModeActive) {
    digitalWrite(STATUS_LED_BLUE, LOW); // Desliga azul
    digitalWrite(STATUS_LED_RED, !digitalRead(STATUS_LED_RED)); // Pisca vermelho
    Serial.println("Tentando reconectar...");
    delay(500);
  } else if (!apModeActive) {
    setLEDColor(true, false);
  }

  // Verifica se o botão está pressionado por 5 segundos
  if (digitalRead(RESET_BUTTON) == LOW) {
    if (buttonPressStart == 0) {
      buttonPressStart = millis();
    } else if (millis() - buttonPressStart >= 5000) {
      Serial.println("Botão pressionado por 5 segundos. Entrando no modo AP...");
      wm.resetSettings();
      delay(1000);
      ESP.restart();
    }
  } else {
    buttonPressStart = 0;
  }

  delay(100);
}

void configModeCallback(WiFiManager *myWiFiManager) {
  apModeActive = true;
  Serial.println("Entrou no modo AP (Configuração)");
  Serial.print("SSID do AP: ");
  Serial.println(myWiFiManager->getConfigPortalSSID());
  Serial.print("IP do AP: ");
  Serial.println(WiFi.softAPIP());
  setLEDColor(false, true);
}

void saveConfigCallback() {
  Serial.println("Novas credenciais Wi-Fi salvas na memória!");
}

void resetConfigCallback() {
  Serial.println("Credenciais Wi-Fi apagadas (resetConfigCallback)");
}

void setLEDColor(bool blue, bool red) {
  digitalWrite(STATUS_LED_BLUE, blue ? HIGH : LOW);
  digitalWrite(STATUS_LED_RED, red ? HIGH : LOW);
}
