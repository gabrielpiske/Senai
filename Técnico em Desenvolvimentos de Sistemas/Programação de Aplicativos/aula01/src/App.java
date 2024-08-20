import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Locale.setDefault(Locale.US);

        Double peso;
        Double altura;
        Double imc;
        Scanner ler = new Scanner(System.in);


        System.out.print("\nEntre com seu peso: ");
        peso = ler.nextDouble();

        System.out.print("\nEntre com sua altura: ");
        altura = ler.nextDouble();

        imc = peso / (altura * altura);

        System.out.printf("\nSeu imc é: %.4f%n", imc);
        ler.close();
    }
}