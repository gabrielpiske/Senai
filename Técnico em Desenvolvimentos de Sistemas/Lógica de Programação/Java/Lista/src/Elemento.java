/**
 *
 * @author gabriel_piske
 */
class Elemento {
    //O que o elemento tem de informação
    private String valor;
    private Elemento proximo;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }

    public Elemento(String valor) {
        this.valor = valor;
    }
    
    
}
