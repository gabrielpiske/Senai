package applocadora;

/**
 *
 * @author gabriel_piske
 */
public class Carro {

    //definição dos atributos da classe
    private String modelo;
    private String cor;
    private String motor;
    private int km;
    private int tpcombustivel;
    public float qtdCombustivel;
    private boolean parado;
    private boolean desligado;

    //Construtor da Classe
    public Carro(){
        
    }
    
    public Carro(String modelo, String cor, int tp) {
        this.modelo = modelo;
        this.cor = cor;
        this.tpcombustivel = tp;
        this.parado = true;
        this.desligado = true;
        this.km = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getTpcombustivel() {
        return tpcombustivel;
    }

    public void setTpcombustivel(int tpcombustivel) {
        this.tpcombustivel = tpcombustivel;
    }

    // defiinição dos métodos da classe
    public void avancar(int km) {
        if (desligado) {
            System.out.println("Carro Desligado");
        } else {
            System.out.println("Carro andando");
            acelerar(km);
            parado = false;
        }
    }

    public void voltar() {

    }

    public void acelerar(int k) {
        // carro acelerando
        this.km += k;
        System.out.println("O carro andou mais " + km + " kms");
    }

    public void parar() {
        if (!parado) {
            parado = true;
        } else {
            // o carro ja esta parado
            System.out.println("O carro ja esta parado...");
        }
    }

    public void ligar() {
        if (desligado) {
            desligado = false;
        } else {
            // o carro ja esta ligado
            System.out.println("O carro ja esta desligado...");
        }
    }

    public void desligar() {
        if (!desligado) {
            desligado = true;
        } else {
            // o carro ja esta ligado
        }
    }

    public void printStatus() {
        System.out.println("Modelo..........:" + this.modelo);
        System.out.println("Cor.............:" + this.cor);
        System.out.println("Desligado.......:" + this.desligado);
        System.out.println("Parado..........:" + this.parado);
        System.out.println("Quilometragem...:" + this.km);
    }
}
