package introducaotelajoptionpane;

import javax.swing.JOptionPane;

/**
 *
 * @author gabriel_piske
 */
public class IntroducaoTelaJOptionPane {

    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Uauuuuu");

        int idade;
        String nome;
        double salario;

        nome = JOptionPane.showInputDialog("Informe seu Nome: ");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade: "));
        salario = Integer.parseInt(JOptionPane.showInputDialog("Informe seu salario: "));

        
        //Idade
        JOptionPane.showMessageDialog(null, "Você tem " + idade + " anos");
        if (idade < 18) {
            JOptionPane.showMessageDialog(null, "Voce é menor de idade 😢");
        } else {
            JOptionPane.showMessageDialog(null, "Você é maior de idade 😎");
        }
        //Salario
        JOptionPane.showMessageDialog(null, "Você ganha R$" + salario);
        if (salario > 12000) {
            JOptionPane.showMessageDialog(null, "Você é o Hermano");
        } else {
            JOptionPane.showMessageDialog(null, "Você trabalha na Unifique");
        }
    }

}
