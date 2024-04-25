programa{
	
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t

	inteiro corTexto = g.criar_cor(30, 100, 90)
	inteiro pts[3][2] ={
		{300,100},
		{200,200}, 
		{100,100}
	}
	
	funcao texto(){
		g.definir_cor(corTexto)
		g.definir_tamanho_texto(25.0)
		g.desenhar_texto(20, 20, "TESTE DO DESENHAR TEXTO")
	}

	funcao shapes(){
		g.definir_cor(g.COR_AMARELO)
		g.desenhar_poligono(pts, verdadeiro)
	}
	
	funcao paint(){
		g.definir_cor(g.COR_BRANCO)
		g.limpar()

		g.definir_cor(g.COR_PRETO)
		g.desenhar_retangulo(200, 150, 400, 300, falso, falso)
		g.desenhar_elipse(250, 350, 150, 100, verdadeiro)

		shapes()
		texto()
		g.renderizar()
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800, 600)
		g.definir_titulo_janela("Utilizando Modo Gráfico")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){	
			paint()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 271; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */