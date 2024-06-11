
import java.util.PriorityQueue;
import java.util.Queue;

/*
    1 - Implemente uma fila simples
 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Main {


    public static void main(String[] args) {
        Queue objFila = new PriorityQueue();
        
        // Adicionando elementos na fila
        objFila.add("Primeiro");
        objFila.add("Segundo");
        objFila.add("Terceiro");
        
        // Mostrando a fila
        System.out.println("Elementos na fila: " + objFila);
        
        // Removendo
        System.out.println("Elemento removido: " + objFila.poll());

        // Mostrando
        System.out.println("Elementos na fila após remoção: " + objFila);

        // Mostrando o próximo elemento a ser removido sem removê-lo
        System.out.println("Próximo elemento a ser removido: " + objFila.peek());
    }
    
}
