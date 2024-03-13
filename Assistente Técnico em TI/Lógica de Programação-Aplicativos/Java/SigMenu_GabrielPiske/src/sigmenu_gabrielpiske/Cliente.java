/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sigmenu_gabrielpiske;

/**
 *
 * @author alana_prusseck
 */
public class Cliente {
    //Atributos da Calsse
    private int codigo;
    private String tele;
    private String nome;
    private String email;
    private String ende;
    
    //Construtor da Classe
    public Cliente(){
        
        
    }
    public Cliente(int cod, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
    
    //Métodos Acessores

    public int getCodigo() {
        return codigo;
    }

    public void setMat(int codigo) {
        this.codigo = codigo;
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
