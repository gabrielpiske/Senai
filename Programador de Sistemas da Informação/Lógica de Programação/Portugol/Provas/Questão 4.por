programa
{
	//Bibliotecas
	inclua biblioteca Util --> u
	inclua biblioteca Texto --> txt

	//Variavéis Globais
	cadeia texto, textoInvertido = ""
	inteiro tamanho
	
	funcao inicio()
	{
		faca{
			//Entrada do texto
			escreva("Entre com um um texto contendo entre 50 e 100 caracteres: ")
			leia(texto)

			//Obter numero de carcteres do texto
			tamanho = txt.numero_caracteres(texto)

			//Verifica se o texto é possível
			se(tamanho < 50 ou tamanho > 100){
				escreva("Texto Inválido")
				u.aguarde(3000)
				limpa()
			}
		}enquanto(tamanho < 50 ou tamanho > 100)

		para(inteiro i = tamanho -1; i>=0; i--){
			textoInvertido = textoInvertido + txt.obter_caracter(texto, i)
		}
		escreva("Texto Invertido: ", textoInvertido)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 426; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */