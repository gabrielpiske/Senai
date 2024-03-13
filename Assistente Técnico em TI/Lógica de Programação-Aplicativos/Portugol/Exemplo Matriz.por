programa
{
	inclua biblioteca Matematica
	
	funcao inicio()
	{
		cadeia alunos[4] ////vetor
		real notas[4][4]////Matriz
		
		para(inteiro L=0; L<4; L++)
		{
			escreva("Aluno ",L+1," :")
			leia(alunos[L])

			para(inteiro C=0; C<3; C++)
			{
				escreva("Nota",C+1," do aluno ", L+1)
				leia(notas[L][3]) += notas[L][C]
				
			}
			para(inteiro L=0; L<4; L++)
			{
				para(inteiro C=0;C<3 ; C++)
				{
					notas[L][3] += notas[L][C]
				}
			}
			notas[L][3] = notas[L][3]/3
			escreva("\nAluno ",alunos[L], "=> MF= ", Matematica.arredondar(notas[L][3],2))
			
		}
		
		
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 290; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */