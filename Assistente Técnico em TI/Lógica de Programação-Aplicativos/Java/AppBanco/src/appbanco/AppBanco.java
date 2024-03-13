package appbanco;

public class AppBanco {

    public static void main(String[] args) {
        System.out.println("=============================");
        System.out.println("=    Controle de Contas     =");
        System.out.println("= Gerenciamento de Clientes =");
        System.out.println("=============================");
        
        /////Criação Conta
        Conta c1 = new Conta();
        //c1.setnConta(100);
        c1.cpf = "111.222.333-70";
        c1.titular = " João Com Braço";
        //c1.setTpConta('0');
        //c1.saldo = 0.0f;
        //c1.limite = 0.0f;
        
        
        
        ////Invocar Métodos
        c1.imprimir();
        c1.depositar(1500.0f);
        
        c1.imprimir();
        
    }
    
}
