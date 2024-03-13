    package exemplo_utilizacao_pilha;


    public class PilhaObj {
         // Atributos da Classe Pilha
        private Object[] objeto;
        private int tam_max = 50;
        private int topo = -1;

        // Construtor vazio da Classe
        public PilhaObj(){
            this.objeto = new Object[tam_max];
        }
        // Construtor com tamanho da Pilha definido pelo Ususario
        public PilhaObj(int tm){
            this.tam_max = tm;
            this.objeto = new Object[tam_max];
        }

        // Métodos da Classe Pilha
        // Verificar se está vazia
        public boolean estaVazia(){
            return (topo < 0);
        }
        // Verificar se a Pilha está cheia
        public boolean estaCheia(){
            return (topo == (this.tam_max-1));
        }
        //Listar conteúdo da pilha
        public void printPilha(){
            for(int c=0 ; c <= topo ; c++){
                System.out.print(" ["+objeto[c]+"] ");
            }
        }
        // Visualizar o Topo
        public Object verTopo(){
            return(objeto[topo]);
        }
        // Método Empílhar "Push"
        public void empilhar(Object obj){
            topo++;
            this.objeto[topo] = obj;
        }
        // Método Remover ou desempilhar "Pop"
        public Object remover(){
            return(objeto[topo--]);
        }



    }
