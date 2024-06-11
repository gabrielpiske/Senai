
import java.util.Scanner;

/*
    3- Elabore um algoritmo que o usuário opte por ordenar usando o “Bubble Sort ou Comb
    Sort” os seguintes números: 50,10,25,11,21,23,50,101,3215,325,849,894.
*/
/**
 *
 * @author julio_busarello / gabriel_piske / wilian_cardoso
 */
public class Main {
    
    public static int vet[] = {50,10,25,11,21,23,50,101,3215,325,849,894};
    public static int aux;
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int option;
        
        System.out.print("Vetor desordenado: ");
        for(int i = 0; i < vet.length; i ++){
            System.out.print(vet[i]+" ");
        }
        System.out.println("");
        
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Comb Sort");
        System.out.print("Informe a opção desejada para ordenação: ");
        option = ler.nextInt();
        
        switch(option){
            case 1:
                bubbleSort();
            break;
            case 2:
                combSort();
            break;
            default:
        }
        
    }
    // Método de ordenação Bubble Sort
    public static void bubbleSort(){
        for(int i = 0; i < vet.length; i++){
            for(int j = 0; j < vet.length-1; j++){
                if(vet[j] > vet[j + 1]){
                    aux = vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = aux;
                }
            }
	}
        System.out.print("Vetor ordenado com Bubble Sort: ");
        for(int i = 0; i < vet.length; i ++){
            System.out.print(vet[i]+" ");
        }
    }
    // Método de ordenação Comb Sort
    public static void combSort(){
        int gap = 10, i = 0, tamanho = vet.length;
        double fator = 1.3;
        boolean trocado = true;
        
        while(gap > 1 || trocado){
            gap = (int) (gap / fator);
            if(gap < 1){
                gap = 1;
            }
            trocado = false;
            i = 0;
            while(i + gap < tamanho){
                if(vet[i] > vet[i + gap]){
                    aux = vet[i];
                    vet[i] = vet[i+gap];
                    vet[i+gap] = aux;
                    trocado = true;
                }
                i = i + 1;
            }
        }
        System.out.print("Vetor ordenado com Comb Sort: ");
        for(i = 0; i < vet.length; i ++){
            System.out.print(vet[i]+" ");
        }
    }
    
}
