package appgeometrico;

/**
 *
 * @author gabriel_piske
 */
public class Retangulo {

    //variavéis
    private float lado1;
    private float lado2;
    private float area;
    private float perimetro;
    
    //Get e Set
    public float getLado1() {
        return lado1;
    }
    public void setLado1(float lado1) {
        this.lado1 = lado1;
    }
    public float getLado2() {
        return lado2;
    }
    public void setLado2(float lado2) {
        this.lado2 = lado2;
    }
    
    //Construtor vazio
    public Retangulo(){
        
    }
    
    //Construtor Base
    public Retangulo(float lado1, float lado2){
       this.lado1 = lado1;
       this.lado2 = lado2;
    }
    
    //Métodos
    public void calArea(){
        System.out.println("Area do retangulo: " + (this.lado1 * this.lado2));
    }
    public void calcPerimetro(){
        System.out.println("Perimetro do retangulo: " + (this.lado1 * 2 + this.lado2 * 2));
    }
}
