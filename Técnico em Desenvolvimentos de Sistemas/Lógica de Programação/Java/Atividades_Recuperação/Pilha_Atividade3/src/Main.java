
import java.util.Scanner;
import java.util.Stack;

/*
    3 - Escreva um programa que leia um inteiro n e uma sequência de n números inteiros e
        positivos e imprima primeiro os números impares na ordem inversa da leitura e, depois,
        os números pares também na ordem inversa da leitura. (Use duas pilhas ? uma para
        armazenar os números impares e outra para armazenar os números pares.)
 */
/**
 *
 * @author julio_busarello / gabriel_piske / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        // Cria as pilhas
        Stack par = new Stack();
        Stack impar = new Stack();
        // Cria variáveis
        int parVet[] = new int[100];
        int imparVet[] = new int[100];
        int pares = 0;
        int impares = 0;

        int n;
        boolean continuar = true;
        byte resp;

        do {
            System.out.println("Informe um número: ");
            n = ler.nextInt();

            // Verifica se é par ou impar
            if (n % 2 == 0) {
                par.push(n);
                parVet[pares] = n;
                System.out.println(n + " adicionado a pilha par");
                pares++;
            } else {
                impar.push(n);
                imparVet[impares] = n;
                System.out.println(n + " adicionado a pilha impar");
                impares++;
            }

            // Testa se deve continuar
            System.out.println("Continuar? (0(Não)/1(Sim))");
            resp = ler.nextByte();
            if (resp == 1) {
                continuar = true;
            } else {
                continuar = false;
            }

        } while (continuar);

        // Exibe os números pares na ordem inversa que foram recebidos
        System.out.println("Numeros pares: ");
        for (int i = pares - 1; i >= 0; i--) {
            System.out.print(parVet[i] + " ");
        }
        // Exibe os números impares na ordem inversa que foram recebidos
        System.out.println("\nNumeros impares: ");
        for (int i = impares - 1; i >= 0; i--) {
            System.out.print(imparVet[i] + " ");
        }
    }

}
