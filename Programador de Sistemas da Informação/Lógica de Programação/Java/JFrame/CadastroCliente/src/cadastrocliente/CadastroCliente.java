package cadastrocliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author gabriel_piske
 */
public class CadastroCliente {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
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

        JFrame form = new JFrame();
        form.setSize(500, 400);
        form.setLocationRelativeTo(null);
        form.setTitle("Cadastro Clientes");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);

        //Titulo
        JLabel txtTitulo = new JLabel();
        txtTitulo.setBounds(20, 20, 250, 30);
        txtTitulo.setText("Cadastro de Clientes");
        txtTitulo.setOpaque(true);
        Color corLetra = new Color(210, 105, 30);
        txtTitulo.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        txtTitulo.setForeground(corLetra);

        //Nome
        JLabel txtNome = new JLabel();
        txtNome.setBounds(67, 70, 250, 30);
        txtNome.setText("Nome: ");
        txtNome.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
        //Area de Texto
        JTextField jtfNome = new JTextField();
        jtfNome.setBounds(150, 75, 200, 25);

        //CPF
        JLabel txtCpf = new JLabel();
        txtCpf.setBounds(75, 110, 250, 30);
        txtCpf.setText("CPF: ");
        txtCpf.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
        //Area de Texto
        JTextField jtfCpf = new JTextField();
        jtfCpf.setBounds(150, 114, 200, 25);

        //Email
        JLabel txtEmail = new JLabel();
        txtEmail.setBounds(57, 150, 250, 30);
        txtEmail.setText("Email: ");
        txtEmail.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
        //Area de Texto
        JTextField jtfEmail = new JTextField();
        jtfEmail.setBounds(150, 153, 200, 25);

        //Telefone
        JLabel txtTele = new JLabel();
        txtTele.setBounds(31, 190, 250, 30);
        txtTele.setText("Telefone: ");
        txtTele.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
        //Area de Texto
        JTextField jtfTele = new JTextField();
        jtfTele.setBounds(150, 193, 200, 25);

        //Botão Cadastrar
        JButton btnCad = new JButton("Cadastrar");
        btnCad.setBounds(40, 250, 100, 25);
        btnCad.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão Cadastrar Clicado!");
            }
        });

        //Botão Limpar
        JButton btnClean = new JButton("Limpar");
        btnClean.setBounds(160, 250, 80, 25);
        btnClean.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão Limpar Clicado!");
            }
        });

        //Botão fechar
        JButton btnClose = new JButton("Fechar");
        btnClose.setBounds(260, 250, 75, 25);
        btnClose.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão Fechar Clicado!");
            }
        });

        //Botão busca
        JButton btnBusca = new JButton("Busca");
        btnBusca.setBounds(355, 250, 70, 25);
        btnBusca.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão Busca Clicado!");
            }
        });

        //Botão Alterar
        JButton btnAlt = new JButton("Alterar");
        btnAlt.setBounds(40, 300, 75, 25);
        btnAlt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão Alterar Clicado!");
            }
        });

        //------> Chamando elementos
        //Textos
        form.add(txtTitulo);
        form.add(txtNome);
        form.add(txtCpf);
        form.add(txtEmail);
        form.add(txtTele);

        //Campos de Entrada
        form.add(jtfNome);
        form.add(jtfCpf);
        form.add(jtfEmail);
        form.add(jtfTele);

        //Botões
        form.add(btnCad);
        form.add(btnClean);
        form.add(btnClose);
        form.add(btnBusca);
        form.add(btnAlt);

        form.setVisible(true);
    }

}
