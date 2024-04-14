programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		//Variavéis
		real a=0, b=0, c=0, x1=0, x2=0, delta=0.0
		logico continuar = verdadeiro

		//Entrada de Dados
		enquanto(continuar == verdadeiro){
			escreva("| -> Entre com valor A: ")
			leia(a)
			escreva("| -> Entre com valor B: ")
			leia(b)
			escreva("| -> Entre com valor C: ")
			leia(c)
			//Verificação Delta
			se(a == 0 e b == 0){
				continuar = falso
			}
			//Calculo Delta
			delta = m.potencia(b,2.0) - 4*a*c
	
			se(delta < 0){
				escreva("Não é possivel calcular pois o delta é negativo")
			} senao{
				x1 = (-b + m.raiz(delta, 2.0))/2*a
				x2 = (-b - m.raiz(delta, 2.0))/2*a
				//resultado
				escreva("X1 = ", m.arredondar(x1,2), "\n")
				escreva("X2 = ", m.arredondar(x2,2), "\n")	
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 441; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */