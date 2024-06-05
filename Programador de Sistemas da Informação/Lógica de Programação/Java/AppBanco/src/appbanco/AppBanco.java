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
        
        conta1.tipo = '0';
        conta1.titular = "Piske";
        conta1.limite = 500.0f;
        conta1.saldo = 100;
        
        conta1.status("Conta1");
        
        Conta conta2 = new Conta();
        conta2.numero = 100;
        conta2.tipo = '2';
        conta2.titular = "Lucas";
        conta2.saldo = 230.0f;
        conta2.status("Conta2");
    }
    
}
