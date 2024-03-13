/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sigversaomenu;

/**
 *
 * @author alana_prusseck
 */
public class Produto {
    //Atributos da Calsse
    private String cod;
    private String desc;
    private String uni;
    private int quanti;
    private float valor;

    //Construtor da Classe
    public Produto(){
        
    }
    public Produto(String cod, String desc){
        this.cod = cod;
        this.desc = desc;
         
}

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public int getQuanti() {
        return quanti;
    }

    public void setQuanti(int quanti) {
        this.quanti = quanti;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}