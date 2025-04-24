package com.piske;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("Bem-vindo ao sistema Home Theater");

        while(true){
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Assistir Filme");
            System.out.println("2 - Encerrar Filme");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    homeTheaterFacade.assistirFilme();
                    break;
                case 2:
                    homeTheaterFacade.acabouFilme();
                    break;
                case 0:
                    System.out.println("Sistema finalizado.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}