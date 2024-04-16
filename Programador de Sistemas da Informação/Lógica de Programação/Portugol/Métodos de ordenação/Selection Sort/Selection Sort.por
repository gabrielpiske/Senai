/*
 	SELECTION SORT
	Sua ideia consiste em ordenar a lista “selecionando” a cada iteração o menores itens possíveis
	e os colocam da esquerda para a direita.
	
	Estado Inicial: [5, 3, 1, 2, 4]
	Após a primeira seleção : [1, 3, 5, 2, 4]
	Após a segunda seleção: [1, 2, 5, 3, 4]
	Após a terceira seleção: [1, 2, 3, 5, 4]
	Após a quarta seleção: [1, 2, 3, 4, 5]
 */
programa{

	inclua biblioteca Util --> u

	funcao imprimir(inteiro vetor[], inteiro tam){
		inteiro i
		para(i = 0; i < tam; i++)
			escreva(vetor[i], ",")
			escreva("\n")
	}
	funcao inicio(){
		inteiro i, j, menor, copia, tam = 5, vet[5]

		para(i = 0; i < tam; i++)
			vet[i] = Util.sorteia(1, 20)

			imprimir(vet, tam)
    
			para(i = 0; i < tam - 1; i++){
				menor = i
				para(j = i; j < tam; j++){
					se(vet[j] < vet[menor])
						menor = j
				}
				copia = vet[menor]
				vet[menor] = vet[i]
				vet[i] = copia
				escreva("Seleção:", i, "\t")
				imprimir(vet, tam)
			}
			imprimir(vet, tam)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 739; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */