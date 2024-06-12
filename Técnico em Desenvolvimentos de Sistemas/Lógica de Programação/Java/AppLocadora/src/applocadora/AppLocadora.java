package applocadora;

/**
 *
 * @author gabriel_piske
 */
public class AppLocadora {

    public static void main(String[] args) {
        //Gerenciando a frota de veiculos1
        
        //Instanciando objetos
        Carro carro1 = new Carro("XPTO-207", "AZUL","XTO1.8", 0);
        
        carro1.setMotor("Isuzu Diesel");
        carro1.qtdCombustivel = 35.0f;
        carro1.ligar();
        carro1.avancar(5);
        
        carro1.printStatus();
        
        System.out.println("------------------------------------");
    }
    
}