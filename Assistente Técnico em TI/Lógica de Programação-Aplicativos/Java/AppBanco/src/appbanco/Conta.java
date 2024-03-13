package appbanco;

public class Conta {
    /////Atributos classe
    private int nConta;
    String cpf;
    String titular;
    private float saldo;
    private char tpConta; 
    private float limite;
    
    
    ///Contrutores classe
    public Conta(){
        this.saldo = 0.0f;
        this.limite = 0.0f;
    }
    public Conta(int n, String cpf, String tit){
        this.nConta = n;
        this.cpf = cpf;
        this.titular = tit;
        this.saldo = 0.0f;
        this.limite = 0.0f;
    }
    ////Métodos Acessores

    public float getSaldo() {
        return saldo;
    }

    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimite() {
        return limite;
    }

    private void setLimite(float limite) {
        this.limite = limite;
    }

    public int getnConta() {
        return nConta;
    }

    private void setnConta(int nConta) {
        this.nConta = nConta;
        System.out.println("Você não tem Permissão de Alterar o Numero da Conta!!!");
    }

    public char getTpConta() {
        return tpConta;
    }

    private void setTpConta(char tpConta) {
        this.tpConta = tpConta;
        System.out.println("Você não tem Permissão para Alterar o Tipo de Conta!!!");
    }
       
        
    /// Métodos Publicos da Classe
    public void imprimir(){
        System.out.println("Nº Conta.........:"+this.nConta);
        System.out.println("CPF..............:"+this.cpf);
        System.out.println("Titular..........:"+this.titular);
        System.out.println("Tipo de Conta....:"+this.tpConta);
        System.out.println("Saldo............:"+this.saldo);
        System.out.println("Limite...........:"+this.limite);
        System.out.println("----------------------------------");
    }
    public void depositar(float dep){
        //this.saldo = this.saldo + dep;
        this.saldo += dep;
        System.out.println("Operação Realizada com Sucesso.");
    }
}
