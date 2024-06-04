/**
 *
 * @author gabriel_piske
 */
class Fila {
    int inicio;
    int fim;
    int tamanho;
    int qtdeElementos;
    String f[];
    
    public Fila(){
        inicio = fim = -1;
        tamanho = 100;
        f = new String[tamanho];
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
    
    public void adicionar(String e){
        if(!estaCheia()){
            if (inicio == -1){
                inicio = 0;
            }
            fim++;
            f[fim] = e;
            qtdeElementos++;
        }
    }
    
    public void remover(){
        if(!estaVazia()){
            inicio++;
            qtdeElementos--;
        }
    }
    
    public void mostrar(){
        String elementos = "";
        for(int i = inicio; i <= fim; i++){
            elementos += f[i] + " - ";
        }
        System.out.println(elementos);
    }
}
