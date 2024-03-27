programa
{
	inteiro op
	
	funcao inicio()
	{
		escreva("|========= MENU ========|\n")
		escreva("|1- Somar \t\t| \n|2- Subtrair \t\t| \n|3- Multiplicar \t| \n|4- Dividir \t\t|")
		escreva("\n|=======================|\n")
		escreva("Escolha uma operação: ")
		leia(op)

		escolha(op){
			caso 1:
				escreva("Somar")
			pare
			caso 2:
				escreva("Subtrair")
			pare
			caso 3:
				escreva("Multiplicar")
			pare
			caso 4:
				escreva("Dividir")
			pare
			caso contrario:
				escreva("Opção inválida")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 219; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */