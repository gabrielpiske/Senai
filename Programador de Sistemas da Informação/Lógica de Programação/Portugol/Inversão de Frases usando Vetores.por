programa
{
	//Inversão de Frases utilizando estruturas de controle e Vetores

	//variavéis
	caracter frase[200]
	inteiro totCaracter = 0
	
	funcao inicio()
	{
		inteiro index = 0
		logico continuar = verdadeiro
		//Verificação para a Exucação de Entrada de Dados
		enquanto(continuar == verdadeiro){
			escreva("| Digite uma Frase: ")
			para(inteiro i = 0; i < index; i++) {
				escreva(frase[i])
			}
			leia(frase[index])
			limpa()
			se(frase[index] == '.'){
				continuar = falso
			}
			index++
			totCaracter++
		}
		//Escreve a Frase Completa digitada
		escreva("\n| Frase digitada: ")
		para(inteiro c = 0; c < index; c++){
			escreva(frase[c])
		}
		index--
		//Escreve a Frase invertendo o indice e deixando ela ao contrario
		escreva("\n | Frase digitada ao contrário: ")
		para(index; index >=0; index--){
			escreva(frase[index])
		}
		//Passa ao Usuario a quantidade de Caracteres com a variavek totCaracter
		escreva("\n | Total de Caracteres: ", totCaracter)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 923; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */