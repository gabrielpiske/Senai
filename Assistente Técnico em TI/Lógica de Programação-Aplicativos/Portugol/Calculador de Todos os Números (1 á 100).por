programa
{
	
	funcao inicio()
	{

		escreva("Escrevendo todos os numeros pares de 1 até 100 \n")
		escreva("===============================================\n")


		inteiro contador = 0
		inteiro valor


		faca{
			
			contador++
			valor = contador % 2
			se(valor == 0){
				se(contador < 10){
					escreva("0")
					
				}
				escreva(contador, " - ")
			}

			se((contador % 10) ==1){
				escreva("\n")
				
			}
			
		}
		enquanto(contador <= 100)
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 352; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */