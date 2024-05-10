package test

import (
	"fmt"
)

func main{
	var num1 int = 4
	num2 := 2

	result := dividir(num1, num2)

	fmt.Println(result)
}

func dividir(a, b int) int {
	return a / b
}
