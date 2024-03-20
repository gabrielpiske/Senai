programa
{
	funcao inicio()
	{
		real notas[200], auxiliar = 0, auxiliar1 = 0
		inteiro index = 0

		faca{
			escreva("Entre com a Pontuação: ", (index+1), ": ")
			leia(auxiliar)
			se(auxiliar != 0){
				notas[index] = auxiliar
				index++
			}
		} enquanto(auxiliar != 0.0)

		para(inteiro c = 1; c < index; c++){
			para(inteiro i = 0; i < index - 1; i ++){
				se(notas[i] < notas[i+1]){
					auxiliar = notas[i]
					notas[i] = notas[i + 1]
					notas[i + 1] = auxiliar
				} 
			}
		}
		escreva("-------------------------------------------\n")
		escreva("---------10 melhores pontuações------------")
		para(inteiro c =0; c<10; c++ ){
			escreva("\n| ",(c+1), "º lugar \t", notas[c])
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 486; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */