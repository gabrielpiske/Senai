
/*
   5- Dada uma fila de inteiros, escreva um programa que exclua todos os números positivos.

 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //variaveis
        int tam = 10;
        Queue<Integer> fila = new LinkedList<>();
        
        //preenchimento fila
        Random random = new Random();
        for (int i = 0; i < tam; i++) {
            int nmAleatoria = random.nextInt(200) -100;
            fila.add(nmAleatoria);
        }
        //saida fila original
        System.out.println("Fila Original: "+fila);
        
        //chamada funcao d remover
        removeNeg(fila);
        
        //saida fila alterada
        System.out.println("Fila alterada: " + fila);
    }
    
    //Funcao de remoção de numeros negativos
    public static void removeNeg(Queue<Integer> fila){
        Queue<Integer> filaAux = new LinkedList<>();
        
        while (!fila.isEmpty()) {
            int numero = fila.poll();
            if (numero <= 0) {
                filaAux.add(numero);
            }
        }
        
        fila.addAll(filaAux);
    }
}
