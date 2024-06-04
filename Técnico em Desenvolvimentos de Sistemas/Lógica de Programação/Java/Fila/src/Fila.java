/**
 *
 * @author gabriel_piske
 */
class Fila {
    int inicio;
    int fim;
    int tamanho;
    int qtdeElementos;
    int f[];
    
    public Fila(){
        inicio = fim = -1;
        tamanho = 100;
        f = new int[tamanho];
        qtdeElementos = 0;
    }
    
    public boolean estaVazia(){
        if(qtdeElementos == 0){
            return true;
        }
        return false;
    }
    
    public boolean estaCheia(){
        if(qtdeElementos == tamanho -1){
            return true;
        }
        return false;
    }
    
    public void adicionar(int e){
        if(!estaCheia()){
            if (inicio == -1){
                inicio = 0;
            }
        }
    }
}
