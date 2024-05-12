package main

//Importa pacote
import (
	"fmt"
	"projetoTeste/calc"
)

// Função principal do programa
func main() {
	//jeito convencioanl de declarar a variavel
	var num1 int = 4

	//outro jeito que ele ja reconhece o tipo da variavel sozinho
	num2 := 2

	result := calc.Dividir(num1, num2)

	fmt.Println(result)
}
