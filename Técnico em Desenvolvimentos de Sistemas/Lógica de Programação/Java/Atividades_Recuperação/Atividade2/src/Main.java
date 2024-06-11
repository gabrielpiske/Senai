/*
    Utilizando o “Selection Sort” organize os seguintes dados: 
    10,20,50,80,8,9,4,2,8,08,18,14,84.
*/
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Main {


    public static void main(String[] args) {
        //Variavéis
        int vetor[] = {10,20,50,80,8,9,4,2,8,8,18,14,84}, tam = 13, memoria;
        //Saída do vetor original
        System.out.println("Vetor Original");
        for (int i = 0; i < tam; i++) {
            System.out.print(vetor[i] + " ");
        }
        //Inicio da Ordenação
        System.out.println();
        for (int i = 0; i < tam-1; i++) {
            int index = i;
            for (int c = i + 1; c < tam; c++) {
                if(vetor[c] < vetor[index]){
                    index = c;
                }
            }
            memoria = vetor[i];
            vetor[i] = vetor[index];
            vetor[index] = memoria;
        }
        //Saida do vetor ordenado
        System.out.println("Vetor Ordenado");
        for (int i = 0; i < tam; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
    
}
