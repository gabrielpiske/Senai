programa
{	
	inteiro n1, n2, n3, n4, n5
	
	funcao inteiro media(inteiro n1, inteiro n2, inteiro n3, inteiro n4, inteiro n5){
		inteiro media = 0
		media = (n1+n2+n3+n4+n5)/5
		retorne media
	}

	
	funcao inicio()
	{
		inteiro numero1, numero2, numero3, numero4, numero5, media2
		
		escreva("Entre com o numero 1: ")
		leia(numero1)
		limpa()
		escreva("Entre com o numero 2: ")
		leia(numero2)
		limpa()
		escreva("Entre com o numero 3: ")
		leia(numero3)
		limpa()
		escreva("Entre com o numero 4: ")
		leia(numero4)
		limpa()
		escreva("Entre com o numero 5: ")
		leia(numero5)
		limpa()
		media2 = media(numero1,numero2,numero3,numero4,numero5)
		escreva("Média é ", media2)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 337; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */