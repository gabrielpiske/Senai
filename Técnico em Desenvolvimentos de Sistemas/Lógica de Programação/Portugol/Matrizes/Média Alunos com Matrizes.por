programa
{
	inclua biblioteca Matematica --> m
	inclua biblioteca Texto --> t
	inclua biblioteca Util --> u

	//Variaveis Globais
	cadeia alunos[999][2]
	real notas[999][4]
	inteiro nota = 3
	inteiro tamanho = 999
	cadeia resposta = ""
	logico continuar = verdadeiro
	inteiro index = 0
	
	funcao inicio()
	{	enquanto(continuar == verdadeiro){
		escreva("===== Cálculo Média Final =====\n")
			//Verificação para entrada de dados
				escreva("Nome do Aluno ", (index+1), ": ")
				leia(alunos[index][0])
				para(inteiro c = 0; c<nota; c++){
					escreva("| Nota ", (c+1)," : ")
					leia(notas[index][c])
				}
				limpa()
				//Média dos Alunos
				notas[index][3] = m.arredondar(((notas[index][0] + notas[index][1] + notas[index][2])/nota), 2)
				//Status
				se(notas[index][3] > 7){
					alunos[index][1] = "Aprovado" 
				} senao se(notas[index][3] > 5){
					alunos[index][1] = "Recuperação"
				} senao{
					alunos[index][1] = "Reprovado"
				}
				escreva("Continuar? (s/n)")
				leia(resposta)
				resposta = t.caixa_alta(resposta)
				se(resposta == "N"){
					continuar = falso
				}
				index++
		}
		//Saída Médias
		escreva("========= Status dos alunos ===========================\n")
		escreva("Aluno\tNota 1\tNota 2\tNota 3\tMédia \tStatus\n")
		escreva("=======================================================")
		para(inteiro i = 0; i<index; i++){
			escreva("\n",alunos[i][0], "  \t ", notas[i][0], "\t ", notas[i][1], "\t ", notas[i][2], "\t ", notas[i][3],"\t(",alunos[i][1],")")
			//escreva("\n| - ", alunos[i][0], " :\t ", notas[i][3],"\t --> (",alunos[i][1],")")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1020; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {notas, 9, 6, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */