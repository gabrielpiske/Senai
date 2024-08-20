import java.util.Locale;
import java.util.Scanner;

public class raiz {

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Locale.setDefault(Locale.US);

        Scanner ler = new Scanner(System.in);
        double numero;
        System.out.print("\nEntre com o numero: ");
        numero = ler.nextDouble();

        double raiz = Math.sqrt(numero);

        System.out.print("\nRaiz Quadrada: " + raiz);
        ler.close();
    }
}
