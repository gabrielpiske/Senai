import java.util.Locale;
import java.util.Scanner;

import entities.rectangle;

public class retangulo {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        rectangle retangulo;
        retangulo = new rectangle();

        System.out.println("Enter rectangle width and height: ");
        retangulo.width = ler.nextDouble();
        retangulo.height = ler.nextDouble();

        System.out.println("AREA =  "+retangulo.area());
        System.out.println("PERIMETER =  "+retangulo.perimeter());
        System.out.println("DIAGONAL =  "+retangulo.diagonal());
    }
}
