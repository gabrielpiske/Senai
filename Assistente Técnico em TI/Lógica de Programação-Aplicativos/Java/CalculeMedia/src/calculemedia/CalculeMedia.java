/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculemedia;

/**
 *
 * @author gabriel_piske
 */
import java.util.Scanner;


public class CalculeMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definição das variavéis do programa

        String nome, status;
        float nota1, nota2, nota3, mf;
        int op = -1;
        while (op != 0) {

            Scanner teclado = new Scanner(System.in);

            System.out.println("Digite o nome do Aluno: ");
            nome = teclado.nextLine();

            System.out.println("Digite a primeira nota: ");
            nota1 = teclado.nextFloat();

            System.out.println("Digite a segunda nota: ");
            nota2 = teclado.nextFloat();

            System.out.println("Digite a terceira nota: ");
            nota3 = teclado.nextFloat();

            mf = (nota1 + nota2 + nota3) / 3;

            if (mf >= 7) {
                status = "APROVADO";
            } else if (mf <= 5) {
                status = "REPROVADO";
            } else {
                status = "EM RECUPERAÇÃO";
            }

            System.out.println("O Aluno " + nome + " foi " + status + " com média final de: " + mf);
            System.out.println("Deseja continuar? (S ou N");
            op = teclado.nextInt();
        }
    }

}
