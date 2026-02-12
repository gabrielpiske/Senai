#include <WiFi.h>
#include <PubSubClient.h>

const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

const char* mqtt_server = "10.74.241.74";

WiFiClient espClient;
PubSubClient client(espClient);

int ledRGB_R = 27;

void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Mensagem recebida no tópico [");
  Serial.print(topic);
  Serial.print("]: ");

  String mensagem;

  for (int i = 0; i < length; i++) {
    mensagem += (char)payload[i];
  }

  Serial.println(mensagem);

  if (mensagem == "ON") {
    digitalWrite(ledRGB_R, 1);
    Serial.println("Led LIGADO!");
  } else if (mensagem == "OFF") {
    digitalWrite(ledRGB_R, 0);
    Serial.println("Led DESLIGADO!");
  }
}

void setup_wifi() {
  delay(10);
  Serial.print("Conectando ao Wi-Fi");
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(200);
  }
  Serial.println("\nWi-Fi conectado!");
  Serial.println(WiFi.localIP());
}

void reconnect() {
  while (!client.connected()) {
    Serial.print(".");
    if (client.connect("Esp32Client")) {
      Serial.println("\nConectado!");
      client.subscribe("/smart4.0/temp");
    } else {
      Serial.print("Falhou, rc=");
      Serial.print(client.state());
      Serial.println(" Tentando novamene em 2s");
      delay(2000);
    }
  }
}

void setup() {
  pinMode(ledRGB_R, OUTPUT);
  Serial.begin(115200);
  setup_wifi();
  client.setServer(mqtt_server, 1883);
  client.setCallback(callback);
}

void loop() {
  if(!client.connected()) {
    Serial.print("Tentando conexão ao broker");
    reconnect();
  }

  client.loop();

  String msg = "{\"temperatura\":25.45}";
  client.publish("/smart4.0/temp", msg.c_str());
  delay(2000);
}
