
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
        //Variavéis
        int opcao;
        Scanner ler = new Scanner(System.in);

        do {
            paintMenu();

            System.out.println("Informe qual a conversão desejada: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    moeda();
                    break;
                case 2:
                    velocidade();
                    break;
                case 3:
                    peso();
                    break;
                case 4:
                    comprimento();
                    break;
                case 5:
                    clearConsole();
                    System.out.println("Voce escolheu sair");
                    break;
                default:
                    System.out.println("Opcao Invalida !!!");
                    System.exit(0);
            }
        } while (opcao != 5);
    }

    //Desenhar Menu
    public static void paintMenu() {
        //clearConsole();
        System.out.println("=======================================");
        System.out.println("------- Calculadora de Coversao -------");
        System.out.println("--- 1 - Converter moeda ");
        System.out.println("--- 2 - Converter Velocidade ");
        System.out.println("--- 3 - Converter Peso ");
        System.out.println("--- 4 - Converter Comprimento ");
        System.out.println("=======================================");
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

    //Conversão Moeda
    public static void moeda() {
        Scanner ler = new Scanner(System.in);
        double dolar;
        clearConsole();
        System.out.println("Entre com o valor em R$ que deseja converter: ");
        dolar = ler.nextInt();
        dolar = dolar * 5.13;
        clearConsole();
        System.out.println("Valor convertido em Dolar: $" + dolar);
    }

    //Conversão Velocidade
    public static void velocidade() {
        Scanner ler = new Scanner(System.in);
        double metros;
        int conv;
        clearConsole();
        System.out.println("Escolha a opcao de Conversao");
        System.out.println("-- 1 - Km p/h ");
        System.out.println("-- 2 - M/s ");
        System.out.println("-- 3 - Mph/h ");
        System.out.println("-- 4 - velocidade da luz ");
        conv = ler.nextInt();
        switch (conv) {
            case 1:
                clearConsole();
                System.out.println("Entre com o valor em Km p/h");
                metros = ler.nextInt();
                clearConsole();
                System.out.println("Velocidade : " + metros);
                break;
            case 2:
                clearConsole();
                System.out.println("Entre com o valor em Km p/h que deseja converter: ");
                metros = ler.nextInt();
                metros = metros / 3.6;
                clearConsole();
                System.out.println("Valor convertido em m/s:  " + metros + " metros por segundo");
                break;
            case 3:
                clearConsole();
                System.out.println("Entre com o valor em Km p/h que deseja converter: ");
                metros = ler.nextInt();
                metros = metros / 1.609;
                clearConsole();
                System.out.println("Valor convertido em Mph/h:  " + metros + " milhas por hora");
                break;
            case 4:
                clearConsole();
                System.out.println("Entre com o valor em Km p/h que deseja converter: ");
                metros = ler.nextInt();
                metros = metros / 1079252848.7999;
                clearConsole();
                System.out.println("Valor convertido para velocidade da luz: " + metros);
                break;
            default:
                throw new AssertionError();
        }
    }

    //Conversão Peso
    public static void peso() {
        Scanner ler = new Scanner(System.in);
        double peso;
        int opPeso;
        clearConsole();
        System.out.println("Escolha a opcao de Conversao");
        System.out.println("-- 1 - Grama ");
        System.out.println("-- 2 - Libra ");
        System.out.println("-- 3 - Miligrama ");
        System.out.println("-- 4 - Onca ");
        opPeso = ler.nextInt();
        switch (opPeso) {
            case 1:
                clearConsole();
                System.out.println("Entre com o peso em KG: ");
                peso = ler.nextInt();
                peso = peso * 1000;
                System.out.println("O valor em GRAMAS é: "+peso);
                break;
            case 2:
                clearConsole();
                System.out.println("Entre com o peso em KG: ");
                peso = ler.nextInt();
                peso = peso * 2.205;
                System.out.println("O valor em LIBRAS é: "+peso);
                break;
            case 3:
                clearConsole();
                System.out.println("Entre com o peso em KG: ");
                peso = ler.nextInt();
                peso = peso * 1000000;
                System.out.println("O valor em MILIGRAMAS é: "+peso);
                break;
            case 4:
                clearConsole();
                System.out.println("Entre com o peso em KG: ");
                peso = ler.nextInt();
                peso = peso * 35.274;
                System.out.println("O valor em ONCAS é: "+peso);
                break;
            default:
                throw new AssertionError();
        }
    }

    //Conversão comprimento
    public static void comprimento() {
        Scanner ler = new Scanner(System.in);
        double dist;
        int op;
        clearConsole();
        System.out.println("Escolha a opcao de Conversao");
        System.out.println("-- 1 - Metro ");
        System.out.println("-- 2 - Jarda ");
        System.out.println("-- 3 - Picometro ");
        op = ler.nextInt();
        switch (op) {
            case 1:
                clearConsole();
                System.out.println("Entre com medida em CM: ");
                dist = ler.nextInt();
                dist = dist / 100;
                System.out.println("A medida em METROS é: " + dist);
                break;
            case 2:
                clearConsole();
                System.out.println("Entre com medida em CM: ");
                dist = ler.nextInt();
                dist = dist / 91.44;
                System.out.println("A medida em JARDAS é: " + dist);
                break;
            case 3:
                clearConsole();
                System.out.println("Entre com medida em CM: ");
                dist = ler.nextInt();
                dist = dist * 1.0e10;
                System.out.println("A medida em PICOMETROS é: " + dist);
                break;
            default:
                throw new AssertionError();
        }
    }
}
