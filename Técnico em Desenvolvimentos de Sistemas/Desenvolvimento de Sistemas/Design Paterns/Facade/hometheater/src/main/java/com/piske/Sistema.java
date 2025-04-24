package com.piske;

public class Sistema {

    public class Projetor {
        void ligar() {
            System.out.println("Projetor Ligado");
        }

        void desligar() {
            System.out.println("Projetor Desligado");
        }
    }

    public class Som {
        void ligar() {
            System.out.println("Som Ligado");
        }

        void desligar() {
            System.out.println("Som Desligado");
        }
    }

    public class BluRay {
        void reproduzirFilme() {
            System.out.println("Filme começado");
        }

        void pausarFilme() {
            System.out.println("Filme Pausado");
        }
    }

    public class Luz {
        void escurecer() {
            System.out.println("Luz Desligada");
        }

        void acender() {
            System.out.println("Luz Ligada");
        }
    }
}
