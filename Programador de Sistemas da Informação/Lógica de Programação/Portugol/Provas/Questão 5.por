programa
{
	//Bibliotecas
	inclua biblioteca Texto --> txt

	//Variavéis Globais
	cadeia numero
	inteiro tamanho 
	
	funcao inicio()
	{
		faca{
			//Entrada do telefone e verificação se é um numero válido
			escreva("Escreva seu numero de telefone fixo: ")
			leia(numero)
			tamanho = txt.numero_caracteres(numero)
			se(tamanho != 10){
				escreva("Numero deve ter 10 caracteres")
				limpa()
			}
		} enquanto(tamanho != 10)
		//Insere os caracteres necessarios nos lugares solicitados
		para(inteiro i = 0; i< tamanho; i++){
			escolha(i){
				caso 0:
					escreva("(")
					pare
				caso 2:
					escreva(")")
					pare
				caso 6:
					escreva("-")
					pare
			}
			//Sáida de dados
			escreva(txt.obter_caracter(numero, i))
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 595; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */