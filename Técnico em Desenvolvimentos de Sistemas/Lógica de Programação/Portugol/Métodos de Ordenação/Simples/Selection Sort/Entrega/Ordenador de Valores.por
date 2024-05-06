/*
 	Insira 8 valores em um vetor e aplique o insertion sort para organizar o vetor.
 	Escreva o vetor original e o organizado.
 */
programa{

	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[8], tamanho = 8,j,elementoAtual,indice

		escreva("Número de elementos do Vetor: ",tamanho,"\n")
		//Preencher Vetor
		para (inteiro i=0; i<tamanho;i++){
			vetor[i]=u.sorteia(10, 50)
		}
		//Escrever Vetor Original
		escreva("Vetor Original: ")
		para(inteiro i=0; i<tamanho;i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")
		//Ordenação
		para(inteiro i = 1; i < 8; i++){
			elementoAtual = vetor[i]
			indice = i
			enquanto(indice > 0 e vetor[indice - 1] > elementoAtual){
				vetor[indice] = vetor[indice - 1]
				indice--
			}
			vetor[indice] = elementoAtual
		}
		//Vetor Organizado
		escreva("Vetor ordenado: ")
		para(inteiro i=0; i<tamanho;i++){
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 127; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 10, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */