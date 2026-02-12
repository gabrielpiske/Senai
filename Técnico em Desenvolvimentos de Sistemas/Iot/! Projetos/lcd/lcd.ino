#include <LiquidCrystal.h>

LiquidCrystal lcd(32, 33, 23, 22, 21, 18);

void setup() {
  lcd.begin(16, 2);
  iniciar();
}

void loop() {
  moverTexto();
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
}

void moverTexto() {
  // Texto a mostrar
  const char* linha1 = "PISKE";
  const char* linha2 = "JULIO";
  int maxPos = 16 - 5; 
  
  // Mover da esquerda para direita
  for (int pos = 0; pos <= maxPos; pos++) {
    lcd.clear();
    lcd.setCursor(pos, 0);
    lcd.print(linha1);
    lcd.setCursor(pos, 1);
    lcd.print(linha2);
    delay(300);
  }

  // Mover da direita para esquerda
  for (int pos = maxPos; pos >= 0; pos--) {
    lcd.clear();
    lcd.setCursor(pos, 0);
    lcd.print(linha1);
    lcd.setCursor(pos, 1);
    lcd.print(linha2);
    delay(300);
  }
}
