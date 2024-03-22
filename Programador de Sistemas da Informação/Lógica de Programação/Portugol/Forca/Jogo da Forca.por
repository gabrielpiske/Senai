programa
{
	inclua biblioteca Texto --> t
	
	//Variaveis
	cadeia palavra, status = "", palavraConhecida = ""
	inteiro tamanho, chances = 5
	caracter letras[500], letSabidas[500], tentativa
	
	funcao inicio()
	{
		//Inicio e eentrada da palavra
		escreva("-- JOGO DA FORCA --\n\n")
		escreva("Digite um palavra: ")
		leia(palavra)

		tamanho = t.numero_caracteres(palavra)
		
		limpa()


		para(inteiro i = 0; i<tamanho; i++){
			letras[i] = t.obter_caracter(palavra, i)
			letSabidas[i] = '_'
		}
		faca{
			mostrarForca(chances, falso)
			escrever()
			escreva("Chances Restantes ", chances)
			escreva("\nTentativa: ")
			leia(tentativa)
			verificarTentativa(tentativa)	
			verificarStatus()
			limpa()
		} enquanto(status != "venceu" e status != "perdeu")

		se(status == "venceu"){
			mostrarForca(chances, verdadeiro)
			escrever()
			escreva("\nVocê Ganhou")
		} senao{
			mostrarForca(chances, falso)
			escrever()
			escreva("\nVocê Perdeu")
		}
	}
	funcao escrever(){
		para(inteiro i = 0; i<tamanho; i ++){
			escreva("[", letSabidas[i], "]")
		}
	}
	funcao verificarTentativa(caracter palp){
		inteiro auxiliar = 0
		para(inteiro i=0; i<tamanho; i++){
			se(palp == letras[i]  e palp != letSabidas[i]){
				letSabidas[i] = palp
			} senao{
				auxiliar ++
			} se(auxiliar == tamanho){
				chances--
			}
		}
	}
	funcao verificarStatus(){
		palavraConhecida = ""
		para(inteiro i = 0; i < tamanho; i++){
			palavraConhecida += letSabidas[i]
		}
		se(palavraConhecida == palavra){
			status="venceu"
		}
		se(chances == 0){
			status = "perdeu"
		}
	}
	funcao mostrarForca(inteiro vida, logico venceu){
		se(venceu == falso){
			se(vida == 5){
				
			} senao se(vida == 4){
				
			} senao se(vida == 3){
				
			} senao se(vida == 2){
				
			} senao se(vida == 1){
				
			} senao{
				//inteiro
			}
		} senao{
			//completo sem forca
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1853; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {status, 6, 17, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */