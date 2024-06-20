package Classes;

/**
 *
 * @author gabriel_piske
 */
public class Carro {

    private int velocidade;
    private boolean status;

    public Carro(int velocidade) {
        this.velocidade = velocidade;
        this.status = status;
    }

    //Gets and Setss
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    //Métodos
    //Acelerar
    public void acelerar(int acel) {
        if (this.status) {
            this.velocidade += acel;
        }
    }

    //Freiar
    public void frear(int velocidade) {
        if (this.status) {
            this.velocidade -= velocidade;
            if (this.velocidade < 0) {
                this.velocidade = 0;
            }
        }
    }

    //Ligar
    public void ligar() {
        if (this.status) {
            System.err.println("O carro ja esta ligado");
        } else {
            System.out.println("Ligando o carro");
            this.status = true;
        }
    }

    //Desligar
    public void desligar() {
        if (this.status && this.velocidade == 0) {
            System.out.println("Carro desligado");
            this.status = false;
        } else {
            System.err.println("Desacelere o carro");
        }
    }

}
