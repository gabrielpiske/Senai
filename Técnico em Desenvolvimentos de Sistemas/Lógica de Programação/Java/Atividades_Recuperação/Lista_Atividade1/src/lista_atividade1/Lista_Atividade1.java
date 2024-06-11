package lista_atividade1;

import java.util.ArrayList;

/*
    1- Crie um programa que gerencie uma lista de tarefas. O programa deve permitir ao 
usuário adicionar, remover e listar todas as tarefas
 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Lista_Atividade1 {

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
        System.out.println("Valores da lista apos remocao de 'Valor 3':");
        for (String valor : lista) {
            System.out.println(valor);
        }
        
        // Exibe o tamanho
        System.out.println("Tamanho da lista apos remocao: " + lista.size());
        
        // Adiciona um novo valor
        lista.add("Valor 6");
        
        // Exibe os valores
        System.out.println("Valores da lista apos adicionar 'Valor 6':");
        for (String valor : lista) {
            System.out.println(valor);
        }
        
        // Exibe o tamanho
        System.out.println("Tamanho da lista apos adicionar 'Valor 6': " + lista.size());
    }
    
}
