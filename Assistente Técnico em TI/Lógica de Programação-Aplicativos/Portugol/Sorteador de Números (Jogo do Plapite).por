programa
{
	inclua biblioteca Util
	
		funcao inicio()
	{
	
		inteiro chute = 0
		inteiro resp
		inteiro try = 0
		caracter reiniciar = 'X'

		escreva("------JOGO DA ADIVINHAÇÃO------\n")
		resp = Util.sorteia(1, 50)
		escreva("Digite um número de 1 a 50: \n")

		enquanto(reiniciar != 'N')
		{

			enquanto(chute != resp)
			{
				leia(chute)
				se(chute < resp)
				{
					escreva("Escolha um numero maior: \n")
				}
				se(chute > resp)
				{
					escreva("Escolha um numero menor: \n")
				}
				try++
			}
			escreva("Parabéns! Você acertou!\nForam feitas ", try, " tentativas")
			escreva("\nDigite S para jogar novamente e N para encerrar\n")
			leia(reiniciar)
			se(reiniciar == 'S')
			{
				try = 0
				resp = Util.sorteia(1, 50)
				escreva("Digite um numero de 1 a 50:\n")

				}
			}
		}
		
	}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 806; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */