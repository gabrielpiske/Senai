package jogopalpite_janelas;

import java.util.Random;
import javax.swing.JOptionPane;

public class JogoPalpite_janelas {

    public static void main(String[] args) {

        int numeroAleatorio = random.nextInt(50) + 1;
        int palpite = 0;
        int tentativas = 0;
        int op = -1;
        Random random = new Random();
        int sorteio = rand.nextInt(5);
        while (op != 0) {

            palpite = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero de 1 a 100", "Jogo Do Palpite", JOptionPane.QUESTION_MESSAGE));

            while (op != 0) {

                tentativas++;
                if (palpite > sorteio) {

                    palpite = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um numero menor", "Tentativa " + tentativas, JOptionPane.QUESTION_MESSAGE));

                } else if (palpite == sorteio) {
                    JOptionPane.showMessageDialog(null, "Você acertou em " + tentativas + " tentativas Parabéns!!! ", "Parabêns", JOptionPane.WARNING_MESSAGE);
                    op = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja continuar? 1- Sim 0- Não", "Reinico", JOptionPane.QUESTION_MESSAGE));

                    if (op == 1) {
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
}
