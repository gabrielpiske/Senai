/*
 	Insira 50 valores em um vetor e utilizando o Insertion Sort em uma função (passe o vetor como parâmetro),
 	organize-o em forma crescente e decrescente.Exiba o vetor original, crescente e decrescente.
 */
programa{
	
	inclua biblioteca Util --> u
	
	inteiro vetor[50], tamanho = 50,j,elementoAtual,indice
	funcao inicio(){


		escreva("Número de elementos do Vetor: ",tamanho,"\n")
		//Preencher Vetor
		para (inteiro i=0; i<tamanho;i++){
			vetor[i]=u.sorteia(0, 100)
		}
		//Escrever Vetor Original
		escreva("Vetor Original: ")
		para(inteiro i=0; i<tamanho;i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		organizar(vetor)
	}
	funcao organizar(inteiro vet[]){
		//Organiza em ordem Crescente
		para(inteiro i = 0; i < tamanho; i++){
			elementoAtual = vet[i]
			indice = i
			enquanto(indice > 0 e vet[indice - 1] > elementoAtual){
				vet[indice] = vet[indice - 1]
				indice--
			}
			vet[indice] = elementoAtual
		}
		//Escreve em ordem crescente
		escreva("Vetor Crescente: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		//Escreve de forma invertida
		escreva("\nVetor Decrescente: ")
		para(inteiro i = tamanho-1; i >= 0; i--){
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 893; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */