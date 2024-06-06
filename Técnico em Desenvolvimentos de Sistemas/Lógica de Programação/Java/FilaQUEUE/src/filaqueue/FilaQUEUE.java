/*
    Implemente uma Fila Simples - Class QUEUE
 */
package filaqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author gabriel_piske
 */
public class FilaQUEUE {

    public static void main(String[] args) {
        Queue<String> objFila = new LinkedList<>();
        
        // Adicionando elementos na fila
        objFila.add("Primeiro");
        objFila.add("Segundo");
        objFila.add("Terceiro");
        
        // Mostrando a fila
        System.out.println("Elementos na fila: " + objFila);
        
        // Removendo
        String removido = objFila.poll();
        System.out.println("Elemento removido: " + removido);

        // Mostrando
        System.out.println("Elementos na fila após remoção: " + objFila);

        // Mostrando o próximo elemento a ser removido sem removê-lo
        String proximo = objFila.peek();
        System.out.println("Próximo elemento a ser removido: " + proximo);
    }

}
