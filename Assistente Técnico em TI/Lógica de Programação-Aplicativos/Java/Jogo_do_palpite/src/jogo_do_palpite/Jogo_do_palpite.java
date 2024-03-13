
package jogo_do_palpite;

import java.util.Scanner;
import java.util.Random;

public class Jogo_do_palpite {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        
        int numeroAleatorio = random.nextInt(50) + 1;
        int palpite = 0;
        int tentativas = 0;
        int op = -1;
        while (op != 0) {

            System.out.println("Seja bem-vindo ao Jogo do Palpite!");
            System.out.println("Tente adivinhar um numero entre 1 e 50!");

            while (palpite != numeroAleatorio) {
                System.out.print("Digite o seu palpite: ");
                palpite = scanner.nextInt();
                tentativas++;

                if (palpite < numeroAleatorio) {
                    System.out.println("Palpite baixo. Tente novamente.");
                } else if (palpite > numeroAleatorio) {
                    System.out.println("Palpite alto. Tente novamente.");
                } else {
                    System.out.println("Parabéns! Você acertou o número em " + tentativas + " tentativas!");
                    System.out.println("Deseja cintinuar? (1 = Sim ou 0 = Não)");
                    op = teclado.nextInt();
                }
            }
        }
    }
}