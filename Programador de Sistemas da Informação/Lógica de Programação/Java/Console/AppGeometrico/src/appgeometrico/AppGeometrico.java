package appgeometrico;

/**
 *
 * @author gabriel_piske
 */
public class AppGeometrico {

    public static void main(String[] args) {
        
        System.out.println(" <--------- Retangulo 1 --------->");
        Retangulo rec1 = new Retangulo(10, 5);
        
        //Atribuindo Valores
        rec1.calArea();
        rec1.calcPerimetro();
        rec1.setLado2(7);
        rec1.calArea();
        rec1.calcPerimetro();
        
        System.out.println("");
        System.out.println(" <--------- Retangulo 2 --------->");
        Retangulo rec2 = new Retangulo(40, 60);
        
        //Atribuindo Valores
        rec2.calArea();
        rec2.calcPerimetro();
        rec2.setLado2(70);
        rec2.calArea();
        rec2.calcPerimetro();
        
        System.out.println("");
        System.out.println(" <--------- Retangulo 3 --------->");
        Retangulo rec3 = new Retangulo(5, 2);
        
        //Atribuindo Valores
        rec3.calArea();
        rec3.calcPerimetro();
        rec3.setLado2(3);
        rec3.calArea();
        rec3.calcPerimetro();
        
        System.out.println("");
        System.out.println(" <--------- Retangulo 4 --------->");
        Retangulo rec4 = new Retangulo(20, 10);
        
        //Atribuindo Valores
        rec4.calArea();
        rec4.calcPerimetro();
        rec4.setLado2(70);
        rec4.calArea();
        rec4.calcPerimetro();
    }
    
}
