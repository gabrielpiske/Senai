programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		//Variavéis
		cadeia alunos[5][2]
		real notas[5][4]
		inteiro nota = 3
		inteiro tamanho = 5
		//Verificação para entrada de dados
		para(inteiro i=0; i<tamanho; i++){
			escreva("Nome do aluno ", (i+1)," : ")
			leia(alunos[i][0])
			para(inteiro c = 0; c<nota; c++){
				escreva("| Nota ", (c+1)," : ")
				leia(notas[i][c])
			}
			limpa()//limpeza
			escreva("\n")
			//Calculo da Média dos Alunos
			notas[i][3] = m.arredondar(((notas[i][0] + notas[i][1] + notas[i][2])/nota), 2)
			//Verificação do Status
			se(notas[i][3] > 7){
				alunos[i][1] = "Aprovado"
			} senao se(notas[i][3] > 5){
				alunos[i][1] = "Recuperação"
			} senao{
				alunos[i][1] = "Reprovado"
			}
		}
		//Saída das Médias
		escreva("--------- Média Final ---------")
		para(inteiro i = 0; i<tamanho; i++){
			escreva("\n| - ", alunos[i][0], " :\t ", notas[i][3],"\t --> (",alunos[i][1],")")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 775; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {alunos, 8, 9, 6}-{notas, 9, 7, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */