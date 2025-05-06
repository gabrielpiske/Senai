package com.piske.calculadora;

/**
 *
 * @author gabriel_piske
 */
public class Calculadora {

    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }

    // Método que calcula o fatorial de um número (versão iterativa)
    public static int fatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo");
        }
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
