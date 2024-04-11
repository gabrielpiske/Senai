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
	 */
	
	funcao inicio()
	{
		inteiro centavos, moedas50 = 0, moedas25 = 0, moedas10 = 0, moedas5 = 0, moedas1 =0

		escreva("Quantidade de centavos: ")
		leia(centavos)

		se(centavos <= 100){
			se(centavos /50 == 2){
				moedas50 = 2
			}
			senao se((centavos/50) > 0 e (centavos/50) <2){
				moedas50 = 1
			}
			se((centavos % 50) < 50 e (centavos % 50) >25){
				moedas25 = 1	
			}
			se((centavos % 25) < 25 e (centavos % 25) >10){
				moedas10 = 1	
			}
			se((centavos % 10) < 10 e (centavos % 10) >5){
				moedas5 = 1	
			}
			se((centavos % 5) < 5 e (centavos % 5) >0){
				moedas1 = 1	
			}
		}
		escreva("Moedas de 50: ",moedas50," Moedas de 25: ",moedas25," Moedas de 10: ",moedas10," Moedas de 5: ",moedas5," Moedas de 1: ",moedas1)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 889; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */