programa{
	
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[10], tamanho = 10, auxiliar, i, j, indice, gap
		real fator
		logico trocado
		cadeia nome[10], auxNome

		//Preenchimento
		para(i=0; i<tamanho; i++){
			escreva("Entre com o nome da ", i+1,"º pessoa: ")
			leia(nome[i])
			escreva("Entre com idade nº ", i+1,": ")
			leia(vetor[i])
			limpa()
		}

		fator = 1.3
		trocado = verdadeiro
		gap = tamanho
		enquanto(gap > 1 ou trocado)
		{
			gap = (gap / fator)
			se(gap < 1){
				gap = 1
			}
			trocado = falso
			i = 0
			enquanto(i + gap < tamanho){
				se(vetor[i] < vetor[i + gap]){
					//Troca os Elementos
					auxiliar = vetor[i]
					auxNome = nome[i]
					
					vetor[i] = vetor[i + gap]
					nome[i] = nome[i + gap]
					
					vetor[i + gap] = auxiliar
					nome[i + gap] = auxNome
					
					trocado = verdadeiro
				}
				i = i + 1
			}
		}
		para(i = 0; i < tamanho; i++){
			escreva("A pessoa ", nome[i], " tem a idade ", vetor[i], "\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 95; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 6, 10, 5}-{nome, 9, 9, 4};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */