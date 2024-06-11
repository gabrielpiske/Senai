/*
    4- Utilizando o “Quicksort” ordene os números: 50,104,8,89,1,41,2103,321.
 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Main {

    public static final int tam = 8;

    public static void main(String[] args) {
        int vetor[] = {50, 104, 8, 89, 1, 41, 2103, 321};
        int tamanho = tam, aux, i;
        //Saida Inicial
        System.out.print("Vetor Original: ");
        for (i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("");
        //Ordenação da função
        quickSort(vetor, 0, tam - 1);

        //Saida final
        System.out.print("Vetor Ordenado: ");
        for (i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
    
    public static void quickSort(int vetor[], int inicio, int fim){
        int i, j, pivo, aux;
        i = inicio; // posição inicial
        j = fim; //posição final
        pivo = vetor[(inicio + fim) / 2]; // posição do pivo    
        
        while (i <= j) {            
            while(vetor[i] < pivo){
                i++; //aumenta a posição
            }
            while(vetor[j] > pivo){
                j--; //diminui a posição
            }
            if(i <= j){
                //Realiza as trocas
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
            }
        }
        if(j > inicio){
            quickSort(vetor, inicio, j);
        }
        if(i < fim){
            quickSort(vetor, i, fim);
        }
    }
}
