programa
{
	//Vetores
	cadeia vendedor[5]
	real sal_base[5], val_venda[5], sal_final[5]
	
	
	funcao inicio()
	{
		para(inteiro c = 0; c < 5; c++){
			//Entrada de Dados
			escreva("Qual o Nome do Vendedor? : ")
			leia(vendedor[c])
			escreva("Qual o Salario Base do Vendedor? : ")
			leia(sal_base[c])
			escreva("Qual o Valor das Vendas do Vendedor? : ")
			leia(val_venda[c])
			
			//Calculo Salario Final
			sal_final[c] = (sal_base[c]+val_venda[c] * 0.015)
		}
		escreva("-----------Saída de Dados-----------")
		para(inteiro c = 0; c < 5; c++){
			//Saída de Dados
			escreva("\n" + vendedor[c] + "\t | " + sal_base[c] + " | " + sal_final[c])			
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 91; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vendedor, 4, 8, 8}-{sal_base, 5, 6, 8}-{val_venda, 5, 19, 9}-{sal_final, 5, 33, 9};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */