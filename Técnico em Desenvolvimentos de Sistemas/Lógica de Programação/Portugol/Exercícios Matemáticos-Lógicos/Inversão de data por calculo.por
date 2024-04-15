programa
{
	/*
		Decompondo uma data. Admitindo que uma data é lida por um algoritmo em uma variável
		inteira, e não em uma variável do tipo data, crie um programa que leia uma data no tipo de
		dados de número inteiro no formato DDMMAA e imprima essa data no formato AAMMDD, onde:
			• a letra D corresponde a dois algarismos representando o dia;
			• a letra M corresponde a dois algarismos representando o mês;
			• a letra A corresponde aos dois últimos algarismos representando o ano."
	*/
	
	
	funcao inicio()
	{
		inteiro data, dia, mes, ano

		escreva("Entre com uma data no formato dia/mes/ano: ")
		leia(data)

		dia = data/10000
		ano = data % 100
		mes = data / 100 % 100

		escreva("Data invertida: ", ano,"/",mes,"/",dia)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 499; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {data, 15, 10, 4}-{dia, 15, 16, 3}-{mes, 15, 21, 3}-{ano, 15, 26, 3};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */