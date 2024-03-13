/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagerenciamento;

/**
 *
 * @author gabriel_piske
 */
public class Cliente {

    //Atributos da Classe
    private String mat;
    private String nome;
    private String fone;
    private String email;

    //Construtores da Classe
    public Cliente() {

    }

    public Cliente(String m, String n) {
        this.mat = m;
        this.nome = n;
    }

    //Metodos Acessores
    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
