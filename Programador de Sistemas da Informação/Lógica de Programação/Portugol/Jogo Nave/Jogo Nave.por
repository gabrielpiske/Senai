programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g
	
	//Estilização
	inteiro nave = g.carregar_imagem("/nave_image.png")
	inteiro tiro = g.carregar_imagem("/tiro.png")
	inteiro corTexto = g.COR_BRANCO

	//variaveis
	inteiro px = 385
	inteiro py = 285
	logico disparo = falso

	//Controle de Movimento
	funcao ctrl(){
		//Tecla: W
		se(t.tecla_pressionada(t.TECLA_W) ou t.tecla_pressionada(t.TECLA_SETA_ACIMA)){
			py-=5
			//g.definir_rotacao(-90)
		}
		// Tecla: S
		se(t.tecla_pressionada(t.TECLA_S) ou t.tecla_pressionada(t.TECLA_SETA_ABAIXO)){
			py+=5
			//g.definir_rotacao(90)
		}
		// Tecla: D
		se(t.tecla_pressionada(t.TECLA_D) ou t.tecla_pressionada(t.TECLA_SETA_DIREITA)){
			px+=5
			//g.definir_rotacao(0)
		}
		// Tecla: A
		se(t.tecla_pressionada(t.TECLA_A) ou t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)){
			px-=5
			//g.definir_rotacao(180)
		}
	}
	
	//Função que não deixa a nave sair da tela
	funcao borda(){
		se(px <= 0) px = 0
		se(px >= 750) px = 750
		se(py <= 0) py = 0
		se(py >= 550) py = 550
	}

	//Verifica Tecla do Tiro
	funcao verificarTiro(){
		se(t.tecla_pressionada(t.TECLA_ESPACO)){
			atirar()
		}		
	}

	//Criação da bala do tiro
	funcao atirar(){
		inteiro tx = px + 50, ty = py + 27 
		enquanto(tx < 800){
			paint()
			ctrl()
			borda()
			g.desenhar_imagem(tx, ty, tiro)
			tx+=20
			g.renderizar()
			u.aguarde(10)
		}
	}
	
	//Pintura dos Componentes
	funcao paint(){
		//Desenhar nave
		g.desenhar_imagem(px, py, nave)
		//Texto
		g.definir_cor(corTexto)
		g.desenhar_texto(730, 10, "Cordenadas")
		g.desenhar_texto(755, 30, "X: " + px + "")
		g.desenhar_texto(755, 50, "Y: " + py + "")
	}

	//Inicialização do Sistema
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800, 600)
		g.definir_titulo_janela("Exercício - Modo Gráfico")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			paint()
			ctrl()
			borda()
			verificarTiro()
			g.renderizar()
			u.aguarde(10)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1690; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */