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
    float limite = 3000.0f;
    float maxLimite = 3000.0f;

    //Métodos da Classe
    public void saque(float saq) {
        if (this.saldo >= saq) {
            this.saldo -= saq;
        } else if (this.tipo == '0' && this.saldo + this.limite >= saq) {
            this.saldo = 0.0f;
            this.limite -= saq - this.saldo;
            System.out.println("Saque realizado com sucesso");
        } else {
            System.out.println("Voce nao tem saldo suficiente para este saque.");
        }
    }

    public void deposito(float dep) {
        if (this.tipo == '0') {
            if (this.maxLimite > this.limite) {
                if (this.limite + dep > this.maxLimite) {
                    this.saldo += dep - (this.maxLimite - this.limite);
                    this.limite = 1000.0f;
                } else {
                    this.limite += dep;
                }
            } else {
                this.saldo += dep;
            }
            System.out.println("Deposito de " + dep + " realizado");
            System.out.println("Limite Atualizado: " + this.limite);
        }
    }

    public void transferir(float transf, int destino) {
        if (this.tipo == '0') {
            if (transf > this.saldo + this.limite) {
                System.out.println("Valor insuficiente para esta operacao");
            } else if (transf <= this.saldo) {
                saldo -= transf;
            } else {
                this.limite -= transf - this.saldo;
                this.saldo = 0;
            }
        } else{
            if(transf > this.saldo){
                System.out.println("Valor insuficiente para esta operacao");
            } else{
                this.saldo -= transf;
            }
        }

    }

    public float verSaldo() {
        return this.saldo;
    }

    public void status(String obj) {
        System.out.println("|=== Informacoes da Conta " + obj + " ====|");
        System.out.println("Tipo.............: " + this.tipo);
        System.out.println("Numero...........: " + this.numero);
        System.out.println("Titular..........: " + this.titular);
        System.out.println("Saldo............: " + this.saldo);
        System.out.println("Limite...........: " + this.limite);
        System.out.println("|===================================|");
    }
}
