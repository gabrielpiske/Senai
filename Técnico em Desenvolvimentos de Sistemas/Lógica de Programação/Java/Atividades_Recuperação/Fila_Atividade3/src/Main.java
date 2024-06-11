
import java.util.ArrayDeque;
import java.util.Deque;

/*
    3- Implemente uma fila deque.
 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Main {


    public static void main(String[] args) {
        Deque<Integer> nms = new ArrayDeque<>();
        
        //Adicionando Elementos
        nms.offer(1);
        nms.offerLast(2);
        nms.offerFirst(3);
        System.out.println("Deque: " + nms);
        
        //Printar 1º elemento
        int firstElement = nms.peekFirst();
        System.out.println("Primeiro Elemento: " + firstElement);
        
        //Printar ultimo elemento
        int lastElement = nms.peekLast();
        System.out.println("Ultimo Elemento: " + lastElement);

        //Remover 1º elemento
        int removedNumber1 = nms.pollFirst();
        System.out.println("Removendo Primeiro Elemento: " + removedNumber1);
        
        //Remover ultimo elemento
        int removedNumber2 = nms.pollLast();
        System.out.println("Removendo Ultimo Elemento: " + removedNumber2);
        
        //Atualizar
        System.out.println("Deque Atualizado: " + nms);
    }
    
}
