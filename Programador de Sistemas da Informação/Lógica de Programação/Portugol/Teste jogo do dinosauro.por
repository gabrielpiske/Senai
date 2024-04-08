programa
{
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g
	inclua biblioteca Util --> u

	//Variavéis
	inteiro posPersonagemX = 100
	inteiro posPersonagemY = 530
	//Gravidade
	inteiro gravidade = 1
	inteiro velocidade = 0

	//Estilos
	inteiro corFundo = g.criar_cor(176,196,222)
	inteiro corPersonagem = g.criar_cor(131,111,255)
	inteiro corChao = g.criar_cor(119,136,153)
	
	funcao paint(){
		g.definir_cor(corFundo)
		g.limpar()
		//Bola
		g.definir_cor(corPersonagem)
		g.desenhar_retangulo(posPersonagemX, posPersonagemY, 30, 30, falso, verdadeiro)
		//Chão
		g.definir_cor(corChao)
		g.desenhar_retangulo(0, 560, 1000, 100, falso, verdadeiro)

		g.renderizar()
	}

	funcao pulo(){
		se(t.tecla_pressionada(t.TECLA_ESPACO)){
			velocidade = velocidade + gravidade
			posPersonagemY += gravidade
			se(posPersonagemY > 400){
				posPersonagemY = 400
				velocidade = 0
			}
			gravidades()
		}
	}

	funcao gravidades(){
		se(posPersonagemY == 400){
			posPersonagemY += 2
			u.aguarde(100)
		}
	}
	
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro) // Iniciar Modo Gráfico
		g.definir_dimensoes_janela(800, 600) // Tamanho janela
		g.definir_titulo_janela("") //Titulo
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){ //Manter janela aberta
			pulo()
			paint()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 973; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {posPersonagemY, 9, 9, 14};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */