programa
{
	inclua biblioteca Texto
	
	funcao inicio()
	{

		cadeia nome

		escreva("Escreva um nome: ")
		leia(nome)

		escreva("\n")
	
		escreva("As letras do nome digitado são: ")
		
		para(inteiro n=0; n<Texto.numero_caracteres(nome); n++){
			escreva(Texto.obter_caracter(nome, n), "-")
		}
			escreva("\n")

		para(inteiro n=Texto.numero_caracteres(nome)-1; n > -1; n--){
			escreva(Texto.obter_caracter(nome, n), "-")
		}	
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 138; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */