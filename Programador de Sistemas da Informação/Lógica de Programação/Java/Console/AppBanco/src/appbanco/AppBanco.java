package appbanco;

/**
 *
 * @author gabriel_piske
 */
public class AppBanco {


    public static void main(String[] args) {
        // Aqui vamos gerenciar os conceitos de POO
        System.out.println("|===================================|");
        System.out.println("|   App de Gerenciamento do banco   |");
        System.out.println("|===================================|");
        
        //Instanciar um novo objeto conta
        Conta conta1 = new Conta();
        
        conta1.tipo = '0';  //Tipo da Conta (Corrente)
        conta1.numero = 101;
        conta1.titular = "Piske";
        conta1.saldo = 50.00f;
        conta1.limite = 3000.0f;
        System.out.println("");
        conta1.status("Conta1");
        
        
        System.out.println("Deposito: 1800");
        conta1.deposito(1800.0f);
        conta1.status("Conta1");
        
        System.out.println("Saque: 450");
        conta1.saque(450);
        conta1.status("Conta1");
        
        System.out.println("transferencia: 2000");
        conta1.transferir(2000.0f, 102);
        conta1.status("Conta1");
         
        
         /*
        Conta conta2 = new Conta();
        conta2.numero = 100;
        conta2.tipo = '2';
        conta2.titular = "Lucas";
        conta2.saldo = 230.0f;
        conta2.status("Conta2");
        */
    }
    
}
