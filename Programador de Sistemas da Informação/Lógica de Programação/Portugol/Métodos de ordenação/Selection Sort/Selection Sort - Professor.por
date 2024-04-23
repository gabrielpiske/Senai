programa{
	
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[10], tam = 10, index, memoria
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
		escreva("Valores ordenados: ")
		para(inteiro i = 0; i < tam; i++){
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 595; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 6, 10, 5}-{index, 6, 31, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */