
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
/*
1- Pedir 5 numeros pro usuário e armazenar em um vetor. mostrar o maior, menor, media e soma.
Usuário deverá informar um valor e o algoritmo deverá consultar pra ver se ele existe
2- Soma de Matrizes: Escreva um programa que receba duas matrizes bidimensionais de mesmo tamanho e realize a soma entre elas, armazenando o resultado em uma terceira matriz. Em seguida, exiba a matriz resultante.
4- Faça um programa que receba uma matriz bidimensional e retorne sua matriz transposta. A matriz transposta é obtida ao trocar as linhas pelas colunas.
5- Escreva um programa que receba uma matriz bidimensional e exiba o maior valor em cada linha. Por exemplo, para a matriz [[1, 2, 3], [4, 5, 6], [7, 8, 9]], o programa deve exibir: 3, 6, 9.
6- Implemente um programa que realize a multiplicação entre duas matrizes bidimensionais. O usuário deve informar as dimensões das matrizes e seus elementos. O programa deve exibir a matriz resultante da multiplicação.
7- Escreva um programa que receba uma matriz bidimensional e exiba a média dos valores em cada coluna. Por exemplo, para a matriz [[1, 2, 3], [4, 5, 6], [7, 8, 9]], o programa deve exibir: 4.0, 5.0, 6.0.
 */
public class Main {

    public static void main(String[] args) {
        questao1();
        //questao2();
        //questao3();
        //questao4();
        //questao5();
        //questao6();
    }

    public static void questao1() {
        Scanner ler = new Scanner(System.in);
        int nm[] = new int[5];
        int media = 0, soma = 0;

        int indice;
        int elementoAtual;

        for (int i = 0; i < 5; i++) {
            System.out.println("Informe o numero: ");
            nm[i] = ler.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            soma += nm[i];
        }
        media = soma / 5;

        for (int i = 1; i < 5; i++) {
            elementoAtual = nm[i];
            indice = i;
            while (indice > 0 && nm[indice - 1] > elementoAtual) {
                nm[indice] = nm[indice - 1];
                indice--;
            }
            nm[indice] = elementoAtual;
        }
        System.out.println("A media dos elementos : " + media);
        System.out.println("A soma dos elementos : " + soma);
        System.out.println("O menor elemento : " + nm[0]);
        System.out.println("O maior elemento : " + nm[4]);
    }

    public static void questao2() {

    }

    public static void questao3() {

    }

    public static void questao4() {

    }

    public static void questao5() {

    }

    public static void questao6() {

    }
}
