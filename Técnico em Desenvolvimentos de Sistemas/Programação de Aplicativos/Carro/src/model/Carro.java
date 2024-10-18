package model;

/**
 *
 * @author gabriel_piske
 */
public class Carro {
    private int cod_carro, pot_carro;
    private String desc_carro, cor_carro;

    public Carro() {
    }

    public Carro(int cod_carro, int pot_carro, String desc_carro, String cor_carro) {
        this.cod_carro = cod_carro;
        this.pot_carro = pot_carro;
        this.desc_carro = desc_carro;
        this.cor_carro = cor_carro;
    }

    public int getCod_carro() {
        return cod_carro;
    }

    public void setCod_carro(int cod_carro) {
        this.cod_carro = cod_carro;
    }

    public int getPot_carro() {
        return pot_carro;
    }

    public void setPot_carro(int pot_carro) {
        this.pot_carro = pot_carro;
    }

    public String getDesc_carro() {
        return desc_carro;
    }

    public void setDesc_carro(String desc_carro) {
        this.desc_carro = desc_carro;
    }

    public String getCor_carro() {
        return cor_carro;
    }

    public void setCor_carro(String cor_carro) {
        this.cor_carro = cor_carro;
    }
    
    
}
