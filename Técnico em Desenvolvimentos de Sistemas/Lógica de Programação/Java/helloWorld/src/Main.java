
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class Main {

    
    public static void main(String[] args) {
        //-------------------------- Variavéis ---------------------------------
        
        //tipos primitivos
        byte a = 2; // -128 a 127 = 1 bytes
        short b = 2; // -32768 a 32767 = 2 bytes
        int c = 2; // -2146483648 a 2147483647 = 4 bytes
        long d = 2; // vai de 9 e uma porrada de números negativos a 9 e uma cacetada de numeros positivos
        boolean e = false; // 1 bit
        char f = 'a'; // 2 bytes
        float g = 3.41f; // 4 bytes
        double h2 = 3.14; // 8 bytes
        
        //-------------------- Entrada e Leitura de dados ----------------------
        
        //receber nome
        String nome;
        //Criação do scanner de leitura
        Scanner input = new Scanner(System.in);
        //Leitura da entrada pelo teclado
        System.out.println("Qual o seu nome: ");
        nome = input.nextLine();
        //Saída do input
        System.out.println("Seu nome is "+nome+".");
        
        //-------------------- Estruturas Condicionais -------------------------
        
        //Se senão
        if (a < b) {
            
        } else {
            
        }
        
        //Laço para
        for (int i = 0; i < 10; i++) {
            System.out.println("Teste");
        }
        
        //Escolha Caso
        switch (a) {
            case 1:
                
                break;
            default:
                throw new AssertionError();
        }
        
        //Enquanto
        while (a < b) {            
            
        }
    }
    
}
