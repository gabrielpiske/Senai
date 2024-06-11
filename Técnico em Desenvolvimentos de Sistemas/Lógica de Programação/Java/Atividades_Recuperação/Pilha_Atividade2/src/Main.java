
import java.util.Scanner;
import java.util.Stack;

/*
    2- Escreva um programa que leia 10 números. Para cada número lido faça:
        Se o número for par, empilhe na pilha chamada par
        Se o número for impar, empilhe na pilha chamada impar
        Se o número for “0”, desempilhe um elemento de cada pilha. Caso alguma
        pilha esteja vazia, mostre uma mensagem de erro.
*/
/**
 *
 * @author julio_busarello / gabriel_piske / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        // Ler mensagem
        Scanner ler = new Scanner(System.in);
        // Declarar pilhas
        Stack par = new Stack();
        Stack impar = new Stack();
        // Declarar variáveis
        int v = 0;
        int elemento;
        do {
            System.out.println("Informe um numero: ");
            elemento = ler.nextInt();
            
            if (elemento == 0) {            // Se o número informado for zero executa
                if (!par.empty() && !impar.empty()) {
                    System.out.println("Voce removeu o elemento "+par.pop()+" da pilha par");
                    System.out.println("Voce removeu o elemento "+impar.pop()+" da pilha impar");
                } else {
                    System.out.println("Erro, pilha vazia");
                }
            } else if (elemento % 2 == 0) { // Se o resultado do resto do número por 2 for 0 ele é par
                System.out.println(elemento+" empilhado na pilha par");
                par.push(elemento);
            } else {                        // Se não for nenhum dos outros ele é impar
                System.out.println(elemento+" empilhado na pilha impar");
                impar.push(elemento);
            }
            v++;
        } while (v <= 10); // Repetir 10 vezes
    }
    
}
