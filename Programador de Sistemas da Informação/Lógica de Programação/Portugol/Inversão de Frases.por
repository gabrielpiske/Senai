programa
{
	//Inversão de Frases utilizando estruturas de controle e Vetores

	caracter frase[200]
	inteiro totCaracter = 0
	
	funcao inicio()
	{
		inteiro index = 0
		logico continuar = verdadeiro
		escreva("Digite uma Frase: \n")
		enquanto(continuar == verdadeiro){
			leia(frase[index])
			se(frase[index] == '.'){
				continuar = falso
			}
			index++
			totCaracter++
		}
		escreva("\nFrase digitada: ")
		para(inteiro c = 0; c < index; c++){
			escreva(frase[c])
		}
		escreva("\n")
		index--
		escreva("\nFrase digitada ao contrário: ")
		para(index; index >=0; index--){
			escreva(frase[index])
		}
		escreva("\nTotal de Caracteres: ", totCaracter)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 345; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {frase, 5, 10, 5}-{totCaracter, 6, 9, 11};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */