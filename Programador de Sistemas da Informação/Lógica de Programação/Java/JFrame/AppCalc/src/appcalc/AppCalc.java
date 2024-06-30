package appcalc;

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

        //Variavéis
        int hBtn = 60;
        int wBtn = 60;
        int espaco = 20;

        // Criaçao da tela
        JFrame form = new JFrame();
        form.setSize(360, 570);
        form.setTitle("Calculadora");
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);

        // Visor da calculadora
        JTextField visor = new JTextField();
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visor.setFont(new Font("JetBrains Mono", Font.PLAIN, 28));
        visor.setBounds(20, 20, 300, 80);

        // Criação dos Botões
        //Limpar tudo
        JButton btnClear = new JButton("C");
        btnClear.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnClear.setBounds(espaco, 120, wBtn, hBtn);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText("");
            }
        });

        //Limpar ultimo digito da calculadora
        JButton btnBack = new JButton("<");
        btnBack.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnBack.setBounds(espaco * 2 + wBtn, 120, wBtn, hBtn);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (visor.getText().length() > 0) {
                    visor.setText(visor.getText().substring(0, visor.getText().length() - 1));
                }
            }
        });

        //Digito '('
        JButton btnOpnPar = new JButton("(");
        btnOpnPar.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnOpnPar.setBounds(espaco * 3 + wBtn * 2, 120, wBtn, hBtn);
        btnOpnPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "(");
            }
        });

        //Digito ')'
        JButton btnClsPar = new JButton(")");
        btnClsPar.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnClsPar.setBounds(espaco * 4 + wBtn * 3, 120, wBtn, hBtn);
        btnClsPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + ")");
            }
        });

        //Digito 7
        JButton btn7 = new JButton("7");
        btn7.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn7.setBounds(espaco, 120 + 60 + 20, wBtn, hBtn);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "7");
            }
        });

        //Digito 8
        JButton btn8 = new JButton("8");
        btn8.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn8.setBounds(espaco * 2 + wBtn, 120 + 60 + 20, wBtn, hBtn);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "8");
            }
        });

        //Digito 9
        JButton btn9 = new JButton("9");
        btn9.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn9.setBounds(espaco * 3 + wBtn * 2, 120 + 60 + 20, wBtn, hBtn);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "9");
            }
        });

        //Digito '/'
        JButton btnBarr = new JButton("/");
        btnBarr.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnBarr.setBounds(espaco * 4 + wBtn * 3, 120 + 60 + 20, wBtn, hBtn);
        btnBarr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "/");
            }
        });

        //Digito 4
        JButton btn4 = new JButton("4");
        btn4.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn4.setBounds(espaco, 120 + 80 * 2, wBtn, hBtn);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "4");
            }
        });

        //Digito 5
        JButton btn5 = new JButton("5");
        btn5.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn5.setBounds(espaco * 2 + wBtn, 120 + 80 * 2, wBtn, hBtn);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "5");
            }
        });

        //Digito 6
        JButton btn6 = new JButton("6");
        btn6.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn6.setBounds(espaco * 3 + wBtn * 2, 120 + 80 * 2, wBtn, hBtn);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "6");
            }
        });

        //Digito'*'
        JButton btnMult = new JButton("*");
        btnMult.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnMult.setBounds(espaco * 4 + wBtn * 3, 120 + 80 * 2, wBtn, hBtn);
        btnMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "*");
            }
        });

        //Digito 1
        JButton btn1 = new JButton("1");
        btn1.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn1.setBounds(espaco, 120 + 80 * 3, wBtn, hBtn);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "1");
            }
        });

        //Digito 2
        JButton btn2 = new JButton("2");
        btn2.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn2.setBounds(espaco * 2 + wBtn, 120 + 80 * 3, wBtn, hBtn);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "2");
            }
        });

        //Digito 3
        JButton btn3 = new JButton("3");
        btn3.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn3.setBounds(espaco * 3 + wBtn * 2, 120 + 80 * 3, wBtn, hBtn);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "3");
            }
        });

        //Digito '-'
        JButton btnLess = new JButton("-");
        btnLess.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnLess.setBounds(espaco * 4 + wBtn * 3, 120 + 80 * 3, wBtn, hBtn);
        btnLess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "-");
            }
        });

        //Digito 0
        JButton btn0 = new JButton("0");
        btn0.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btn0.setBounds(espaco, 120 + 80 * 4, wBtn, hBtn);
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "0");
            }
        });

        //Digito '.'
        JButton btnDot = new JButton(".");
        btnDot.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnDot.setBounds(espaco * 2 + wBtn, 120 + 80 * 4, wBtn, hBtn);
        btnDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + ".");
            }
        });

        //Digito '='
        JButton btnEquals = new JButton("=");
        btnEquals.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnEquals.setBounds(espaco * 3 + wBtn * 2, 120 + 80 * 4, wBtn, hBtn);
        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String exp = visor.getText();               //Pega a expressão do visor
                System.out.println(">>>" + exp);            //Printa a expressão no console
                Calculadora calculo = new Calculadora();    //Instancia o objeto calculadora
                String resultado = calculo.evalExp(exp);    //Manda a string do visor para o calculo
                visor.setText(resultado);                   //Atualiza o visor
            }
        });

        //Digito '+'
        JButton btnPlus = new JButton("+");
        btnPlus.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
        btnPlus.setBounds(espaco * 4 + wBtn * 3, 120 + 80 * 4, wBtn, hBtn);
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "+");
            }
        });

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

        //Tela Visivel
        form.setVisible(true);
    }

}
