package main

import (
	"fmt"
)

func main() {
	for {
		calculadora()
		var opcao string
		fmt.Printf("Deseja utilizar a calculadora novamente? (s/n): ")
		fmt.Scan(&opcao)
		if opcao != "s" {
			break
		}
	}
}

func calculadora() {
	var num1, num2 float64
	var sinal string

	fmt.Printf("Entre com o primeiro número: ")
	fmt.Scan(&num1)

	fmt.Printf("Entre com o Sinal: ")
	fmt.Scan(&sinal)

	fmt.Printf("Entre com o segundo número: ")
	fmt.Scan(&num2)

	switch sinal {
	case "+":
		fmt.Printf("Resultado: %.2f\n", soma(num1, num2))
	case "-":
		fmt.Printf("Resultado: %.2f\n", subtracao(num1, num2))
	case "*":
		fmt.Printf("Resultado: %.2f\n", multiplicacao(num1, num2))
	case "/":
		if num2 != 0 {
			fmt.Printf("Resultado: %.2f\n", divisao(num1, num2))
		} else {
			fmt.Printf("Erro: Não se pode dividir número por 0\n")
		}
	default:
		fmt.Printf("Sinal Inválido!\n")
	}
}

func soma(a, b float64) float64 {
	return a + b
}

func subtracao(a, b float64) float64 {
	return a - b
}

func multiplicacao(a, b float64) float64 {
	return a * b
}

func divisao(a, b float64) float64 {
	return a / b
}
