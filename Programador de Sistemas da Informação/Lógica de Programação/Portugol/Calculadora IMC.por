programa
{
	
	funcao inicio()
	{

	//Variavéis
	real peso, altura, imc
	cadeia nome

	//Perguntas
	escreva("Digite o nome do paciente: ")
	leia(nome)
	escreva("Digite a sua altura: ")
	leia(altura)
	escreva("Digite o seu peso: ")
	leia(peso)

	//Calculo imc
	imc= peso/(altura*altura)

	//Output Iimc
	escreva("O seu imc é ", imc, "\n")

		se(imc<=16.9){
			escreva("Você está extremamente abaixo do peso", nome, "Va imediatamente ao McDonald's")
		}
		senao se(imc<=18.4 ){
			escreva("Você está abaixo do peso ", nome, " Está na hora de começar a comer")
		}
		senao se(imc>=18.5){	
			escreva("Você esta no peso ideial,",nome," parabéns!!!!")	
		}
		senao se(imc>=25.00){
			escreva("Você esta levemente acima do peso ", nome, " Comece a comer, tome cuidado")
		}
		senao se(imc>=30.00){
			escreva("Você esta com obesidade grau I ", nome, " Está começando a pesar mais que o meu pai e minha mãe juntos!!!!, tome cuidado")
		}
		senao se(imc>=35.00){
			escreva("Você esta com obesidade grau II, este é um grau severo ", nome, " Tá com um pé na cova já")
		}
		senao{
			escreva("Você esta com obesidade grau III ou seja severa ", nome, " Tome alguma atitude ou morrera em breve...")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 631; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */