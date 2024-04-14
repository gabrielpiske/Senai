programa
{
	
	funcao inicio()
	{
		logico continuar = verdadeiro
		inteiro soma=0
		caracter resp
/*
		escreva("Deseja Continuar ? (verdadeiro (1) ou falso (0)) \n")
		leia(resp)
		se(resp == '1') continuar = verdadeiro
		se(resp == '0') continuar = falso
*/
		faca{
			escreva("Continuar ? (verdadeiro (1) ou falso (0)) \n")
			leia(resp)

			se(resp == '1') continuar = verdadeiro
			se(resp == '0') continuar = falso

			soma += 100
			escreva("SOMA = ",soma,"\n1")
		}enquanto(continuar)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 425; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */