programa
{
	
	funcao inicio()
	{
		
		escreva("Imprimindo todos os números pares e impares separados entre 1 e 50. \n")
		escreva("================================================\n")

		
		escreva("Pares \n")
		para(inteiro num=1; num<= 50; num++){

			se((num % 2) ==0){

				escreva(num, " - ")
			}
		}
		escreva("\n")
		
		escreva("Impares \n")
		para(inteiro num1=1; num1<=50; num1++){

			se((num1 % 2) ==1){

				escreva(num1, " - ")
			}
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 274; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */