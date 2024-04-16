/*Enunciado
 *Escreva um software que solicite 2 numeros e realize os seguintes calculos
 	-Subtração
 	-Adição
 	-Multiplicação
 	-Divisão
 	-Média
 	-Porcentagem
 */
programa{
	
	funcao inicio(){
		real nm1, nm2, result
		escreva("Informe o primeiro número: ")
		leia(nm1)
		escreva("Informe o segundo número: ")
		leia(nm2)

		limpa()
		//Soma
		result = nm1 + nm2
		escreva("Soma: ",result,"\n")
		//Subtração
		result = nm1 - nm2
		escreva("Subtração: ",result,"\n")
		//Multiplicação
		result = nm1 * nm2
		escreva("Multiplicação: ",result,"\n")
		//Divisão
		result = nm1 / nm2
		escreva("Divisão: ",result,"\n")
		//Média
		result = (nm1+nm2) / 2
		escreva("Média: ",result,"\n")
		//Porcentagem
		result = (nm1*nm2) / 2
		escreva("Porcentagem: ",result," %\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 209; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */