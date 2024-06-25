
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author gabriel_piske
 */
public class Main {

    private static Scanner ler = new Scanner(System.in);
    private static ArrayList<Pizza> listaPizza = new ArrayList<Pizza>();

    public static void main(String[] args) throws IOException {
        Menu();
    }

    private static void Menu() throws IOException {
        int op;
        do {
            System.out.println("------ Cadastro de Pizza ------");
            System.out.println(" 1 - Cadastrar Pizza          -");
            System.out.println(" 2 - Listar Pizza            -");
            System.out.println(" 3 - Deletar Pizza            -");
            System.out.println(" 4 - Alterar Pizza             -");
            System.out.println(" 5 - Apagar Pizza             -");
            System.out.println(" 6 - Recuperar Dados          -");
            System.out.print("Entrada: ");
            op = ler.nextInt();

            switch (op) {
                case 1:
                    cadastro();
                    break;
                case 2:
                    listarPizzas();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (op != 0);
    }

    private static void cadastro() {
        System.err.println("Entre com o Tamanho da Pizza:  ");
        String tam = ler.next();

        System.err.println("Entre com o Sabor 1: ");
        String sb1 = ler.next();

        System.err.println("A pizza tera borda? (s / n): ");
        boolean bord;
        String aux = ler.next();
        if ("s".equals(aux)) {
            bord = true;
        } else {
            bord = false;
        }

        System.err.println("Qual o Formato da Pizza: ");
        String form = ler.next();

        System.err.println("Quantas fatias? : ");
        int fatias = ler.nextInt();

        System.err.println("Entre com o Sabor 2: ");
        String sb2 = ler.next();

        System.err.println("Pizza Premium? (s / n): ");
        boolean premi = true;
        String auxPre = ler.next();
        if ("s".equals(auxPre)) {
            premi = true;
        } else {
            premi = false;
        }

        Pizza pizza = new Pizza(tam, sb1, bord, form, fatias, sb2, premi);
        listaPizza.add(pizza);
    }

    private static void listarPizzas() throws IOException {
        if (listaPizza.isEmpty()) {
            System.err.println("Nenhum Pizza Cadastrado");
            return;
        }
        FileWriter arquivo = new FileWriter("registro.txt", true);
        PrintWriter gravador = new PrintWriter(arquivo);
        String relatorio = "";
        gravador.printf("---Lista de Pizzas ---\r\n");
        gravador.print(" |CODIGO|  |TAMANHO|  |SABOR 1|  |BORDA|  |FORMATO|  |FATIAS|  |SABOR 2|  |PREMIUM| \n");

        for (int i = 0; i < listaPizza.size(); i++) {
            Pizza pizza = listaPizza.get(i);
            System.out.println(pizza);
            gravador.println(pizza);
            relatorio = "\nCodigo: " + pizza.getCodigo()
                    + "\nTamanho: " + pizza.getTam()
                    + "\nSabor 1: " + pizza.getSabor1()
                    + "\nSabor 2: " + pizza.getSabor2()
                    + "\nFormato: " + pizza.getFormato()
                    + "\nFatias: " + pizza.getFatias()
                    + "\nBorda: " + pizza.isBorda()
                    + "\nPremium: " + pizza.isPremium()
                    + "\n------------------------------------------";
        }
        gravador.print(relatorio);
        gravador.close();
    }
}
