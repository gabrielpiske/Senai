package appbanco;

import java.util.*;

/**
 *
 * @author gabriel_piske
 */
public class Conta {

    //Variavéis
    private String idBanco;
    private int tpConta; // 0-Corrente    1-Salario   2-Poupança
    private int nmConta;
    private String titular;
    private float saldo = 0.0f;
    private float limite = 1500.0f;
    private float limiteMax = 1500.0f;
    private boolean ativo = true;
    private Stack<String> historico = new Stack<>();
    

    //Construtor Base
    public Conta(String idBanco) {
        this.idBanco = idBanco;
        this.ativo = true;
        this.saldo = 0.00f;
    }

    //Gets e Sets
    public int getTipoConta() {
        return tpConta;
    }
    public void setTipoConta(int tipoConta) {
        this.tpConta = tipoConta;
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
    public String getIdBanco() {
        return idBanco;
    }
    public void setIdBanco(String idBanco) {
        this.idBanco = idBanco;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public Stack<String> getHistorico() {
        return historico;
    }
    public void setHistorico(Stack<String> historico) {
        this.historico = historico;
    }

    //Métodos da classe
    
    //Realização de Saque e conferencia do limite
    public void sacar(float saque) {
        if (this.saldo >= saque) {
            this.saldo -= saque;
            historico.push("Saque de: R$" + saque);
            System.out.println("Saque realizado com sucesso");
        } else if (this.tpConta == 0 && this.saldo + this.limite >= saque) {
            this.limite -= (saque - this.saldo);
            this.saldo = 0.0f;
            historico.push("Saque de: R$" + saque + " (usando limite)");
            System.out.println("Saque realizado com sucesso utilizando limite");
        } else {
            System.err.println("Voce nao tem saldo suficiente para este saque.");
        }
    }
    
    //Distribuição correta dos depositos entre limite e saldo total
    public void depositar(float dep) {
        if(this.limite < this.limiteMax){
            float diferencaLimite = this.limiteMax - this.limite;
            if(dep <= diferencaLimite){
                this.limite += dep;
            } else{
                this.limite = this.limiteMax;
                this.saldo += (dep - diferencaLimite);
            }
        } else{
            this.saldo += dep;
        }
        historico.push("Deposito de: R$" + dep);
        System.out.println("Deposito de R$" + dep + " realizado");
        System.out.println("Saldo Atualizado: R$" + this.saldo);
        System.out.println("Limite Atualizado: R$" + this.limite);
    }
    
    //Função de Transfêrencia com verificação de saldo e limite
    public void transferir(float transf) {
        if (this.tpConta == 0) {
            if (transf > this.saldo + this.limite) {
                System.err.println("Valor em Conta Insuficiente");
            } else if (transf <= this.saldo) {
                this.saldo -= transf;
                System.out.println("Valor Transferido com Sucesso");
            } else {
                this.limite -= (transf - this.saldo);
                this.saldo = 0.0f;
            }
        } else {
            if (transf >= this.saldo) {
                System.err.println("Valor em Conta Insuficiente");
            } else {
                this.saldo -= transf;
                System.out.println("Valor Transferido com Sucesso");
            }
        }
        historico.push("Transferencia de: R$" + transf);
    }
    
    //Aplicar porcentagem de juros ao saldo
    public void aplyJuros(){
        if(this.tpConta == 2){
            this.saldo += this.saldo * 0.01f;
            historico.push("Juros Aplicados");
            System.out.println("Juros Aplicados com Sucesso");
        } else {
            System.err.println("Juros somente para contas Poupancas");
        }
    }
    
    //Exibição do extrato
    public void exibirExtrato(){
        System.out.println("Extrato da Conta: ");
        for(String evt : historico){
            System.out.println(evt);
        }
    }
    
    //Fechamento de Conta
    public void fecharConta(){
        if(this.saldo == 0 && this.limite == this.limiteMax){
            this.ativo = false;
            historico.push("Conta Fechada");
            System.out.println("Conta Fechada com Sucesso");
        } else{
            System.err.print("Saldo ou Limite pendente ");
            System.out.println("A conta não pode ser fechada");
        }
    }
    
    //Exibe no console todos os status da conta
    public void verStatus() {
        System.out.println("|======= Informacoes da Conta  =======|");
        System.out.println("Tipo.............: " + this.tpConta);
        System.out.println("Numero...........: " + this.nmConta);
        System.out.println("Titular..........: " + this.titular);
        System.out.println("Saldo............: " + this.saldo);
        System.out.println("Limite...........: " + this.limite);
        System.out.println("Status...........: " + (this.ativo ? "Ativo" : "Fechado"));
        System.out.println("|=====================================|");
    }
}
