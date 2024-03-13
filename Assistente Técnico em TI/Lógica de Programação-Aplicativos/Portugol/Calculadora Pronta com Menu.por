programa
{
	funcao vazio menu()
	{

		escreva("°--CALCULADORA--°", "\n")
		escreva("°-----MENU-----°", "\n")
		escreva("1-Adição", "\n")
		escreva("2-Subtração", "\n")
		escreva("3-Multiplicação", "\n")
		escreva("4-Divisão", "\n")
		escreva("\n")
		escreva("°--Escolha uma operação--°")
		escreva("\n\n")
		escreva("Tecle 0 para terminar ")
		escreva("\n\n")
		escreva("==============================")
		escreva("\n\n")
		
	}

	
	funcao inicio()
	{

		inteiro op = -1
		real valor1, valor2

			
		enquanto(op !=0)
		{

			limpa()
			menu()
			escreva("Entre o valor 1: ")
			leia(valor1)
			escreva("Entre o valor 2: ")
			leia(valor2)
			escreva("Escolha a operação: ")
			leia(op)
			
			se(op == 1)
				escreva("A soma dos valores é igual a: ", valor1+valor2, "\n")
			se(op == 2)
				escreva("A soma dos valores é igual a: ", valor1-valor2, "\n")
			se(op == 3)
				escreva("A soma dos valores é igual a: ", valor1*valor2, "\n")
			se(op == 4)
				escreva("A soma dos valores é igual a: ", valor1/valor2, "\n")

			escreva("Deseja continuar? (Sim = 1, Não = 0)")
			leia(op)
			
		}
		

		

	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 546; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */