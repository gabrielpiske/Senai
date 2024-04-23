package insertionsort;

import java.util.Scanner;

public class InsertionSort {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        //Variaveis
        int tam = 10;
        int vetor[] = new int[tam];
        int indice;
        int elementoAtual;
        
        //Leitura de daddos
        for(int i = 0; i < tam; i++){
            System.out.println("Entre com o valor " + (i+1) + ": ");
            vetor[i] = ler.nextInt();
        }
        
        //Exibição Vetor
        System.out.println("Vetor Original");
        for(int i = 0; i < tam; i++){
            System.out.print(vetor[i] + " ");    
        }
        
        for(int i = 1; i < tam; i ++){
            elementoAtual = vetor[i];
            indice = i;
            while(indice > 0 && vetor[indice-1] > elementoAtual){
                vetor[indice] = vetor[indice-1];
                indice--;
            }
            vetor[indice] = elementoAtual;
        }
        System.out.println("");
        System.out.println("Vetor Ordenado");
        for(int i = 0; i < tam; i++){
            System.out.print(vetor[i] + " ");    
        }
    }
    
}
