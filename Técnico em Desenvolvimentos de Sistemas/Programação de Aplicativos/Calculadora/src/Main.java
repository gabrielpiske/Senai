import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultado;

    public Main(){
        setTitle("Calculadora");
        setSize(1000,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //num1Field.setBounds(200, 150, 100, 30);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton multButton = new JButton("*");
        JButton divButton = new JButton("/");
        resultado = new JLabel("Resultado");

        panel.add(new JLabel("Numero 1"));
        panel.add(num1Field);        
        panel.add(new JLabel("Numero 2"));
        panel.add(num2Field);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(multButton);
        panel.add(divButton);
        panel.add(resultado);
        add(panel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                operacaoMatematica('+');
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                operacaoMatematica('-');
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                operacaoMatematica('/');
            }
        });

        multButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                operacaoMatematica('*');
            }
        });
    }
    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        frame.setVisible(true);
    }

    private void operacaoMatematica(char operador){
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operador) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                if(num2 != 0) result = num1 / num2;
                else resultado.setText("Erro: Impossivel dividir por zero"); break;
                default:
                    break;
            }
            resultado.setText("Resultado: " + result);
        } catch (Exception e) {
            resultado.setText("Erro: Entrada Invalida");
        }
    }
}
