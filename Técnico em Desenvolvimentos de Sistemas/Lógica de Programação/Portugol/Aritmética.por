programa
{

	/*
	 	Aritmética. Escreva um programa que leia do usuário dois inteiros a e b. Seu programa deve
		computar e exibir o seguinte:
			• A soma de a e b
			• A diferença quando b é subtraído de a
			• O produto de a por b
			• O quociente quando a é dividido por b
			• O resto quando a é dividido por b
			• O resultado de ��
	 */

	 inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		inteiro a, b

		escreva("Entre com valor A: ")
		leia(a)
		escreva("Entre com valor B: ")
		leia(b)

		escreva("A soma de a e b: ", a+b,"\n")
		escreva("A diferença quando b é subtraido de a: ", b - a,"\n")
		escreva("O produto de a por b:", a * b,"\n")
		escreva("O quociente quando a é dividido por b:", a / b,"\n")
		escreva("O resto quando a é dividido por b:", a % b,"\n")
		escreva("O resultado de a^b:", m.potencia(a,b),"\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 829; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */