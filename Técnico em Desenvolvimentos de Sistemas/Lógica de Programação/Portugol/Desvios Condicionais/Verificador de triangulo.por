programa
{
	
	funcao inicio()
	{
		triangulo()
	}
	funcao triangulo(){
		//Variaveis
		inteiro lado1 =0, lado2=0, lado3=0
		cadeia status = ""
		//Entrada de Dados
		escreva("Valor 1: ")
		leia(lado1)
		escreva("Valor 2: ")
		leia(lado2)
		escreva("Valor 3: ")
		leia(lado3)
		//Verificar se é possivel formar um triangulo
		se(lado1 > lado2 e lado1 > lado3){
			se(lado1 < lado2 + lado3){
				escreva("Possível")
				status = "Possível"
			}
			senao{
				escreva("Impossivel")
				status = "Impossivel"
			}
		}
		senao se (lado2 > lado1 e lado2 > lado3){
			se(lado2 < lado1 + lado3){
				escreva("Possível")
				status = "Possível"
			}
			senao{
				escreva("Impossivel")
				status = "Impossivel"
			}
		}
		senao{
			se(lado3 < lado2 + lado1){
				escreva("Possível")
				status = "Possível"
			}
			senao{
				escreva("Impossivel")
				status = "Impossivel"
			}
		}
		//Verificar qual o tipo do Triangulo
		se(status == "Possível"){
			se(lado1 == lado2 e lado2 == lado3 ){
				escreva("\nTriângulo Equilátero")
			}
			senao se(lado1 == lado2 ou lado2 == lado3 ou lado3 == lado1){
				escreva("\nTriângulo Isósceles")
			}
			senao{
				escreva("\nTriangulo Escaleno")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1196; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */