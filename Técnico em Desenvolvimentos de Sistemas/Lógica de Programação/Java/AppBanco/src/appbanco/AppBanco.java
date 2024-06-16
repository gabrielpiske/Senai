package appbanco;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class AppBanco {
    
    //Scanner Global
    private static Scanner ler = new Scanner(System.in);
    
    public static void main(String[] args) {
        Conta conta = new Conta("001");
        boolean rodar = true;
        
        do{
            menu();
            int menu = ler.nextInt();
            ler.nextLine(); //consumir linha nova
            
            //Entrada no sistema de decisão
            switch (menu) {
                case 1:
                    criarConta(conta);
                    break;
                case 2:
                    verStatus(conta);
                    break;
                case 3:
                    verSaldo(conta);
                    break;
                case 4:
                    depositar(conta);
                    break;
                case 5:
                    sacar(conta);
                    break;
                case 6:
                    transferir(conta);
                    break;
                case 7:
                    aplicarJuros(conta);
                    break;
                case 8:
                    extrato(conta);
                    break;
                case 9:
                    closeConta(conta);
                    rodar = false;
                    break;
                case 10:
                    rodar = false;
                    break;
                default:
                    System.err.println("Entrada Invalida. Tente Novamente");
            }
            if(rodar){
                System.out.println("\nPressione Enter Para Continuar...");
                ler.nextLine();
            }
        }while(rodar);
    }
    
    //Desenho do Menu Inicial
    private static void menu(){
        clearConsole();
        System.out.println("\n===============================================================");
        System.out.println("=               Aplicativo Gerenciador de Contas              =");
        System.out.println("=-------------------------------------------------------------=");
        System.out.println("=                             MENU                            =");
        System.out.println("=-------------------------------------------------------------=");
        System.out.println("=   1 - Criar Conta                 2 - Ver Status da Conta   =");
        System.out.println("=   3 - Ver Saldo                   4 - Depositar             =");
        System.out.println("=   5 - Sacar                       6 - Transferir            =");
        System.out.println("=   7 - Aplicar Juros (Poupanca)    8 - Exibir Extrato        =");
        System.out.println("=   9 - Fechar Conta                10 - Sair                 =");
        System.out.println("===============================================================");
        System.out.print("Entrada: ");
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
    
    //1 - Criar conta
    private static void criarConta(Conta conta){
        clearConsole();
        //Entrada Tipo da Conta
        System.out.println("Tipos de Conta: 0-Corrente  1-Salario   2-Poupanca");
        System.out.print("Escolha o tipo de conta: ");
        int tpConta = ler.nextInt();
        ler.nextLine();
        conta.setTipoConta(tpConta);
        
        //Entrada Numero da Conta
        System.out.print("Entre com o numero da Conta: ");
        int nmConta = ler.nextInt();
        ler.nextLine();
        conta.setNmConta(nmConta);
        
        //Entrada Nome o Titular
        System.out.print("Entre com nome do titular: ");
        String titular = ler.nextLine();
        conta.setTitular(titular);
        
        clearConsole();
        
        System.out.println("Conta Criada com Sucesso!");
    }
    
    //2 - Ver Status
    private static void verStatus(Conta conta){
        clearConsole();
        conta.verStatus();
    }
    
    //3- Ver Saldo
    private static void verSaldo(Conta conta){
        clearConsole();
        System.out.println("Saldo Atual: R$" + conta.getSaldo());
    }
    
    //4- Depositar
    private static void depositar(Conta conta){
        clearConsole();
        System.out.print("Valor para depostito: R$");
        float valor = ler.nextFloat();
        ler.nextLine();
        conta.depositar(valor);
    }
    
    //5- Sacar
    private static void sacar(Conta conta){
        clearConsole();
        System.out.print("Valor do Saque: R$");
        float valor = ler.nextFloat();
        ler.nextLine();
        conta.sacar(valor);
    }
    
    //6- Transferir
    private static void transferir(Conta conta){
        clearConsole();
        System.out.print("Valor da Transferencia: R$");
        float valor = ler.nextFloat();
        ler.nextLine();
        conta.transferir(valor);
    }
    
    //7- Aplicar Juros
    private static void aplicarJuros(Conta conta){
        clearConsole();
        conta.aplyJuros();
    }
    
    //8- Extrato
    private static void extrato(Conta conta){
        clearConsole();
        conta.exibirExtrato();
    }
    
    //9- Fechar Conta
    private static void closeConta(Conta conta){
        clearConsole();
        conta.fecharConta();
    }
}
