#include <WiFi.h>

const char* ssid = "Smart 4.0 (3)";
const char* password = "Smart4.0";

int LED = 27;

WiFiServer server(80);

void setup() {
  Serial.begin(115200);
  pinMode(LED, OUTPUT);

  Serial.println();
  Serial.print("Conectando-se a ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.println("Conectando ao Wi-Fi..");
  }

  Serial.println("");
  Serial.println("Wi-Fi conectada.");
  Serial.println("Endereço de IP: ");
  Serial.println(WiFi.localIP());

  server.begin();
}

void loop() {
  WiFiClient client = server.available();
  if (client) {
    Serial.println("New Client.");
    String currentLine = "";
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();
        Serial.write(c);
        if (c == '\n') {
          if (currentLine.length() == 0) {
            client.println("HTTP/1.1 200 OK");
            client.println("Content-type:text/html");
            client.println();

            client.print(R"rawliteral(
                  <!DOCTYPE html>
                  <html lang="pt-BR">
                  <head>
                    <meta charset="UTF-8">
                    <title>Controle de LED</title>
                    <style>
                      body {
                        background-color: #f0f8ff;
                        font-family: Arial, sans-serif;
                        text-align: center;
                        padding-top: 50px;
                      }
                      h1 {
                        color: #333;
                      }
                      .btn {
                        display: inline-block;
                        background-color: #4CAF50;
                        color: white;
                        padding: 15px 30px;
                        margin: 20px;
                        text-decoration: none;
                        font-size: 18px;
                        border-radius: 8px;
                        transition: background-color 0.3s ease;
                      }
                      .btn:hover {
                        background-color: #45a049;
                      }
                      .btn.off {
                        background-color: #f44336;
                      }
                      .btn.off:hover {
                        background-color: #d32f2f;
                      }
                      .container {
                        margin-top: 30px;
                      }
                    </style>
                  </head>
                  <body>
                    <h1>Controle do LED - GPIO 27</h1>
                    <div class="container">
                      <a href="/H" class="btn">Ligar LED</a>
                      <a href="/L" class="btn off">Desligar LED</a>
                    </div>
                  </body>
                  </html>
                  )rawliteral");
            client.println();
            break;
          } else {
            currentLine = "";
          }
        } else if (c != '\r') {
          currentLine += c;
        }
        if (currentLine.endsWith("GET /H")) {
          digitalWrite(LED, HIGH);
        }
        if (currentLine.endsWith("GET /L")) {
          digitalWrite(LED, LOW);
        }
      }
    }
    client.stop();
    Serial.println("Client Disconnected.");
  }
}
