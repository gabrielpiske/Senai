programa
{
	
	funcao inicio()
	{
		inteiro op = 0
		real resultFinal=0, nm1=0, nm2=0

		escreva("Entre com o primeiro numero: ")
		leia(nm1)
		escreva("Entre com o segundo numero: ")
		leia(nm2)

		limpa()

		escreva("| Escolha abaixo a operação desejada |\n")
		escreva("| 1- Soma                            |\n")
		escreva("| 2- Subtração                       |\n")
		escreva("| 3- Divisão                         |\n")
		escreva("| 4- Multiplicação                   |\n")
		escreva("| 5- Média                           |\n")
		escreva("|____________________________________|\n")
		escreva("Entrada: ")
		leia(op)

		escolha(op){
			caso 1:
				resultFinal = nm1 + nm2
			pare
			caso 2:
				resultFinal = nm1 - nm2
			pare
			caso 3:
				resultFinal = nm1 / nm2
			pare
			caso 4:
				resultFinal = nm1 * nm2
			pare
			caso 5:
				resultFinal = (nm1+nm2) / 2
			pare
		}
		limpa()
		escreva("Resultado da Operação é: ", resultFinal)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 551; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */