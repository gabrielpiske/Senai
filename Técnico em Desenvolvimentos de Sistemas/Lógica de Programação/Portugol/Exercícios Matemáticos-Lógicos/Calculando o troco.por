programa
{

	/*
	 	Calculando o troco. Considere o software que controla uma máquina automática de compras.
		Uma tarefa que ele precisa realizar é determinar quanto troco fornecer ao comprador quando
		este faz o pagamento em dinheiro. Escreva um programa que inicia lendo do usuario uma
		quantidade de centavos como um número inteiro (portanto vamos considerar números de 0 a
		99). Então o seu programa deve calcular e exibir quantidade e o valor de cada moeda para
		compor este troco em centavos informado. O troco deve ser montado com a menor quantidade
		possível de moedas. Assuma que a máquina possui moedas de 50, 25, 10, 5 e 1 centavos.

			 	-- Adaptado do código python do Bruno --
	 */
	
	funcao inicio()
	{
		inteiro centavos, moedas50 = 0, moedas25 = 0, moedas10 = 0, moedas5 = 0, moedas1 =0
		logico continuar = verdadeiro

		escreva("Quantidade de centavos (max: 99): ")
		leia(centavos)

		enquanto(continuar){
			se(centavos>=50){
				centavos -= 50
				moedas50 += 1
			}
			senao se(centavos >= 25){
				centavos -= 25
				moedas25 += 1
			}
			senao se(centavos >= 10){
				centavos -= 10
				moedas10 += 1
			}
			senao se(centavos >= 5){
				centavos -= 5
				moedas5 += 1
			}
			senao se(centavos >= 1){
				centavos -= 1
				moedas1 += 1
			} senao{
				continuar = falso
			}
		}
		escreva("Moedas de 50 centavos: \t", moedas50,"\n")
		escreva("Moedas de 25 centavos: \t", moedas25,"\n")
		escreva("Moedas de 10 centavos: \t", moedas10,"\n")
		escreva("Moedas de 5 centavos: \t", moedas5,"\n")
		escreva("Moedas de 1 centavos: \t", moedas1,"\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 695; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {centavos, 18, 10, 8}-{moedas50, 18, 20, 8}-{moedas25, 18, 34, 8}-{moedas10, 18, 48, 8}-{moedas5, 18, 62, 7}-{moedas1, 18, 75, 7}-{continuar, 19, 9, 9};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */