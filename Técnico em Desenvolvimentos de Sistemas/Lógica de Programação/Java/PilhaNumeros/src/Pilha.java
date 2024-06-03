
/**
 *
 * @author gabriel_piske
 */
public class Pilha {

    public static final int maxItens = 100;
    private int itens;
    private Object stk[];
    private int topo = -1;

    //Construct
    public Pilha() {
        this.itens = maxItens;
        stk = new Object[itens];
    }

    //Construct
    public Pilha(int n) {
        this.itens = n;
        stk = new Object[itens];
    }

    public void print() {
        if (!vazia()) {
            String resp = "";
            for (int i = 0; i <= topo; i++) {
                resp += " [" + stk[i].toString() + "] ";
            }
            System.out.println(resp);
        } else {
            System.out.println("Pilha Vazia");
        }
    }

    public int tamanho() {
        return (topo + 1);
    }

    public boolean vazia() {
        return (topo < 0);
    }

    public Object topo() {
        if (!vazia()) {
            return stk[topo];
        } else {
            return null;
        }
    }

    public void empilha(Object obj) {
        if (topo < itens - 1) {
            topo++;
            stk[topo] = obj;
        } else {
            System.out.println("Pilha Cheia");
        }
    }

    public Object desempilha() {
        if (!vazia()) {
            return stk[topo--];
        } else {
            return null;
        }
    }
}
