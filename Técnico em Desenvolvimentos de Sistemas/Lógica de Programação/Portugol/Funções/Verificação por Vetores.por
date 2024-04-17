programa{
	funcao inicio(){
		inteiro numero[10], cont = 0
		para(inteiro i = 0; i < 10; i++){
			escreva("Entre com o Número: ")
			leia(numero[i])
			limpa()
			se(numero[i] > 5) cont++
		}
		escreva("\n",cont," números são maiores que 5")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 249; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {numero, 3, 10, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */