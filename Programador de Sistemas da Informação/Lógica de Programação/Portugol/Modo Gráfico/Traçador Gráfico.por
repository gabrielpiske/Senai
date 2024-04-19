programa{
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> m

	//variavéis
	inteiro corGrade = g.criar_cor(220, 220, 220)
	logico trava_Texto[3] = {falso, falso, falso}
	inteiro numero[3] = {0, 0, 0}

	//Pintura da grade de fundo do sistema
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

	//Realiza Pintura do eixo base
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

	//Faz a exibição da fórmula incial e seus parâmetros
	funcao texto(){
		//Variavel Posição
		inteiro somaPos = 40

		//Primeira Caixa
		caixaTexto(somaPos, 115, 0)
		somaPos += 45
		
		//Texto
		g.definir_tamanho_texto(25.0)
		g.desenhar_texto(somaPos, 120, "x² +")
		somaPos += g.largura_texto("x² +") + 10

		//Segunda caixa
		caixaTexto(somaPos, 115, 1)
		somaPos += 45

		//Texto
		g.desenhar_texto(somaPos, 120, "x +")
		somaPos += 45

		//Terceira Caixa
		caixaTexto(somaPos, 115, 2)
		somaPos += 45

		//Texto
		g.desenhar_texto(somaPos, 120, "=")
		somaPos += 45
	}

	//Desenha a caixa de texto e define suas propriedades iniciais, e também, verifica qual cor ira utilizar
	funcao caixaTexto(inteiro x, inteiro y, inteiro indice){
		se(estaClicado(x, y, 35, 35)){
			para(inteiro i = 0; i < 3; i++){
				se(i == indice) trava_Texto[i] = verdadeiro
				senao trava_Texto[i] = falso
			}
		} se(trava_Texto[indice]){
			g.definir_cor(g.COR_VERMELHO)
			//Verificação Tecla
			se(t.tecla_pressionada(t.TECLA_ADICAO)){
				numero[indice]++
				u.aguarde(100)
			}
			se(t.tecla_pressionada(t.TECLA_SUBTRACAO)){
				numero[indice]--
				u.aguarde(100)
			}
		} senao{
			g.definir_cor(g.COR_PRETO)
		}
		//Desenho Retângulos
		g.desenhar_retangulo(x, y, 35, 35, falso, falso)

		//Desenho Números
		g.definir_cor(g.COR_PRETO)
		g.desenhar_texto(x + 35/2 - g.largura_texto(numero[indice]+"")/2, y + 35/2 - 25/2, ""+numero[indice])
	}

	//verifica a Posição do mouse e seu clique, e retorna verdadeiro ou falso
	funcao logico estaClicado(inteiro x, inteiro y, inteiro largura, inteiro altura){
		//Posicionamento do Mouse
		se(m.posicao_x() >= x e m.posicao_x() <= x + largura e m.posicao_y() >= y e m.posicao_y() <= y + altura e m.botao_pressionado(0)){
			retorne verdadeiro
		}
		retorne falso
	}

	funcao parabola(){
		
	}

	//Pinta os Componentes
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

		texto()

		g.renderizar()
	}

	//Inicializa o algoritmo
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
 * @POSICAO-CURSOR = 2459; 
 * @DOBRAMENTO-CODIGO = [12, 26, 130, 135, 156];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */