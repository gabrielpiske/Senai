/*
    1 - Realize a soma das matrizes abaixo em uma quarta matriz:
*/
/**
 *
 * @author julio_busarello / gabriel_piske / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        int matrizA[][] = { {1,2,3},{4,5,6},{7,8,9} };
        int matrizB[][] = { {2,4,6},{1,3,5},{7,8,0} };
        int matrizC[][] = { {9,8,7},{6,5,4},{3,2,1} };
        int matrizSoma[][] = new int[3][3];
        
        // Soma as matrizes e adiciona em uma matriz
        for(int i = 0; i < 3; i ++){
            for(int a = 0 ; a < 3; a++){
                matrizSoma[i][a] = matrizA[i][a] + matrizB[i][a] + matrizC[i][a]; 
            }
        }
        // Exibe a matriz A
        System.out.println("Matriz A:"); 
        for(int i = 0; i < 3; i++){
            for(int a = 0; a < 3; a++){
                System.out.print(matrizA[i][a]+" ");
            }
            System.out.println("");
        }
        // Exibe a matriz B
        System.out.println("Matriz B:"); 
        for(int i = 0; i < 3; i++){
            for(int a = 0; a < 3; a++){
                System.out.print(matrizA[i][a]+" ");
            }
            System.out.println("");
        }
        // Exibe a matriz C
        System.out.println("Matriz C:"); 
        for(int i = 0; i < 3; i++){
            for(int a = 0; a < 3; a++){
                System.out.print(matrizA[i][a]+" ");
            }
            System.out.println("");
        }
        // Exibe a soma das matrizes
        System.out.println("Soma das matrizes:");
        for(int i = 0; i < 3; i++){
            for(int a = 0; a < 3; a++){
                System.out.print(matrizSoma[i][a]+" ");
            }
            System.out.println("");
        }
    }
    
}
