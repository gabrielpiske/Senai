programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{

		inteiro opcao = 0
		inteiro valor
		inteiro contador =0


		escreva("Jogo do Sorteio e Acerto \n")
		valor = Util.sorteia(1, 50)
		escreva("Entre com um Número: ")
		

		enquanto(opcao != valor){
			leia(opcao)
			
		se (opcao < valor){

			escreva("Escolha um número maior: ")
			
		}

		se(opcao > valor)
		{
			escreva("Escoha um número menor: ")		
		}
		contador = contador + 1
			
	}
	escreva("Parabéns você acertou em ", contador, " tentativas")
	
	
   	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 373; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */