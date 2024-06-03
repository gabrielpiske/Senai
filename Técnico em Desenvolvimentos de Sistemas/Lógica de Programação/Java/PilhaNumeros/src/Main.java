
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        boolean continuar = true;
        Pilha p1 = new Pilha(50);
        int menu;
        int ele, nmEle = 0;
        String vazio;
        Scanner ler = new Scanner(System.in);
        do {
            System.out.println("------------------------------");
            System.out.println("----    PILHA DE NUMEROS     -");
            System.out.println("------------------------------");
            System.out.println("Voce deseja ?:               -");
            System.out.println("1 - Empilhar Elemento:       -");
            System.out.println("2 - Desempilhar Elemento:    -");
            System.out.println("3 - Verificar se esta vazio: -");
            System.out.println("4 - Printar:                 -");
            System.out.println("5 - Sair:                    -");
            menu = ler.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Qual elemento deseja empilhar? :");
                    ele = ler.nextInt();
                    p1.empilha(ele);
                    nmEle+=1;
                    break;
                case 2:
                    System.out.println("Voce desempilhou o ultimo elemento");
                    p1.desempilha();
                    nmEle-=1;
                    break;
                case 3:
                    if(p1.vazia()){
                        vazio = "vazia";
                    } else{
                        vazio = "com "+nmEle+" elementos";
                    }
                    System.out.println("A pilha esta: "+vazio);
                    break;
                case 4:
                    p1.print();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (continuar);
    }

}
