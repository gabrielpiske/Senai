
import java.util.Scanner;
import java.util.Stack;

/*
    4 - Escreva um programa que leia 10 números e armazene em uma pilha somente os
        números primos. O programa deverá implementar o printar e desempilhar.
 */
/**
 *
 * @author julio_busarello / gabriel_piske / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        Stack<Integer> pilha = new Stack<>();

        int a = 0;
        int numero;

        do {
            System.out.println("Informe um número: ");
            numero = ler.nextInt();
            // Verifica se o número informado é primo
            if (primo(numero)) {
                System.out.println(numero + " é um número primo");
                pilha.push(numero);
            }

            a++;
        } while (a < 10);// Repete 10 vezes
        
        System.out.println("------------------------------------------------");
        while (!pilha.isEmpty()) {
            // Mostra o elemento do topo
            System.out.println("Elemento do topo: " + pilha.peek());

            // Desempilha o elemento do topo
            int desempilhado = pilha.pop();
            System.out.println("Elemento desempilhado: " + desempilhado);
        }
    }

    public static boolean primo(int numero) {
        // Se o número for menor ou igual a 1, não é primo
        if (numero <= 1) {
            return false;
        }

        // Verifica se o número é divisível por algum número de 2 até a raiz quadrada do próprio número
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        // Se nenhum outro for verificado ele é primo
        return true;
    }

}
