package java_janelas;

import javax.swing.JOptionPane;

public class Java_Janelas {

    public static void main(String[] args) {

        String nome = new String();
        int idade = 0;
        float media = 0;

        nome = JOptionPane.showInputDialog(null, "Digite o nome do Aluno: ", "Nome do Aluno: ", JOptionPane.QUESTION_MESSAGE);
        idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade do Aluno: ", "Idade do Aluno: ", JOptionPane.QUESTION_MESSAGE));
        media = Float.parseFloat(JOptionPane.showInputDialog(null,"Digite a média final do Aluno: ","Média do ALuno", JOptionPane.QUESTION_MESSAGE));
        
        JOptionPane.showMessageDialog(null, "O nome digitado do é: " + nome + "\n e ele tem " + idade + " anos", null, JOptionPane.WARNING_MESSAGE);
       
    }

}
