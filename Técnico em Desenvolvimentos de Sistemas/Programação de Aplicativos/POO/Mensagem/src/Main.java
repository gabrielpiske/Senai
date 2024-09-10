import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Main extends JFrame {

    public Main(){
        setTitle("Titulo");
        setSize(300, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(200, 100));


        //Nome
        JLabel lblNome = new JLabel("Nome: ");
        lblNome.setBounds(9, 10, 100, 30);
        lblNome.setFont(new Font("Arial",Font.BOLD,16));
        lblNome.setForeground(Color.BLUE);
        //lblNome.setIcon(new ImageIcon("C:\\Users\\gabriel_piske\\Downloads\\peleza.png"));
        lblNome.setToolTipText("Informe seu Nome");

        JTextField txtNome = new JTextField();
        txtNome.setBounds(60, 10, 200, 30);

        JButton addButton = new JButton("Exibir Nome");
        addButton.setBounds(60, 50, 200,30);

        //Sobrenome
        JLabel lblSobNome = new JLabel("Sobrenome: ");
        lblSobNome.setBounds(9, 100, 100, 30);
        lblSobNome.setFont(new Font("Arial",Font.BOLD,16));
        lblSobNome.setForeground(Color.BLUE);
        //lblNome.setIcon(new ImageIcon("C:\\Users\\gabriel_piske\\Downloads\\peleza.png"));
        lblNome.setToolTipText("Informe seu Nome");

        JTextField txtSobNome = new JTextField();
        txtSobNome.setBounds(105, 100, 155, 30);

        JButton addButtonSobNome = new JButton("Exibir Sorenome");
        addButtonSobNome.setBounds(60, 140, 200,30);

        //Fechar Programa
        JButton btnClose = new JButton("Fechar Programa");
        btnClose.setBounds(17, 200, 250,30);

        //Interações
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(txtNome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Entrada Vazia");
                } else{
                    JOptionPane.showMessageDialog(null, "Seu nome é: " + txtNome.getText());
                    txtNome.setText("");
                }
            }
        });

        addButtonSobNome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(txtSobNome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Entrada Vazia");
                } else{
                    JOptionPane.showMessageDialog(null, "Seu sobrenome é: " + txtSobNome.getText());
                    txtSobNome.setText("");                    
                }
            }
        });

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        add(btnClose);
        add(addButtonSobNome);
        add(txtSobNome);
        add(lblSobNome);
        add(addButton);
        add(txtNome);
        add(lblNome);
        add(panel);
    }

    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
