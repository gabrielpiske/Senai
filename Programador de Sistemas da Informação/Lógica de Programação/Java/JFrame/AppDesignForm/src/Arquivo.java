
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author gabriel_piske
 */
public class Arquivo {

    public static String read(String path) {
        String content = "";
        try {
            FileReader arquivo = new FileReader(path);
            BufferedReader leitura = new BufferedReader(arquivo);
            String line = "";
            try {
                line = leitura.readLine();
                while (line != null) {
                    content += line + "\n";
                    line = leitura.readLine();
                }
                arquivo.close();
                return content;
            } catch (IOException ex) {
                System.err.println("Erro: Erro de Leitura de Arquivo");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Erro: Arquivo não encontrado");
            return "";
        }
    }

    public static boolean write(String path, String txt) {
        try{
            FileWriter arquivo = new FileWriter(path);
            PrintWriter gravacao = new PrintWriter(arquivo);
            gravacao.append(txt);
            gravacao.close();
            return true;
        } catch(IOException ex){
            System.err.println("Erro: " + ex.getMessage());
            return false;
        }
    }
}
