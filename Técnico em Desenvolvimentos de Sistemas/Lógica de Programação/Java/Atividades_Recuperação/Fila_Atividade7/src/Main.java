
/*
   5- Dada uma fila de inteiros, escreva um programa que exclua todos os números primos.

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
        Queue<Integer> filaAux = new LinkedList<>();

        //preenchimento fila
        Random random = new Random();
        for (int i = 0; i < tam; i++) {
            int nmAleatoria = random.nextInt(200);
            fila.add(nmAleatoria);
        }
        //saida fila original
        System.out.println("Fila Original: " + fila);
        
        while (!fila.isEmpty()) {
            int numero = fila.poll();
            if (!primo(numero)) {
                filaAux.add(numero);
            }
        }

        //saida fila alterada
        System.out.println("Fila alterada: " + filaAux);
    }

    //Funcao de remoção de numeros negativos
    public static boolean primo(int numero) {
        if (numero <= 1) {
            return false;
        }
        //verificação doida que segunda o julio ta certo mas sei lá né...
        for (int i = 2; i < Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
