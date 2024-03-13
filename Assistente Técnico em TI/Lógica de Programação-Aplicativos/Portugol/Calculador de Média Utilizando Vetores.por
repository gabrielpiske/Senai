programa
{
	inclua biblioteca Matematica
	
	funcao inicio()
	{
	
		cadeia alunos[4]
		real nota1[4], nota2[4], nota3[4], mf[4]

		para(inteiro c=0; c<4 ; c++)
			{

			escreva("Entre com o nome do Aluno ", c+1, ": ")
			leia(alunos[c])
						
			escreva("Entre com a nota 1 do aluno ", c+1, ": ")
			leia(nota1[c])

			escreva("Entre com a nota 2 do aluno ", c+1, ": ")
			leia(nota1[c])

			escreva("Entre com a nota 3 do aluno ", c+1, ": ")
			leia(nota1[c])

			mf[c] = (nota1[c]+nota2[c]+nota3[c])/3
			
		}
		escreva("\n****** RESULTADO ****** \n\n")
		para(inteiro c=0; c<4; c++)
		{
			
			escreva("O aluno ",alunos[c]," tem média final = ",Matematica.arredondar(mf[c], 2), "\n")
			
			 
		}
		
				
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 553; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */