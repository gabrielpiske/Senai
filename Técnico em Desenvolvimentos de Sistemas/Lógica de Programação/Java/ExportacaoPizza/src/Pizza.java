
/**
 * @author gabriel_piske
 */
public class Pizza {

    private int codigo;
    private static int codigoPizza = 0;
    private String tam;
    private String sabor1;
    private boolean borda;
    private String formato;
    private int fatias;
    private String sabor2;
    private boolean premium;

    //Construtores
    public Pizza() {
        codigo++;
        codigoPizza = codigo;
    }

    public Pizza(String tam, String sabor1, boolean borda, String formato, int fatias, String s2, boolean prem) {
        codigo++;
        codigoPizza = codigo;
        this.tam = tam;
        this.sabor1 = sabor1;
        this.borda = borda;
        this.formato = formato;
        this.fatias = fatias;
        this.sabor2 = s2;
        this.premium = prem;
    }

    //Gets e Setas
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int getCodigoPizza() {
        return codigoPizza;
    }

    public static void setCodigoPizza(int codigoPizza) {
        Pizza.codigoPizza = codigoPizza;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public String getSabor1() {
        return sabor1;
    }

    public void setSabor1(String sabor1) {
        this.sabor1 = sabor1;
    }

    public boolean isBorda() {
        return borda;
    }

    public void setBorda(boolean borda) {
        this.borda = borda;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getFatias() {
        return fatias;
    }

    public void setFatias(int fatias) {
        this.fatias = fatias;
    }

    public String getSabor2() {
        return sabor2;
    }

    public void setSabor2(String sabor2) {
        this.sabor2 = sabor2;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    //Métodos

}
