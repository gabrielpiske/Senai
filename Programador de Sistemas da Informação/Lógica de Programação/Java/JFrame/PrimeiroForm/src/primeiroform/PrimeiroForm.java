package primeiroform;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author gabriel_piske
 */
public class PrimeiroForm {

    public static void main(String[] args) {
        JFrame form = new JFrame();
        form.setSize(600, 400);
        form.setLocationRelativeTo(null);
        form.setTitle("Exemplo de Form em JAVA");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);
        
        JLabel label = new JLabel();
        label.setBounds(50, 50, 200, 30);
        label.setText("Teste de label no java");
        label.setOpaque(true);
        Color corLetra = new Color(210, 105, 30);
        Color corBackLb = new Color(255, 222, 173);
        label.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
        label.setForeground(corLetra);
        label.setBackground(corBackLb);

        
        JTextField jtfNome = new JTextField();
        jtfNome.setBounds(50, 90, 200, 30);
        
        
        JButton botao = new JButton("Confirmar");
        botao.setBounds(50,130,200,30);
        
        
        form.add(label);        
        form.add(jtfNome);
        form.add(botao);
        
        form.setVisible(true);
    }

}
