programa
{
	//Estrutura de dodos --> VETOR

	caracter letras[] = {'p','a','r','a','l','e','l','o','g','r','a','m','o'}
	real valores[5]

	funcao inicio()
	{
		valores[0] = 5.8
		valores[1] = 7.4
		valores[2] = 3.8
		valores[3] = 6.3
		valores[4] = 5.5		

		para(inteiro c = 0; c < 8; c++){
			escreva(letras[c])
		}
		escreva("\n")

		escreva("SOMA: ", valores[2]+valores[3])
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 387; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */