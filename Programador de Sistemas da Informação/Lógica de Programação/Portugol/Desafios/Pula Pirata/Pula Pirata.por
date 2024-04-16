programa
{
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g
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
	inteiro numeros[3][3] = {
		{7,8,9},
		{4,5,6},
		{1,2,3}
	}

	inteiro numSorteado = u.sorteia(1,9)
	inteiro tclPress

	//Verificar tecla pressionada
	funcao tecla_pressionada(){
		inteiro valor = t.ler_tecla()
		se(valor >= 97 e valor <= 105){
			tclPress = valor - 96
		}
		//verificar
		se(tclPress == numSorteado){
			pular_pirata()
		}
	}

	funcao pular_pirata(){
		
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
				g.definir_tamanho_texto(24.0)
				g.desenhar_texto(posicoes[j][0], posicoes[i][1],numeros[i][j]+"")
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
			se(t.alguma_tecla_pressionada()) tecla_pressionada()
			g.renderizar()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1546; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {numSorteado, 23, 9, 11}-{tclPress, 24, 9, 8};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */