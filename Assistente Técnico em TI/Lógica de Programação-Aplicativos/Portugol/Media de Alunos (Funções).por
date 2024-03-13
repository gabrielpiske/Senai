programa
{
	funcao cadeia status(real m1, real m2)
	{
		real m
		cadeia res

		m = (m1+m2)/2

		se(m>=7)
		{
			res = "APROVADO"
		}
		senao
		{
			res = "REPROVADO"	
		}
		retorne res
	}
	funcao inicio()
	{
		inteiro next = 1
		real m1,m2
		cadeia nome

		enquanto(next != 0)
		{
			limpa()
			escreva("Entre o nome do aluno: ")
			leia(nome)
			escreva("\nEntre com a nota 1  do aluno: ")
			leia (m1)
			escreva("\nEntre com a nota 2  do aluno: ")
			leia (m2)
			escreva("O aluno ",nome, " está ", status(m1,m2),"\n")
			escreva("\n\nDeseja continuar? (Sim = 1, Não = 0): ")
		 	leia(next)	
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 244; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */