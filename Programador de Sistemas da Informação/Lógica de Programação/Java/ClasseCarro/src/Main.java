
import Classes.Carro;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        //Carro = Classe
        //carro = Objeto
        //Carro() = Construtor
        Carro carro = new Carro();  //Instancio
        boolean rodar = true;
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("---------------------------------");
            System.out.println("1 - Acelerar                    |");
            System.out.println("2 - Frear                       |");
            System.out.println("3 - Ligar o Carro               |");
            System.out.println("4 - Desligar o Carro            |");
            System.out.println("0 - Sair                        |");
            System.out.println("---------------------------------");
            System.out.print("Entrada: ");
            int op = ler.nextInt();

            switch (op) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

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
