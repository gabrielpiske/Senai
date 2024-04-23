/*
 	Crie um programa que leia um vetor com 12 numeros inteiros
 	e utilize o algoritmo de selection sort para encontrar e exibir o maior e menor elemento presente no vetor
 */
programa
{
	
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[12],tam = 12, index, memoria
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
		escreva("\n")
		escreva("Menor Valor: ",vetor[0],"\n")
		escreva("Maior Valor: ",vetor[tam-1])
		
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 392; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */