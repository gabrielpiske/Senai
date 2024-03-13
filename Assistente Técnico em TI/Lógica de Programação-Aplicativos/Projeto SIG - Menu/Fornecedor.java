/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sigversaomenu;

/**
 *
 * @author alana_prusseck
 */
public class Fornecedor {
//Atributos da Calsse
    private String cod;
    private String nome;
    private String tele;
    private String email;
    private String contato;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
     
    //Construtor da Classe
    public Fornecedor(){
        
    }
    public Fornecedor(String cod, String nome){
        this.cod = cod;
        this.nome = nome;
        
}
}
