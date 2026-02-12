#define LED_R 14
#define LED_G 33
#define LED_B 32

#define LED2_R 27
#define LED2_G 26
#define LED2_B 25

#define BOTAO 0

// --- Estado do LED1 ---
unsigned long tempoLED1 = 0;
const unsigned long intervaloLED1 = 100; // troca cor a cada 100ms
int estadoLED1 = 0;

// --- Estado do LED2 ---
unsigned long tempoLED2 = 0;
const unsigned long intervaloLED2 = 15; // passo do arco-íris
int hue = 0;
bool efeitoAtivo = false;

// --- Botão ---
bool botaoAnterior = HIGH;
unsigned long tempoDebounce = 0;
const unsigned long intervaloDebounce = 50;

void setup() {
  Serial.begin(115200);

  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);

  ledcAttach(LED2_R, 5000, 8);
  ledcAttach(LED2_G, 5000, 8);
  ledcAttach(LED2_B, 5000, 8);

  pinMode(BOTAO, INPUT_PULLUP);
}

void loop() {
  unsigned long agora = millis();

  // ----------- BOTÃO -----------
  bool botaoAtual = digitalRead(BOTAO);
  if (botaoAnterior == HIGH && botaoAtual == LOW && (agora - tempoDebounce > intervaloDebounce)) {
    efeitoAtivo = !efeitoAtivo;
    Serial.println(efeitoAtivo ? "Efeito ATIVADO" : "Efeito DESATIVADO");
    tempoDebounce = agora;
  }
  botaoAnterior = botaoAtual;

  // ----------- LED1 (piscando cores) -----------
  if (agora - tempoLED1 >= intervaloLED1) {
    tempoLED1 = agora;
    switch (estadoLED1) {
      case 0:
        digitalWrite(LED_R, HIGH);
        digitalWrite(LED_G, LOW);
        digitalWrite(LED_B, LOW);
        Serial.println("LED_R LIGADO");
        break;
      case 1:
        digitalWrite(LED_R, LOW);
        digitalWrite(LED_G, LOW);
        digitalWrite(LED_B, HIGH);
        Serial.println("LED_B LIGADO");
        break;
      case 2:
        digitalWrite(LED_R, LOW);
        digitalWrite(LED_G, HIGH);
        digitalWrite(LED_B, LOW);
        Serial.println("LED_G LIGADO");
        break;
      case 3:
        digitalWrite(LED_R, LOW);
        digitalWrite(LED_G, LOW);
        digitalWrite(LED_B, LOW);
        Serial.println("LEDS DESLIGADOS");
        break;
    }
    estadoLED1 = (estadoLED1 + 1) % 4;
  }

  // ----------- LED2 (efeito arco-íris) -----------
  if (efeitoAtivo && agora - tempoLED2 >= intervaloLED2) {
    tempoLED2 = agora;
    uint8_t r, g, b;
    hsvToRgb(hue, 255, 100, r, g, b);
    setColorLED2(r, g, b);
    hue = (hue + 1) % 256;
  } else if (!efeitoAtivo) {
    setColorLED2(0, 0, 0); // desliga LED2
  }
}

// Atualiza LED2 com valores RGB
void setColorLED2(uint8_t r, uint8_t g, uint8_t b) {
  ledcWrite(LED2_R, r);
  ledcWrite(LED2_G, g);
  ledcWrite(LED2_B, b);
}

// Conversão HSV → RGB
void hsvToRgb(uint8_t h, uint8_t s, uint8_t v, uint8_t &r, uint8_t &g, uint8_t &b) {
  float hh = h / 255.0 * 360.0;
  float ss = s / 255.0;
  float vv = v / 100.0;

  int i = int(hh / 60.0) % 6;
  float f = (hh / 60.0) - i;
  float p = vv * (1 - ss);
  float q = vv * (1 - f * ss);
  float t = vv * (1 - (1 - f) * ss);

  float rf, gf, bf;
  switch (i) {
    case 0: rf = vv; gf = t; bf = p; break;
    case 1: rf = q; gf = vv; bf = p; break;
    case 2: rf = p; gf = vv; bf = t; break;
    case 3: rf = p; gf = q; bf = vv; break;
    case 4: rf = t; gf = p; bf = vv; break;
    case 5: rf = vv; gf = p; bf = q; break;
  }

  r = int(rf * 255);
  g = int(gf * 255);
  b = int(bf * 255);
}
