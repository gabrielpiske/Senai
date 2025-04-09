
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class Login_Desafio_01 {
    public static HashMap<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Desafio de Teste - Versão 01");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(10, 20, 80, 25);
        frame.add(lblUsuario);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 20, 165, 25);
        frame.add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(10, 50, 80, 25);
        frame.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 50, 165, 25);
        frame.add(txtSenha);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(10, 90, 100, 25);
        frame.add(btnLogin);

        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.setBounds(120, 90, 120, 25);
        frame.add(btnCadastro);

        JLabel lblMensagem = new JLabel("");
        lblMensagem.setBounds(10, 130, 300, 25);
        frame.add(lblMensagem);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());
                if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
                    lblMensagem.setText("Login realizado com sucesso!");
                } else {
                    lblMensagem.setText("Usuário ou senha inválidos.");
                }
            }
        });

        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());
                usuarios.put(usuario, senha);
                lblMensagem.setText("Usuário cadastrado.");
            }
        });

        frame.setVisible(true);
    }
}
