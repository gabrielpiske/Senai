/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemagerenciamento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel_piske
 */
public class SistemaGerenciamento {

    //Variavéis Globais do Sistema
    //Cliente
    public static JTable tblCli = new JTable();
    public static JScrollPane pnlScrlTbCli = new JScrollPane(tblCli);

    //Produto
    public static JTable tblProd = new JTable();
    public static JScrollPane pnlScrlTbProd = new JScrollPane(tblProd);

    //Fornecedor
    public static JTable tblForn = new JTable();
    public static JScrollPane pnlScrlTbForn = new JScrollPane(tblForn);

    //Listas
    public static ArrayList<Cliente> listaCliente = new ArrayList();
    public static ArrayList<Produto> listaProduto = new ArrayList();
    public static ArrayList<Fornecedor> listaFornecedor = new ArrayList();

    //Funções ou Métodos do Sistema
    //Tabela Cliente
    public static void tblCliente() { //Atualiza a JTable de Clientes
        DefaultTableModel modeloCli = new DefaultTableModel(new Object[]{"Matricula", "Nome", "Fone", "Email"}, 0);

        for (int i = 0; i < listaCliente.size(); i++) {
            Object linhaCli[] = new Object[]{listaCliente.get(i).getMat(), listaCliente.get(i).getNome(), listaCliente.get(i).getFone(), listaCliente.get(i).getEmail()};

            modeloCli.addRow(linhaCli);
        }
        tblCli.setModel(modeloCli);

    }

    //Tabela Produto
    public static void tblProduto() { //Atualiza a JTable de Produtos
        DefaultTableModel modeloProd = new DefaultTableModel(new Object[]{"Código", "Descrição", "Unidade", "Quantidade", "Preço"}, 0);

        for (int i = 0; i < listaProduto.size(); i++) {
            Object linhaProd[] = new Object[]{listaProduto.get(i).getCodigo(), listaProduto.get(i).getDescricao(), listaProduto.get(i).getUnidade(), listaProduto.get(i).getQuantidade(), listaProduto.get(i).getPreco()};

            modeloProd.addRow(linhaProd);
        }
        tblProd.setModel(modeloProd);

    }

    //Tabela Fornecedor
    public static void tblFornecedor() { //Atualiza a JTable do Fornecedor
        DefaultTableModel modeloForn = new DefaultTableModel(new Object[]{"Código", "Empresa", "Contato", "Telefone", "Email"}, 0);

        for (int i = 0; i < listaFornecedor.size(); i++) {
            Object linhaForn[] = new Object[]{listaFornecedor.get(i).getCodigo(), listaFornecedor.get(i).getEmpresa(), listaFornecedor.get(i).getContato(), listaFornecedor.get(i).getTelefone(), listaFornecedor.get(i).getEmail()};

            modeloForn.addRow(linhaForn);
        }
        tblForn.setModel(modeloForn);

    }

    ///SALVAR CLIENTE NO ARQUIVO .DB
    public static void saveCli() {
        String fileCli = "cliente.db";
        String linhaCli = "";

        for (int i = 0; i < listaCliente.size(); i++) {
            linhaCli += listaCliente.get(i).getMat() + ";"
                    + listaCliente.get(i).getNome() + ";"
                    + listaCliente.get(i).getFone() + ";"
                    + listaCliente.get(i).getEmail() + "\n";
        }
        if (Arquivo.write(fileCli, linhaCli)) {
            JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }

    ///SALVAR PRODUTO NO ARQUIVO .DB
    public static void saveProd() {
        String fileProd = "produto.db";
        String linhaProd = "";

        for (int i = 0; i < listaProduto.size(); i++) {
            linhaProd += listaProduto.get(i).getCodigo() + ";"
                    + listaProduto.get(i).getDescricao() + ";"
                    + listaProduto.get(i).getUnidade() + ";"
                    + listaProduto.get(i).getQuantidade() + ";"
                    + listaProduto.get(i).getPreco() + "\n";
        }
        if (Arquivo.write(fileProd, linhaProd)) {
            JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }
    ///SALVAR FORNCECEDOR NO ARQUIVO .DB

    public static void saveForn() {
        String fileForn = "fornecedor.db";
        String linhaForn = "";

        for (int i = 0; i < listaFornecedor.size(); i++) {
            linhaForn += listaFornecedor.get(i).getCodigo() + ";"
                    + listaFornecedor.get(i).getContato() + ";"
                    + listaFornecedor.get(i).getEmail() + ";"
                    + listaFornecedor.get(i).getEmpresa() + ";"
                    + listaFornecedor.get(i).getTelefone() + "\n";
        }
        if (Arquivo.write(fileForn, linhaForn)) {
            JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }

    ///Caregamento Cliente
    public static void loadCli() {
        String fileCli = "cliente.db";
        String conteudo = Arquivo.read(fileCli);
        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura do Arquivo.");
        } else {
            String[] linhaCli = conteudo.split("\n");
            String[] dadosCli;
            for (int i = 0; i < linhaCli.length; i++) {
                dadosCli = linhaCli[i].split(";");
                Cliente cli = new Cliente();
                cli.setMat(dadosCli[0]);
                cli.setNome(dadosCli[1]);
                cli.setFone(dadosCli[2]);
                cli.setEmail(dadosCli[3]);
                listaCliente.add(cli);
            }
        }
    }

    ///Caregamento Produto
    public static void loadProd() {
        String fileProd = "produto.db";
        String conteudo = Arquivo.read(fileProd);
        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura do Arquivo.");
        } else {
            String[] linhaProd = conteudo.split("\n");
            String[] dadosProd;
            for (int i = 0; i < linhaProd.length; i++) {
                dadosProd = linhaProd[i].split(";");
                Produto prod = new Produto();
                prod.setCodigo(dadosProd[0]);
                prod.setDescricao(dadosProd[1]);
                prod.setUnidade(dadosProd[2]);
                prod.setQuantidade(Integer.parseInt(dadosProd[3]));
                prod.setPreco(Float.parseFloat(dadosProd[4]));
                listaProduto.add(prod);
            }
        }
    }

    ///Caregamento Fornecedor
    public static void loadForn() {
        String fileForn = "fornecedor.db";
        String conteudo = Arquivo.read(fileForn);
        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura do Arquivo.");
        } else {
            String[] linhaForn = conteudo.split("\n");
            String[] dadosForn;
            for (int i = 0; i < linhaForn.length; i++) {
                dadosForn = linhaForn[i].split(";");
                Fornecedor forn = new Fornecedor();
                forn.setCodigo(dadosForn[0]);
                forn.setEmpresa(dadosForn[1]);
                forn.setContato(dadosForn[2]);
                forn.setTelefone(dadosForn[3]);
                forn.setEmail(dadosForn[4]);
                listaFornecedor.add(forn);
            }
        }
    }

    public static void main(String[] args) {
        FormPrincipal frm = new FormPrincipal();

        frm.setSize(600, 400);

        //Painel com Abas
        JTabbedPane jTbPaneCadastro = new JTabbedPane();
        //jTbPaneCadastro.setSize(545,300);
        //jTbPaneCadastro.setLocation(20,10);
        jTbPaneCadastro.setBounds(20, 10, 545, 300);

        //Painel Aba Cliente
        JPanel pnlCli = new JPanel();
        pnlCli.setLayout(null);

        //Painel Aba Produto
        JPanel pnlProd = new JPanel();
        pnlProd.setLayout(null);

        //Painel Aba Fornecedor
        JPanel pnlForn = new JPanel();
        pnlForn.setLayout(null);

        //Adicionando os painéis ao Painel com abas
        jTbPaneCadastro.add("Cliente", pnlCli);
        jTbPaneCadastro.add("Produto", pnlProd);
        jTbPaneCadastro.add("Fornecedor", pnlForn);

        loadCli();
        tblCliente();

        //Adicionando o painel com Abas no formulario
        frm.add(jTbPaneCadastro);

        //Tabel da Clientes
        //JTable tblCli;
        //vetor com os titulos das colunas da tabela
        /* String[] colTbCli = {"Matricula","Nome", "Telefone", "Email"};
      
      //Vetor com o dados da Tabela
      String [] [] dadosTbCli = {
          {"12345","Ana Silva"           , "47 1111-1111", "anasilva@gmail"},
          {"12345","Paulo Sena"          , "47 2222-2222", "paulo.silva@gmail"},
          {"12567","Carlos Lima"         , "47 3333-3333", "carlos.lima@gmail"},
          {"12098","Paulo Freire"        , "47 4444-4444", "paulo.freire@gmail"},
          {"12274","Helena Catomi"       , "47 5555-5555", "helena.catoni@gmail"},
          {"12196","Diogo Santana"       , "47 6666-6666", "diogo.santana@gmail"},
          {"12968","Glaucia Fernandes"   , "47 7777-7777", "glaucia.fernandes@gmail"},          
          {"12310","João Guilherme"      , "47 8888-8888", "joao.guilherme@gmail"},          
      };
         */
        //Preencha a tabela com os dados e nomes das colunas
        //tblCli = new JTable(dadosTbCli, colTbCli);
        //Adiciona a tabela ao painel de rolagem
        //pnlScrlTbCli = new JScrollPane (tblCli);
        ///Definições Tamanho, localização e adição
        //pnlScrlTbCli.setSize(530,118);
        //pnlScrlTbCli.setLocation(5,5);
        pnlScrlTbCli.setBounds(5, 5, 530, 118);
        pnlCli.add(pnlScrlTbCli);

        //////////////////////////////////////////////////////////////////////////
        //Criar painel de cadrasto Clientes
        JPanel pnlCadCli = new JPanel();
        pnlCadCli.setBounds(5, 130, 530, 135);

        //Coloca borda azul no painel
        Border brdBlue = BorderFactory.createLineBorder(Color.blue);
        pnlCadCli.setBorder(brdBlue);
        pnlCadCli.setLayout(null);
        pnlCli.add(pnlCadCli);

        //////////////////////////////////////////////////////////////////////////
        //Nome
        JLabel jlblNom = new JLabel();
        jlblNom.setBounds(200, 10, 160, 15); //tamanho e localização
        Font arialBold_16 = new Font("Arial", Font.BOLD, 12);
        jlblNom.setFont(arialBold_16);
        jlblNom.setText("Nome: "); //definição texto
        pnlCadCli.add(jlblNom); //inserindo formulario
        //Entrada Nome
        JTextField jtfNomeD = new JTextField();
        //jtfNomeD.setSize(150, 20); //definição de tamanho
        //jtfNomeD.setLocation(200,25); //localização
        jtfNomeD.setBounds(200, 25, 150, 20); //tamanho e localização
        pnlCadCli.add(jtfNomeD); //inserindo formulario

        //Matricula
        JLabel jlblMat = new JLabel();
        //jlblMat.setSize(100, 15); //definição de tamanho
        //jlblMat.setLocation(10,10); //localização
        jlblMat.setBounds(10, 10, 100, 15); //tamanho e localização
        jlblMat.setFont(arialBold_16);
        jlblMat.setText("Matricula: "); //definição texto
        pnlCadCli.add(jlblMat); //inserindo formulario
        //Entrada Nome
        JTextField jtfMatriculaD = new JTextField();
        //jtfMatriculaD.setSize(150, 20); //definição de tamanho
        //jtfMatriculaD.setLocation(10,25); //localização
        jtfMatriculaD.setBounds(10, 25, 150, 20); //tamanho e localização
        pnlCadCli.add(jtfMatriculaD); //inserindo formulario

        //Telefone
        JLabel jlblTel = new JLabel();
        //jlblTel.setSize(160, 15); //definição de tamanho
        //jlblTel.setLocation(10,50); //localização
        jlblTel.setBounds(10, 50, 160, 15); //tamanho e localização
        jlblTel.setFont(arialBold_16);
        jlblTel.setText("Telefone: "); //definição texto
        pnlCadCli.add(jlblTel); //inserindo formulario
        //Entrada Nome
        JTextField jtfTelefoneD = new JTextField();
        //jtfTelefoneD.setSize(150, 20); //definição de tamanho
        //jtfTelefoneD.setLocation(10,65); //localização
        jtfTelefoneD.setBounds(10, 65, 150, 20); //tamanho e localização
        pnlCadCli.add(jtfTelefoneD); //inserindo formulario

        //Email
        JLabel jlblEmail = new JLabel();
        //jlblEmail.setSize(100, 15); //definição de tamanho
        //jlblEmail.setLocation(200,50); //localização
        jlblEmail.setBounds(200, 50, 100, 15); //tamanho e localização
        jlblEmail.setFont(arialBold_16);
        jlblEmail.setText("Email: "); //definição texto
        pnlCadCli.add(jlblEmail); //inserindo formulario
        //Entrada Nome
        JTextField jtfEmailD = new JTextField();
        //jtfEmailD.setSize(145, 20); //definição de tamanho
        //jtfEmailD.setLocation(200,65); //localização
        jtfEmailD.setBounds(200, 65, 145, 20); //tamanho e localização
        pnlCadCli.add(jtfEmailD); //inserindo formulario

        //Apagar
        JButton btnApagar = new JButton(); //criação botão
        //btnApagar.setSize(100, 20); //tamanho
        //btnApagar.setLocation(400,25); //localização
        btnApagar.setBounds(400, 25, 100, 20); //tamanho e localização
        btnApagar.setText("Apagar"); //definição texto
        pnlCadCli.add(btnApagar); //inserindo botão

        //Salvar
        JButton btnSave = new JButton(); //criação botão
        btnSave.setSize(100, 20); //tamanho
        btnSave.setLocation(400, 65); //localização
        btnSave.setBounds(400, 65, 100, 20); //tamanho e localização
        btnSave.setText("Salvar"); //definição texto
        pnlCadCli.add(btnSave); //inserindo botão        

        ///////////////////////////////////////////////////////////////////////////    
        ///Produto
        //Painel com barra de rolagem
        //JScrollPane pnlScrlTbProd;
        //Tabel da Clientes
        // JTable tblProd;
        //vetor com os titulos das colunas da tabela
        //String[] colTbProd = {"Código", "Descrição", "Unidade", "Quantidade", "Preço"};
        //Vetor com o dados da Tabela
        /*String [] [] dadosTbProd = {
          {"0001", "Descrição", "Unidade", "Quantidade", "R$1,10"},          
          {"0002", "Descrição", "Unidade", "Quantidade", "R$1,20"},          
          {"0003", "Descrição", "Unidade", "Quantidade", "R$1,30"},          
          {"0004", "Descrição", "Unidade", "Quantidade", "R$1,40"},          
          {"0005", "Descrição", "Unidade", "Quantidade", "R$1,50"},          
          {"0006", "Descrição", "Unidade", "Quantidade", "R$1,60"},          
          {"0007", "Descrição", "Unidade", "Quantidade", "R$1,70"},          
          {"0008", "Descrição", "Unidade", "Quantidade", "R$1,80"},          
      };
      
      //Preencha a tabela com os dados e nomes das colunas
      tblProd = new JTable(dadosTbProd, colTbProd);
      
      //Adiciona a tabela ao painel de rolagem
      pnlScrlTbProd = new JScrollPane (tblProd);
         */
        ///Definições Tamanho, localização e adição
        //pnlScrlTbProd.setSize(530,118);
        //pnlScrlTbProd.setLocation(5,5);
        pnlScrlTbProd.setBounds(5, 5, 530, 118);
        pnlProd.add(pnlScrlTbProd);

        //////////////////////////////////////////////////////////////////////////
        //Criar painel de cadrasto Produtos
        JPanel pnlCadProd = new JPanel();
        pnlCadProd.setBounds(5, 130, 530, 135);

        //Coloca borda azul no painel
        pnlCadProd.setBorder(brdBlue);
        pnlCadProd.setLayout(null);
        pnlProd.add(pnlCadProd);

        loadProd();
        tblProduto();

        //////////////////////////////////////////////////////////////////////////
        //Código
        JLabel jlblCod = new JLabel();
        jlblCod.setBounds(10, 10, 160, 15); //localização e Size
        jlblCod.setFont(arialBold_16);
        jlblCod.setText("Código: "); //definição texto
        pnlCadProd.add(jlblCod); //inserindo formulario
        //Entrada Codigo
        JTextField jtfCodigoD = new JTextField();
        jtfCodigoD.setBounds(10, 25, 150, 20); //localização e Size
        pnlCadProd.add(jtfCodigoD); //inserindo formulario

        //Descrição
        JLabel jlblDesc = new JLabel();
        jlblDesc.setBounds(10, 50, 160, 15); //localização e Size
        jlblDesc.setFont(arialBold_16);
        jlblDesc.setText("Descrição: "); //definição texto
        pnlCadProd.add(jlblDesc); //inserindo formulario
        //Entrada Nome
        JTextField jtfDescricaoD = new JTextField();
        jtfDescricaoD.setBounds(10, 65, 150, 60); //localização e Size
        pnlCadProd.add(jtfDescricaoD); //inserindo formulario

        //Unidade
        JLabel jlblUni = new JLabel();
        jlblUni.setBounds(200, 90, 160, 15); //localização e Size
        jlblUni.setFont(arialBold_16);
        jlblUni.setText("Unidade: "); //definição texto
        pnlCadProd.add(jlblUni); //inserindo formulario
        //Entrada Nome
        JTextField jtfUnidadeD = new JTextField();
        jtfUnidadeD.setBounds(200, 105, 145, 20); //localização e Size
        pnlCadProd.add(jtfUnidadeD); //inserindo formulario      

        //Quantidade
        JLabel jlblQuant = new JLabel();
        jlblQuant.setBounds(200, 10, 100, 15); //localização e Size
        jlblQuant.setFont(arialBold_16);
        jlblQuant.setText("Quantidade: "); //definição texto
        pnlCadProd.add(jlblQuant); //inserindo formulario
        //Entrada Nome
        JTextField jtfQuantidadeD = new JTextField();
        jtfQuantidadeD.setBounds(200, 25, 145, 20); //localização e Size
        pnlCadProd.add(jtfQuantidadeD); //inserindo formulario

        //Preço
        JLabel jlblPrec = new JLabel();
        jlblPrec.setBounds(200, 50, 100, 15); //localização e Size
        jlblPrec.setFont(arialBold_16);
        jlblPrec.setText("Preço: "); //definição texto
        pnlCadProd.add(jlblPrec); //inserindo formulario
        //Entrada Nome
        JTextField jtfPrecoD = new JTextField();
        jtfPrecoD.setBounds(200, 65, 145, 20); //localização e Size
        pnlCadProd.add(jtfPrecoD); //inserindo formulario

        //Apagar Produto
        JButton btnApagarProd = new JButton(); //criação botão
        btnApagarProd.setBounds(400, 25, 100, 20); //localização e Size
        btnApagarProd.setText("Apagar"); //definição texto
        pnlCadProd.add(btnApagarProd); //inserindo botão

        //Salvar Produto
        JButton btnSaveProd = new JButton(); //criação botão
        btnSaveProd.setBounds(400, 65, 100, 20); //localização e Size
        btnSaveProd.setText("Salvar"); //definição texto
        pnlCadProd.add(btnSaveProd); //inserindo botão        

        /////////////////////////////////////////////////////////////////////////
        ///Fornecedor
        /*         
      //Painel com barra de rolagem
      JScrollPane pnlScrlTbForn;
      
      //Tabel da Clientes
      JTable tblForn;
      
      //vetor com os titulos das colunas da tabela
      String[] colTbForn = {"Código", "Empresa", "Contato", "Telefone", "Email"};
      
      //Vetor com o dados da Tabela
      String [] [] dadosTbForn = {
          {"0001", "Empresa", "Contato", "Telefone", "teste1@gmail.com"},          
          {"0002", "Empresa", "Contato", "Telefone", "teste2@gmail.com"},          
          {"0003", "Empresa", "Contato", "Telefone", "teste3@gmail.com"},          
          {"0004", "Empresa", "Contato", "Telefone", "teste4@gmail.com"},          
          {"0005", "Empresa", "Contato", "Telefone", "teste5@gmail.com"},          
          {"0006", "Empresa", "Contato", "Telefone", "teste6@gmail.com"},          
          {"0007", "Empresa", "Contato", "Telefone", "teste7@gmail.com"},          
          {"0008", "Empresa", "Contato", "Telefone", "teste8@gmail.com"},          
      };
      
      //Preencha a tabela com os dados e nomes das colunas
      tblForn = new JTable(dadosTbForn, colTbForn);
      
      //Adiciona a tabela ao painel de rolagem
      pnlScrlTbForn = new JScrollPane (tblForn);
         */
        ///Definições Tamanho, localização e adição
        //pnlScrlTbForn.setSize(530,118);
        //pnlScrlTbForn.setLocation(5,5);
        pnlScrlTbForn.setBounds(5, 5, 530, 118);
        pnlForn.add(pnlScrlTbForn);

        //////////////////////////////////////////////////////////////////////////
        //Criar painel de cadrasto Produtos
        JPanel pnlCadForn = new JPanel();
        pnlCadForn.setBounds(5, 130, 530, 135);

        //Coloca borda azul no painel
        pnlCadForn.setBorder(brdBlue);
        pnlCadForn.setLayout(null);
        pnlForn.add(pnlCadForn);

        loadForn();
        tblFornecedor();

        //////////////////////////////////////////////////////////////////////////
        //Código
        JLabel jlblCodForn = new JLabel();
        jlblCodForn.setBounds(10, 10, 160, 15); //localização e Size
        jlblCodForn.setFont(arialBold_16);
        jlblCodForn.setText("Código: "); //definição texto
        pnlCadForn.add(jlblCodForn); //inserindo formulario
        //Entrada Codigo
        JTextField jtfCodigoFornD = new JTextField();
        jtfCodigoFornD.setBounds(10, 25, 150, 20); //localização e Size
        pnlCadForn.add(jtfCodigoFornD); //inserindo formulario

        //Empresa
        JLabel jlblEmpre = new JLabel();
        jlblEmpre.setBounds(10, 50, 160, 15); //localização e Size
        jlblEmpre.setFont(arialBold_16);
        jlblEmpre.setText("Empresa: "); //definição texto
        pnlCadForn.add(jlblEmpre); //inserindo formulario
        //Entrada Nome
        JTextField jtfEmpresaD = new JTextField();
        jtfEmpresaD.setBounds(10, 65, 150, 20); //localização e Size
        pnlCadForn.add(jtfEmpresaD); //inserindo formulario

        //Contato
        JLabel jlblCont = new JLabel();
        jlblCont.setBounds(10, 90, 160, 15); //localização e Size
        jlblCont.setFont(arialBold_16);
        jlblCont.setText("Contato: "); //definição texto
        pnlCadForn.add(jlblCont); //inserindo formulario
        //Entrada Nome
        JTextField jtfContatoD = new JTextField();
        jtfContatoD.setBounds(10, 105, 335, 20); //localização e Size
        pnlCadForn.add(jtfContatoD); //inserindo formulario      

        //Telefone
        JLabel jlblTelefone = new JLabel();
        jlblTelefone.setBounds(200, 10, 100, 15); //localização e Size
        jlblTelefone.setFont(arialBold_16);
        jlblTelefone.setText("Telefone: "); //definição texto
        pnlCadForn.add(jlblTelefone); //inserindo formulario
        //Entrada Nome
        JTextField jtfTelefoneFornD = new JTextField();
        jtfTelefoneFornD.setBounds(200, 25, 145, 20); //localização e Size
        pnlCadForn.add(jtfTelefoneFornD); //inserindo formulario

        //Email
        JLabel jlblEmailForn = new JLabel();
        jlblEmailForn.setBounds(200, 50, 100, 15); //localização e Size
        jlblEmailForn.setFont(arialBold_16);
        jlblEmailForn.setText("Email: "); //definição texto
        pnlCadForn.add(jlblEmailForn); //inserindo formulario
        //Entrada Nome
        JTextField jtfEmailFornD = new JTextField();
        jtfEmailFornD.setBounds(200, 65, 145, 20); //localização e Size
        pnlCadForn.add(jtfEmailFornD); //inserindo formulario

        //Apagar Produto
        JButton btnApagarForn = new JButton(); //criação botão
        btnApagarForn.setBounds(400, 25, 100, 20); //localização e Size
        btnApagarForn.setText("Apagar"); //definição texto
        pnlCadForn.add(btnApagarForn); //inserindo botão

        //Salvar Produto
        JButton btnSaveForn = new JButton(); //criação botão
        btnSaveForn.setBounds(400, 65, 100, 20); //localização e Size
        btnSaveForn.setText("Salvar"); //definição texto
        pnlCadForn.add(btnSaveForn); //inserindo botão

        frm.repaint();

        //Ação Botão Salvar Cliente
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Cliente cli = new Cliente();

                cli.setMat(jtfMatriculaD.getText());
                cli.setNome(jtfNomeD.getText());
                cli.setFone(jtfTelefoneD.getText());
                cli.setEmail(jtfEmailD.getText());

                listaCliente.add(cli);

                tblCliente();
                saveCli();
            }
        });
        //Ação Botão Salavar Produto
        btnSaveProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Produto prod = new Produto();

                prod.setCodigo(jtfCodigoD.getText());
                prod.setDescricao(jtfDescricaoD.getText());
                prod.setPreco(Float.parseFloat(jtfPrecoD.getText()));
                prod.setQuantidade(Integer.parseInt(jtfQuantidadeD.getText()));
                prod.setUnidade(jtfUnidadeD.getText());

                listaProduto.add(prod);

                tblProduto();
                saveProd();
            }
        });
        //Ação Botão Salavar Fornecedor
        btnSaveForn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Fornecedor forn = new Fornecedor();

                forn.setCodigo(jtfCodigoFornD.getText());
                forn.setContato(jtfContatoD.getText());
                forn.setEmail(jtfEmailFornD.getText());
                forn.setEmpresa(jtfEmpresaD.getText());
                forn.setTelefone(jtfTelefoneFornD.getText());

                listaFornecedor.add(forn);

                tblFornecedor();
                saveForn();
            }
        });
    }

}
