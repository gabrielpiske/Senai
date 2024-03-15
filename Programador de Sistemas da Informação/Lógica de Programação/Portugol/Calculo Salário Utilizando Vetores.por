programa
{
	//Vetores
	cadeia vendedor[200]
	real sal_base[200], val_venda[200], sal_final[200]
	inteiro numero
	
	funcao inicio()
	{
		escreva("Qual o numero de funcionarios (máximo de 200): ")
		leia(numero)
	
		para(inteiro c = 0; c < numero; c++){
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
		para(inteiro c = 0; c < numero; c++){
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
 * @POSICAO-CURSOR = 198; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */