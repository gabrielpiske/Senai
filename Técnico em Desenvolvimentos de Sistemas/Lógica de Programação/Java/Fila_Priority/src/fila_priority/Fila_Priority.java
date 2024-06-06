/*
    Implemente uma fila de prioridade - Priority
*/
package fila_priority;

import java.util.PriorityQueue;

/**
 *
 * @author gabriel_piske
 */
public class Fila_Priority {

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
        System.out.println("Elementos na fila após remoção: " + objFila);

        // Mostrando o próximo elemento a ser removido sem removê-lo
        System.out.println("Próximo elemento a ser removido: " + objFila.peek());
    }
    
}
