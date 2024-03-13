/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.Color;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import sigversaomenu.*;

/**
 *
 * @author gmtci
 */
public class FormCliente extends JInternalFrame {
    
    JTable jTblCli = new JTable();
    JScrollPane scrlTbCli = new JScrollPane(jTblCli);
    public ArrayList<Cliente> listaCliente;
    
    
    public FormCliente() {
        super();
        this.setSize(800, 500);
        this.setResizable(false);
        this.setTitle("Cadastro de Clientes");
        this.setLayout(null);

        initComponentes();
    }
    public void tblCliente() {    //Atualiza os dados da tabela Cliente
        DefaultTableModel modeloCli = new DefaultTableModel(new Object[]{
            "Matricula",
            "Nome",
            "Telefone",
            "E-mail",
            "Endereço"}, 0);
        for (int i = 0; i < listaCliente.size(); i++) {
            Object linhaCli[] = new Object[]{
                listaCliente.get(i).getMat(),
                listaCliente.get(i).getNome(),
                listaCliente.get(i).getTele(),
                listaCliente.get(i).getEmail(),
                listaCliente.get(i).getEnde()};
            modeloCli.addRow(linhaCli);
        }
        jTblCli.setModel(modeloCli);
        jTblCli.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTblCli.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTblCli.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTblCli.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTblCli.getColumnModel().getColumn(4).setPreferredWidth(80);
    }
    private void initComponentes() {

        
        
        listaCliente = new ArrayList();

        JLabel lblCodCli = new JLabel("Matrícula: ");
        lblCodCli.setBounds(10, 35, 50, 25);
        
        JTextField jtxtCodCli = new JTextField();
        jtxtCodCli.setBounds(10, 60, 100, 25);
        
        JLabel lblNomCli = new JLabel("Nome: ");
        lblNomCli.setBounds(10, 95, 50, 25);
        
        JTextField jtxtNomCli = new JTextField();
        jtxtNomCli.setBounds(10, 120, 270, 25);
        
        JLabel lblFonCli = new JLabel("Fone: ");
        lblFonCli.setBounds(10, 155, 50, 25);
        
        JTextField jtxtFonCli = new JTextField();
        jtxtFonCli.setBounds(10, 180, 270, 25);
        
        JLabel lblMailCli = new JLabel("Email: ");
        lblMailCli.setBounds(10, 215, 50, 25);
        
        JTextField jtxtMailCli = new JTextField();
        jtxtMailCli.setBounds(10, 240, 270, 25);
        
        JLabel lblEndeCli = new JLabel("Endereço: ");
        lblEndeCli.setBounds(10, 275, 100, 25);
        
        JTextArea jtxtEndeCli = new JTextArea();
        jtxtEndeCli.setBounds(10, 300, 270, 100);
        Border gray = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        jtxtEndeCli.setBorder(gray);
        
        
        scrlTbCli.setBounds(300, 60, 460, 340);
        scrlTbCli.setBorder(gray);
        
        
        tblCliente();
        
   
        
        JButton btnNewCli = new JButton("Salvar");
        btnNewCli.setBounds(20,420, 130,30);
        this.add(btnNewCli);
        
        JButton btnEdtCli = new JButton("Editar");
        btnEdtCli.setBounds(170,420, 130,30);
        this.add(btnEdtCli);
        
        JButton btnDelCli = new JButton("Excluir");
        btnDelCli.setBounds(320,420, 130,30);
        this.add(btnDelCli);
        
        JButton btnEscCli = new JButton("Cancelar");
        btnEscCli.setBounds(470,420, 130,30);
        this.add(btnEscCli);
        
        JButton btnSavCli = new JButton("Salvar");
        btnSavCli.setBounds(620,420, 130,30);
        this.add(btnSavCli);
        
        
        
        
        
        
        add(jtxtCodCli);
        add(lblCodCli);
        add(lblNomCli);
        add(jtxtNomCli);
        add(lblFonCli);
        add(jtxtFonCli);
        add(lblMailCli);
        add(jtxtMailCli);
        add(lblEndeCli);
        add(jtxtEndeCli);
        add(scrlTbCli);
        
        repaint();

    }

}
