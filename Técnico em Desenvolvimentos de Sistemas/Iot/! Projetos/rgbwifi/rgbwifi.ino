#include <WiFiServer.h>
#include <WiFi.h>
#include <LiquidCrystal.h>

WiFiServer sv(555);
WiFiClient cl;

LiquidCrystal lcd(32, 33, 23, 22, 21, 18);

const int LED_R = 25;
const int LED_G = 26;
const int LED_B = 27;

void setup() {
  lcd.begin(16, 2);
  Serial.begin(115200);
  WiFi.mode(WIFI_AP);

  WiFi.softAP("RedeLaudo", "");
  sv.begin();
  Serial.println("Server TCP iniciado");
  
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

      Serial.println("\nMensagem recebida do cliente:");
      Serial.print("IP do cliente: ");
      Serial.println(cl.remoteIP());
      Serial.print("Mensagem: ");
      Serial.println(req);

      lcd.clear();
      lcd.setCursor(0,0);
      lcd.print(req);

      int r, g, b;
      if (parseRGB(req, r, g, b)) {
        Serial.printf("Valores RGB recebidos → R: %d, G: %d, B: %d\n", r, g, b);

        analogWrite(LED_R, r);
        analogWrite(LED_G, g);
        analogWrite(LED_B, b);

        cl.println("RGB recebido com sucesso!");
      } else {
        Serial.println("Erro ao interpretar os valores RGB.");
        cl.println("Formato inválido. Use: R,G,B (ex: 255,100,50)");
      }
    }
  } else {
    cl = sv.available();
    delay(1);
  }
}

bool parseRGB(String input, int &r, int &g, int &b) {
  input.trim();
  int index1 = input.indexOf(',');
  int index2 = input.lastIndexOf(',');

  if (index1 == -1 || index2 == -1 || index1 == index2) return false;

  String rs = input.substring(0, index1);
  String gs = input.substring(index1 + 1, index2);
  String bs = input.substring(index2 + 1);

  r = rs.toInt();
  g = gs.toInt();
  b = bs.toInt();

  return (r >= 0 && r <= 255) && (g >= 0 && g <= 255) && (b >= 0 && b <= 255);
}