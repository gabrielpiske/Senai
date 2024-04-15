programa
{
	/*
		Número de matrícula. Suponha que uma escola utilize, como código de matrícula, um número
		inteiro no formato AASDDD, onde:
			• os dois primeiros dígitos, representados pela letra A, são os dois últimos algarismos do
			ano da matrícula;
			• o terceiro dígitos, representado pela letra S, vale 1 ou 2, conforme o aluno tenha se
			matriculado no 1o ou 2o semestre;
			• os três últimos dígitos, representados pela letra D, correspondem à ordem da matrícula do
			aluno, no semestre e no ano em questão.
			• Crie um programa que leia o número de matrícula de um aluno e imprima o ano e o
			semestre em que ele foi matriculado.
	*/
	
	funcao inicio()
	{
		inteiro matricula, ano, s, d

		escreva("Entre com a matricula do aluno no formato AASDDD: ")
		leia(matricula)

		ano = matricula/10000
		s = matricula / 1000 % 10
		d = matricula % 1000

		escreva("Ano: ", ano, " \t Semestre: ", s, "\t Matricula: ", d)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 770; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {matricula, 18, 10, 9}-{ano, 18, 21, 3}-{s, 18, 26, 1}-{d, 18, 29, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */