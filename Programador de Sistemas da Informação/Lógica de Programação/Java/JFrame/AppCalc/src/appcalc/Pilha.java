package appcalc;

/**
 * @author gabriel_piske
 */
public class Pilha {

    public static final int maxItems = 100;
    private int itens;
    private Object stk[];
    private int topo = -1;

    //Construtores
    public Pilha() {
        this.itens = maxItems;
        stk = new Object[itens];
    }

    public Pilha(int n) {
        this.itens = n;
        stk = new Object[itens];
    }
    
    //Métodos
    //Retorna os Elementos da Pilha
    public void print() {
        if (!isEmpty()) {
            String resp = "";
            for (int i = 0; i <= topo; i++) {
                resp += " [" + stk[i].toString() + "] ";
            }
            System.out.println(resp);
        } else {
            System.out.println("Pilha vazia");
        }
    }
    
    //Retorna o tamanho da pilha
    public int size(){
        return (topo + 1);
    }
    
    //Retorna o estado da Pilha (vazia/cheia)
    public boolean isEmpty(){
        return (topo < 0);
    }
    
    //Retorna o Objeto do Topo
    public Object top(){
        if(!isEmpty()){
            return stk[topo];
        }
        else{
            return null;
        }
    }
    
    //Adiciona objeto na pilha
    public void push(Object obj){
        if(topo < itens - 1){
            topo++;
            stk[topo] = obj;
        }
        else{
            System.out.println("Pilha cheia");
        }
    }
    
    //Retira o Objeto da Pilha
    public Object pop(){
        if(!isEmpty()){
            return stk[topo--];
        }
        else{
            return null;
        }
    }
}
