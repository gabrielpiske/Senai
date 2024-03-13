package Pilha_Stack;

import java.util.Stack;

public class Pilha_Stack {
   
        public static void main(String[] args){
            Stack<Object> pilha = new Stack<>();
            
            //Verificar se vazia
            System.out.println("A pilha está vazia? " + pilha.isEmpty());
            
            //Empilhar Elementos
            pilha.push("Funciona POR FAVOR 1");
            pilha.push("Funciona POR FAVOR 2");
            pilha.push("Funciona POR FAVOR 3");
            
            //Listar Conteudo
            System.out.print("Conteudo da Pilha: " + pilha);
            
            //Visualizar o topo
            System.out.println("Este é o Topo da Pilha: " + pilha.peek());
            
            //Remover 
            System.out.println("Elementos Desempilhados : " + pilha.pop());
            System.out.println("Elementos Desempilhados : " + pilha.pop());
            System.out.println("Elementos Desempilhados : " + pilha.pop());
        }
    }

