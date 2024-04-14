programa
{
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g
	inclua biblioteca Util --> u 
	
	//Estilização
	inteiro pirata = g.carregar_imagem("/pirata.png")
	inteiro barril = g.carregar_imagem("/barril.png")
	inteiro fundo = g.carregar_imagem("\fundo.jpg")

	//Variavéis
	inteiro fundoX = 0, fundoY = 0
	inteiro pirataX = 139, pirataY = 329 
	inteiro barrilX = 132 , barrilY = 426
	inteiro posicoes[3][2] = {{210,516}, {290,575}, {370,635}}

	inteiro numSorteado = u.sorteia(1,9)
	inteiro tclPress

	//Verificar tecla pressionada
	funcao tecla_pressionada(){
		se(t.tecla_pressionada(t.TECLA_1_NUM)){
			tclPress = 1
		} senao se(t.tecla_pressionada(t.TECLA_2_NUM)){
			tclPress = 2
		}senao se(t.tecla_pressionada(t.TECLA_3_NUM)){
			tclPress = 3
		} senao se(t.tecla_pressionada(t.TECLA_4_NUM)){
			tclPress = 4
		} senao se(t.tecla_pressionada(t.TECLA_5_NUM)){
			tclPress = 5
		} senao se(t.tecla_pressionada(t.TECLA_6_NUM)){
			tclPress = 6
		} senao se(t.tecla_pressionada(t.TECLA_7_NUM)){
			tclPress = 7
		} senao se(t.tecla_pressionada(t.TECLA_8)){
			tclPress = 8
		} senao se(t.tecla_pressionada(t.TECLA_9)){
			tclPress = 9
		}
	}
	
	//Pintura dos Componentes
	funcao paint(){
		//Componentes Gráficos
		g.desenhar_imagem(fundoX, fundoY, fundo)
		g.desenhar_imagem(pirataX, pirataY, pirata)
		g.desenhar_imagem(barrilX, barrilY, barril)
		//Números
		para(inteiro i = 0; i < 3; i++){
			para(inteiro j = 0; j < 3; j++){
				inteiro texto_index = i * 3 + j + 1
				g.definir_tamanho_texto(24)
				g.desenhar_texto(posicoes[j][0], posicoes[i][1], ""+texto_index)
			}
		}
	}

	//Inicialização do programa	
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(600, 800)
		g.definir_titulo_janela("Pula Pirata")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			paint()
			tecla_pressionada()
			g.renderizar()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1636; 
 * @DOBRAMENTO-CODIGO = [21, 44];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {numSorteado, 18, 9, 11}-{tclPress, 19, 9, 8};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */