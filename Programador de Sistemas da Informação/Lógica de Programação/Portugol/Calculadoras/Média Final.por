programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		// Definação de Variavéis
		real n1 =0, n2 =0, n3 =0, mf =0
		cadeia status = ""
		
		escreva("==========================\n")
		escreva("= CÁLCULO DA MÉDIA FINAL =\n")
		escreva("==========================\n")

		escreva("| -> Primeira Nota: ")
		leia(n1)
		escreva("|=========================\n")
		escreva("| -> Segunda  Nota: ")
		leia(n2)
		escreva("|=========================\n")
		escreva("| -> Terceira Nota: ")
		leia(n3)
		escreva("|=========================\n")

		//Calcular Média
		mf = (n1+n2+n3)/3

		se(mf >= 7.0){
			status = "APROVADO"
		} senao se(mf < 5){
			status = "REPROVADO"
		} senao{
			status = "RECUPERAÇÃO"
		}
			
		escreva("A média final do aluno é: " + m.arredondar(mf, 2) + " ( " + status + " ) ")
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 756; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */