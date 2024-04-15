programa
{
	/*
	 	Faça um programa que leia um número inteiro de cinco algarismos (variável codigo) e gere e
		imprima o dígito verificador (digitoV) módulo 7 para o mesmo.
		O dígito verificador pode ser calculado da seguinte maneira: supondo que os cinco algarismos
		do código são ABCDE, uma forma de calcular o dígito desejado, com módulo 7 é:
		S = 6*A + 5*B + 4*C + 3*D + 2*E
		digito_verificador = resto da divisão de S por 7
	 */

	
	funcao inicio()
	{
		inteiro codigo, digitoV,  a,b,c,d,es, s

		escreva("Entre com o código: ")
		leia(codigo)

		a = codigo / 10000
		b = codigo / 1000 % 10
		c = codigo / 100 % 10
		d = codigo / 10 % 10
		es = codigo % 10

		s = 6*a + 5*b + 4*c + 3*d + 2*es

		digitoV = s % 7

		escreva("Código Verificador: ", digitoV)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 558; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {codigo, 15, 10, 6}-{digitoV, 15, 18, 7}-{a, 15, 28, 1}-{b, 15, 30, 1}-{c, 15, 32, 1}-{d, 15, 34, 1}-{es, 15, 36, 2};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */