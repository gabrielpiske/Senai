/*
    Escreva um programa que leia 10 numeros. Para cada numero lido faça:
    1- se o numero for par, empilhe na pilha chamada par
    2- se o numero for impar, empilhe na pilha chamada impar
    3- se o numero for "0", desempilhe um elemento de cada pilha.
    4- caso alguma pilha esteja vazia, mostre uma mensagem de erro.
 */
package pilha_verificadornumerico;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author gabriel_piske
 */
public class Pilha_VerificadorNumerico {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Stack<Integer> par = new Stack<>();
        Stack<Integer> impar = new Stack<>();

        System.out.println("Entre com 10 numeros: ");
        for (int i = 0; i < 10; i++) {
            int numero = ler.nextInt();

            if (numero == 0) {
                if (!par.isEmpty() && !impar.isEmpty()) {
                    int desempilhadoPar = par.pop();
                    int desempilhadoImpar = impar.pop();
                    System.out.println("Par Desempilhado: " + desempilhadoPar);
                    System.out.println("Impar Desempilhado: " + desempilhadoImpar);
                } else {
                    System.out.println("Erro: As pilhas estao vazias.");
                }
            } else if (numero % 2 == 0) {
                par.push(numero);
                System.out.println("Empilhado na pilha par: " + numero);
            } else {
                impar.push(numero);
                System.out.println("Empilhado na pilha impar: " + numero);
            }
        }
    }

}
