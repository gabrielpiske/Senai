/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagerenciamento;

/**
 *
 * @author gabriel_piske
 */
public class Produto {

    //Atributos da Classe
    private String codigo;
    private String descricao;
    private String unidade;
    private int quantidade;
    private float preco;

    //Construtores da Classe
    public Produto() {

    }

    public Produto(String c, String d) {
        this.codigo = c;
        this.descricao = d;
    }

    //Métodos Acessores
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
