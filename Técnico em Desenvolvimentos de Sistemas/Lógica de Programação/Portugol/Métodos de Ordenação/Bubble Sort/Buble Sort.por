programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro vetor[15], tamanho = 15, j, auxiliar, indice

		para(inteiro i = 0; i < tamanho; i ++){
			vetor[i] = u.sorteia(10, 50)
		}
		escreva("\n")
		para(j = 1; j < tamanho; j++){
			para(inteiro i = 0; i < tamanho - 1; i ++){
				se(vetor[i] > vetor[i+1]){
					auxiliar = vetor[i]
					vetor[i] = vetor[i + 1]
					vetor[i + 1] = auxiliar
				}
			}
		}
		escreva("Vetor em Ordem Crescente: \t")
		para(inteiro i = 0; i < tamanho; i ++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		para(j = 1; j < tamanho; j++){
			para(inteiro i = 0; i < tamanho - 1; i ++){
				se(vetor[i] < vetor[i+1]){
					auxiliar = vetor[i]
					vetor[i] = vetor[i + 1]
					vetor[i + 1] = auxiliar
				}
			}
		}
		escreva("Vetor em Ordem Decrescente: \t")
		para(inteiro i =  0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 406; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */