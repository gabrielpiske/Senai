
import java.util.Random;
import java.util.Stack;

/*
    1 - Implemente uma pilha usando o Stack da API Java
 */
/**
 *
 * @author julio_busarello / gabriel_piske / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        Stack pilha = new Stack();
        Random elemento = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println("Inserido na pilha: " + pilha.push(elemento.nextInt(100)));
        }
        System.out.println("A pilha está vazia? " + pilha.empty());
        for (int i = 0; i < 10; i++) {
            System.out.println("Removido da pilha: " + pilha.pop());
        }
        System.out.println("A pilha está vazia? " + pilha.empty());
    }

}
