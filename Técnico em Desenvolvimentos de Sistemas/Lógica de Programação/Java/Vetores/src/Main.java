/**
 *
 * @author gabriel_piske
 */
public class Main {

    public static void main(String[] args) {
        int[] vInt = new int[5];
        boolean[] vBool = new boolean[5];
        String[] vString = new String[5];
        int[] vInteiro = new int[5];
        
        //utilizando o length
        System.out.println("Vator de Inteiros utilizando o ");
        for (int i = 0; i < vInteiro.length; i++) {
            System.out.println(vInteiro[i] + " ");
        }
        // declarando e inicializando
        int[] vetorNumerosInicializado = new int[]{1,2,3,4,5};
        
        //criando e inicializado
        int vetorEnxuto[] = {7,8,9,10,11};
        
        int i=0;
        System.out.println("Vetor de Inteiros Inicializado");
        while (i < 5) {
            System.out.println(vetorNumerosInicializado[i] + " ");
            i++;
        }
        i = 0;
        System.out.println("Vetor de Inteiros Inicializado Enxuta");
        while (i<5) {
            System.out.println(vetorEnxuto[i] + " ");
            i++;
        }
        i = 0;
        System.out.println("Vetor Menorzinho");
        while (i < 5) {
            System.out.println(vInt[i] + " ");
            i++;
        }
        i = 0;
        System.out.println("Vetor de Booleans");
        while(i < 5){
            System.out.println(vBool[i] + " ");
            i++;
        }
        i = 0;
        System.out.println("Vetor de Strings");
        while(i < 5){
            System.out.println(vString[i] + " ");
            i++;
        }
    }
    
}
