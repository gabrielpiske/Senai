
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
    4- Implemente uma fila BlockingQueue
 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> objFila = new ArrayBlockingQueue<>(10);
        
        // Adicionando elementos na fila
        objFila.add(35);
        objFila.add(1);
        objFila.add(2);
        objFila.add(66);
        objFila.add(97);
        objFila.add(15);
        
        // Mostrando a fila
        System.out.println("Elementos na fila: " + objFila);
        
        // Removendo
        System.out.println("Elemento removido: " + objFila.poll());

        // Mostrando
        System.out.println("Elementos na fila apos remocao: " + objFila);

        // Mostrando o próximo elemento a ser removido sem removê-lo
        System.out.println("Proximo elemento a ser removido: " + objFila.peek());
    }

}
