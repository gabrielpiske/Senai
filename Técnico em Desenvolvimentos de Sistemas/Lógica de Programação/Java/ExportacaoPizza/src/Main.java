
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author gabriel_piske
 */
public class Main {

    //Variavéis Globais
    private static Scanner ler = new Scanner(System.in);
    private static ArrayList<Pizza> listaPizza = new ArrayList<Pizza>();

    //Main Principal
    public static void main(String[] args) throws IOException {
        Menu();
    }

    //Menu Padrão do Sistema e gerenciamento de telas
    private static void Menu() throws IOException {
        int op;
        do {
            System.out.println("------ Cadastro de Pizza ------");
            System.out.println(" 1 - Cadastrar Pizza          -");
            System.out.println(" 2 - Listar Pizza             -");
            System.out.println(" 3 - Deletar Pizza            -");
            System.out.println(" 4 - Alterar Pizza            -");
            System.out.println(" 5 - Apagar Pizza             -");
            System.out.println(" 6 - Recuperar Dados          -");
            System.out.print("Entrada: ");
            op = ler.nextInt();

            switch (op) {
                case 1:
                    cadastro();
                    break;
                case 2:
                    listarPizza();
                    break;
                case 3:
                    deletarPizza();
                    break;
                case 4:
                    alterarPizza();
                    break;
                case 5:
                    apagarPizza();
                    break;
                case 6:
                    recuperarPizza();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (op != 0);
    }

    //Cadastro de Pizzas usando o construtor
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

    //Listando as Pizzas e salvando em Arquivo Txt
    private static void listarPizza() throws IOException {
        if (listaPizza.isEmpty()) {
            System.err.println("Nenhum Pizza Cadastrado");
            return;
        }
        FileWriter arquivo = new FileWriter("registro.txt", true);
        PrintWriter gravador = new PrintWriter(arquivo);
        String relatorio = "";
        gravador.printf("-----> Lista de Pizzas <-----\r\n");

        for (int i = 0; i < listaPizza.size(); i++) {
            Pizza pizza = listaPizza.get(i);
            relatorio = "\nTamanho: " + pizza.getTam()
                    + "\nSabor 1: " + pizza.getSabor1()
                    + "\nSabor 2: " + pizza.getSabor2()
                    + "\nFormato: " + pizza.getFormato()
                    + "\nFatias: " + pizza.getFatias()
                    + "\nBorda: " + (pizza.isBorda() ? "Sim" : "Nao")
                    + "\nPremium: " + (pizza.isPremium() ? "Sim" : "Nao")
                    + "\n------------------------------------------\n";
        }
        gravador.print(relatorio);
        gravador.close();
    }

    //Faz o delete de Pizzas fazendo seleção por tamanho da pizza
    private static void apagarPizza() throws IOException {
        if (listaPizza.size() == 0) {
            System.out.println("Nenhuma pizza cadastrado");
            return;
        }
        System.out.println("Informe o formato da pizza para apagar");
        String pesquisar = ler.next();
        for (int i = 0; i < listaPizza.size(); i++) {
            Pizza alterarNome = listaPizza.get(i);
            if (pesquisar.equalsIgnoreCase(alterarNome.getFormato())) {
                listaPizza.remove(i);
                System.out.println("Pizza deletada com sucesso!");
            }
        }
    }

    // Alterar Itens Especificicos da Pizza
    private static void alterarPizza() throws IOException {
        if (listaPizza.size() == 0) {
            System.out.println("Nenhuma pizza cadastrada");
            return;
        }
        System.out.println("O que deseja alterar?");
        System.out.println(" 1 - Tamanho");
        System.out.println(" 2 - Sabor 1");
        System.out.println(" 3 - Sabor 2");
        System.out.print("Entrada: ");
        int atributo = ler.nextInt();

        System.out.println("Informe o código da pizza para alterar: ");
        int codigoPizza = ler.nextInt();

        boolean achou = false;

        for (int i = 0; i < listaPizza.size(); i++) {
            Pizza pizza = listaPizza.get(i);
            if (pizza.getCodigo() == codigoPizza) {
                achou = true;
                switch (atributo) {
                    case 1:
                        System.out.println("Informe o novo tamanho: ");
                        String novoTamanho = ler.next();
                        pizza.setTam(novoTamanho);
                        break;
                    case 2:
                        System.out.println("Informe o novo sabor 1: ");
                        String novoSabor1 = ler.next();
                        pizza.setSabor1(novoSabor1);
                        break;
                    case 3:
                        System.out.println("Informe o novo sabor 2: ");
                        String novoSabor2 = ler.next();
                        pizza.setSabor2(novoSabor2);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
        if (achou) {
            System.out.println("Pizza alterada com sucesso!");
        } else {
            System.out.println("Pizza não encontrada.");
        }
    }

    //Deleta a Lista de Pizzas Inteira
    private static void deletarPizza() throws IOException {
        if (listaPizza.size() == 0) {
            System.err.println("Nenhum personagem Cadastrada");
            return;
        }
        listaPizza.clear();
        System.out.println("Todas os personagens apagados com sucesso");
    }

    //Recuperação de Dados Perdidos
    private static void recuperarPizza() throws IOException {
        String exib = "";
        String aarq = "registro.txt";
        String linha = "";
        File arq = new File(aarq);
        if (arq.exists()) {
            exib = "Recuperado \n";
            try {
                exib += "";
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    exib += linha + "\n";
                }
                leitor.close();
            } catch (Exception erro) {
            }
            System.out.println(exib);
        }
        FileWriter arquivo = new FileWriter("registro.txt", true);
        System.out.println("Todos pizzas recuperadas com sucesso! ");
    }
}
