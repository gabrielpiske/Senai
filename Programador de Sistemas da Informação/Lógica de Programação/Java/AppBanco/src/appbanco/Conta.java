package appbanco;

/**
 *
 * @author gabriel_piske
 */
public class Conta {

    //Atributos de Classe
    //Tipo => (0- Corrente      1- Poupança     2- Salário)
    char tipo;
    int numero;
    String titular;
    float saldo = 0.0f;
    float limite = 0.0f;

    //Métodos da Classe
    public void saque(float saq) {
        if(this.saldo >= saq){
            this.saldo -= saq;
        } else{
            System.out.println("Voce nao tem saldo suficiente para este saque.");
        }
    }

    public void deposito(float dep) {
        this.saldo += dep;
    }

    public void transferir(float transf, int destino) {
        if(this.saldo >= transf){
            this.saldo -= transf;
            System.out.println("Transferencia realizada com sucesso para"+destino+ " !!!");
        } else{
            System.out.println("Voce não tem saldo suficiente para esta trasferencia");
        }
    }

    public float verSaldo() {
        return this.saldo;
    }

    public void status(String obj) {
        System.out.println("|=== Informacoes da Conta "+obj+  " ====|");
        System.out.println("Tipo.............: "+this.tipo);
        System.out.println("Numero...........: "+this.numero);
        System.out.println("Titular..........: "+this.titular);
        System.out.println("Saldo............: "+this.saldo);
        System.out.println("Limite...........: "+this.limite);
        System.out.println("|===================================|");
    }
}
