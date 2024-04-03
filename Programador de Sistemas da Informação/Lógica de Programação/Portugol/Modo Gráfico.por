programa
{
	//Bibliotecas
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	inclua biblioteca Util --> u

	//Variaveis Globais
	inteiro bola_x = 385 //Posição X da bola
	inteiro bola_y = 285 //Posição Y da bola 
	inteiro v = 5
	
	//Estilos
	inteiro corFundo = g.criar_cor(100,149,237) //Azul Claro
	inteiro corBola = g.criar_cor(138,43,226) //Roxo Claro
	inteiro corTexto = g.criar_cor(0,0,0) // Preto

	//Movimentação pelo Teclado
	funcao movimentoBola(){
		// Teclas: W / Cima
		se(t.tecla_pressionada(t.TECLA_SETA_ACIMA) ou t.tecla_pressionada(t.TECLA_W)){
			bola_y--
			u.aguarde(v)
		}
		// Teclas: S / Baixo
		se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO) ou t.tecla_pressionada(t.TECLA_S)){
			bola_y++
			u.aguarde(v)
		}
		// Teclas: D / Direita
		se(t.tecla_pressionada(t.TECLA_SETA_DIREITA) ou t.tecla_pressionada(t.TECLA_D)){
			bola_x++
			u.aguarde(v)
		}
		// Teclas: A / Esquerda
		se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA) ou t.tecla_pressionada(t.TECLA_A)){
			bola_x--
			u.aguarde(v)
		}
		//Verificação Borda
		se(bola_y <= -30){
			bola_y = 629
		}
		se(bola_y >= 630){
			bola_y = -29
		}
		se(bola_x <= -30){
			bola_x = 829
		}
		se(bola_x >= 830){
			bola_x = -29
		}
		
		//Tiro
		se(t.tecla_pressionada(t.TECLA_ESPACO)){
			enquanto(bola_x != 830){
				v = 10
				bola_x++
				paint()
			}
		}
		
		//Calculo Velocidade
		se(v>0){
			//Aumentar Velocidade
			se(t.tecla_pressionada(t.TECLA_ADICAO)){
				v--
				u.aguarde(50)
			}
		}
		se(v<10){
			//Diminuir Velocidade
			se(t.tecla_pressionada(t.TECLA_SUBTRACAO)){
				v++
				u.aguarde(50)
			}	
		}
	}
	funcao paint(){
		g.definir_cor(corFundo)
		g.limpar()
		//Bola
		g.definir_cor(corBola)
		g.desenhar_elipse(bola_x, bola_y, 30, 30, verdadeiro)
		//Texto
		g.definir_cor(corTexto)
		g.desenhar_texto(10, 10, "Velocidade: " + (10 - v) + "")
		g.desenhar_texto(10, 30, "X: " + bola_x + "")
		g.desenhar_texto(10, 50, "Y: " + bola_y + "")
		//Pintar Componentes
		g.renderizar()
	}
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro) // Iniciar Modo Gráfico
		g.definir_dimensoes_janela(800, 600) // Tamanho janela
		g.definir_titulo_janela("Modo Gráfico") //Titulo
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){ //Manter janela aberta
			paint()
			movimentoBola()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1343; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {bola_x, 9, 9, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */