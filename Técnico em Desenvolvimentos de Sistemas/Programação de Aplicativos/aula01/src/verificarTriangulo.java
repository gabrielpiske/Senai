import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class verificarTriangulo {

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);

        Scanner ler = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        // Triangulo X
        System.out.println("Entre com os lados do triangulo X: ");
        x.a = ler.nextDouble();
        x.b = ler.nextDouble();
        x.c = ler.nextDouble();
        double area1 = x.area();

        // Triangulo Y
        System.out.println("Entre com os lados do triangulo Y: ");
        y.a = ler.nextDouble();
        y.b = ler.nextDouble();
        y.c = ler.nextDouble();
        double area2 = y.area();

        //Saida do programa
        System.out.printf("Area do do triangulo X:  %.4f%n" , area1);
        System.out.printf("Area do triangulo Y:  %.4f%n" , area2);

        //Verificação de maior
        if(area1 > area2) System.out.println("Triangulo X maior!");
        else System.out.println("Triangulo Y maior!");

        ler.close();
    }
}
