/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagerenciamento;

/**
 *
 * @author gabriel_piske
 */
public class Fornecedor {

    //Atributos da Classe
    private String codigo;
    private String empresa;
    private String contato;
    private String telefone;
    private String email;

    //Construtores da Classe
    public Fornecedor() {

    }

    public Fornecedor(String c, String e) {
        this.codigo = c;
        this.empresa = e;
    }

    //Métodos Acesssores 
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
