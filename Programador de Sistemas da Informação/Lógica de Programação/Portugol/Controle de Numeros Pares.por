programa
{
	
	funcao inicio()
	{
		inteiro index =1
		para(inteiro c = 2; c<=50; c+=2){
			se(c<10){
				escreva("0",c," ")
			}
			senao{
				escreva(c, " ")
			}
			se(index == c/10){
				escreva("\n")
				index++
			}
		}
	}
	
}

/*
 * 
 * inteiro cont10 = 10
		para(inteiro c =2; c <= 50; c+=2){
			se(c < 10){
				escreva("0", cont10, " ")
			}
			senao se(c == cont10){
				escreva(" - ",cont10, "\n")
				cont10 += 10
			}
			senao{
				escreva(" - ", c, " ")
			}		
		}
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 185; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */