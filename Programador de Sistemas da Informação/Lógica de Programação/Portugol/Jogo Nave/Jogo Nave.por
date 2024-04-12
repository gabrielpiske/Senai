programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g
	
	//Estilização
	inteiro nave = g.carregar_imagem("/nave_image.png")
	inteiro tiro = g.carregar_imagem("/tiro.png")
	inteiro meteoro = g.carregar_imagem("/meteoro.png")
	inteiro corTexto = g.COR_BRANCO

	//variaveis
	inteiro px = 385
	inteiro py = 285
	inteiro vida = 5
	logico disparo = falso
	inteiro metX = 800, metY = u.sorteia(50, 550)
	inteiro tx = px + 50, ty = py + 27

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
		tx = px + 50
		ty = py + 27 
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

	//Realiza o posicionamento do meteoro de forma aleatória e gerencia sua movimentação
	funcao geracao_meteoro(){
		g.desenhar_imagem(metX, metY, meteoro)
		metX = metX - 5
		se(metX <= 0){
			metX = 800
			metY = u.sorteia(50, 550)
			geracao_meteoro()
		}
	}

	//Verificação da posição da nave em relação ao meteoro, junto disso a diminuição de vidas
	funcao explodir_nave(){
		se(px == metX){
			se(py + 63 >= metY e py - 38 <= metY){
				vida -= 1
				px = 50
				py = 280
				metY = 800
			}
		}
	}
	
	//Verificar destruição do meteoro através do tiro
	funcao destruir_meteoro(){
		se(tx + 5 <= metX e tx -5 >= metX){
			se(ty > metY e ty < metY + 38){
				metX = 800
			}
		}
	}

	//verificação da quantidade das vidas
	funcao vidas(){
		se(vida <= 0){
			g.encerrar_modo_grafico()
		}
	}
	
	//Pintura dos Componentes
	funcao paint(){
		//Desenhar coisas
		g.desenhar_imagem(px, py, nave)				
		geracao_meteoro()
		//Texto
		g.definir_cor(corTexto)
		g.desenhar_texto(10, 10, "Vidas: " + vida)
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
			//Funções
			paint()
			ctrl()
			borda()
			verificarTiro()
			explodir_nave()
			vidas()
			destruir_meteoro()
			//Renderizar
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
 * @POSICAO-CURSOR = 402; 
 * @DOBRAMENTO-CODIGO = [21, 45, 53, 60, 75, 86, 107, 114];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {tx, 19, 9, 2}-{ty, 19, 23, 2};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */