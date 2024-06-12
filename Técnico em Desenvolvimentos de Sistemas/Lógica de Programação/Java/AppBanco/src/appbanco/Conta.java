package appbanco;

/**
 *
 * @author gabriel_piske
 */
public class Conta {

    private int tipoConta;
    private int nmConta;
    private String titular;
    private float saldo = 0.0f;
    private float limite = 1500.0f;
    private boolean ativo = true;
    
    //Gets e Setters
    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getNmConta() {
        return nmConta;
    }

    public void setNmConta(int nmConta) {
        this.nmConta = nmConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }
    
    //Métodos da classe
    public void sacar() {
        
    }
    
    public void depositar(){
        
    }
    
    public void transferir(){
        
    }
    
    public void verSaldo(){
        
    }
    
    public void verStatus(){
        
    }
}
