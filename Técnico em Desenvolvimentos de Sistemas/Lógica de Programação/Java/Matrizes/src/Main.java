/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        int matriz1[][] = new int[2][2];
        int [][] matriz2 = new int[2][2];
        int [][] matriz3 = {{1,2}, {3,4}};
        
        for(int j = 0; j <2; j++){
            for(int k = 0; k < 2; k++){
                System.out.println("Matriz: L: "+ j + " C: " + k + ". Valor: "+matriz3[j][k] + ".");
            }
        }
    }
    
}
