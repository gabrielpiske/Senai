programa
{
	//Bibliotecas
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	inclua biblioteca Util --> u

	//Variaveis Globais
	inteiro bola_x = 385
	inteiro bola_y = 285
	inteiro v = 5

	//Estilização
	inteiro corFundo = g.criar_cor(100,149,237)

	funcao movimentoBola(){
		se(t.tecla_pressionada(t.TECLA_SETA_ACIMA) ou t.tecla_pressionada(t.TECLA_W)){
			bola_y--
			u.aguarde(v)
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO) ou t.tecla_pressionada(t.TECLA_S)){
			bola_y++
			u.aguarde(v)
		}
		se(t.tecla_pressionada(t.TECLA_SETA_DIREITA) ou t.tecla_pressionada(t.TECLA_D)){
			bola_x++
			u.aguarde(v)
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA) ou t.tecla_pressionada(t.TECLA_A)){
			bola_x--
			u.aguarde(v)
		}
		//Velocidade
		se(v>0){
			//Aumentar
			se(t.tecla_pressionada(t.TECLA_ADICAO)){
				v--
				u.aguarde(50)
			}
		}
		se(v<10){
			//Diminuir
			se(t.tecla_pressionada(t.TECLA_SUBTRACAO)){
				v++
				u.aguarde(50)
			}	
		}
	}
	
	funcao paint(){
		g.definir_cor(corFundo)
		g.limpar()
		g.definir_cor(g.COR_PRETO)
		g.desenhar_elipse(bola_x, bola_y, 30, 30, verdadeiro)
		g.renderizar()
	}
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800, 600)
		g.definir_titulo_janela("Modo Gráfico")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			paint()
			movimentoBola()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 204; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */