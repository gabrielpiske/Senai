programa{
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[10], tamanho=10, elementoAtual, indice

		//Preencher vetor
		para(inteiro i = 0; i < tamanho; i++){
			vetor[i] = u.sorteia(10, 50)
		}
		//Escreve o vetor original
		escreva("Vetor original: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i]," ")
		}
		escreva("\n")
		//Realiza a ordenação
		para(inteiro i = 0; i < 10; i++){
			elementoAtual = vetor[i]
			indice = i
			enquanto(indice > 0 e vetor[indice-1] > elementoAtual){
				vetor[indice] = vetor[indice-1]
				indice--
			}
			vetor[indice] = elementoAtual
		}
		//Escreve o vetor organizado
		escreva("Vetor ordenado: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i]," ")
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
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */