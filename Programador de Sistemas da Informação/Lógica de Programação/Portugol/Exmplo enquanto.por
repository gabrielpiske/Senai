programa
{
	
	funcao inicio()
	{
		logico continuar =verdadeiro
		inteiro soma = 0
		caracter resp

		escreva("Continuar ? (verdadeiro ou falso ) \n")
		leia(resp)

		enquanto(continuar){
			soma += 100
			escreva("Soma =",soma, "\n")

			escreva("Continuar ? (verdadeiro ou falso ) \n")
			leia(resp)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 310; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */