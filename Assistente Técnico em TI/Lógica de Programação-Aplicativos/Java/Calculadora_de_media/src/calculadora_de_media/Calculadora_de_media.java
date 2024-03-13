package calculadora_de_media;

import java.util.Scanner;

public class Calculadora_de_media {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String nomes_alunos[] = new String[4];
        float nota1[] = new float[4];
        float nota2[] = new float[4];
        float media_final[] = new float[4];

        // entrada dados
        for (int i = 0; i < 4; i++) {
            
            Scanner teclado = new Scanner(System.in);

            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes_alunos[i] = teclado.nextLine();

            System.out.print("Digite a primeira nota do aluno " + (i + 1) + ": ");
            nota1[i] = teclado.nextFloat();

            System.out.print("Digite a segunda nota do aluno " + (i + 1) + ": ");
            nota2[i] = teclado.nextFloat();

            media_final[i] = (nota1[i] + nota2[i]) / 2;
            System.out.println("");

        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Aluno " + nomes_alunos[i] + ", nota1 = " + nota1[i] + ", nota2 = " + nota2[i] + " e Média Final = " + media_final[i]);
        }

    }

}
