package main

import (
	"fmt"
)

func main() {
	//Variavéis
	var num1, num2 float64
	var sinal string

	//Entrada de dados
	fmt.Printf("Entre com o primeiro numero: ")
	fmt.Scan(&num1)

	fmt.Printf("Entre com o Sinal: ")
	fmt.Scan(&sinal)

	fmt.Printf("Entre com o segundo numero: ")
	fmt.Scan(&num2)

	//Calculo e saida do resultado
	switch sinal {
	case "+":
		fmt.Printf("Resultado: %.2f\n", num1+num2)
	case "-":
		fmt.Printf("Resultado: %.2f\n", num1-num2)
	case "*":
		fmt.Printf("Resultado: %.2f\n", num1*num2)
	case "/":
		if num1 != 0 {
			fmt.Printf("Resultado: %.2f\n", num1/num2)
		} else {
			fmt.Printf("Erro: Não se pode dividir numero por 0")
		}
	default:
		fmt.Printf("Sinal Invalido !")
	}

}
