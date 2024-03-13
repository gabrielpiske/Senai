programa
{
	
	funcao inicio()
	{

	real peso, altura, imc
	cadeia nome



	escreva("Digite o nome do paciente: ")
	leia(nome)

	escreva("Digite a sua altura: ")
	leia(altura)

	escreva("Digite o seu peso: ")
	leia(peso)

	
	imc= (peso/(altura*altura))


	escreva("O seu imc é ", imc, "\n")



		se(imc<18.5)
		{
		
		escreva("Você está abaixo do peso ", nome, " Está na hora de começar a comer")
		
		}
		senao se(imc<=24.9)
		{
			
		escreva("Você esta no peso ideial, parabéns!!!!")	
		
		}
		senao se(imc<=29.9)
		{
		
		escreva("Você esta levemente acima do peso ", nome, " Comece a comer, tome cuidado")
		
		}
		senao se(imc<=34.9)
		{
		
		escreva("Você esta com obesidade grau 1 ", nome, " Está começando a pesar mais que o meu pai e minha mãe juntos!!!!, tome cuidado")
		
		}
		senao se(imc<=39.9)
		{
		
		escreva("Você esta com obesidade grau 2, este é um grau severo ", nome, " Tá com um pé na cova já")
		
		}
		senao
		{
		
		escreva("Você esta com obesidade severa ", nome, " Tome alguma atitude ou morrera em breve...")
		
		}


		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1057; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */