package calcbasica;

import java.util.Scanner;

/**
 *
 * @author gabriel_piske
 */
public class CalcBasica {

    
    public static void main(String[] args) {
        int nm1, nm2, mf;
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Entre com o primeiro numero: ");
        nm1 = ler.nextInt();
        System.out.println("Entre com o segundo numero: ");
        nm2 = ler.nextInt();
        
        mf = (nm1 + nm2);
        
        System.out.println("A soma dos numeros is: "+mf);
    }
    
}
