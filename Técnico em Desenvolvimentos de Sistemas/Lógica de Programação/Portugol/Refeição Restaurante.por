programa
{

	/*
	 	Conta do almoço. Imagine que você foi almoçar num restaurante, e pediu uma refeição com
		um suco, um prato principal e uma sobremesa. Cada um desses itens tem um preço unitário.
		Ao final, o valor da conta deve ser a soma do valor dos itens consumidos, acrescida de 10% de
		taxa de serviço. Faça um programa para receber estes dados do usuário e calcular o valor total
		da conta deste tipo de refeição. Exiba a resposta com os mesmos critérios de formatação da
		questão anterior (R$ e 2 casas decimais).
	 */

	 inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		real prato, valorF = 0.0
		logico veref = falso
		caracter s = ' '

		faca{
			escreva("Entre com o valor da refeição: ")
			leia(prato)
			limpa()
			
			valorF += prato

			escreva("Mais algum valor?: ")
			leia(s)
			limpa()
			
			se(s != 's') veref = verdadeiro
			
		}enquanto(veref == falso)
		valorF += valorF * 0.10
		escreva("Valor total da refeição: R$", m.arredondar(valorF, 2))
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 866; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {prato, 17, 7, 5}-{valorF, 17, 14, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */