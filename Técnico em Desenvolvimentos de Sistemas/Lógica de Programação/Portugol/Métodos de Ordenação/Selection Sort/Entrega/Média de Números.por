programa{

	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[9], tam = 9, index, memoria, md[9], numero =0
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
		inteiro media = 0
		para(inteiro i = 0; i < tam; i++){
			md[media] = vetor[i]
			media++ 
		}
		escreva("Média dos valores: ")
		para(inteiro i = 0; i < tam; i++){
			numero = (md[0] + md[1]+ md[2]+ md[3]+ md[4]+ md[5]+ md[6]+ md[7]+ md[8]) / 9
		}
		escreva(numero)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 634; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 6, 10, 5}-{md, 6, 45, 2};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */