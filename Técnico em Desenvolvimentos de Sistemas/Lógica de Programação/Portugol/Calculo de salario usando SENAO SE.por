programa
{
	real sal_base, valor, val_vendas, sal_final
	cadeia nome
	
	funcao inicio()
	{
		entrada()
	}
	funcao entrada(){
		escreva("Entre com o nome do vendedor: ")
		leia(nome)
		limpa()
		escreva("Qual é o Salario Base?: R$")
		leia(sal_base)
		limpa()
		escreva("Qual é o valor das Vendas?: R$")
		leia(val_vendas)
		limpa()	

		se(val_vendas >= 30000 e val_vendas < 50000){
			sal_final = sal_base + (val_vendas * 0.012)
		} senao se(val_vendas >= 50000 e val_vendas < 75000){
			sal_final = sal_base + (val_vendas * 0.015)
		} senao se(val_vendas >= 75000 e val_vendas < 90000){
			sal_final = sal_base + (val_vendas * 0.018)
		} senao se(val_vendas > 90000){
			sal_final = sal_base + (val_vendas * 0.025)
		} senao{
			sal_final = sal_base
		}
		escreva("O vendedor ", nome, " receberá o salário final de: R$", sal_final)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 832; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */