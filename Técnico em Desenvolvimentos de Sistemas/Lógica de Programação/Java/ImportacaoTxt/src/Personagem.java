/**
 *
 * @author gabriel_piske
 */
public class Personagem {
    private int codigo;
    private String nome;
    private static int codigoP = 0;
    private String categoria;
    private String filme;
    private String cor;
    
    //Construtor
    public Personagem(){
        codigoP++;
        codigo = codigoP;
    }
    
    public Personagem(String nome, String categoria, String filme, String cor){
        codigoP++;
        codigo = codigoP;
        this.nome = nome;
        this.categoria = categoria;
        this.filme = filme;
        this.cor = cor;
    }
    
    //Gets e Sets
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public static int getCodigoP() {
        return codigoP;
    }
    public static void setCodigoP(int codigoP) {
        Personagem.codigoP = codigoP;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getFilme() {
        return filme;
    }
    public void setFilme(String filme) {
        this.filme = filme;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String toString(){
        return "" + nome + ", " + categoria + ", " + filme + ", " + cor;
    }
    
}
