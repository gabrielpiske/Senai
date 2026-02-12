#define LED_R 14
#define LED_G 33
#define LED_B 32

#define LED2_R 27
#define LED2_G 26
#define LED2_B 25

void setup() {
  Serial.begin(115200);

  // LED1 com digitalWrite
  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);

  // LED2 com PWM moderno (ESP32 core 3.x)
  ledcAttach(LED2_R, 5000, 8); // 5kHz, 8 bits
  ledcAttach(LED2_G, 5000, 8);
  ledcAttach(LED2_B, 5000, 8);
}

void loop() {
  // -------- LED1 (RGB discreto) --------
  digitalWrite(LED_R, HIGH);
  digitalWrite(LED_B, LOW);
  Serial.println("LED_R LIGADO");
  delay(100);

  digitalWrite(LED_R, LOW);
  digitalWrite(LED_B, HIGH);
  Serial.println("LED_B LIGADO");
  delay(100);

  digitalWrite(LED_G, HIGH);
  digitalWrite(LED_B, LOW);
  Serial.println("LED_G LIGADO");
  delay(100);

  digitalWrite(LED_R, LOW);
  digitalWrite(LED_G, LOW);
  digitalWrite(LED_B, LOW);
  Serial.println("LEDS DESLIGADOS");

  // -------- LED2 (Efeito bonito) --------
  for (int i = 0; i < 256; i++) {
    uint8_t r, g, b;
    hsvToRgb(i, 255, 100, r, g, b); // H varia de 0 a 255
    setColorLED2(r, g, b);
    delay(15); // Quanto menor, mais rápido o efeito
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
