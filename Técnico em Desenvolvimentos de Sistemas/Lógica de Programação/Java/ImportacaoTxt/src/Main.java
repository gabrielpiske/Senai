
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /*  String nome = "João";
        int idade = 25;
        String email = "joao@example.com";

        try {
            //Abre o Arquivo em Modo de Anexação
            FileWriter arquivo = new FileWriter("registro.txt", true);
            PrintWriter gravador = new PrintWriter(arquivo);
            
            gravador.println("Nome: " + nome);
            gravador.println("Idade: " + idade);
            gravador.println("Email: " + email);
            gravador.println("--------------------------------------------"); 

            gravador.close();
            System.out.println("Registro salvo com Sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao salvar registro: " + e.getMessage());
        }*/

        Scanner menu = new Scanner(System.in);
        System.out.println("1- Cadastrar Personagem");
        Menu();
        System.out.println("Programa Finalizado");
    }

    private static void Menu() throws IOException {
        Scanner input = new Scanner(System.in);
        String tela = "-------------Menu------------\n"
                + "1 - Cadastrar Personagem \n"
                + "2 - Listar Personagem \n"
                + "3 - Alterar Personagem \n"
                + "4 - Apagar Personagem \n"
                + "5 - Deletar Personagem \n"
                + "6 - Recuperar Personagem \n"
                + "7 - Sair \n"
                + "-----------------------------\n";
        System.out.println(tela);
        String opcao = input.nextLine();

        while (opcao != "7") {
            if (opcao.equals("1")) {
                cadastrarPersonagem();
            } else if (opcao.equals("2")) {
                listarPersonagem();
            } else if (opcao.equals("3")) {
                alterarPersonagem();
            } else if (opcao.equals("4")) {
                apagarPersonagem();
            } else if (opcao.equals("5")) {
                deletarPersonagem();
            } else if (opcao.equals("6")) {
                recuperarPersonagem();
            } else if (opcao.equals("7")) {
                System.err.println("Saindo do Sistema...");
                System.exit(0);
            }
            System.out.println(tela);
            opcao = input.nextLine();
        }
    }

    private static void cadastrarPersonagem() {
        Scanner input = new Scanner(System.in);
        System.err.println("Insira o nome do personagem: ");
        String nome = input.nextLine();

        System.err.println("Insira a categoria do personagem: ");
        String categoria = input.nextLine();

        System.err.println("Insira o nome do filme do personagem: ");
        String filme = input.nextLine();

        System.err.println("Insira a cor do personagem: ");
        String cor = input.nextLine();

        Personagem personagem = new Personagem(nome, categoria, filme, cor);
        listap.add(personagem);
    }

    private static void listarPersonagem() throws IOException {
        if (listarPersonagem().isEmpty()) {
            System.err.println("Nenhum Personagem Cadastrado");
            return;
        }
        FileWriter arquivo = new FileWriter("registro.txt", true);
        PrintWriter gravador = new PrintWriter(arquivo);
        String relatorio = "";
        gravador.printf("---Lista de Personagens---\r\n");
        gravador.print(" |NOME|  |CATEGORIA|  |FILME|  |COR| \n");

        for (int i = 0; i < listap.size(); i++) {
            Personagem personagem = listap.get(i);
            System.out.println(personagem);

            relatorio = "\nNome: " + personagem.getNome()
                    + "\nCategoria: " + personagem.getCategoria()
                    + "\nFilme: " + personagem.getFilme()
                    + "\nCor: " + personagem.getCor()
                    + "\n------------------------------------------";
        }
        gravador.close();
    }

    private static void alterarPersoagem() {
        if (listap.size() == 0) {
            System.out.println("Nenhuma pessoa cadastrada");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do personagem para alterar");
        String pesquisar = input.nextLine();
        for (int i = 0; i < listap.size(); i++) {
            Personagem alterarNome = listap.get(i);
            if (pesquisar.equalsIgnoreCase(alterarNome.getNome())) {
                System.out.println("Informe o novo nome");
                String novoNome = input.nextLine();

                alterarNome.setNome(novoNome);
                break;
            }
            System.out.println("Nome alterado com sucesso! ");
        }
    }

    public static void apagarPersonagem() {
        if (listap.size() == 0) {
            System.out.println("Nenhma personagem cadastrado");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do personagem para apagar");
        String pesquisar = input.nextLine();
        for (int i = 0; i < listap.size(); i++) {
            Personagem alterarNome = listap.get(i);
            if (pesquisar.equalsIgnoreCase(alterarNome.getNome())) {
                listap.remove(i);
                System.out.println("Personagem deletado com sucesso!");
            }
        }
    }
    
    public static void deletarPersonagem(){
        if(listap.size() == 0){
            System.err.println("Nenhum personagem Cadastrada");
            return;
        }
        listap.clear();
        System.out.println("Todas os personagens apagados com sucesso");
    }
    
    public static  void recuperarPersonagem () throws IOException{
        String exib = "";
        String aarq = "registro.txt";
        String linha = "";
        File arq = new File(aarq);
        if(arq.exists()){
            exib = "Recuperado \n";
            try{
                exib += "";
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
            }
        }
    }

}
