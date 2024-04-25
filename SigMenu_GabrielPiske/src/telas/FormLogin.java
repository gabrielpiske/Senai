/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import dao.ModuloConexao;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.sql.*;

/**
 *
 * @author gmtci
 */
public class FormLogin extends JFrame {

    Connection conexao = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public JTextField txtUser;
    public JTextField txtPass;

    public void logar() {
        String sql = "select * from tbuser where nmuser = ? and password = ?";
//        String sql = "select * from tbuser";

        //System.out.println(sql);
        try {
            stm = conexao.prepareStatement(sql);
            stm.setString(1, this.txtUser.getText());
            stm.setString(2, this.txtPass.getText());

            //System.out.println(stm.toString());
            rs = stm.executeQuery();
//            while (rs.next()) {
//                String idUser = rs.getString("idtbuser");
//                String nmUser = rs.getString("nmuser");
//                String password = rs.getString("password");
//                String priv = rs.getString("priv");
//                String tipo = rs.getString("tipo");
//
//                System.out.println(idUser + " - " + nmUser + " - " + password + " - " + priv + " - " + tipo+"\n");
//
//            }
            if  (rs.next()){
                FormMain fmain = new FormMain();
                fmain.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou Senha inválidos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro form Login: " + e);
        }
    }

    public FormLogin() {
        super("Login");
        setSize(400, 300);
        //setLocationRelativeTo(this);
        //setUndecorated(true);
        //setLayout(null);
        //setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InitComponents();
    }

    private void InitComponents() {
        PaneImgFundo painel = new PaneImgFundo("back.jpg");
        conexao = ModuloConexao.conector();
        if (conexao != null) {
            //JOptionPane.showMessageDialog(null, "Conectado ao Banco com sucesso");

            JLabel lblStatusDB = new JLabel();
            lblStatusDB.setBounds(10, 10, 40, 40);
            lblStatusDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/dbok.png")));
            painel.add(lblStatusDB);
        } else {
            JLabel lblStatusDB = new JLabel();
            lblStatusDB.setBounds(10, 10, 40, 40);
            lblStatusDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/dberror.png")));
            painel.add(lblStatusDB);
        }

        setBounds(0, 0, 400, 300);
        add(painel);

        JButton jbtnLogin = new JButton("Logar");
        jbtnLogin.setBounds(240, 200, 100, 25);
        painel.add(jbtnLogin);

        //Usuario
        JPanel usuarioPanel = new JPanel();
        usuarioPanel.setBounds(100, 80, 190, 27);
        usuarioPanel.setOpaque(true);
        usuarioPanel.setBackground(Color.GRAY);
        usuarioPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinhamento à esquerda
        painel.add(usuarioPanel);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        usuarioPanel.setBorder(border);
        usuarioPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinhamento ao centro
        painel.add(usuarioPanel);

        JLabel lblUsuario = new JLabel("Usuario: ");
        usuarioPanel.add(lblUsuario);

        txtUser = new JTextField(15); // Defina um tamanho preferido para o campo de texto
        txtUser.setBorder(new LineBorder(Color.GRAY));
        usuarioPanel.add(txtUser);

        //Senha
        JPanel senhaPanel = new JPanel();
        senhaPanel.setBounds(100, 140, 190, 27);
        senhaPanel.setOpaque(true);
        senhaPanel.setBackground(Color.GRAY);
        senhaPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinhamento à esquerda
        painel.add(senhaPanel);

        Border borderSenha = BorderFactory.createLineBorder(Color.BLACK);
        senhaPanel.setBorder(border);
        senhaPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinhamento ao centro
        painel.add(senhaPanel);

        JLabel lblSenha = new JLabel("Senha: ");
        senhaPanel.add(lblSenha);

        txtPass = new JTextField(15); // Defina um tamanho preferido para o campo de texto
        txtPass.setBorder(new LineBorder(Color.GRAY));
        senhaPanel.add(txtPass);

/////////////////////////////////////////////////////////////////////////////////////////
//        username = "admin";
//        password = "abc@123";
        jbtnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //JOptionPane.showMessageDialog(null, "Fechar");
//                setVisible(false);
                // JOptionPane.showMessageDialog(null, txtUser.getText() + "  " + txtPass.getText());
                logar();
            }

        });
    }
}
