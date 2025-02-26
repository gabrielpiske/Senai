package com.piske.calculator;

/**
 * @author gabriel_piske
 */
public class Calculator {

    public double soma(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicacao(double a, double b) {
        return a * b;
    }

    public double divisao(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não existe");
        } else {
            return a / b;
        }
    }

    public double potencia(double a, int b) {
        return Math.pow(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double resultadoSoma = calculator.soma(1, 2);
        double resultadoSubtracao = calculator.subtrair(1, 2);

        if (resultadoSoma == 3) {
            System.out.println("Soma deu boa");
        } else {
            System.out.println("Insira os numeros esperados");
        }

        if (resultadoSubtracao == -1) {
            System.out.println("Subtracao deu boa");
        } else {
            System.out.println("Insira os numeros esperados");
        }
    }
}
