package insertionsortletras;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortLetras {

    public static void main(String[] args) {
        //inicia scanner
        Scanner ler = new Scanner(System.in);
        
        //variavel letras
        String letras = new String();
        
        //entrada de dados sendo gravado em letras
        System.out.println("Entre com as letras: ");
        letras = ler.nextLine();
        
        //converte string em um array de caracteres
        char[] caracteres = letras.toCharArray();
        Arrays.sort(caracteres);
        
        String ordenada = new String(caracteres);
        System.out.println("Caracteres Ordenados: " + ordenada);
        
        ler.close();
    }
}
