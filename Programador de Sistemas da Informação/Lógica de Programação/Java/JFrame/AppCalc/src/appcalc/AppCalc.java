package appcalc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author gabriel_piske
 */
public class AppCalc {

    public static void main(String[] args) {

        //Selecionar o Look & Feel desejado
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } catch (InstantiationException exc) {
            exc.printStackTrace();
        } catch (IllegalAccessException exc) {
            exc.printStackTrace();
        }
        // Listar os Look & Feel
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName());
        }

        //Variáveis
        int hBtn = 60;
        int wBtn = 60;
        int espaco = 20;

        // Criação da tela
        JFrame form = new JFrame();
        form.setSize(360, 570);
        form.setTitle("Calculadora");
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);
        form.getContentPane().setBackground(Color.DARK_GRAY);

        // Visor da calculadora
        JTextField visor = new JTextField();
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visor.setFont(new Font("JetBrains Mono", Font.PLAIN, 28));
        visor.setBounds(20, 20, 300, 80);
        visor.setBackground(Color.BLACK);
        visor.setForeground(Color.WHITE);

        // Criação dos Botões
        JButton btnClear = new JButton("C");
        styleButton(btnClear, espaco, 120, wBtn, hBtn, visor);

        JButton btnBack = new JButton("<");
        styleButton(btnBack, espaco * 2 + wBtn, 120, wBtn, hBtn, visor);

        JButton btnOpnPar = new JButton("(");
        styleButton(btnOpnPar, espaco * 3 + wBtn * 2, 120, wBtn, hBtn, visor);

        JButton btnClsPar = new JButton(")");
        styleButton(btnClsPar, espaco * 4 + wBtn * 3, 120, wBtn, hBtn, visor);

        JButton btn7 = new JButton("7");
        styleButton(btn7, espaco, 120 + 60 + 20, wBtn, hBtn, visor);

        JButton btn8 = new JButton("8");
        styleButton(btn8, espaco * 2 + wBtn, 120 + 60 + 20, wBtn, hBtn, visor);

        JButton btn9 = new JButton("9");
        styleButton(btn9, espaco * 3 + wBtn * 2, 120 + 60 + 20, wBtn, hBtn, visor);

        JButton btnBarr = new JButton("/");
        styleButton(btnBarr, espaco * 4 + wBtn * 3, 120 + 60 + 20, wBtn, hBtn, visor);

        JButton btn4 = new JButton("4");
        styleButton(btn4, espaco, 120 + 80 * 2, wBtn, hBtn, visor);

        JButton btn5 = new JButton("5");
        styleButton(btn5, espaco * 2 + wBtn, 120 + 80 * 2, wBtn, hBtn, visor);

        JButton btn6 = new JButton("6");
        styleButton(btn6, espaco * 3 + wBtn * 2, 120 + 80 * 2, wBtn, hBtn, visor);

        JButton btnMult = new JButton("*");
        styleButton(btnMult, espaco * 4 + wBtn * 3, 120 + 80 * 2, wBtn, hBtn, visor);

        JButton btn1 = new JButton("1");
        styleButton(btn1, espaco, 120 + 80 * 3, wBtn, hBtn, visor);

        JButton btn2 = new JButton("2");
        styleButton(btn2, espaco * 2 + wBtn, 120 + 80 * 3, wBtn, hBtn, visor);

        JButton btn3 = new JButton("3");
        styleButton(btn3, espaco * 3 + wBtn * 2, 120 + 80 * 3, wBtn, hBtn, visor);

        JButton btnLess = new JButton("-");
        styleButton(btnLess, espaco * 4 + wBtn * 3, 120 + 80 * 3, wBtn, hBtn, visor);

        JButton btn0 = new JButton("0");
        styleButton(btn0, espaco, 120 + 80 * 4, wBtn, hBtn, visor);

        JButton btnDot = new JButton(".");
        styleButton(btnDot, espaco * 2 + wBtn, 120 + 80 * 4, wBtn, hBtn, visor);

        JButton btnEquals = new JButton("=");
        styleButton(btnEquals, espaco * 3 + wBtn * 2, 120 + 80 * 4, wBtn, hBtn, visor);

        JButton btnPlus = new JButton("+");
        styleButton(btnPlus, espaco * 4 + wBtn * 3, 120 + 80 * 4, wBtn, hBtn, visor);

        //Adicionando Elementos na Tela
        form.add(btnPlus);
        form.add(btnEquals);
        form.add(btnDot);
        form.add(btn0);
        form.add(btnLess);
        form.add(btn3);
        form.add(btn2);
        form.add(btn1);
        form.add(btnMult);
        form.add(btn6);
        form.add(btn5);
        form.add(btn4);
        form.add(btnBarr);
        form.add(btn9);
        form.add(btn8);
        form.add(btn7);
        form.add(btnClsPar);
        form.add(btnOpnPar);
        form.add(btnBack);
        form.add(btnClear);
        form.add(visor);

        //Tela Visível
        form.setVisible(true);
    }

    // Estilizar os botões
    private static void styleButton(JButton button, int x, int y, int width, int height, JTextField visor) {
        button.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(90, 93, 95));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);  // Remover borda do cliquue
        button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("C")) {
                    visor.setText("");
                } else if (command.equals("<")) {
                    if (visor.getText().length() > 0) {
                        visor.setText(visor.getText().substring(0, visor.getText().length() - 1));
                    }
                } else if (command.equals("=")) {
                    String exp = visor.getText();               // Pega a expressão do visor
                    System.out.println(">>>" + exp);            // Printa a expressão no console
                    Calculadora calculo = new Calculadora();    // Instancia o objeto calculadora
                    String resultado = calculo.evalExp(exp);    // Manda a string do visor para o calculo
                    visor.setText(resultado);                   // Atualiza o visor
                } else {
                    visor.setText(visor.getText() + command);
                }
            }
        });
    }
}
