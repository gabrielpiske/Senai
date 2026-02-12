#include <LiquidCrystal.h>

#define TRIGPIN 13
#define ECHOPIN 35

#define LED_R 25
#define LED_G 26
#define LED_B 27

#define BOTAO_MODO 17
#define BOTAO_RECC 16
#define BOTAO_RECB 4
#define BOTAO_RECA 0

LiquidCrystal lcd(32, 33, 23, 22, 21, 18);

long duration;
float distanceCm;
int bloco_c = 5;
int bloco_b = 10;
int bloco_a = 15;

bool modoManual = false;

void setup() {
  lcd.begin(16, 2);
  Serial.begin(115200);
  pinMode(TRIGPIN, OUTPUT);
  pinMode(ECHOPIN, INPUT);

  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_B, OUTPUT);

  pinMode(BOTAO_MODO, INPUT);
  pinMode(BOTAO_RECC, INPUT);
  pinMode(BOTAO_RECB, INPUT);
  pinMode(BOTAO_RECA, INPUT);
  iniciar();
}

void loop() {
  lcd.setCursor(0,0);
  distancia();
  if(digitalRead(BOTAO_MODO == 1)) {
    modoManual = !modoManual;
    return;
  }

  if(modoManual == false) {
    if(distanceCm >= (bloco_c - 1) && distanceCm <= (bloco_c + 1)) {
      lcd.print("Recipiente: C");
      setLEDColor(0, 0, 1);
    } else if (distanceCm >= (bloco_b - 1) && distanceCm <= (bloco_b + 1)) {
      lcd.print("Recipiente: B");
      setLEDColor(0, 1, 0);
    } else if (distanceCm >= (bloco_a - 1) && distanceCm <= (bloco_a + 1)) {
      lcd.print("Recipiente: A");
      setLEDColor(1, 0, 0);
    }
  } else {
    lcd.print("Modo Manual");
    lcd.setCursor(0,1);
    if(digitalRead(BOTAO_RECC == 1)) {
      lcd.print("Recipiente: C");
      setLEDColor(0, 0, 1);
    } else if (digitalRead(BOTAO_RECB == 1)) {
      lcd.print("Recipiente: B");
      setLEDColor(0, 1, 0);
    } else if (digitalRead(BOTAO_RECA == 1)) {
      lcd.print("Recipiente: A");
      setLEDColor(1, 0, 0);
    } 
  }

  delay(200);
}

void iniciar() {
  lcd.setCursor(4, 0);
  lcd.print("S");
  delay(100);
  lcd.setCursor(5, 0);
  delay(100);
  lcd.print("E");
  lcd.setCursor(6, 0);
  lcd.print("N");
  delay(100);
  lcd.setCursor(7, 0);
  lcd.print("A");
  delay(100);
  lcd.setCursor(8, 0);
  lcd.print("I");
  delay(100);
  lcd.setCursor(3, 1);
  lcd.print("TEC_DES");
  delay(1000);
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("seletor-de-pecas");
  delay(1000);
  lcd.clear();
}

void distancia() {
  digitalWrite(TRIGPIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIGPIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIGPIN, LOW);

  duration = pulseIn(ECHOPIN, HIGH);

  distanceCm = (duration / 2.0) / 29.1;

  Serial.print("Distancia: ");
  Serial.print(distanceCm);
  Serial.println(" cm");
}

void setLEDColor(bool r, bool g, bool b) {
  digitalWrite(LED_R, r ? HIGH : LOW);
  digitalWrite(LED_G, g ? HIGH : LOW);
  digitalWrite(LED_B, b ? HIGH : LOW);
}