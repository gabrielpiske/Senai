/*
    Faça a transposição das seguintes matrizes e vetores:
    1 Vetor ={5,7,8,9,0,1,2}
    2 Matrizes (2x3 e 4x2) =
 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        int vetor[] = {5, 7, 8, 9, 0, 1, 2}, tam = 7;
        int matriz[][] = {{3, 1, 4}, {2, 5, 0}};
        int matriz2[][] = {{1, 3}, {2, 8}, {0, 4}, {5, 6}};

        System.out.print("Vetor original: ");
        for (int i = 0; i < tam; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("");
        System.out.println("Vetor Transposto: ");
        for (int i = 0; i < tam; i++) {
            System.out.print(vetor[i] + "\n");
        }
        System.out.println("---------------------------------");
        System.out.println("Matriz 2x3: ");
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(matriz[l][c] + " ");
            }
            System.out.println("");
        }
        System.out.println("Matriz 4x2: ");
        for (int l = 0; l < 4; l++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(matriz2[l][c] + " ");
            }
            System.out.println("");
        }
        System.out.println("---------------------------------");
        System.out.println("Matriz 2x3: ");
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(matriz[c][l] + " ");
            }
            System.out.println("");
        }
        System.out.println("Matriz 4x2: ");
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 4; c++) {
                System.out.print(matriz2[c][l] + " ");
            }
            System.out.println("");
        }
    }

}
