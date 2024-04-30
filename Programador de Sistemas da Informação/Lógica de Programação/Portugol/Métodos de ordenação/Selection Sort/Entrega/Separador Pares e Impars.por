programa{
	
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[15], tam = 15, index, memoria, pares[15], impar[15]
		escreva("Valores originais: ")
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(1, 50)
			escreva(vetor[i], " ")
		}
		escreva("\n")
		para(inteiro i = 0; i < tam-1; i++){
			index = i
			para(inteiro c = i + 1; c < tam; c++){
				se(vetor[c] < vetor[index]){
					index = c
				}
			}
			memoria = vetor[i]
			vetor[i] = vetor[index]
			vetor[index] = memoria
		}
		inteiro par = 0, impars = 0
		para(inteiro i = 0; i < tam; i++){
			se(vetor[i] % 2 == 0){
				pares[par] = vetor[i]
				par++
			} senao{
				impar[impars] = vetor[i]
				impars++
			}
		}
		escreva("Numeros pares:")
		para(inteiro i = 0; i < tam; i++){
			escreva(pares[i], " ")
		}
		escreva("\nNumeros impares: ")
		para(inteiro i = 0; i < tam; i++){
			escreva(impar[i], " ")
		}
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