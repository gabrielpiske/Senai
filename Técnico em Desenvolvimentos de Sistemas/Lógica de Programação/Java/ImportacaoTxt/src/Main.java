
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        String nome = "João";
        int idade = 25;
        String email = "joao@example.com";

        try {
            //Abre o Arquivo em Modo de Anexação
            FileWriter arquivo = new FileWriter("registro.txt", true);

            PrintWriter gravador = new PrintWriter(arquivo);
            gravador.println("Nome: " + nome);
            gravador.println("Idade: " + idade);
            gravador.println("Email: " + email);
            gravador.println(); // Linha em Branco pra fazer separação

            gravador.close();
            System.out.println("Registro salvo com Sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao salvar registro: " + e.getMessage());
        }
    }

}
