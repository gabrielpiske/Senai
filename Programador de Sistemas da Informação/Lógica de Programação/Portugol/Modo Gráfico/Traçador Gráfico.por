programa{
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	inclua biblioteca Matematica --> m
	inclua biblioteca Util --> u
	
	funcao eixo(){
		g.definir_cor(g.COR_VERMELHO)

		// Linha do eixo x
		g.desenhar_linha(500, 335, 1000, 335)
		// Linha do eixo y
		g.desenhar_linha(750, 100, 750, 570)


		g.definir_cor(g.COR_PRETO)
		para(inteiro i = 500; i < 1000; i+=5){
			se(i % 50 == 0){
				//Posição de Y2 é 335
				g.desenhar_linha(i, 335-10, i, 335+10)				
			} senao {
				g.desenhar_linha(i, 335-3, i, 335+3)
			}
		}
		para(inteiro i = 100; i < 570; i+=5){
			se((i + 15) % 50 == 0){
				//Posição de Y2 é 750
				g.desenhar_linha(750-10, i, 750+10, i)				
			} senao {
				g.desenhar_linha(750-3, i, 750+3, i)
			}
		}
	}

	funcao texto(){
		
	}

	funcao parabola(){
		
	}

	funcao paint(){
		g.definir_cor(g.COR_BRANCO) //Cor fundo
		g.limpar()

		// Cor retângulo
		g.definir_cor(g.COR_PRETO)
		// Retângulo do Título
		g.desenhar_retangulo(20, 10, 980, 80, falso, falso)
		// Retângulo da Equação
		g.desenhar_retangulo(20, 100, 450, 470, falso, falso)
		// Retângulo do eixo
		g.desenhar_retangulo(500, 100, 500, 470, falso, falso)	

		eixo()
		
		g.renderizar()
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1024, 600)
		g.definir_titulo_janela("Traçador Gráfico de Funções")
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
 * @POSICAO-CURSOR = 795; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */