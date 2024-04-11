programa
{
	/*
	 	Soma dos dígitos de um inteiro. Desenvolva um programa que obtenha do usuário
		um número inteiro de 4 dígitos e exiba a soma dos dígitos do número. Por exemplo, se
		o usuário fornecer o número 3141, então seu programa deve exibir o número 9 (3 + 1
		+ 4 + 1).
	 */
	
	funcao inicio()
	{
		inteiro numero, a,b,c,d,soma
		
		escreva("Entre com um numero: ")
		leia(numero)
		
		a = numero / 1000
		b = numero / 100 % 10
		c = numero / 10 % 10
		d = numero % 10
		soma = a+b+c+d

		escreva("A soma é: ",soma)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 483; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */