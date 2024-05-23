
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        int num1, num2;
        while (opcao != 5) {
            Calcular calcular = new Calcular();
            
            System.out.println("Entre com os valores (2 valores): ");
            num1 = ler.nextInt();
            num2 = ler.nextInt();
            
            System.out.println("========================================");
            System.out.println("===          Menu Principal          ===");
            System.out.println("===     Escolha a opcao desejada     ===");
            System.out.println("=== 1 - SOMA                         ===");
            System.out.println("=== 2 - SUBTRACAO                    ===");
            System.out.println("=== 3 - MULTIPLICACAO                ===");
            System.out.println("=== 4 - DIVISAO                      ===");
            System.out.println("=== 5 - Sair                         ===");
            System.out.println("========================================");
            opcao = ler.nextInt();
            
            switch (opcao) {
                case 1:
                    calcular.soma(num1, num2);
                    break;
                case 2:
                    calcular.subtracao(num1, num2);
                    break;
                case 3:
                    calcular.multiplicacao(num1, num2);
                    break;
                case 4:
                    calcular.divisao(num1, num2);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }
}
