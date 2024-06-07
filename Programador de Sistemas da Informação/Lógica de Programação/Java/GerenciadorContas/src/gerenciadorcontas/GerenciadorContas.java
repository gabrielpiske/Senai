package gerenciadorcontas;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class GerenciadorContas {

    public static void main(String[] args) {
        //Variaveis
        Scanner ler = new Scanner(System.in);
        Conta c1 = new Conta();
        int menu;
        boolean rodar = true;

        do {
            Scanner leia = new Scanner(System.in);
            //Menu inicial
            System.out.println("=======================================");
            System.out.println("=   Aplicativo Gerenciador de Senhas  =");
            System.out.println("=-------------------------------------=");
            System.out.println("=                MENU                 =");
            System.out.println("=-------------------------------------=");
            System.out.println("=   1 - Criar Conta                   =");
            System.out.println("=   2 - Listar Conta                  =");
            System.out.println("=   3 - Sacar                         =");
            System.out.println("=   4 - Depositar                     =");
            System.out.println("=   5 - Fechar App                    =");
            System.out.println("=======================================");
            System.out.print("Entrada: ");
            menu = ler.nextInt();

            //Decisão de Telas
            switch (menu) {
                case 1:
                    clearConsole();
                    System.out.print("Entre com o tipo da sua conta: ");
                    c1.tipo = ler.nextInt();
                    System.out.print("Seu numero de conta é: " + (c1.numero += 1));
                    System.out.print("\nQual o nome da sua conta: ");
                    c1.titular = leia.nextLine();
                    System.out.println("Conta Criada com Sucesso !!!");
                    break;
                case 2:
                    clearConsole();
                    System.out.println("Lista de Status da Conta");
                    c1.status("C1");
                    break;
                case 3:
                    clearConsole();
                    float valor;
                    System.out.print("Qual valor deseja sacar: ");
                    valor = ler.nextFloat();
                    c1.saque(valor);
                    break;
                case 4:
                    clearConsole();
                    float deposito;
                    System.out.print("Qual valor deseja depositar: ");
                    deposito = ler.nextFloat();
                    c1.deposito(deposito);
                    break;
                default:
                    rodar = false;
            }
        } while (rodar);
    }

    //Limpa Console
    public final static void clearConsole() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }

}
