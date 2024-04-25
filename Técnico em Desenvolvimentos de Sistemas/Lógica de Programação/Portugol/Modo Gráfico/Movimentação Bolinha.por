programa
{
	
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	inclua biblioteca Util --> u

	inteiro bolaX = 400, bolaY = 300

	funcao mover(){
		se(t.tecla_pressionada(t.TECLA_SETA_DIREITA)){
			bolaX++
			u.aguarde(1)
		} se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)){
			bolaX--
			u.aguarde(1)
		} se(t.tecla_pressionada(t.TECLA_SETA_ACIMA)){
			bolaY--
			u.aguarde(1)
		} se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO)){
			bolaY++
			u.aguarde(1)
		}
	}

	funcao verificarBorda(){
		se(bolaX <= 0) bolaX = 0
		se(bolaX >= 750) bolaX = 750
		se(bolaY <= 0) bolaY = 0
		se(bolaY >= 550) bolaY = 550		
	}
	
	funcao paint(){
		g.definir_cor(g.COR_BRANCO)
		g.limpar()

		g.definir_cor(g.COR_PRETO)
		g.desenhar_elipse(bolaX, bolaY, 20, 20, verdadeiro)

		g.renderizar()
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800, 600)
		g.definir_titulo_janela("Utilizando Modo Gráfico")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			verificarBorda()	
			mover()
			paint()
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 531; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {bolaX, 8, 9, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */