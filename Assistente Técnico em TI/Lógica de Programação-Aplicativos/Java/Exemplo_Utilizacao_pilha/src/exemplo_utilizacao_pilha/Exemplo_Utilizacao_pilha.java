package exemplo_utilizacao_pilha;


public class Exemplo_Utilizacao_pilha {


    public static void main(String[] args) {
       // Teste de Uso da Pilha
       /*Pilha p1 = new Pilha();
       
        p1.empilhar("BANANA");
        p1.empilhar("CASA");
        p1.empilhar("SENAI");
        p1.empilhar("ABIROLBADO");
        p1.empilhar("0000-0000");
        
       
        System.out.println("A pilha está vazia? "+p1.estaVazia());
        System.out.println("A pílha está cheia? "+p1.estaCheia());
        
        p1.printPilha();
        System.out.println("");
        
        System.out.println("Este é p item do Topo: "+p1.verTopo());
        p1.remover();
        
        System.out.println("Este é p item do Topo: "+p1.verTopo());
    }*/
     //Utilizando a classe PilhaObj()
    PilhaObj objeto = new PilhaObj();
    
    objeto.empilhar("Escola");
    
    objeto.empilhar(1955);
    
    objeto.empilhar('A');
    
    objeto.empilhar(6.78f);
            
    objeto.empilhar(true);
    
    objeto.empilhar(2.567894872);
    
        System.out.println("Objetos empilhados");
        objeto.printPilha();
    }
}
