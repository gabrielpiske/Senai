package exemplo_utilizacao_pilha;


public class Pilha {
    // Atributos da Classe Pilha
    private String[] palavras;
    private int tam_max = 50;
    private int topo = -1;
    
    // Construtor vazio da Classe
    public Pilha(){
        this.palavras = new String[tam_max];
    }
    // Construtor com tamanho da Pilha definido pelo Ususario
    public Pilha(int tm){
        this.tam_max = tm;
        this.palavras = new String[tam_max];
    }
    
    // Métodos da Classe Pilha
    // Verificar se está vazia
    public boolean estaVazia(){
        return (topo < 0);
    }
    // Verificar se a Pilha está cheia
    public boolean estaCheia(){
        return (topo == (this.tam_max-1));
    }
    //Listar conteúdo da pilha
    public void printPilha(){
        for(int c=0 ; c <= topo ; c++){
            System.out.print(" ["+palavras[c]+"] ");
        }
    }
    // Visualizar o Topo
    public String verTopo(){
        return(palavras[topo]);
    }
    // Método Empílhar "Push"
    public void empilhar(String item){
        topo++;
        this.palavras[topo] = item;
    }
    // Método Remover ou desempilhar "Pop"
    public String remover(){
        return(palavras[topo--]);
    }
}
