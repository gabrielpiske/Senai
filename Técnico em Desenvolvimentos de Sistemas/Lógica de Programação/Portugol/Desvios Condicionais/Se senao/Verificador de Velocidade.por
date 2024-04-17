/*
 	Ecsreva um programa que pergunte a velocidade de um carro
 	Caso ultrapasse 80km p/h, exiba uma mensagem dizendo que o usuario foi multado.
 	Nesse caso, exiba o vakor da multa, cobrando R$ 5,00 por cada Km acima da velocidade permitida.
 */
programa
{
	
	funcao inicio()
	{
		inteiro velocidade, multa
		
		escreva("Qual a sua velocidade? ")
		leia(velocidade)
		limpa()
		se(velocidade > 80){
			multa = (velocidade-80)*5
			escreva("Você foi multado. Valor da multa R$",multa)
		} senao{
			escreva("Dentro da velocidade permitida")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 315; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */