
package javaapplication7;

import java.util.Random;
import javax.swing.JOptionPane;


public class JavaApplication7 {


    public static void main(String[] args) {
        int tentativas = 0;
        int palpite = 0;
        int reiniciar = -1;
        int op = -1;
        Random rand = new Random();
        int sorteio = rand.nextInt(5);

        palpite = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero de 1 a 100", "Jogo Do Palpite", JOptionPane.QUESTION_MESSAGE));

        while (reiniciar != 0) {

            tentativas++;
            if (palpite > sorteio) {

                palpite = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um numero menor", "Tentativa " + tentativas, JOptionPane.QUESTION_MESSAGE));

            } else if (palpite == sorteio) {
                JOptionPane.showMessageDialog(null, "Você acertou em " + tentativas + " tentativas Parabéns!!! ", "Parabêns", JOptionPane.WARNING_MESSAGE);
                reiniciar = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja continuar? 1- Sim 0- Não", "Reinico", JOptionPane.QUESTION_MESSAGE));

                if (reiniciar == 1) {
                    tentativas = 0;
                    sorteio = rand.nextInt(5);
                    palpite = Integer.parseInt(JOptionPane.showInputDialog(null, "Novo Jogo \nDigite um numero de 1 a 100", "Jogo Do Palpite", JOptionPane.QUESTION_MESSAGE));

                }

            } else {

                palpite = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um numero Maior", "Tentativa " + tentativas, JOptionPane.QUESTION_MESSAGE));

            }

        }

    }

}
