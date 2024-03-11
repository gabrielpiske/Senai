programa
{
	
	funcao inicio()
	{

		logico controle = falso
		caracter resp

		
		enquanto(controle != verdadeiro){
			escreva("Estou executando o laçon\n")

			escreva("Deseja continuar executando? (S / N)\n")
			leia(resp)

			se(resp == 'S'){
				controle = falso
			}
			senao{
				controle = verdadeiro
			}
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 118; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */