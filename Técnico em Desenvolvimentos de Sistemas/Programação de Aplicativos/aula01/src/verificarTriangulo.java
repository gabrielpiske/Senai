import java.util.Locale;
import java.util.Scanner;

public class verificarTriangulo {

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);

        Scanner ler = new Scanner(System.in);
        double a, b, c, p;
        double area1, area2;

        // Triangulo X
        System.out.println("Entre com lado A do triangulo X: ");
        a = ler.nextDouble();
        System.out.println("Entre com lado B do triangulo X: ");
        b = ler.nextDouble();
        System.out.println("Entre com lado C do triangulo X: ");
        c = ler.nextDouble();
        p = (a + b + c) / 2;
        area1 = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        // Triangulo Y
        System.out.println("Entre com lado A do triangulo Y: ");
        a = ler.nextDouble();
        System.out.println("Entre com lado B do triangulo Y: ");
        b = ler.nextDouble();
        System.out.println("Entre com lado C do triangulo Y: ");
        c = ler.nextDouble();
        p = (a + b + c) / 2;
        area2 = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.printf("Area do do triangulo X:  %.4f%n" , area1);
        System.out.printf("Area do triangulo Y:  %.4f%n" , area2);

        if(area1 > area2) System.out.println("Triangulo X maior!");
        else System.out.println("Triangulo Y maior!");

        ler.close();
    }
}
