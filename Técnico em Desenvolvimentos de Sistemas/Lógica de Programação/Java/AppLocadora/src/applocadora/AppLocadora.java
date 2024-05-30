package applocadora;

/**
 *
 * @author gabriel_piske
 */
public class AppLocadora {

    public static void main(String[] args) {
        //Gerenciando a frota de veiculos1
        
        //Instanciando objetos
        Carro carro1 = new Carro("CHEVETE", "VERMELHO");
        
        carro1.setMotor("Isuzu Diesel");
        carro1.setTpcombustivel(1); //tp = 1 Gaso; 2 Alcool; 3 Flex
        carro1.qtdCombustivel = 35.0f;
        carro1.ligar();
        carro1.avancar(5);
        
        carro1.printStatus();
        
        System.out.println("------------------------------------");
        
        //carro1.parar();
        //carro1.qtdCombustivel = 15.0f;
        
        //carro1.printStatus();
    }
    
}