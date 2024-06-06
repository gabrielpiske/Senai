/*
    Implemente uma lista usando o ArrayList da API Java. 5 valores
*/
package lista_arraylist;

/**
 *
 * @author gabriel_piske
 */
public class Lista_ArrayList {

    
    public static void main(String[] args) {
        // Cria um novo ArrayList
        ArrayList<String> lista = new ArrayList<>();
        
        // Adiciona 5 valores ao ArrayList
        lista.add("Valor 1");
        lista.add("Valor 2");
        lista.add("Valor 3");
        lista.add("Valor 4");
        lista.add("Valor 5");
        
        // Exibe os valores
        System.out.println("Valores da lista:");
        for (String valor : lista) {
            System.out.println(valor);
        }
        
        // Exibe o tamanho
        System.out.println("Tamanho da lista: " + lista.size());
        
        // Remove
        lista.remove("Valor 3");
        
        // Exibe os valores
        System.out.println("Valores da lista após remoção de 'Valor 3':");
        for (String valor : lista) {
            System.out.println(valor);
        }
        
        // Exibe o tamanho
        System.out.println("Tamanho da lista após remoção: " + lista.size());
        
        // Adiciona um novo valor
        lista.add("Valor 6");
        
        // Exibe os valores
        System.out.println("Valores da lista após adicionar 'Valor 6':");
        for (String valor : lista) {
            System.out.println(valor);
        }
        
        // Exibe o tamanho
        System.out.println("Tamanho da lista após adicionar 'Valor 6': " + lista.size());
    }
    
}
