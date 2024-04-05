programa
{
	//Bibliotecas
	inclua biblioteca Texto --> txt
	inclua biblioteca Util --> u

	//Variavéis Globais
	cadeia texto, textoInvertido = ""
	inteiro tamanho

	funcao inicio()
	{
		faca{
			//Entrada do texto
			escreva("Entre com um texto contendo entre 50 e 100 caracteres: ")
			leia(texto)

			//Obter numero de carcteres do texto
			tamanho = txt.numero_caracteres(texto)

			//Verifica se o texto é possível
			se(tamanho < 50 ou tamanho > 100){
				escreva("\nTexto Inválido")
				u.aguarde(3000)
				limpa()
			}
		}enquanto(tamanho < 50 ou tamanho > 100)

		para(inteiro i = 0; i >= tamanho; i++){
			textoInvertido = txt.caixa_alta(txt.obter_caracter(texto, i) + "")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 688; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {texto, 8, 8, 5}-{textoInvertido, 8, 15, 14}-{tamanho, 9, 9, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */