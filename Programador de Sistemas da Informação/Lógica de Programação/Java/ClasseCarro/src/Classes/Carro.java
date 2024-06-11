package Classes;

/**
 *
 * @author gabriel_piske
 */
public class Carro {

    private int velocidade;
    private boolean status;

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

    public void acelerar(int acel) {
        if (this.status) {
            this.velocidade += acel;
        }
    }

    public void partida() {
        if (!this.status) {
            this.status = true;
        }
    }

    public void desligar() {
        this.status = false;
    }

}
