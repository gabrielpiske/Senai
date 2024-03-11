programa
{
	
	funcao inicio()
	{
		//ex1()
		//ex2()
		ex3()
	}
	funcao ex1(){
		cadeia vendedor
		real vendas =0, salario =0, final =0

		escreva("Qual o nome do Vendedor: ")
		leia(vendedor)
		escreva("Salario Vendedor: ")
		leia(salario)
		escreva("Valor vendido: ")
		leia(vendas)

		final = salario + (vendas*0.15)

		escreva("O vendedor ", vendedor, " vendeu R$", vendas, " e o salario com comissão ficou: ", final)
	}
	funcao ex2(){
		real C, F

		escreva("Temperatura em Graus Cº: ")
		leia(C)

		F=(9*C+160)/5

		escreva("A temperatura em Fahrenheit é: ", F)
	}
	funcao ex3(){
		real seg1 =0, seg2=0, seg3=0, mr = 0

		escreva("Tamanho 1 (cm): ")
		leia(seg1)
		escreva("Tamanho 2 (cm): ")
		leia(seg2)
		escreva("Tamanho 3 (cm): ")
		leia(seg3)

		se(seg1 > seg2 e seg1 > seg3){
			se(seg1 < seg2 + seg3){
				posivel(seg1, seg2, seg3)
			}
			senao{
				impossivel()
			}
		}
		senao se (seg2 > seg1 e seg2 > seg3){
			se(seg2 < seg1 + seg3){
				posivel(seg1, seg2, seg3)
			}
			senao{
				impossivel()
			}
		}
		senao{
			se(seg3 < seg2 + seg1){
				posivel(seg1, seg2, seg3)
			}
			senao{
				impossivel()
			}
		}
	}
	
	funcao posivel(real seg1, real seg2, real seg3){
		se(seg1 == seg2 e seg2 == seg3){
			escreva("Triangulo Equilátero")
		}
		senao se(seg1 != seg2 e seg2 != seg3){
			escreva("Triangulo Escaleno")
		}
		senao{
			escreva("Triangulo Isósceles")
		}
	}
	funcao impossivel(){
		escreva("É impossivel criar o triângulo")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1466; 
 * @DOBRAMENTO-CODIGO = [9, 24, 34, 70, 81];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */