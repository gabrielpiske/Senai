programa{
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	inclua biblioteca Matematica --> m
	inclua biblioteca Util --> u

	//variavéis
	inteiro corGrade = g.criar_cor(220, 220, 220)

	funcao grade(){
		//Grade Vertical
		para(inteiro i = 505; i < 997; i+=5){
			//Horizontal
			g.definir_cor(corGrade)
			g.desenhar_linha(i, 101, i, 569)
		}
		//Grade Horizontal
		para(inteiro i = 105; i < 567; i+=5){
			g.desenhar_linha(501, i, 999, i)
		}
	}

	
	funcao eixo(){
		//Pintura Grade
		grade()
		
		//Cor Eixo
		g.definir_cor(g.COR_VERMELHO)

		// Linha do eixo x
		g.desenhar_linha(500, 335, 1000, 335)
		// Linha do eixo y
		g.desenhar_linha(750, 100, 750, 570)

		
		g.definir_cor(g.COR_PRETO)
		//Horizontal
		para(inteiro i = 500; i < 1000; i+=5){
			se(i % 50 == 0){
				g.desenhar_linha(i, 325, i, 345)
			}
			senao{
				g.desenhar_linha(i, 332, i, 338)
			}
		}
		
		//Vertical
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
	
	funcao inicio(){
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
 * @POSICAO-CURSOR = 868; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */