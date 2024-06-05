/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        System.out.println("Tamanho: "+lista.getTamanho());
        lista.adicionar("Gustavo");
        lista.adicionar("m");
        lista.adicionar("A");
        
        lista.remover("B"); // Implementar
        System.out.println(lista.getTamanho());
        System.out.println(lista.getPrimeiro().getValor());
        System.out.println(lista.getUltimo().getValor());
        System.out.println(lista.get(0).getValor());
        System.out.println(lista.get(1).getValor());
        System.out.println(lista.get(2).getValor());
    }
    
}
