programa{
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> m
	inclua biblioteca Matematica --> mat

	//Estilização
	inteiro formula = g.carregar_imagem("/formula.png")

	//variavéis
	inteiro corGrade = g.criar_cor(220, 220, 220)
	logico trava_Texto[3] = {falso, falso, falso}
	inteiro numero[3] = {0, 0, 0}

	real a = numero[0]
	real b = numero[1]
	real c = numero[2]
	
	real x1 = 0.0, x2 = 0.0
	real delta = 0.0
	real xV = 0.0, xY = 0.0

	real xT[2000]
	real fX[2000]

	inteiro orgX = 750
	inteiro orgY = 350
	

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
		se(numero[1] >= 0){
			g.desenhar_texto(somaPos, 120, "x² +")
			somaPos += g.largura_texto("x² +") + 10	
		} senao{
			g.desenhar_texto(somaPos, 120, "x² -")
			somaPos += g.largura_texto("x² -") + 10
			
		}

		//Segunda caixa
		caixaTexto(somaPos, 115, 1)
		somaPos += 45

		//Texto
		se(numero[2] >= 0){
			g.desenhar_texto(somaPos, 120, "x +")
			somaPos += 45
		} senao{
			g.desenhar_texto(somaPos, 120, "x -")
			somaPos += 45
		}
		

		//Terceira Caixa
		caixaTexto(somaPos, 115, 2)
		somaPos += 45

		//Texto
		g.desenhar_texto(somaPos, 120, "= 0")
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
		se(numero[indice]>= 0){
			g.desenhar_texto(x + 35/2 - g.largura_texto(numero[indice]+"")/2, y + 35/2 - 25/2, ""+numero[indice])			
		} senao{
			g.desenhar_texto(x + 35/2 - g.largura_texto(numero[indice]+"")/2, y + 35/2 - 25/2, ""+numero[indice]*-1)
		}

		g.desenhar_imagem(40, 190, formula)
	}

	//verifica a Posição do mouse e seu clique, e retorna verdadeiro ou falso
	funcao logico estaClicado(inteiro x, inteiro y, inteiro largura, inteiro altura){
		//Posicionamento do Mouse
		se(m.posicao_x() >= x e m.posicao_x() <= x + largura e m.posicao_y() >= y e m.posicao_y() <= y + altura e m.botao_pressionado(0)){
			retorne verdadeiro
		}
		retorne falso
	}

	//Recebimento das respostas
	funcao caixaResposta(){
		
		g.desenhar_retangulo(200, 210, 70, 35, falso, falso)
		g.desenhar_texto(210,217, delta+"")
		
		g.desenhar_retangulo(200, 280, 70, 35, falso, falso)
		g.desenhar_texto(210,287,xV+"")
		
		g.desenhar_retangulo(200, 340, 70, 35, falso, falso)
		g.desenhar_texto(210,347,xY+"")
		
		g.desenhar_texto(50,440,"X1= "+mat.arredondar(x1, 2)+"")
		g.desenhar_texto(50,500,"X2= "+mat.arredondar(x2, 2)+"")
	}
	
	funcao parabola(){
		a = numero[0]
		b = numero[1]
		c = numero[2]
		
		inteiro cor_p1 = g.criar_cor(0, 0, 128)
		delta = mat.potencia(b, 2.0) - 4 * a * c

		se(delta >= 0){
			x1 = (-b + mat.raiz(delta, 2.0)) / (2*a)
			x2 = (-b - mat.raiz(delta, 2.0)) / (2*a)
		} senao{
			escreva("A equação não possui raízes reais")
		}

		real valorX = -5.0
		para(inteiro x = 0; x < 2000; x++){
			valorX += 0.02
			xT[x] = valorX
			fX[x] = (a*mat.potencia(xT[x],2.0) + b*xT[x] + c) * -50

			se(xT[x]+orgX > 500 e xT[x]+orgX < 755 e fX[x]+orgY > 100 e fX[x]+orgY < 570){
				g.desenhar_ponto(xT[x]*50+orgX, fX[x]+orgY)
				//g.desenhar_elipse(xT[x]*50+orgX, fX[x]+orgY, 2, 2, falso)
			}
		}
		
		xV = -b / 2 * a
		xY = -delta / 4 * a
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

		caixaResposta()

		parabola()

		g.renderizar()
	}

	//Inicializa o algoritmo
	funcao inicio(){
		numero[0] = 1
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1024, 600)
		g.definir_titulo_janela("Traçador Gráfico de Funções")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			//parabola()
			paint()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 4253; 
 * @DOBRAMENTO-CODIGO = [31, 45, 124, 159];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {numero, 14, 9, 6}-{a, 16, 6, 1}-{b, 17, 6, 1}-{c, 18, 6, 1}-{delta, 21, 6, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */