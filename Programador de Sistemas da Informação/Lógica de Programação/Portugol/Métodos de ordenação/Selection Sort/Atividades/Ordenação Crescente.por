/*
 	Crie um programa que leia um vetor com 10 números inteiros e utilize o algoritmo de Selection Sort
 	para ordenar o vetor em ordem crescente. Em seguida, exiba o vetor ordenado
 */
programa{
	
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[10], tam = 10, index, memoria
		para(inteiro i = 0; i < tam; i++){
			escreva("Entre com o valor ",i+1,": ")
			leia(vetor[i])
			limpa()
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
		escreva("Valores em ordem crescente: ")
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
 * @POSICAO-CURSOR = 339; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */