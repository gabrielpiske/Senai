#include <WiFi.h>
#include <PubSubClient.h>
#include <ArduinoJson.h>
#include <LiquidCrystal.h>
#include <WiFiManager.h>

#define MAX_VARIABLES 12

#define LED_R 25   // LED Vermelho
#define LED_G 26   // LED Verde
#define LED_B 27   // LED Azul

#define LCD_RS 32
#define LCD_EN 33
#define LCD_D4 23
#define LCD_D5 22
#define LCD_D6 21
#define LCD_D7 18

#define BTN_R 0
#define BTN_A 4
#define BTN_W 16

LiquidCrystal lcd(LCD_RS, LCD_EN, LCD_D4, LCD_D5, LCD_D6, LCD_D7);

const char* ssid = "RedeLaudo";
const char* password = "Smart4.0";
const char* mqtt_server = "10.74.241.147";

bool apMode = false;
unsigned long buttonPressStart = 0;

unsigned long lastMsg = 0;

const long interval = 5000;

int currentVarIndex = 0;

int lastShownIndex = -1;

unsigned long lastDebounceTimeR = 0;
unsigned long lastDebounceTimeA = 0;
const unsigned long debounceDelay = 200;

struct Variable {
  String name;
  String value;
};

Variable variables[MAX_VARIABLES];
int varCount = 0;

WiFiManager wm;

WiFiClient espClient;
PubSubClient client(espClient);

void setColor(bool r, bool g, bool b) {
  digitalWrite(LED_R, r);
  digitalWrite(LED_G, g);
  digitalWrite(LED_B, b);
}

void configModeCallback(WiFiManager *myWiFiManager) {
  apMode = true;
  Serial.println("Entrou no modo AP(Configuração via celular)");
  Serial.print("SSID do AP: ");
  Serial.println(myWiFiManager->getConfigPortalSSID());
  Serial.print("IP do AP: ");
  Serial.println(WiFi.softAPIP());
  lcd.setCursor(14, 1);
  lcd.print("AP");
  //setColor(LOW, LOW, HIGH);
}

void saveConfigCallback() {
  Serial.println("Novas credenciais Wi-Fi salvas!");
}

void resetConfigCallback() {
  Serial.println("Credenciais Wi-Fi apagadas");
}

void showCurrentVariable() {
  if (varCount == 0) {
    if (lastShownIndex != -2) {  // Para não ficar limpando toda hora
      lcd.clear();
      lcd.print("Sem dados");
      lastShownIndex = -2;
    }
    return;
  }

  if (lastShownIndex == currentVarIndex) return;

  lcd.clear();

  String name = variables[currentVarIndex].name;
  String value = variables[currentVarIndex].value;

  lcd.setCursor(0,0);
  lcd.print(name);

  lcd.setCursor(0,1);
  lcd.print(value);

  lastShownIndex = currentVarIndex;
}

void updateVariable(const char* varName, const char* val) {
  if (val == nullptr || strlen(val) == 0 || strcmp(val, "null") == 0 || varName == nullptr || strcmp(varName, "null") == 0) return;

  for (int i = 0; i < varCount; i++) {
    if (variables[i].name.equals(varName)) {
      variables[i].value = String(val);
      showCurrentVariable();
      return;
    }
  }

  if(varCount < MAX_VARIABLES) {
    variables[varCount].name = String(varName);
    variables[varCount].value = String(val);
    varCount++;
    currentVarIndex = varCount - 1;
    showCurrentVariable();
  }
}

void callback(char* topic, byte* payload, unsigned int length) {
  String msg = "";
  for (unsigned int i = 0; i < length; i++) msg += (char)payload[i];

  Serial.println("Mensagem MQTT recebida:");
  Serial.println(msg);

  StaticJsonDocument<4096> doc;
  DeserializationError error = deserializeJson(doc, msg);
  if (error) {
    Serial.print("Erro JSON: "); Serial.println(error.c_str());
    return;
  }

  if (doc.is<JsonObject>()) {
    JsonObject obj = doc.as<JsonObject>();
    // Itera em todas as chaves do objeto
    for (JsonPair kv : obj) {
      String name = kv.key().c_str();
      // Converte o valor para string (funciona para int, float, string etc)
      String val = "";
      if (kv.value().is<const char*>()) {
        val = kv.value().as<const char*>();
      } else {
        val = String(kv.value().as<float>(), 2);  // 2 casas decimais para float
      }
      updateVariable(name.c_str(), val.c_str());
    }
  } else {
    Serial.println("JSON não é objeto!");
  }

  showCurrentVariable();
}

void setup_wifi() {
  setColor(HIGH, LOW, LOW);

  if (!wm.autoConnect(ssid, password)) {
    Serial.println("Falha na conexão. Reiniciando...");
    delay(3000);
    ESP.restart();
  }
  Serial.println("Wi-Fi conectado com sucesso!");
  Serial.print("Endereço IP: ");
  Serial.println(WiFi.localIP());

  setColor(LOW, LOW, HIGH);
}

void reconnect() {
  while (!client.connected()) {
    Serial.print("Tentando conexão MQTT...");
    if (client.connect("ESP32_CLIENT")) {
      Serial.println("Conectado ao Broker!");
      client.subscribe("/smart");
      setColor(LOW, HIGH, LOW);
    } else {
      Serial.print("Falha, rc=");
      Serial.print(client.state());
      Serial.println(" Tentando novamente em 5s");
      if (!wm.autoConnect(ssid, password)) {
        setColor(1, 0, 0);
      } else {
        setColor(0, 0, 1);
      }
      delay(5000);
    }
  }
}

void setup() {
  Serial.begin(115200);

  pinMode(BTN_A, INPUT_PULLUP);
  pinMode(BTN_R, INPUT_PULLUP);
  pinMode(BTN_W, INPUT_PULLUP);

  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);

  setColor(HIGH, LOW, LOW); 
  lcd.begin(16, 2);
  lcd.clear();

  wm.setAPCallback(configModeCallback);
  wm.setSaveConfigCallback(saveConfigCallback);
  wm.setConfigResetCallback(resetConfigCallback);

  /*if (digitalRead(BTN_W) == 1) {
    Serial.println("Resetando Wi-Fi...");
    wm.resetSettings();
  }*/

  setup_wifi();

  lcd.print("TESTE");

  delay(1000);

  lcd.clear();

  client.setServer(mqtt_server, 1883);
  client.setCallback(callback);
}

void loop() {
  if (!client.connected()) reconnect();
  client.loop();

  if (digitalRead(BTN_A) == LOW) {
    if (millis() - lastDebounceTimeA > debounceDelay) {
      lastDebounceTimeA = millis();
      if (varCount == 0) return;
      currentVarIndex++;
      if (currentVarIndex >= varCount) currentVarIndex = 0;
      showCurrentVariable();
    }
  }

  // Botão Voltar (BTN_R)
  if (digitalRead(BTN_R) == LOW) {
    if (millis() - lastDebounceTimeR > debounceDelay) {
      lastDebounceTimeR = millis();
      if (varCount == 0) return;
      if (currentVarIndex == 0) {
        currentVarIndex = varCount - 1;
      } else {
        currentVarIndex--;
      }
      showCurrentVariable();
    }
  }

  unsigned long now = millis();
  if (now - lastMsg > interval) {
    lastMsg = now;
  }

  if (digitalRead(BTN_W) == LOW) {
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
}
