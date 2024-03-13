programa
{
	inclua biblioteca Mouse --> r
	inclua biblioteca Matematica --> m
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g

	///Variáveis globais

	inteiro px = 25
	inteiro py = 25
	logico movimentacao = falso
	logico new = verdadeiro
	
	funcao bolinha(inteiro x, inteiro y)
	{
		////criar bolinha
		inteiro cor_bolinha = g.criar_cor(128,0,0)
		g.definir_cor(cor_bolinha)
		g.desenhar_elipse(x-10, y-5, 25, 25, verdadeiro)
	}
	
	funcao paint()
	{
		///aparecer coisas
		inteiro cor_salmao = g.criar_cor(250,128,114)
		g.definir_cor(cor_salmao)
		g.limpar()
		bolinha(px, py)		
		g.renderizar()
	}
	funcao ctrl()
	{
		//movimentacaoimentação
		se(movimentacao == falso)
		{
			se(t.tecla_pressionada(t.TECLA_SETA_DIREITA))
			{
				u.aguarde(5)
				px++
				se(px>575)
				px = 575		
			}
			se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA))
			{
				u.aguarde(5)
				px--
				se(px<25)
				px = 25
			}
			se(t.tecla_pressionada(t.TECLA_SETA_ACIMA))
			{
				u.aguarde(5)
				py--
				se(py<10)
				py=10

			}
			se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO))
			{
				u.aguarde(5)
				py++
				se(py>475)
				py=475
			}
 		}
	}
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(600, 500)
		g.definir_titulo_janela("Jogo da Bolinha")

		enquanto(nao t.tecla_pressionada(t.TECLA_ESC))
		{
			paint()
			ctrl()
		}

	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 618; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */