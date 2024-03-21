programa
{
	
	funcao inicio()
	{
		real sal_base, valor, val_vendas, sal_final

		escreva("Qual é o Salario Base?: R$")
		leia(sal_base)
		escreva("Qual é o valor das Vendas?: R$")
		leia(val_vendas)

		se(val_vendas >= 20000 e val_vendas < 35000){
			sal_final = sal_base + (val_vendas * 0.012)
		} senao se(val_vendas >= 35000 e val_vendas < 50000){
			sal_final = sal_base + (val_vendas * 0.015)
		} senao se(val_vendas >= 50000 e val_vendas < 80000){
			sal_final = sal_base + (val_vendas * 0.018)
		} senao se(val_vendas > 80000){
			sal_final = sal_base + (val_vendas * 0.025)
		} senao{
			sal_final = sal_base
		}
		escreva("\nO salario final é: R$", sal_final) 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 675; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */