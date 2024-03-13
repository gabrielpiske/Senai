/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sigversaomenu;

/**
 *
 * @author alana_prusseck
 */
public class Cliente {
    //Atributos da Calsse
    private String mat;
    private String tele;
    private String nome;
    private String email;
    private String ende;
    
    //Construtor da Classe
    public Cliente(){
        
        
    }
    public Cliente(String mat, String nome){
        this.mat = mat;
        this.nome = nome;
    }
    
    //Métodos Acessores

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnde() {
        return ende;
    }

    public void setEnde(String ende) {
        this.ende = ende;
    }
    
}
