import java.util.Scanner;
/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int opcao = 0;
        while (opcao !=5){
            Mensagem mensagem = new Mensagem();
            System.out.println("========================================");
            System.out.println("===          Menu Principal          ===");
            System.out.println("===     Escolha a opção desejada     ===");
            System.out.println("=== 1 - Mensagem de boas-vindas      ===");
            System.out.println("=== 2 - Mensagem de Introdução       ===");
            System.out.println("=== 3 - Mensagem de Atenção          ===");
            System.out.println("=== 4 - Mensagem de Despedida        ===");
            System.out.println("=== 5 - Sair                         ===");
            System.out.println("========================================");
            opcao = Integer.valueOf(input.nextLine());
            switch (opcao) {
                case 1:
                    mensagem.boasVindas();
                    break;
                case 2:
                    mensagem.introducao();
                    break;
                case 3:
                    mensagem.atencao();
                    break;
                case 4:
                    mensagem.despedida();
                    break;
                default:
                    throw new AssertionError();
            }
        }
   }
   
    private static void imprime(){
        System.out.println("Bem vindo ao Java-");
    }
   
}