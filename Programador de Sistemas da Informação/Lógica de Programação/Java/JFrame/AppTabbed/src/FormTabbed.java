
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel_piske
 */
public class FormTabbed extends javax.swing.JFrame {

    /**
     * Creates new form FormTabbed
     */
    //Iniciando os ArrayList
    public static ArrayList<Cliente> listaCliente;
    public static ArrayList<Produto> listaProduto;
    public static ArrayList<Fornecedor> listaFornecedor;

    // Criação das Tabelas
    public final void tblCliente() {
        DefaultTableModel modeloCli = new DefaultTableModel(new Object[]{
            "Código",
            "Nome",
            "Telefone",
            "Email",
            "Endereço"}, 0);
        for (int i = 0; i < listaCliente.size(); i++) {
            Object linhaCli[] = new Object[]{listaCliente.get(i).getCodigo(),
                listaCliente.get(i).getNome(),
                listaCliente.get(i).getFone(),
                listaCliente.get(i).getEmail(),
                listaCliente.get(i).getEndereco()};
            modeloCli.addRow(linhaCli);
        }
        jTbCli.setModel(modeloCli);
        jTbCli.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbCli.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTbCli.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTbCli.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTbCli.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    public final void tblProduto() {
        DefaultTableModel modeloProd = new DefaultTableModel(new Object[]{
            "Código",
            "Descrição",
            "Unidade",
            "Quantidade",
            "Preço"}, 0);
        for (int i = 0; i < listaProduto.size(); i++) {
            Object linhaCli[] = new Object[]{listaProduto.get(i).getCod(),
                listaProduto.get(i).getDesc(),
                listaProduto.get(i).getUnit(),
                listaProduto.get(i).getQtd(),
                listaProduto.get(i).getPreco()};
            modeloProd.addRow(linhaCli);
        }
        jTbPro.setModel(modeloProd);
        jTbPro.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbPro.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTbPro.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTbPro.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTbPro.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    public final void tblFornecedor() {
        DefaultTableModel modeloForn = new DefaultTableModel(new Object[]{
            "Código",
            "Empresa",
            "Contato",
            "Telefone",
            "Email"}, 0);
        for (int i = 0; i < listaFornecedor.size(); i++) {
            Object linhaCli[] = new Object[]{listaFornecedor.get(i).getCod(),
                listaFornecedor.get(i).getEmpresa(),
                listaFornecedor.get(i).getContato(),
                listaFornecedor.get(i).getFone(),
                listaFornecedor.get(i).getEmail()};
            modeloForn.addRow(linhaCli);
        }
        jTbFor.setModel(modeloForn);
        jTbFor.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbFor.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTbFor.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTbFor.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTbFor.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    // Salvamento dos Dados
    public static void saveCli() {
        String fileCli = "cliente.db";
        String linhaCLi = "";

        for (int i = 0; i < listaCliente.size(); i++) {
            linhaCLi += listaCliente.get(i).getCodigo() + ";"
                    + listaCliente.get(i).getNome() + ";"
                    + listaCliente.get(i).getFone() + ";"
                    + listaCliente.get(i).getEmail() + ";"
                    + listaCliente.get(i).getEndereco() + "\n";
        }

        if (Arquivo.write(fileCli, linhaCLi)) {
            JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }

    public static void saveProd() {
        String fileProd = "produto.db";
        String linhaProd = "";

        for (int i = 0; i < listaProduto.size(); i++) {
            linhaProd += listaProduto.get(i).getCod() + ";"
                    + listaProduto.get(i).getDesc() + ";"
                    + listaProduto.get(i).getUnit() + ";"
                    + listaProduto.get(i).getQtd() + ";"
                    + listaProduto.get(i).getPreco() + "\n";
        }

        if (Arquivo.write(fileProd, linhaProd)) {
            JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }

    public static void saveForn() {
        String fileForn = "fornecedor.db";
        String linhaForn = "";

        for (int i = 0; i < listaFornecedor.size(); i++) {
            linhaForn += listaFornecedor.get(i).getCod() + ";"
                    + listaFornecedor.get(i).getEmpresa() + ";"
                    + listaFornecedor.get(i).getContato() + ";"
                    + listaFornecedor.get(i).getFone() + ";"
                    + listaFornecedor.get(i).getEmail() + "\n";
        }

        if (Arquivo.write(fileForn, linhaForn)) {
            JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }

    // Carregamento dos Dados
    public static void loadCLi() {
        String fileCli = "cliente.db";
        String conteudo = Arquivo.read(fileCli);

        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        } else {
            String[] linhaCli = conteudo.split("\n");
            String[] dadosCli;

            for (int i = 0; i < linhaCli.length; i++) {
                dadosCli = linhaCli[i].split(";");
                Cliente cli = new Cliente();
                cli.setCodigo(Integer.parseInt(dadosCli[0]));
                cli.setNome(dadosCli[1]);
                cli.setFone(dadosCli[2]);
                cli.setEmail(dadosCli[3]);
                cli.setEndereco(dadosCli[4]);
                listaCliente.add(cli);
            }
        }
    }

    public static void loadProd() {
        String fileProd = "produto.db";
        String conteudo = Arquivo.read(fileProd);

        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        } else {
            String[] linhaProd = conteudo.split("\n");
            String[] dadosProd;

            for (int i = 0; i < linhaProd.length; i++) {
                dadosProd = linhaProd[i].split(";");
                Produto prod = new Produto();
                prod.setCod(Integer.parseInt(dadosProd[0]));
                prod.setDesc(dadosProd[1]);
                prod.setUnit(dadosProd[2]);
                prod.setQtd(Float.parseFloat(dadosProd[3]));
                prod.setPreco(Float.parseFloat(dadosProd[4]));
                listaProduto.add(prod);
            }
        }
    }

    public static void loadForn() {
        String fileForn = "fornecedor.db";
        String conteudo = Arquivo.read(fileForn);

        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        } else {
            String[] linhaForn = conteudo.split("\n");
            String[] dadosForn;

            for (int i = 0; i < linhaForn.length; i++) {
                dadosForn = linhaForn[i].split(";");
                Fornecedor forn = new Fornecedor();
                forn.setCod(Integer.parseInt(dadosForn[0]));
                forn.setEmpresa(dadosForn[1]);
                forn.setContato(dadosForn[2]);
                forn.setFone(dadosForn[3]);
                forn.setEmail(dadosForn[4]);
                listaFornecedor.add(forn);
            }
        }
    }

    // Construtor da tela
    public FormTabbed() {
        listaCliente = new ArrayList<>();
        listaProduto = new ArrayList<>();
        listaFornecedor = new ArrayList<>();
        loadCLi();
        loadProd();
        loadForn();
        initComponents();
        tblCliente();
        tblProduto();
        tblFornecedor();

        desativarCamposCli();
        desativarCamposPro();
        desativarCamposFor();
    }

    //Cliente
    public void ativarCamposCli() {
        jTfCodCli.setEnabled(true);
        jTfCodCli.setText("");
        jTfNameCli.setEnabled(true);
        jTfNameCli.setText("");
        jTfPhoneCli.setEnabled(true);
        jTfPhoneCli.setText("");
        jTfMailCli.setEnabled(true);
        jTfMailCli.setText("");
        jTaAddrCli.setEnabled(true);
        jTaAddrCli.setText("");
    }
    public void desativarCamposCli() {
        jTfCodCli.setEnabled(false);
        jTfCodCli.setText("");
        jTfNameCli.setEnabled(false);
        jTfNameCli.setText("");
        jTfPhoneCli.setEnabled(false);
        jTfPhoneCli.setText("");
        jTfMailCli.setEnabled(false);
        jTfMailCli.setText("");
        jTaAddrCli.setEnabled(false);
        jTaAddrCli.setText("");

        btnSaveCli.setEnabled(false);
        btnCnlCli.setEnabled(false);
        btnDltCli.setEnabled(false);
        btnEditCli.setEnabled(false);
    }
    //Produto
    public void ativarCamposProd() {
        jTfCodPro.setEnabled(true);
        jTfCodPro.setText("");
        jTaDescPro.setEnabled(true);
        jTaDescPro.setText("");
        jTfUniPro.setEnabled(true);
        jTfUniPro.setText("");
        jTfQuantPro.setEnabled(true);
        jTfQuantPro.setText("");
        jTfPricePro.setEnabled(true);
        jTfPricePro.setText("");
    }
    public void desativarCamposPro(){
        jTfCodPro.setEnabled(false);
        jTfCodPro.setText("");
        jTaDescPro.setEnabled(false);
        jTaDescPro.setText("");
        jTfUniPro.setEnabled(false);
        jTfUniPro.setText("");
        jTfQuantPro.setEnabled(false);
        jTfQuantPro.setText("");
        jTfPricePro.setEnabled(false);
        jTfPricePro.setText("");
        
        btnSavePro.setEnabled(false);
        btnCnlPro.setEnabled(false);
        btnDltPro.setEnabled(false);
        btnEditPro.setEnabled(false);
    }
    //Fornecedor
    public void ativarCamposFor() {
        jTfCodFor.setEnabled(true);
        jTfCodFor.setText("");
        jTfContFor.setEnabled(true);
        jTfContFor.setText("");
        jTfMailFor.setEnabled(true);
        jTfMailFor.setText("");
        jTfPhoneFor.setEnabled(true);
        jTfPhoneFor.setText("");
        jTaEmpresaFor.setEnabled(true);
        jTaEmpresaFor.setText("");
    }
    public void desativarCamposFor() {
        jTfCodFor.setEnabled(false);
        jTfCodFor.setText("");
        jTfContFor.setEnabled(false);
        jTfContFor.setText("");
        jTfMailFor.setEnabled(false);
        jTfMailFor.setText("");
        jTfPhoneFor.setEnabled(false);
        jTfPhoneFor.setText("");
        jTaEmpresaFor.setEnabled(false);
        jTaEmpresaFor.setText("");

        btnSaveFor.setEnabled(false);
        btnCnlFor.setEnabled(false);
        btnDltFor.setEnabled(false);
        btnEditFor.setEnabled(false);
    }
    
    
    // Verificação dos Campos do Cliente
    public boolean isAnyFilledCli() {
        boolean response = !jTfCodCli.getText().isBlank() || !jTfNameCli.getText().isBlank()
                || !jTfMailCli.getText().isBlank() || !jTfPhoneCli.getText().isBlank()
                || !jTaAddrCli.getText().isBlank();
        return (response);
    }
    // Verificação dos Campos do Produto
    public boolean isAnyFilledPro() {
        boolean response = !jTfCodPro.getText().isBlank() || !jTaDescPro.getText().isBlank()
                || !jTfUniPro.getText().isBlank() || !jTfQuantPro.getText().isBlank()
                || !jTfPricePro.getText().isBlank();
        return (response);
    }
    // Verificação dos Campos do Fornecedor
    public boolean isAnyFilledFor() {
        boolean response = !jTfCodFor.getText().isBlank() || !jTaEmpresaFor.getText().isBlank()
                || !jTfContFor.getText().isBlank() || !jTfMailFor.getText().isBlank()
                || !jTfPhoneFor.getText().isBlank();
        return (response);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelCli = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbCli = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNewCli = new javax.swing.JButton();
        btnEditCli = new javax.swing.JButton();
        btnDltCli = new javax.swing.JButton();
        btnSaveCli = new javax.swing.JButton();
        btnCnlCli = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTfCodCli = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTfNameCli = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTfMailCli = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTfPhoneCli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTaAddrCli = new javax.swing.JTextArea();
        jPanelPro = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbPro = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNewPro = new javax.swing.JButton();
        btnEditPro = new javax.swing.JButton();
        btnDltPro = new javax.swing.JButton();
        btnSavePro = new javax.swing.JButton();
        btnCnlPro = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jTfCodPro = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTfPricePro = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTfUniPro = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTfQuantPro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTaDescPro = new javax.swing.JTextArea();
        jPanelFor = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTbFor = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnNewFor = new javax.swing.JButton();
        btnEditFor = new javax.swing.JButton();
        btnDltFor = new javax.swing.JButton();
        btnSaveFor = new javax.swing.JButton();
        btnCnlFor = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jTfCodFor = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTfContFor = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTfMailFor = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTfPhoneFor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTaEmpresaFor = new javax.swing.JTextArea();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCCPF - SISTEMA DE CADASTRO CLIENTE - PRODUTO - FORNECEDOR");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTbCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "Telefone", "Email"
            }
        ));
        jTbCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbCliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbCli);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNewCli.setText("Novo");
        btnNewCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCliActionPerformed(evt);
            }
        });

        btnEditCli.setText("Editar");
        btnEditCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCliActionPerformed(evt);
            }
        });

        btnDltCli.setText("Excluir");
        btnDltCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDltCliActionPerformed(evt);
            }
        });

        btnSaveCli.setText("Salvar");
        btnSaveCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCliActionPerformed(evt);
            }
        });

        btnCnlCli.setText("Cancelar");
        btnCnlCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCnlCliActionPerformed(evt);
            }
        });

        jLabel20.setText("Código");

        jTfCodCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodCliKeyReleased(evt);
            }
        });

        jLabel21.setText("Nome");

        jTfNameCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfNameCliKeyReleased(evt);
            }
        });

        jLabel22.setText("Email");

        jTfMailCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfMailCliKeyReleased(evt);
            }
        });

        jLabel23.setText("Telefone");

        jTfPhoneCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPhoneCliKeyReleased(evt);
            }
        });

        jLabel1.setText("Endereço");

        jTaAddrCli.setColumns(20);
        jTaAddrCli.setRows(5);
        jTaAddrCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaAddrCliKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTaAddrCli);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfMailCli, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfPhoneCli, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfCodCli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfNameCli, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditCli, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(btnNewCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaveCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCnlCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDltCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewCli)
                    .addComponent(jLabel20)
                    .addComponent(jTfCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTfNameCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditCli)
                    .addComponent(jLabel22)
                    .addComponent(jTfMailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jTfPhoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDltCli)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCnlCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveCli))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanelCliLayout = new javax.swing.GroupLayout(jPanelCli);
        jPanelCli.setLayout(jPanelCliLayout);
        jPanelCliLayout.setHorizontalGroup(
            jPanelCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCliLayout.setVerticalGroup(
            jPanelCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cliente", jPanelCli);

        jTbPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Unidade", "Quantidade", "Preço"
            }
        ));
        jTbPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbProMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTbPro);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNewPro.setText("Novo");
        btnNewPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProActionPerformed(evt);
            }
        });

        btnEditPro.setText("Editar");
        btnEditPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProActionPerformed(evt);
            }
        });

        btnDltPro.setText("Excluir");
        btnDltPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDltProActionPerformed(evt);
            }
        });

        btnSavePro.setText("Salvar");
        btnSavePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProActionPerformed(evt);
            }
        });

        btnCnlPro.setText("Cancelar");
        btnCnlPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCnlProActionPerformed(evt);
            }
        });

        jLabel24.setText("Código");

        jTfCodPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodProKeyReleased(evt);
            }
        });

        jLabel25.setText("Preço");

        jTfPricePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPriceProKeyReleased(evt);
            }
        });

        jLabel26.setText("Unidade");

        jTfUniPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfUniProKeyReleased(evt);
            }
        });

        jLabel27.setText("Quantidade");

        jTfQuantPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfQuantProKeyReleased(evt);
            }
        });

        jLabel2.setText("Descricao");

        jTaDescPro.setColumns(20);
        jTaDescPro.setRows(5);
        jTaDescPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaDescProKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTaDescPro);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfCodPro, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfUniPro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfQuantPro, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                            .addComponent(jTfPricePro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditPro, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(btnNewPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSavePro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCnlPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDltPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewPro)
                    .addComponent(jLabel24)
                    .addComponent(jTfCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTfPricePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditPro)
                    .addComponent(jLabel26)
                    .addComponent(jTfUniPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jTfQuantPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDltPro)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCnlPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSavePro))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanelProLayout = new javax.swing.GroupLayout(jPanelPro);
        jPanelPro.setLayout(jPanelProLayout);
        jPanelProLayout.setHorizontalGroup(
            jPanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelProLayout.setVerticalGroup(
            jPanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Produto", jPanelPro);

        jTbFor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Empresa", "Contato", "Telefone", "Email"
            }
        ));
        jTbFor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbForMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTbFor);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNewFor.setText("Novo");
        btnNewFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewForActionPerformed(evt);
            }
        });

        btnEditFor.setText("Editar");
        btnEditFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditForActionPerformed(evt);
            }
        });

        btnDltFor.setText("Excluir");
        btnDltFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDltForActionPerformed(evt);
            }
        });

        btnSaveFor.setText("Salvar");
        btnSaveFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveForActionPerformed(evt);
            }
        });

        btnCnlFor.setText("Cancelar");
        btnCnlFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCnlForActionPerformed(evt);
            }
        });

        jLabel28.setText("Código");

        jTfCodFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodForKeyReleased(evt);
            }
        });

        jLabel29.setText("Contato");

        jTfContFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfContForKeyReleased(evt);
            }
        });

        jLabel30.setText("Email");

        jTfMailFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfMailForKeyReleased(evt);
            }
        });

        jLabel31.setText("Telefone");

        jTfPhoneFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPhoneForKeyReleased(evt);
            }
        });

        jLabel3.setText("Empresa");

        jTaEmpresaFor.setColumns(20);
        jTaEmpresaFor.setRows(5);
        jTaEmpresaFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaEmpresaForKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jTaEmpresaFor);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfCodFor, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfMailFor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfPhoneFor, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                            .addComponent(jTfContFor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditFor, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(btnNewFor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaveFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCnlFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDltFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewFor)
                    .addComponent(jLabel28)
                    .addComponent(jTfCodFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jTfContFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditFor)
                    .addComponent(jLabel30)
                    .addComponent(jTfMailFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jTfPhoneFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDltFor)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCnlFor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveFor))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanelForLayout = new javax.swing.GroupLayout(jPanelFor);
        jPanelFor.setLayout(jPanelForLayout);
        jPanelForLayout.setHorizontalGroup(
            jPanelForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelForLayout.setVerticalGroup(
            jPanelForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fornecedor", jPanelFor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Cliente
    private void btnSaveCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCliActionPerformed
        int cod = Integer.parseInt(jTfCodCli.getText());
        String nome = jTfNameCli.getText();
        String telefone = jTfPhoneCli.getText();
        String email = jTfMailCli.getText();
        String endereco = jTaAddrCli.getText();
        int a = JOptionPane.showConfirmDialog(null,
                "Deseja realmente salvar?\n\n"
                + "Código: " + cod
                + "\nNome: " + nome
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nEnderço: " + endereco,
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            Cliente cliente = new Cliente(nome, telefone);
            cliente.setEndereco(endereco);
            cliente.setEmail(email);
            cliente.setCodigo(cod);

            listaCliente.add(cliente);
            tblCliente();
            saveCli();

            desativarCamposCli();

            btnCnlCli.setEnabled(false);
            btnNewCli.setEnabled(true);
            btnSaveCli.setEnabled(false);
        }
    }//GEN-LAST:event_btnSaveCliActionPerformed

    private void btnCnlCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCnlCliActionPerformed
        desativarCamposCli();

        btnCnlCli.setEnabled(false);
        btnNewCli.setEnabled(true);
        btnSaveCli.setEnabled(false);
    }//GEN-LAST:event_btnCnlCliActionPerformed

    private void btnDltCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDltCliActionPerformed

    }//GEN-LAST:event_btnDltCliActionPerformed

    private void btnEditCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCliActionPerformed

    }//GEN-LAST:event_btnEditCliActionPerformed

    private void btnNewCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCliActionPerformed
        ativarCamposCli();

        btnCnlCli.setEnabled(true);
        btnNewCli.setEnabled(false);
        btnSaveCli.setEnabled(false);
    }//GEN-LAST:event_btnNewCliActionPerformed

    //Produto
    private void btnSaveProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProActionPerformed
        int cod = Integer.parseInt(jTfCodPro.getText());
        String descricao = jTaDescPro.getText();
        String unidade = jTfUniPro.getText();
        float quantidade = Float.parseFloat(jTfQuantPro.getText());
        float preco = Float.parseFloat(jTfPricePro.getText());
        int a = JOptionPane.showConfirmDialog(null,
                "Deseja realmente salvar?\n\n"
                + "Código: " + cod
                + "\nDescricao: " + descricao
                + "\nUnidade: " + unidade
                + "\nQuantidade: " + quantidade
                + "\nPreço: " + preco,
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            Produto produto = new Produto(cod, descricao, unidade, quantidade, preco);

            listaProduto.add(produto);
            tblProduto();
            saveProd();
            
            desativarCamposPro();
            
            btnCnlPro.setEnabled(false);
            btnNewPro.setEnabled(true);
            btnSavePro.setEnabled(false);
        }
    }//GEN-LAST:event_btnSaveProActionPerformed

    private void btnCnlProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCnlProActionPerformed
        desativarCamposPro();

        btnCnlPro.setEnabled(false);
        btnNewPro.setEnabled(true);
        btnSavePro.setEnabled(false);
    }//GEN-LAST:event_btnCnlProActionPerformed

    private void btnDltProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDltProActionPerformed

    }//GEN-LAST:event_btnDltProActionPerformed

    private void btnEditProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProActionPerformed

    }//GEN-LAST:event_btnEditProActionPerformed

    private void btnNewProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProActionPerformed
        ativarCamposProd();

        btnCnlPro.setEnabled(true);
        btnNewPro.setEnabled(false);
        btnSavePro.setEnabled(false);
    }//GEN-LAST:event_btnNewProActionPerformed

    //Fornecedor
    private void btnSaveForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveForActionPerformed
        int cod = Integer.parseInt(jTfCodFor.getText());
        String empresa = jTaEmpresaFor.getText();
        String contato = jTfContFor.getText();
        String fone = jTfPhoneFor.getText();
        String email = jTfMailFor.getText();
        int a = JOptionPane.showConfirmDialog(null,
                "Deseja realmente salvar?\n\n"
                + "Código: " + cod
                + "\nEmpresa: " + empresa
                + "\nContato: " + contato
                + "\nTelefone: " + fone
                + "\nEmail: " + email,
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            Fornecedor fornecedor = new Fornecedor(cod, empresa, contato, fone, email);

            listaFornecedor.add(fornecedor);
            tblFornecedor();
            saveForn();
            
            desativarCamposFor();
            
            btnCnlFor.setEnabled(false);
            btnNewFor.setEnabled(true);
            btnSaveFor.setEnabled(false);
        }
    }//GEN-LAST:event_btnSaveForActionPerformed

    private void btnCnlForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCnlForActionPerformed
        desativarCamposFor();

        btnCnlFor.setEnabled(false);
        btnNewFor.setEnabled(true);
        btnSaveFor.setEnabled(false);
    }//GEN-LAST:event_btnCnlForActionPerformed

    private void btnDltForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDltForActionPerformed

    }//GEN-LAST:event_btnDltForActionPerformed

    private void btnEditForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditForActionPerformed

    }//GEN-LAST:event_btnEditForActionPerformed

    private void btnNewForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewForActionPerformed
        ativarCamposFor();

        btnCnlFor.setEnabled(true);
        btnNewFor.setEnabled(false);
        btnSaveFor.setEnabled(false);
    }//GEN-LAST:event_btnNewForActionPerformed

    //Eventos do Mouse
    private void jTbForMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbForMouseClicked
        int selectedRow = jTbFor.getSelectedRow();
        if (jTbFor.getSelectedRow() != -1) {

            jTfCodFor.setText(jTbFor.getValueAt(selectedRow, 0).toString());
            jTaEmpresaFor.setText(jTbFor.getValueAt(selectedRow, 1).toString());
            jTfContFor.setText(jTbFor.getValueAt(selectedRow, 2).toString());
            jTfPhoneFor.setText(jTbFor.getValueAt(selectedRow, 3).toString());
            jTfMailFor.setText(jTbFor.getValueAt(selectedRow, 4).toString());
        }
    }//GEN-LAST:event_jTbForMouseClicked

    private void jTbCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbCliMouseClicked
        int selectedRow = jTbCli.getSelectedRow();
        if (jTbCli.getSelectedRow() != -1) {

            jTfCodCli.setText(jTbCli.getValueAt(selectedRow, 0).toString());
            jTfNameCli.setText(jTbCli.getValueAt(selectedRow, 1).toString());
            jTfPhoneCli.setText(jTbCli.getValueAt(selectedRow, 2).toString());
            jTfMailCli.setText(jTbCli.getValueAt(selectedRow, 3).toString());
            jTaAddrCli.setText(jTbCli.getValueAt(selectedRow, 4).toString());
        }
    }//GEN-LAST:event_jTbCliMouseClicked

    private void jTbProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbProMouseClicked
        int selectedRow = jTbPro.getSelectedRow();
        if (jTbPro.getSelectedRow() != -1) {

            jTfCodPro.setText(jTbPro.getValueAt(selectedRow, 0).toString());
            jTaDescPro.setText(jTbPro.getValueAt(selectedRow, 1).toString());
            jTfUniPro.setText(jTbPro.getValueAt(selectedRow, 2).toString());
            jTfQuantPro.setText(jTbPro.getValueAt(selectedRow, 3).toString());
            jTfPricePro.setText(jTbPro.getValueAt(selectedRow, 4).toString());
        }
    }//GEN-LAST:event_jTbProMouseClicked

    // Evento de soltar a tecla do cliente
    private void jTfCodCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCodCliKeyReleased
        btnSaveCli.setEnabled(isAnyFilledCli());
    }//GEN-LAST:event_jTfCodCliKeyReleased

    private void jTfNameCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfNameCliKeyReleased
        btnSaveCli.setEnabled(isAnyFilledCli());
    }//GEN-LAST:event_jTfNameCliKeyReleased

    private void jTfMailCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfMailCliKeyReleased
        btnSaveCli.setEnabled(isAnyFilledCli());
    }//GEN-LAST:event_jTfMailCliKeyReleased

    private void jTfPhoneCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPhoneCliKeyReleased
        btnSaveCli.setEnabled(isAnyFilledCli());
    }//GEN-LAST:event_jTfPhoneCliKeyReleased

    private void jTaAddrCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTaAddrCliKeyReleased
        btnSaveCli.setEnabled(isAnyFilledCli());
    }//GEN-LAST:event_jTaAddrCliKeyReleased
    
    
    // Evento de soltar a tecla do Produto
    private void jTfCodProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCodProKeyReleased
        btnSavePro.setEnabled(isAnyFilledPro());
    }//GEN-LAST:event_jTfCodProKeyReleased

    private void jTfPriceProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPriceProKeyReleased
        btnSavePro.setEnabled(isAnyFilledPro());
    }//GEN-LAST:event_jTfPriceProKeyReleased

    private void jTfUniProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfUniProKeyReleased
        btnSavePro.setEnabled(isAnyFilledPro());
    }//GEN-LAST:event_jTfUniProKeyReleased

    private void jTfQuantProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfQuantProKeyReleased
        btnSavePro.setEnabled(isAnyFilledPro());
    }//GEN-LAST:event_jTfQuantProKeyReleased

    private void jTaDescProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTaDescProKeyReleased
        btnSavePro.setEnabled(isAnyFilledPro());
    }//GEN-LAST:event_jTaDescProKeyReleased
    
    // Evento de soltar a tecla do Fornecedor
    private void jTfCodForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCodForKeyReleased
        btnSaveFor.setEnabled(isAnyFilledFor());
    }//GEN-LAST:event_jTfCodForKeyReleased

    private void jTfContForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfContForKeyReleased
        btnSaveFor.setEnabled(isAnyFilledFor());
    }//GEN-LAST:event_jTfContForKeyReleased

    private void jTfMailForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfMailForKeyReleased
        btnSaveFor.setEnabled(isAnyFilledFor());
    }//GEN-LAST:event_jTfMailForKeyReleased

    private void jTfPhoneForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPhoneForKeyReleased
        btnSaveFor.setEnabled(isAnyFilledFor());
    }//GEN-LAST:event_jTfPhoneForKeyReleased

    private void jTaEmpresaForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTaEmpresaForKeyReleased
        btnSaveFor.setEnabled(isAnyFilledFor());
    }//GEN-LAST:event_jTaEmpresaForKeyReleased

    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTabbed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCnlCli;
    private javax.swing.JButton btnCnlFor;
    private javax.swing.JButton btnCnlPro;
    private javax.swing.JButton btnDltCli;
    private javax.swing.JButton btnDltFor;
    private javax.swing.JButton btnDltPro;
    private javax.swing.JButton btnEditCli;
    private javax.swing.JButton btnEditFor;
    private javax.swing.JButton btnEditPro;
    private javax.swing.JButton btnNewCli;
    private javax.swing.JButton btnNewFor;
    private javax.swing.JButton btnNewPro;
    private javax.swing.JButton btnSaveCli;
    private javax.swing.JButton btnSaveFor;
    private javax.swing.JButton btnSavePro;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCli;
    private javax.swing.JPanel jPanelFor;
    private javax.swing.JPanel jPanelPro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTaAddrCli;
    private javax.swing.JTextArea jTaDescPro;
    private javax.swing.JTextArea jTaEmpresaFor;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTbCli;
    private javax.swing.JTable jTbFor;
    private javax.swing.JTable jTbPro;
    private javax.swing.JTextField jTfCodCli;
    private javax.swing.JTextField jTfCodFor;
    private javax.swing.JTextField jTfCodPro;
    private javax.swing.JTextField jTfContFor;
    private javax.swing.JTextField jTfMailCli;
    private javax.swing.JTextField jTfMailFor;
    private javax.swing.JTextField jTfNameCli;
    private javax.swing.JTextField jTfPhoneCli;
    private javax.swing.JTextField jTfPhoneFor;
    private javax.swing.JTextField jTfPricePro;
    private javax.swing.JTextField jTfQuantPro;
    private javax.swing.JTextField jTfUniPro;
    // End of variables declaration//GEN-END:variables
}
