
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        //questao1();
        //questao2();
        //questao3();
        //questao4();
        //questao5();
        questao6();
    }

    public static void questao1() {
        /*
        1- Pedir 5 numeros pro usuário e armazenar em um vetor. mostrar o maior, menor, media e soma.
        Usuário deverá informar um valor e o algoritmo deverá consultar pra ver se ele existe
         */
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
        /*
        2- Soma de Matrizes: Escreva um programa que receba duas matrizes bidimensionais 
        de mesmo tamanho e realize a soma entre elas, armazenando o resultado em uma terceira matriz. 
        Em seguida, exiba a matriz resultante.
         */
        Scanner ler = new Scanner(System.in);
        int matriz1[][] = new int[2][2];
        int matriz2[][] = new int[2][2];
        int matrizSoma[][] = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 2; k++) {
                System.out.println("Insira um valor da matriz 1: ");
                matriz1[i][k] = ler.nextInt();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 2; k++) {
                System.out.println("Insira um valor da matriz 2: ");
                matriz2[i][k] = ler.nextInt();
            }
        }
        //soma
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 2; c++) {
                matrizSoma[l][c] = matriz1[l][c] + matriz2[l][c];
            }
        }
        //saida
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 2; c++) {
                System.out.println("Linhas somadas: " + matrizSoma[l][0]);
                System.out.println("Colunas somadas: " + matrizSoma[0][c]);
            }
        }
    }

    public static void questao3() {
        /*
        Faça um programa que receba uma matriz bidimensional 
        e retorne sua matriz transposta. A matriz transposta é 
        obtida ao trocar as linhas pelas colunas
        */
        Scanner ler = new Scanner(System.in);
        int matriz[][] = new int[2][2];
        int matrizTrans[][] = new int[2][2];
        
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 2; c++) {
                System.out.println("Insira um valor da matriz: ");
                matriz[l][c] = ler.nextInt();
            }
        }
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 2; c++) {
                matrizTrans[c][l] = matriz[l][c];
            }
        }
        System.out.println("Matriz Transposta:");
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(matrizTrans[l][c] + " ");
            }
            System.out.println();
        }
        
    }

    public static void questao4() {
        /*
        Escreva um programa que receba uma matriz bidimensional e exiba o maior valor em cada linha. 
        Por exemplo, para a matriz [[1, 2, 3], [4, 5, 6], [7, 8, 9]], o programa deve exibir: 3, 6, 9.
        */
        Scanner ler = new Scanner(System.in);
        int matriz[][] = new int[3][3];
        
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                System.out.println("Insira um valor da matriz: ");
                matriz[l][c] = ler.nextInt();
            }
        }
        
        for (int i = 0; i < 3; i++) {
            int max = matriz[i][0];
            for (int j = 1; j < 3; j++) {
                if (matriz[i][j] > max) {
                    max = matriz[i][j];
                }
            }
            System.out.println("Maior valor na linha " + (i+1)+ ":"+max);
        }
    }

    public static void questao5() {
        /*
        Implemente um programa que realize a multiplicação entre duas matrizes bidimensionais. 
        O usuário deve informar as dimensões das matrizes e seus elementos.
        O programa deve exibir a matriz resultante da multiplicação.
        */
        Scanner ler = new Scanner(System.in);
        int colunas, linhas;
        
        System.out.println("Informe quantas Linhas: ");
        linhas = ler.nextInt();
        System.out.println("Informe quantas Colunas: ");
        colunas = ler.nextInt();
        
        int matriz1[][] = new int[linhas][colunas];
        int matriz2[][] = new int[linhas][colunas];
        int matrizMult[][] = new int[linhas][colunas];
        
        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                System.out.println("Entre com os elementos Matriz 1: ");
                matriz1[l][c] = ler.nextInt();
            }
        }
        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                System.out.println("Entre com os elementos Matriz 2: ");
                matriz2[l][c] = ler.nextInt();
            }
        }
        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                matrizMult[l][c] = matriz1[l][c] * matriz2[l][c];
            }
        }
        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                System.out.println(matrizMult[l][c]+ " ");
            }
            System.out.println("");
        }
    }

    public static void questao6() {
        /*
        Escreva um programa que receba uma matriz bidimensional e exiba a média dos valores em cada coluna. 
        Por exemplo, para a matriz [[1, 2, 3], [4, 5, 6], [7, 8, 9]], o programa deve exibir: 4.0, 5.0, 6.0.
        */
        Scanner ler = new Scanner(System.in);
        int matriz[][] = new int[3][3];
        int vetor[] = new int[3];
        
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[0].length; c++) {
                System.out.println("Informe um numero");
                matriz[l][c] = ler.nextInt();
            }
        }
    }
}
