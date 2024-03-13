programa
{
	inclua biblioteca Texto
	
	funcao inicio()
	{

		cadeia nome
		cadeia sobrenome
		inteiro tam_nome=0
		inteiro tam_sobrenome=0
		inteiro diferenca=0
		inteiro maior=0
		cadeia mistura=""

		escreva("Entre com o nome: ")
		leia(nome)
		
		escreva("Entre com o sobrenome: ")
		leia(sobrenome)

		tam_nome = Texto.numero_caracteres(nome)
		tam_sobrenome = Texto.numero_caracteres(sobrenome)

		escreva("Seu nome tem ",tam_nome," letras e seu sobrenome tem ",tam_sobrenome, " letras")

		se(tam_nome > tam_sobrenome){
			maior = tam_nome
			diferenca = tam_nome - tam_sobrenome
			escreva("\nSeu nome é maior que o seu sobrenome\n")

			para(inteiro c=0 ; c<diferenca ; c++){
				
				sobrenome = sobrenome + "."
				
			}
			
		}
		senao se(tam_nome < tam_sobrenome){
			maior = tam_sobrenome
			diferenca = tam_sobrenome - tam_nome
			escreva("\nSeu sobrenome é maior que o seu nome")
			
			para(inteiro c=0 ; c<diferenca ; c++){
				
			nome = nome + "."
				
			}
		}
		senao{
			diferenca = 0
			maior = tam_nome
		}
		escreva("Nome: ",nome,"\nSobrenome: ",sobrenome)

		para(inteiro c=0 ; c < maior ; c++){
			
			mistura = mistura + Texto.obter_caracter(nome, c)
			mistura = mistura + Texto.obter_caracter(sobrenome, c)
		}
		escreva("\nA mistura do nome e sobrenome ficou assim: ",mistura)
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 975; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */