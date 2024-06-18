
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

    //Variaveis Globais
    private static Scanner ler = new Scanner(System.in);
    private static boolean rodar = true;

    public static void main(String[] args) {
        //Carro = Classe
        //carro = Objeto
        //Carro() = Construtor
        Carro carro = new Carro(0);  //Instancio

        do {
            System.out.print(carro.isStatus() ? "Ligado" : "Desligado");
            System.out.println( "  |  " + carro.getVelocidade() + "km/h");
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
                    clearConsole();
                    if(carro.isStatus() == false){
                        System.err.println("Ligue o Carro Novamente");
                    } else{
                        System.out.println("Informe a Velocidade: ");
                        int velocidade = ler.nextInt();
                        carro.acelerar(velocidade);
                    }
                    break;
                case 2:
                    clearConsole();
                    if(carro.isStatus() == false || carro.getVelocidade() == 0){
                        System.err.println("Seu carro está desligado ou parado");
                    } else{
                        System.out.println("Informe a Velocidade: ");
                        int velocidade = ler.nextInt();
                        carro.frear(velocidade);
                    }
                    break;
                case 3:
                    clearConsole();
                    carro.ligar();
                    break;
                case 4:
                    clearConsole();
                    carro.desligar();
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
