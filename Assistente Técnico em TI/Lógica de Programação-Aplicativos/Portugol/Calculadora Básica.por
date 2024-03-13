programa
{
	
	funcao inicio()
	{

	real valor1, valor2
	inteiro op





	escreva("°--CALCULADORA--°", "\n")
	escreva("°-----MENU-----°", "\n")
	escreva("1-Adição", "\n")
	escreva("2-Subtração", "\n")
	escreva("3-Multiplicação", "\n")
	escreva("4-Divisão", "\n")

	escreva("----------", "\n")
	
	escreva("Valor 1: ")
	leia(valor1)

	escreva("Valor 2: ")
	leia(valor2)

	escreva("\n", "Escolha uma operação: ")
	leia(op)

	escolha(op)
	{

	caso 1:
	escreva("\n", "O RESULTADO É: ", valor1+valor2)
	pare

	caso 2:
	escreva("\n", "O RESULTADO É: ", valor1-valor2)
	pare

	caso 3:
	escreva("\n", "O RESULTADO É: ", valor1*valor2)
	pare

	caso 4:
	escreva("\n", "O RESULTADO É: ", valor1/valor2)
	pare

	caso contrario:
	escreva("Esse comando não é valido")
	pare
		
	}
	


	

	


		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 757; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */