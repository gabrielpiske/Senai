programa
{
	
	funcao inicio()
	{
		desafio()
	}
	funcao desafio(){

		cadeia frase = " "
		cadeia nmLetras[] = {frase}

		escreva("Digite uma Frase: ")
		leia(frase)
		
		
		para(inteiro c = 0; c < 9; c++){
			escreva(nmLetras[c])
		}


		/*
		 *         cadeia frase = " "
        cadeia fraseInvertida // Não precisa definir o tamanho máximo
        
        escreva("Digite uma frase terminada em ponto: ")
        leia(frase)
        
        inteiro tamanhoFrase = 0
        enquanto(frase[tamanhoFrase] != '.') {
            tamanhoFrase = tamanhoFrase + 1
        }
        
        escreva("A frase tem ", tamanhoFrase, " caracteres.\n")
        
        // Inverter a frase
        fraseInvertida = "" // Inicializando a cadeia invertida
        para (inteiro i = tamanhoFrase - 1; i >= 0; i--) {
            fraseInvertida = fraseInvertida + frase[i]
        }
        fraseInvertida = fraseInvertida + '.' // Adicionando o ponto no final
        
        escreva("Frase ao contrário: ", fraseInvertida)
		 */
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 226; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {nmLetras, 11, 9, 8}-{frase, 10, 9, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */