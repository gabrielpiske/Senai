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
    private Stack historico = new Stack();

    //Construtor Base
    public Conta(String idBanco) {
        this.idBanco = idBanco;
        this.ativo = true;
        this.saldo = 0.00f;
    }

    //Gets e Setters
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
    public Stack getHistorico() {
        return historico;
    }
    public void setHistorico(Stack historico) {
        this.historico = historico;
    }

    //Métodos da classe
    public void sacar(float saque) {
        if (this.saldo >= saque) {
            this.saldo -= saque;
        } else if (this.tpConta == 0 && this.saldo + this.limite >= saque) {
            this.saldo = 0.0f;
            this.limite -= saque - this.saldo;
            System.out.println("Saque realizado com sucesso");
        } else {
            System.err.println("Voce nao tem saldo suficiente para este saque.");
        }
    }

    public void depositar(float dep) {
        if (this.limiteMax >= this.limite) {
            if (this.limite + dep > this.limiteMax) {
                this.saldo += dep - (this.limiteMax - limite);
                this.limite = 1500.0f;
            } else {
                this.limite += dep;
            }
        } else {
            this.limite += dep;
        }
        System.out.println("Deposito de " + dep + " realizado");
        System.out.println("Limite Atualizado: " + this.limite);
    }

    public void transferir(float transf) {
        if(this.tpConta == 0){
            if(transf > this.saldo + this.limite){
                System.err.println("Valor em Conta Insuficiente");
            } else if(transf <= this.saldo){
                this.saldo -= transf;
                System.out.println("Valor Transferido com Sucesso");
            } else{
                this.limite -= transf - this.saldo;
                this.saldo = 0.0f;
            }
        } else{
            if(transf >= this.saldo){
                System.err.println("Valor em Conta Insuficiente");
            } else{
                this.saldo -= transf;
            }
        }
    }

    public float verSaldo() {
        return this.saldo;
    }

    public void verStatus() {
        System.out.println("|======= Informacoes da Conta  =======|");
        System.out.println("Tipo.............: " + this.tpConta);
        System.out.println("Numero...........: " + this.nmConta);
        System.out.println("Titular..........: " + this.titular);
        System.out.println("Saldo............: " + this.saldo);
        System.out.println("Limite...........: " + this.limite);
        System.out.println("Status...........: " + this.ativo);
        System.out.println("|=====================================|");
    }
}
