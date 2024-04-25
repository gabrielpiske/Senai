package telas;

import dao.FornecedorDAO;
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
import java.sql.SQLException;
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
import sigmenu_gabrielpiske.Fornecedor;
import sigmenu_gabrielpiske.Produto;

/**
 *
 * @author gmtci
 */
public class FormFornecedor extends JInternalFrame {

    JTable jTblFor = new JTable();
    JScrollPane scrlTbFor = new JScrollPane(jTblFor);
    public ArrayList<Fornecedor> listaFornecedor;

    Connection conexao = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    FornecedorDAO fornDAO = new FornecedorDAO();

    public FormFornecedor() {
        super();
        this.setSize(800, 500);
        this.setResizable(false);
        this.setTitle("Cadastro de Fornecedores");
        this.setLayout(null);
        initComponentes();
    }

    public void tblFornecedor() {    //Atualiza os dados da tabela Cliente
        DefaultTableModel modeloFor = new DefaultTableModel(new Object[]{
            "Codigo",
            "Nome",
            "Telefone",
            "E-mail",
            "Contato"}, 0);
        for (int i = 0; i < listaFornecedor.size(); i++) {
            Object linhaFor[] = new Object[]{
                listaFornecedor.get(i).getCod(),
                listaFornecedor.get(i).getNome(),
                listaFornecedor.get(i).getTele(),
                listaFornecedor.get(i).getEmail(),
                listaFornecedor.get(i).getContato()};
            modeloFor.addRow(linhaFor);
        }
        jTblFor.setModel(modeloFor);
        jTblFor.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTblFor.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTblFor.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTblFor.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTblFor.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    void loadForn() {
        listaFornecedor.clear();
        try {
            listaFornecedor = fornDAO.listarFornecedor();
            tblFornecedor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FormFornecedor (loadForn): " + e);
        }
    }

//    public void loadForn() {
//        // Preparar Consulta e Apresentar em JOptionPane relação Produtos da base de dados 
//        String sql = "SELECT * FROM produto";
//
//        try {
//            stm = conexao.prepareStatement(sql);
//            rs = stm.executeQuery();
//            String fornecedores = "";
//            while (rs.next()) {
//                String codFornecedor = rs.getString("CodFornecedor");
//                String Cidade_codCidade = rs.getString("Cidade_codCidade");
//                String fornecedor = rs.getString("fornecedor");
//                String endereco = rs.getString("endereco");
//                String num = rs.getString("num");
//                String bairro = rs.getString("bairro");
//                String cep = rs.getString("cep");
//                String contato = rs.getString("contato");
//                String cnpj = rs.getString("cnpj");
//                String insc = rs.getString("insc");
//                String tel = rs.getString("tel");
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
        listaFornecedor = new ArrayList();
        conexao = ModuloConexao.conector();

        JLabel lblCodFor = new JLabel("Código: ");
        lblCodFor.setBounds(10, 35, 50, 25);

        JTextField jtxtCodFor = new JTextField();
        jtxtCodFor.setBounds(10, 60, 100, 25);

        JLabel lblNomFor = new JLabel("Nome: ");
        lblNomFor.setBounds(10, 95, 50, 25);

        JTextField jtxtNomFor = new JTextField();
        jtxtNomFor.setBounds(10, 120, 270, 25);

        JLabel lblTeleFor = new JLabel("Telefone: ");
        lblTeleFor.setBounds(10, 155, 50, 25);

        JTextField jtxtTeleFor = new JTextField();
        jtxtTeleFor.setBounds(10, 180, 270, 25);

        JLabel lblEmaFor = new JLabel("E-mail: ");
        lblEmaFor.setBounds(10, 215, 50, 25);

        JTextField jtxtEmaFor = new JTextField();
        jtxtEmaFor.setBounds(10, 240, 270, 25);

        JLabel lblContFor = new JLabel("Contato: ");
        lblContFor.setBounds(10, 275, 100, 25);

        JTextArea jtxtContFor = new JTextArea();
        jtxtContFor.setBounds(10, 300, 270, 100);
        Border gray = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        jtxtContFor.setBorder(gray);

        scrlTbFor.setBounds(300, 60, 460, 340);
        scrlTbFor.setBorder(gray);

        loadForn();

        JButton btnNewFor = new JButton("Novo");
        btnNewFor.setBounds(20, 420, 130, 30);
        this.add(btnNewFor);

        JButton btnEdtFor = new JButton("Editar");
        btnEdtFor.setBounds(170, 420, 130, 30);
        this.add(btnEdtFor);

        JButton btnDelFor = new JButton("Excluir");
        btnDelFor.setBounds(320, 420, 130, 30);
        this.add(btnDelFor);

        JButton btnEscFor = new JButton("Cancelar");
        btnEscFor.setBounds(470, 420, 130, 30);
        this.add(btnEscFor);

        JButton btnSavFor = new JButton("Salvar");
        btnSavFor.setBounds(620, 420, 130, 30);
        this.add(btnSavFor);

        add(jtxtCodFor);
        add(lblCodFor);
        add(lblNomFor);
        add(jtxtNomFor);
        add(lblTeleFor);
        add(jtxtTeleFor);
        add(lblEmaFor);
        add(jtxtEmaFor);
        add(lblContFor);
        add(jtxtContFor);
        add(scrlTbFor);

        repaint();

        //Salvar Dados no Banco de Dados
        btnSavFor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Gravando....");
                Fornecedor forn = new Fornecedor();

                forn.setNome(jtxtNomFor.getText());
                forn.setContato(jtxtContFor.getText());
                forn.setEmail(jtxtEmaFor.getText());
                forn.setTele(jtxtTeleFor.getText());

                if (fornDAO.salvarFornecedor(forn) == 1) {
                    JOptionPane.showMessageDialog(null, "Fornecedor gravado com Sucesso!");
                }
            }

        });

        //Editar Cliente
        btnEdtFor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Fornecedor forn = new Fornecedor();

                forn.setCod(jtxtCodFor.getText());
                forn.setContato(jtxtContFor.getText());
                forn.setEmail(jtxtEmaFor.getText());
                forn.setNome(jtxtNomFor.getText());
                forn.setTele(jtxtTeleFor.getText());

                fornDAO.alterarFornecedor(forn);
                loadForn();
            }
        });
        jTblFor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int index = jTblFor.getSelectedRow();
                if (index >= 0 && index < listaFornecedor.size()) {
                    Fornecedor forn = listaFornecedor.get(index);
                    jtxtCodFor.setText(forn.getCod());
                    jtxtContFor.setText(forn.getContato());
                    jtxtEmaFor.setText(forn.getEmail());
                    jtxtNomFor.setText(forn.getNome());
                    jtxtTeleFor.setText(forn.getTele());
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
        btnDelFor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int codForn;

                codForn = Integer.parseInt(jtxtCodFor.getText());

                fornDAO.excluirFornecedor(codForn);
                loadForn();
            }
        });

//        //Ação Botão Salavar Fornecedor
//        btnNewFor.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                Fornecedor forn = new Fornecedor();
//
//                forn.setCod(jtxtCodFor.getText());
//                forn.setNome(jtxtNomFor.getText());
//                forn.setTele(jtxtTeleFor.getText());
//                forn.setEmail(jtxtEmaFor.getText());
//                forn.setContato(jtxtContFor.getText());
//
//                listaFornecedor.add(forn);
//
//                tblFornecedor();
//            }
//        });
    }

}
