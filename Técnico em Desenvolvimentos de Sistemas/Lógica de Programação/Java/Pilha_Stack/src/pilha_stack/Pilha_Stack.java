/*
    Implemente uma pilha usando o Stack da API Java.
*/

package pilha_stack;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author gabriel_piske
 */
public class Pilha_Stack {

    public static void main(String[] args) {
        //Criando Pilha
        Stack pilha = new Stack();
        //Gerando Numero
        Random random = new Random();
        //Gravando Numeros
        for (int i = 0; i < 10; i++) {
            System.out.println("Inserindo na pilha: "+pilha.push(random.nextInt(100)));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Retirando na pilha: "+pilha.pop());
        }
    }
    
}
