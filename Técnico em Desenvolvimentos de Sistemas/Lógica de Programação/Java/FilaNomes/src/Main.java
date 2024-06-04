
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
        Fila f1 = new Fila();
        int menu;
        int nmEle = 0;
        String vazio;
        String ele = "";
        Scanner ler = new Scanner(System.in);
        do {
            System.out.println("------------------------------");
            System.out.println("----    FILA DE PALAVRAS     -");
            System.out.println("------------------------------");
            System.out.println("Voce deseja ?:               -");
            System.out.println("1 - Enqueue (adicionar):     -");
            System.out.println("2 - Dequeue (remover):       -");
            System.out.println("3 - Peek (ultimo elemento):  -");
            System.out.println("4 - isEmpty (vazio):         -");
            System.out.println("5 - Sair:                    -");
            menu = ler.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Qual palavra deseja adicionar? :");
                    ele = ler.next();
                    f1.adicionar(ele);
                    nmEle += 1;
                    break;
                case 2:
                    System.out.println("Voce removeu o ultimo elemento");
                    f1.remover();
                    nmEle -= 1;
                    break;
                case 3:
                    System.out.println("Ultimo elemento: " + ele);
                    break;
                case 4:
                    if (f1.estaVazia()) {
                        vazio = "vazia";
                    } else {
                        vazio = "com " + nmEle + " elementos";
                    }
                    System.out.println("A pilha esta: " + vazio);
                    break;
                default:
                    throw new AssertionError();
            }
        } while (continuar);

    }

}
