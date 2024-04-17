/*
 	peça ao ususario 10 numeros e calcule quantos numeros
 	estão acima de 5. Utilize uma função para o calculo. Não utilize vetor.
 */
programa{
	inteiro verify = 0
	funcao inicio(){
		inteiro numero, cont = 0, result
		faca{
			escreva("Entre com o Número: ")
			leia(numero)
			result = verificar(numero)
			cont++
			limpa()
		} enquanto(cont < 10)
		escreva(result," números são maiores que 5")
	}
	funcao inteiro verificar(inteiro nm){
		se(nm > 5) verify++ 
		retorne verify
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 470; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */