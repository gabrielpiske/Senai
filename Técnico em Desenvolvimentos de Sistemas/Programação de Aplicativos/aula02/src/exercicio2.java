import java.util.Locale;
import java.util.Scanner;

import entities.employee;

public class exercicio2 {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        employee employ;
        employ = new employee();

        System.out.print("Name: ");
        employ.name = ler.nextLine();
        System.out.print("Gross salary: ");
        employ.grossSalary = ler.nextDouble();
        System.out.print("Tax: ");
        employ.tax = ler.nextDouble();

        System.out.println("Employee: " + employ.name + ", $" + employ.nextSalary());

        System.out.print("Which percentage to increase salary? ");
        employ.increaseSalary(ler.nextDouble());

        System.out.println();

    }
}
