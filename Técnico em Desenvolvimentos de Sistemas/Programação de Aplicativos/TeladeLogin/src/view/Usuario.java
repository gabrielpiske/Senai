package view;

/**
 *
 * @author gabriel_piske
 */
public class Usuario {

    private String nome, usu, pass;
    private Integer cod;

    public Usuario() {
    }

    public Usuario(Integer cod, String nome, String usu, String pass) {
        this.cod = cod;
        this.nome = nome;
        this.usu = usu;
        this.pass = pass;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
