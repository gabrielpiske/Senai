#include <WiFiServer.h>
#include <WiFi.h>

WiFiServer sv(555);
WiFiClient cl;

void setup() {
  Serial.begin(115200);
  WiFi.mode(WIFI_AP);

  WiFi.softAP("RedeLaudo", "");
  sv.begin();
  Serial.println("Server TCP iniciado");
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
      }
      Serial.print("\nUm cliente enviou uma mensagem.");
      Serial.print("\n... IP do client: ");
      Serial.print(cl.remoteIP());
      Serial.print("\n...IP do servidor: ");
      Serial.print(WiFi.softAPIP());
      Serial.print("\nMensagem do cliente: " + req + "\n");
    }
  } else {
    cl = sv.available();
    delay(1);
  }
}
