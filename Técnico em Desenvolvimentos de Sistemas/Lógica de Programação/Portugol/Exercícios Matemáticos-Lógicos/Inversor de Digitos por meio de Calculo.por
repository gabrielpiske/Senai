programa
{

	/*
		Centena, dezena e unidade. Dado um número inteiro de três algarismos N = CDU (onde C é
		o algarismo das centenas, D é o algarismo das dezenas e U o algarismo das unidades),
		considere o número M constituído pelos algarismos de N em ordem inversa, isto é, M=UDC.
		Faça um programa para gerar M a partir de N (p.ex.:N=123 ->M=321).
	*/
	
	inclua biblioteca Texto --> txt
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		inteiro numero, uni, cent, dez

		escreva("Entre com um numero: \t")
		leia(numero)

		cent = numero/100
		uni = numero % 10
		dez = numero / 10 % 10
		escreva("Digito Invertido: \t",uni,dez,cent)
	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 649; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */