programa{
	
	inclua biblioteca Texto --> txt
	
	funcao inicio(){
		cadeia texto, txtInvertido = ""
		inteiro tamanho

		escreva("Entre com um texto: ")
		leia(texto)

		tamanho = txt.numero_caracteres(texto)

		para(inteiro i = tamanho -1; i>=0; i--){
			txtInvertido = txtInvertido + txt.obter_caracter(texto, i)
		}
		escreva("Quantidade de Caracteres: ", tamanho,"\n")
		escreva("Texto Invertido: ", txtInvertido)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 375; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */