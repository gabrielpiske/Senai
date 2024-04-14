programa
{
	
	funcao inicio()
	{
		//atividade1()
		atividade2()
	}
	funcao atividade1(){
		inteiro v1 =0, v2 =0, v3=0

		escreva("Valor 1: ")
		leia(v1)
		escreva("Valor 2: ")
		leia(v2)
		escreva("Valor 3: ")
		leia(v3)

		se(v1 > v2 e v1 > v3){
			escreva("O valor 1 é o maior (",v1,")\n")
		}
		senao se (v2 > v1 e v2 > v3){
			escreva("O valor 2 é o maior (",v2,")\n")
		}
		senao{
			escreva("O valor 3 é o maior (",v3,")\n")
		}
	}
	funcao atividade2(){
		real r1 =0, r2=0, r3=0, mr = 0

		escreva("Tamanho 1 (cm): ")
		leia(r1)
		escreva("Tamanho 2 (cm): ")
		leia(r2)
		escreva("Tamanho 3 (cm): ")
		leia(r3)

		se(r1 > r2 e r1 > r3){
			se(r1 < r2 + r3){
				escreva("Possível")
			}
			senao{
				escreva("Impossivel")
			}
		}
		senao se (r2 > r1 e r2 > r3){
			se(r2 < r1 + r3){
				escreva("Possível")
			}
			senao{
				escreva("Impossivel")
			}
		}
		senao{
			se(r3 < r2 + r1){
				escreva("Possível")
			}
			senao{
				escreva("Impossivel")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 618; 
 * @DOBRAMENTO-CODIGO = [8];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */