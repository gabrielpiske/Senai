package telas;

import dao.ModuloConexao;
import dao.ProdutoDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import sigmenu_gabrielpiske.Cliente;
import sigmenu_gabrielpiske.Produto;
import java.sql.*;

/**
 *
 * @author gmtci
 */
public class FormProduto extends JInternalFrame {

    JTable jTblPro = new JTable();
    JScrollPane scrlTbPro = new JScrollPane(jTblPro);
    public ArrayList<Produto> listaProduto;

    Connection conexao = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    ProdutoDAO prodDAO = new ProdutoDAO();

    public FormProduto() {
        super();
        this.setSize(800, 500);
        this.setResizable(false);
        this.setTitle("Cadastro de Produtos");
        this.setLayout(null);
        initComponentes();
    }

    public void tblProduto() {    //Atualiza os dados da tabela Cliente
        DefaultTableModel modeloPro = new DefaultTableModel(new Object[]{
            "Codigo",
            "Descricao",
            "Unidade",
            "Quantidade",
            "preço"}, 0);
        for (int i = 0; i < listaProduto.size(); i++) {
            Object linhaPro[] = new Object[]{
                listaProduto.get(i).getCod(),
                listaProduto.get(i).getDesc(),
                listaProduto.get(i).getQuanti(),
                listaProduto.get(i).getUni(),
                listaProduto.get(i).getValor()};
            modeloPro.addRow(linhaPro);
        }
        jTblPro.setModel(modeloPro);
        jTblPro.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTblPro.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTblPro.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTblPro.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTblPro.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    void loadProd() {
        listaProduto.clear();
        try {
            listaProduto = prodDAO.listarProduto();
            tblProduto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FormProduto (loadProd): " + e);
        }
    }

//    public void loadProd() {
//        //Preparar Consulta e Apresentar em JOptionPane relação Produtos da base de dados
//        String sql = "SELECT * FROM produto";
//
//        try {
//            stm = conexao.prepareStatement(sql);
//            rs = stm.executeQuery();
//            String produtos = "";
//            while (rs.next()) {
//                String codProduto = rs.getString("CodProduto");
//                String Categoria_codCategoria = rs.getString("Categoria_codCategoria");
//                String Fornecedor_codFornecedor = rs.getString("Fornecedor_codFornecedor");
//                String descricao = rs.getString("descricao");
//                String peso = rs.getString("peso");
//                String quantidade = rs.getString("endereco");
//                String qtdemin = rs.getString("qtdemin");
//                String linhaProd = "" + codProduto + " - " + Categoria_codCategoria + " - " + Fornecedor_codFornecedor + " - " + descricao + " - " + peso + " - " + quantidade + " - " + qtdemin + "\n";
//                produtos += linhaProd;
//
//                System.out.println();
//            }
//            JOptionPane.showMessageDialog(null, produtos);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
    private void initComponentes() {
        conexao = ModuloConexao.conector();
        listaProduto = new ArrayList();

        JLabel lblCodPro = new JLabel("Código: ");
        lblCodPro.setBounds(10, 35, 50, 25);

        JTextField jtxtCodPro = new JTextField();
        jtxtCodPro.setBounds(10, 60, 100, 25);

        JLabel lblPrecPro = new JLabel("Preço: ");
        lblPrecPro.setBounds(10, 95, 50, 25);

        JTextField jtxtPrecPro = new JTextField();
        jtxtPrecPro.setBounds(10, 120, 270, 25);

        JLabel lblUniPro = new JLabel("Unidade: ");
        lblUniPro.setBounds(10, 155, 50, 25);

        JTextField jtxtUniPro = new JTextField();
        jtxtUniPro.setBounds(10, 180, 270, 25);

        JLabel lblQuaPro = new JLabel("Quantidade: ");
        lblQuaPro.setBounds(10, 215, 50, 25);

        JTextField jtxtQuaPro = new JTextField();
        jtxtQuaPro.setBounds(10, 240, 270, 25);

        JLabel lblDescPro = new JLabel("Descrição: ");
        lblDescPro.setBounds(10, 275, 100, 25);

        JTextArea jtxtDescPro = new JTextArea();
        jtxtDescPro.setBounds(10, 300, 270, 100);
        Border gray = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        jtxtDescPro.setBorder(gray);

        scrlTbPro.setBounds(300, 60, 460, 340);
        scrlTbPro.setBorder(gray);

        loadProd();

        JButton btnNewPro = new JButton("Novo");
        btnNewPro.setBounds(20, 420, 130, 30);
        this.add(btnNewPro);

        JButton btnEdtPro = new JButton("Editar");
        btnEdtPro.setBounds(170, 420, 130, 30);
        this.add(btnEdtPro);

        JButton btnDelPro = new JButton("Excluir");
        btnDelPro.setBounds(320, 420, 130, 30);
        this.add(btnDelPro);

        JButton btnEscPro = new JButton("Cancelar");
        btnEscPro.setBounds(470, 420, 130, 30);
        this.add(btnEscPro);

        JButton btnSavPro = new JButton("Salvar");
        btnSavPro.setBounds(620, 420, 130, 30);
        this.add(btnSavPro);

        add(jtxtCodPro);
        add(lblCodPro);
        add(lblDescPro);
        add(jtxtDescPro);
        add(lblUniPro);
        add(jtxtUniPro);
        add(lblQuaPro);
        add(jtxtQuaPro);
        add(lblPrecPro);
        add(jtxtPrecPro);
        add(scrlTbPro);

        repaint();

        //Salvar Dados no Banco de Dados
        btnSavPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Gravando....");
                Produto prod = new Produto();

                prod.setDesc(jtxtDescPro.getText());
                prod.setQuanti(Integer.parseInt(jtxtQuaPro.getText()));
                prod.setUni(jtxtUniPro.getText());
                prod.setValor(Float.parseFloat(jtxtDescPro.getText()));

                if (prodDAO.salvarProduto(prod) == 1) {
                    JOptionPane.showMessageDialog(null, "Produto gravado com Sucesso!");
                }
            }
        });

        //Editar Produto
        btnEdtPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Produto prod = new Produto();

                prod.setCod((Integer.parseInt(jtxtCodPro.getText())));
                prod.setDesc(jtxtDescPro.getText());
                prod.setQuanti((Integer.parseInt(jtxtQuaPro.getText())));
                prod.setUni(jtxtUniPro.getText());
                prod.setValor(Float.parseFloat(jtxtPrecPro.getText()));

                prodDAO.alterarProduto(prod);
                loadProd();
            }
        });
        jTblPro.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int index = jTblPro.getSelectedRow();
                if (index >= 0 && index < listaProduto.size()) {
                    Produto prod = listaProduto.get(index);
                    jtxtCodPro.setText(String.valueOf(prod.getCod()));
                    jtxtDescPro.setText(prod.getDesc());
                    jtxtQuaPro.setText(String.valueOf(prod.getQuanti()));
                    jtxtUniPro.setText(prod.getUni());
                    jtxtPrecPro.setText(String.valueOf(prod.getValor()));
                }
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });

        //Deletar Cliente
        btnDelPro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int codPro;

                codPro = Integer.parseInt(jtxtCodPro.getText());

                prodDAO.excluirProduto(codPro);
                loadProd();
            }
        });

        //Ação Botão Salavar Produto
//        btnNewPro.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                Produto prod = new Produto();
//
//                prod.setCod(jtxtCodPro.getText());
//                prod.setUni(jtxtUniPro.getText());
//                prod.setValor(Float.parseFloat(jtxtDescPro.getText()));
//                prod.setQuanti(Integer.parseInt(jtxtQuaPro.getText()));
//                prod.setDesc(jtxtDescPro.getText());
//
//                listaProduto.add(prod);
//
//                tblProduto();
//            }
//        });
    }

}
