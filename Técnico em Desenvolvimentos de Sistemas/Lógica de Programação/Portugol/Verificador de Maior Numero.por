programa
{
	funcao inicio() 
	{
		exercicio()
	}
	funcao exercicio(){
		inteiro n1, n2, n3, maior

		escreva("Qual o 1º numero: ")
		leia(n1)
		escreva("Qual o 2º numero: ")
		leia(n2)
		escreva("Qual o 3º numero: ")
		leia(n3)

		se(n1 > n2 e n1 > n3){
			maior = n1
		} senao se(n2 > n1 e n2 > n3){
			maior = n2
		} senao{
			maior = n3
		}
		escreva("\n","O maior Número é: ", maior)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 273; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */