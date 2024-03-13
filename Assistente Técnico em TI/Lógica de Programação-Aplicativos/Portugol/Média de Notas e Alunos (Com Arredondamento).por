programa
{
	inclua biblioteca Matematica
	
	funcao inicio()
	{

	///VARIAVEIS

	cadeia aluno1,aluno2,aluno3

	real n1_1, n2_1
	real n1_2, n2_2
	real n1_3, n2_3
	real media1,media2,media3
	caracter sts1,sts2,sts3
	real aredondar
	inteiro casas
	
	
	////NOTAS PRIMEIRO ALUNO///
	escreva("Digite o nome do aluno 1: ")
	leia(aluno1)
	escreva("Digite a primeira nota: ")
	leia(n1_1)
	escreva("Digite a segunda nota: ")
	leia(n2_1)

	
	////NOTAS SEGUNDO ALUNO////
	escreva("Digite o nome do aluno 2: ")
	leia(aluno2)
	escreva("Digite a primeira nota: ")
	leia(n1_2)
	escreva("Digite a segunda nota: ")
	leia(n2_2)


     ///NOTAS TERCEIRO ALUNO/////
	escreva("Digite o nome do aluno 3: ")
	leia(aluno3)
	escreva("Digite a primeira nota: ")
	leia(n1_3)
	escreva("Digite a segunda nota: ")
	leia(n2_3)

	

	////MÉDIAS ALUNOS

	media1 = (n1_1+n2_2)/2
	media1 = Matematica.arredondar(media1,2)
		
	media2	media1 = Matematica.arredondar(media1,2) = (n1_2+n2_2)/2
	media2 = Matematica.arredondar(media2,2)
	
	media3 = (n1_3+n2_3)/2
	media3 = Matematica.arredondar(media3,2)

	
	////TEXTO MÉDIAS
	
	escreva("As médias foram", "\n","\n",aluno1," : ",media1,"\n", aluno2," : ",media2, "\n", aluno3," : ",media3, "\n", "\n")


	////SITUAÇÃO ALUNO 1
	se(media1>=7)
	{

	escreva("O aluno(a) ", aluno1, " está aprovado", "\n")
		
	}
	senao se(media1<5)
	{
		
	escreva("O aluno(a) ", aluno1, " ficou reprovado(a)")
	
	}
	senao
	{

	escreva("O aluno(a) ", aluno1, " está em recuperação", "\n")

	}


	////SITUAÇÃO ALUNO 2
	se(media2>=7)
	{

	escreva("O aluno(a) ", aluno2, " está aprovado(a)", "\n")
		
	}
	senao se(media2<5)
	{
		
	escreva("O aluno(a) ", aluno2, " ficou reprovado(a)")
	
	}
	senao
	{

	escreva("O aluno(a) ", aluno2, " está em recuperação", "\n")

	}


	///SITUAÇÃO ALUNO 3
	se(media3>=7)
	{

	escreva("O aluno(a) ", aluno3, " está aprovado(a)", "\n")
		
	}
	senao se(media3<5)
	{
		
	escreva("O aluno(a) ", aluno3, " ficou reprovado(a)")
	
	}
	senao
	{

	escreva("O aluno(a) ", aluno3, " está em recuperação", "\n")

	}

		
   }
		
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 995; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */