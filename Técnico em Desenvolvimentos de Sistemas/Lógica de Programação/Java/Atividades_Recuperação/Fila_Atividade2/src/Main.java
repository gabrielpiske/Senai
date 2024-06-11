
import java.util.PriorityQueue;
import java.util.Queue;

/*
    2- Implemente uma fila de prioridade
 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        PriorityQueue objFila = new PriorityQueue();
        
        // Adicionando elementos na fila
        objFila.add("Primeiro");
        objFila.add("Segundo");
        objFila.add("Terceiro");
        
        // Mostrando a fila
        System.out.println("Elementos na fila: " + objFila);
        
        // Removendo
        System.out.println("Elemento removido: " + objFila.poll());

        // Mostrando
        System.out.println("Elementos na fila aps remocao: " + objFila);

        // Mostrando o próximo elemento a ser removido sem removê-lo
        System.out.println("Prximo elemento a ser removido: " + objFila.peek());
    }
    
}
