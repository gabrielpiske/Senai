programa{

	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	
	inteiro pts[4][2] ={
		{10, 150},
		{200, 10}, 
		{390, 150},
		{200, 290}
	}
	
	funcao paint(){
		g.definir_cor(g.COR_VERDE)
		g.limpar()

		g.definir_cor(g.COR_AMARELO)
		g.desenhar_poligono(pts, verdadeiro)

		g.definir_cor(g.COR_AZUL)
		g.desenhar_elipse(200-50, 150-50, 100, 100, verdadeiro)
		
		g.renderizar()
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(400, 300)
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
 * @POSICAO-CURSOR = 357; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */