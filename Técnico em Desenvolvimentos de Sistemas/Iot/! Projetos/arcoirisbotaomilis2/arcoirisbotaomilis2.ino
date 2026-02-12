// Definição dos pinos dos botões
#define BOTAO_SISTEMA 17
#define BOTAO_R 0
#define BOTAO_G 4
#define BOTAO_B 16

// Definição dos pinos do LED RGB
#define LED_R 25
#define LED_G 26
#define LED_B 27

// Definição dos pinos dos LEDs que piscam sequencialmente
#define LED_SEQ_1 14
#define LED_SEQ_2 33
#define LED_SEQ_3 32

// Estado do sistema
bool sistemaLigado = true;

// Tempo de pressionamento dos botões
unsigned long pressStart_R = 0;
unsigned long pressStart_G = 0;
unsigned long pressStart_B = 0;

// Valor final das cores
int valor_R = 0;
int valor_G = 0;
int valor_B = 0;

// Estado anterior dos botões
bool estadoAnteriorBotaoSistema = HIGH;
bool estadoAnteriorBotaoR = HIGH;
bool estadoAnteriorBotaoG = HIGH;
bool estadoAnteriorBotaoB = HIGH;

// Controle do piscar sequencial
unsigned long ultimoPiscar = 0;
int estadoPiscar = 0;

void setup() {
  Serial.begin(115200);

  // Configura pinos dos botões com pull-up
  pinMode(BOTAO_SISTEMA, INPUT_PULLUP);
  pinMode(BOTAO_R, INPUT_PULLUP);
  pinMode(BOTAO_G, INPUT_PULLUP);
  pinMode(BOTAO_B, INPUT_PULLUP);

  // Configura pinos dos LEDs que piscam
  pinMode(LED_SEQ_1, OUTPUT);
  pinMode(LED_SEQ_2, OUTPUT);
  pinMode(LED_SEQ_3, OUTPUT);

  // LED RGB com PWM moderno
  ledcAttach(LED_R, 5000, 8);
  ledcAttach(LED_G, 5000, 8);
  ledcAttach(LED_B, 5000, 8);
}

void loop() {
  unsigned long agora = millis();

  // -------- BOTÃO SISTEMA ON/OFF --------
  bool leituraSistema = digitalRead(BOTAO_SISTEMA);
  if (estadoAnteriorBotaoSistema == HIGH && leituraSistema == LOW) {
    sistemaLigado = !sistemaLigado;
    Serial.println(sistemaLigado ? "SISTEMA LIGADO" : "SISTEMA DESLIGADO");

    if (!sistemaLigado) {
      valor_R = valor_G = valor_B = 0;
      atualizarLED();
      // Desliga LEDs sequenciais também
      digitalWrite(LED_SEQ_1, LOW);
      digitalWrite(LED_SEQ_2, LOW);
      digitalWrite(LED_SEQ_3, LOW);
    }

    delay(200);
  }
  estadoAnteriorBotaoSistema = leituraSistema;

  if (!sistemaLigado) return;

  // -------- PISCAR SEQUENCIAL --------
  piscarSequencial(agora);

  // -------- BOTÃO R --------
  bool leituraR = digitalRead(BOTAO_R);
  if (estadoAnteriorBotaoR == HIGH && leituraR == LOW) {
    pressStart_R = agora;
  }
  if (estadoAnteriorBotaoR == LOW && leituraR == HIGH) {
    unsigned long duracao = agora - pressStart_R;
    valor_R = mapTempoParaPWM(duracao);
    atualizarLED();
  }
  estadoAnteriorBotaoR = leituraR;

  // -------- BOTÃO G --------
  bool leituraG = digitalRead(BOTAO_G);
  if (estadoAnteriorBotaoG == HIGH && leituraG == LOW) {
    pressStart_G = agora;
  }
  if (estadoAnteriorBotaoG == LOW && leituraG == HIGH) {
    unsigned long duracao = agora - pressStart_G;
    valor_G = mapTempoParaPWM(duracao);
    atualizarLED();
  }
  estadoAnteriorBotaoG = leituraG;

  // -------- BOTÃO B --------
  bool leituraB = digitalRead(BOTAO_B);
  if (estadoAnteriorBotaoB == HIGH && leituraB == LOW) {
    pressStart_B = agora;
  }
  if (estadoAnteriorBotaoB == LOW && leituraB == HIGH) {
    unsigned long duracao = agora - pressStart_B;
    valor_B = mapTempoParaPWM(duracao);
    atualizarLED();
  }
  estadoAnteriorBotaoB = leituraB;
}

// Atualiza a cor do LED com os valores atuais
void atualizarLED() {
  ledcWrite(LED_R, valor_R);
  ledcWrite(LED_G, valor_G);
  ledcWrite(LED_B, valor_B);

  Serial.print("R: ");
  Serial.print(valor_R);
  Serial.print(" G: ");
  Serial.print(valor_G);
  Serial.print(" B: ");
  Serial.println(valor_B);
}

// Mapeia o tempo pressionado (ms) para um valor de 0 a 255
int mapTempoParaPWM(unsigned long duracao) {
  const unsigned long TEMPO_MAX = 3000;
  if (duracao > TEMPO_MAX) duracao = TEMPO_MAX;
  return map(duracao, 0, TEMPO_MAX, 0, 255);
}

// Piscar LEDs nas portas 14, 33 e 32 sequencialmente a cada 100ms
void piscarSequencial(unsigned long agora) {
  const unsigned long intervalo = 100;

  if (agora - ultimoPiscar >= intervalo) {
    // Apaga todos
    digitalWrite(LED_SEQ_1, LOW);
    digitalWrite(LED_SEQ_2, LOW);
    digitalWrite(LED_SEQ_3, LOW);

    // Liga o LED da vez
    switch (estadoPiscar) {
      case 0: digitalWrite(LED_SEQ_1, HIGH); break;
      case 1: digitalWrite(LED_SEQ_2, HIGH); break;
      case 2: digitalWrite(LED_SEQ_3, HIGH); break;
    }

    // Atualiza estado e tempo
    estadoPiscar = (estadoPiscar + 1) % 3;
    ultimoPiscar = agora;
  }
}
