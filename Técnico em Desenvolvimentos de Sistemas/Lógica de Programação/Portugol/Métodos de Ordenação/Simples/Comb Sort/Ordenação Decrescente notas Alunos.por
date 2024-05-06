programa
{
	
	inclua biblioteca Util --> u
	
	funcao inicio()
{
		inteiro  notas[5], tamanho = 5, auxiliar, i, j, indice, gap
		real fator
		logico  trocado
		cadeia aluno[5]

		para(i=0; i<tamanho; i++){
			escreva("Entre com o aluno ",i+1,": " )
			leia(aluno[i])
			limpa()
		}
		
		//Preenchimento
		para(i=0; i<tamanho; i++){
			notas[i] = u.sorteia(4,10)
		}

		fator = 1.3
		trocado = verdadeiro
		gap = tamanho
		enquanto(gap > 1 ou trocado){
			gap = (gap / fator)
			se(gap < 1){
				gap = 1
			}
			trocado = falso
			i = 0
			enquanto(i + gap < tamanho){
				se(notas[i] < notas[i + gap]){
					//Troca os Elementos
					auxiliar = notas[i]
					notas[i] = notas[i + gap]
					notas[i + gap] = auxiliar
					trocado = verdadeiro
				}
				i = i + 1
			}
		}
		limpa()
		para(i=0; i<tamanho;i++){
			escreva(aluno[i], " tem a nota ", notas[i], "\n")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 860; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */