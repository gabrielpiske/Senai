/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author gabriel_piske
 */
public class Divulgador {

    private int iddivulgador;
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private String usuario;
    private String senha;
    private int nivel;

    public Divulgador() {
    }

    public Divulgador(String nome, String telefone, String email, LocalDate dataNascimento, String usuario, String senha, int nivel) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
    }

    public int getIddivulgador() {
        return iddivulgador;
    }

    public void setIddivulgador(int iddivulgador) {
        this.iddivulgador = iddivulgador;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "divulgador{" + "iddivulgador=" + iddivulgador + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + ", usuario=" + usuario + ", senha=" + senha + ", nivel=" + nivel + '}';
    }

}
