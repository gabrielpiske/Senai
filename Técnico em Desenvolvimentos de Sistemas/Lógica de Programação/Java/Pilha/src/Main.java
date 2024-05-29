/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        Pilha p1 = new Pilha(50);
        p1.empilha(50);
        p1.empilha(70);
        p1.empilha(90);
        p1.empilha(10);
        p1.print();
        p1.desempilha();
        p1.print();
    }
    
}
