
import java.util.ArrayList;

/*
    2- Implemente uma lista usando o ArrayList da API Java
 */
/**
 *
 * @author julio_busarello / gabriel_piske / wilian_cardoso
 */
public class Main {

    public static void main(String[] args) {
        ArrayList carros = new ArrayList();
        
        carros.add("Uno");
        carros.add("Argo");
        carros.add("Logan");
        carros.add("Polo");
        carros.add(0,"Gol");
        
        carros.remove(0);
        System.out.println(carros);
        System.out.println("Tamanho lista: "+carros.size());
        carros.clear();
        System.out.println(carros);
        System.out.println("Tamanho lista: "+carros.size());
    }
    
}
