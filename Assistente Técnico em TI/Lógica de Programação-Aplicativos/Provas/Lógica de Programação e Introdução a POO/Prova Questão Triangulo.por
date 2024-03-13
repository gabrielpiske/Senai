programa
{
	
	funcao inicio()
	{
		inteiro lado_1, lado_2, lado_3

		escreva("Escreva o Tamanho do Lado 1: ")
		leia(lado_1)
		escreva("Escreva o Tamanho do Lado 2: ")
		leia(lado_2)
		escreva("Escreva o Tamanho do Lado 3: ")
		leia(lado_3)

		se(lado_1 + lado_2 > lado_3 e lado_1 + lado_3 > lado_2 e lado_2 + lado_3 > lado_1)
		{
			escreva("Os três lados fornecidos podem formar um TRIÂNGULO.")
		}
		senao
		{
			escreva("Os três lados fornecidos não podem formar um TRIÂNGULO.")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 498; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */