programa
{
	inclua biblioteca Matematica

	funcao inicio()
	{
		cadeia alunos[4]
		real nota_1 [4], nota_2[4], nota_3[4], media_final[4]

		para(inteiro c=0; c<3; c++)
		{
			escreva("\nEntre com o nome do aluno ", c+1, ": ")
			leia(alunos[c])
		}
		para(inteiro c=0; c<3; c++){
			escreva("\nColoque a nota 1 do aluno",c+1,": ")
			leia(nota_1[c])

			escreva("\nColoque a nota 2 do aluno",c+1,": ")
			leia(nota_2[c])

			escreva("\nColoque a nota 3 do aluno",c+1,": ")
			leia(nota_3[c])

			media_final[c] =(nota_1[c]+nota_2[c]+nota_3[c])/3
			
		}

		escreva("<==========> RESULTADO <==========>\n")

		para(inteiro d=0; d<3; d++)
		{
			se (media_final[d] >= 7.0)
			{
				escreva("O aluno ", alunos[d], " está APROVADO e tem media final = ",Matematica.arredondar(media_final[d],2),"\n")
			}
			senao se (media_final[d] < 5.0)
			{
				escreva("O aluno ", alunos[d], " está REPROVADO e tem media final = ",Matematica.arredondar(media_final[d],2),"\n")
			}
			senao
			{
				escreva("O aluno ", alunos[d], " está RECUPERAÇÃO e tem media final = ",Matematica.arredondar(media_final[d],2),"\n")
			}
		
		
		}
		}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */