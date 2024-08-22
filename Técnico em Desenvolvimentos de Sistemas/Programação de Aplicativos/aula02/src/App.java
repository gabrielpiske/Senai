import java.util.Locale;
import java.util.Scanner;

import entities.product;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        product produto;
        produto = new product();

        // Leitura
        System.out.println("Name: ");
        produto.name = ler.nextLine();
        System.out.println("Price: ");
        produto.price = ler.nextDouble();
        System.out.println("Quantity in stock: ");
        produto.quantity = ler.nextInt();

        System.out.println("Product data: " + produto.name + ", $" + produto.price + ", "+  produto.quantity + " units"+ ", Total: $" + produto.totalValueInStock());

        System.out.printf("Enter the number of products to be added in Stock: ");
        produto.addProducts(ler.nextInt());

        System.out.println("Product data: " + produto.name + ", $" + produto.price + ", "+  produto.quantity + " units"+ ", Total: $" + produto.totalValueInStock());

        System.out.printf("Enter the number of products to be removed in Stock: ");
        produto.removeProducts(ler.nextInt());

        System.out.println("Product data: " + produto.name + ", $" + produto.price + ", "+  produto.quantity + " units"+ ", Total: $" + produto.totalValueInStock());
    }
}
