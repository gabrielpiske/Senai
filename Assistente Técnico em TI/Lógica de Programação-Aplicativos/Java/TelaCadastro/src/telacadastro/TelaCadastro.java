package telacadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class TelaCadastro {


    public static void main(String[] args) {
        JFrame form = new JFrame(); //criação frame
        form.setSize(800, 450); //definição tamanho
        form.setLocation(450, 200); //localização de nascimento
        form.setTitle("Cadastro de Clientes"); //definição do nome da janela
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //mensagem de encerramento do formulario
        form.setLayout(null);
        
        ///Titulo
        JLabel jlblTit = new JLabel();
        jlblTit.setSize(150, 15); //definição de tamanho
        jlblTit.setLocation(135,10); //localização
        Font arialBold_16 = new Font("Arial", Font.BOLD, 16);
        jlblTit.setFont(arialBold_16);
       
        jlblTit.setOpaque (true);
        jlblTit.setForeground(Color.white);
        jlblTit.setBackground(Color.GRAY);
        
        jlblTit.setText("Cadrasto de Cliente"); //definição texto
        form.add(jlblTit); //inserindo formulario
        
        //Entrada de Codigo
        JLabel jlblCodigo = new JLabel();
        jlblCodigo.setSize(45, 30); //definição de tamanho
        jlblCodigo.setLocation(10,50); //localização
        jlblCodigo.setText("Código: "); //definição texto
        form.add(jlblCodigo); //inserindo formulario
        //Entrada de Dados
        JTextField jtfCodigoD = new JTextField();
        jtfCodigoD.setSize(100, 20); //definição de tamanho
        jtfCodigoD.setLocation(120,50); //localização
        form.add(jtfCodigoD); //inserindo formulario
        
        
        //Entrada de Nome
        JLabel jlblNome = new JLabel();
        jlblNome.setSize(45, 20); //definição de tamanho
        jlblNome.setLocation(10,95); //localização
        jlblNome.setText("Nome: "); //definição texto
        form.add(jlblNome); //inserindo formulario
        //Entrada de Dados
        JTextField jtfNomeD = new JTextField();
        jtfNomeD.setSize(250, 20); //definição de tamanho
        jtfNomeD.setLocation(120,95); //localização
        form.add(jtfNomeD); //inserindo formulario
        
        
        //Entrada de Estado
        JLabel jlblUF = new JLabel();
        jlblUF.setSize(50, 20); //definição de tamanho
        jlblUF.setLocation(10,135); //localização
        jlblUF.setText("Estado: "); //definição texto
        form.add(jlblUF); //inserindo formulario
        //Entrada de Dados
        JTextField jtfUFD = new JTextField();
        jtfUFD.setSize(150, 20); //definição de tamanho
        jtfUFD.setLocation(120,135); //localização
        form.add(jtfUFD); //inserindo formulario
        
        
        //Entrada de Cidade
        JLabel jlblCity = new JLabel();
        jlblCity.setSize(50, 20); //definição de tamanho
        jlblCity.setLocation(10,190); //localização
        jlblCity.setText("Cidade: "); //definição texto
        form.add(jlblCity); //inserindo formulario
        //Entrada de Dados
        JTextField jtfcityD = new JTextField();
        jtfcityD.setSize(250, 20); //definição de tamanho
        jtfcityD.setLocation(120,190); //localização
        form.add(jtfcityD); //inserindo formulario
        
        
        //Entrada de Bairro
        JLabel jlblBairro = new JLabel();
        jlblBairro.setSize(50, 20); //definição de tamanho
        jlblBairro.setLocation(10,240); //localização
        jlblBairro.setText("Bairro: "); //definição texto
        form.add(jlblBairro); //inserindo formulario
        //Entrada de Dados
        JTextField jtfBairroD = new JTextField();
        jtfBairroD.setSize(250, 20); //definição de tamanho
        jtfBairroD.setLocation(120,240); //localização
        form.add(jtfBairroD); //inserindo formulario        
        
        
        //Entrada de Lougradouro
        JLabel jlblLougra = new JLabel();
        jlblLougra.setSize(80, 20); //definição de tamanho
        jlblLougra.setLocation(10,290); //localização
        jlblLougra.setText("Lougradouro: "); //definição texto
        form.add(jlblLougra); //inserindo formulario
        //Entrada de Dados
        JTextField jtfLougraD = new JTextField();
        jtfLougraD.setSize(250, 20); //definição de tamanho
        jtfLougraD.setLocation(120,290); //localização
        form.add(jtfLougraD); //inserindo formulario          
        
        
        //Entrada de Complemento
        JLabel jlblComp = new JLabel();
        jlblComp.setSize(100, 20); //definição de tamanho
        jlblComp.setLocation(10,340); //localização
        jlblComp.setText("Complemento: "); //definição texto
        form.add(jlblComp); //inserindo formulario
        //Entrada de Dados
        JTextField jtfCompD = new JTextField();
        jtfCompD.setSize(150, 20); //definição de tamanho
        jtfCompD.setLocation(120,340); //localização
        form.add(jtfCompD); //inserindo formulario
        
        
        //Painelson
        JPanel jpnlPainel = new JPanel();
        jpnlPainel.setSize(370, 380); //definição de tamanho
        jpnlPainel.setLocation(400,10); //localização
        Border black = BorderFactory.createLineBorder(Color.black);
        jpnlPainel.setBorder(black);
        form.add(jpnlPainel);
        jpnlPainel.setLayout(null);
        
        //ComboBox
        JComboBox jcbBox = new JComboBox();
        jcbBox.addItem("SENAI");
        jcbBox.addItem("SESI");
        jcbBox.addItem("FIESC");
        jcbBox.setLocation(10,100);
        jcbBox.setSize(90, 20);
        jpnlPainel.add(jcbBox);
        
        //CheckBox
        JCheckBox jckApren = new JCheckBox("Curso de Aprendizagem");
        jckApren.setLocation(10,190);
        jckApren.setSize(200, 20);
        JCheckBox jckTech = new JCheckBox("Curso Técnico Industrial");
        jckTech.setLocation(10,220);
        jckTech.setSize(200, 20);
        JCheckBox jckKuali = new JCheckBox("Curso de Qualificação");
        jckKuali.setLocation(10,250);
        jckKuali.setSize(200, 20);
        jpnlPainel.add(jckApren);
        jpnlPainel.add(jckTech);
        jpnlPainel.add(jckKuali);
        
        
        ///Botões
        
        //Consultar
        JButton btncon = new JButton(); //criação botão
        btncon.setSize(90, 20); //tamanho
        btncon.setLocation(280,50); //localização
        btncon.setText("Consultar"); //definição texto
        form.add(btncon); //inserindo botão
        
        //Novo
        JButton btnNV = new JButton(); //criação botão
        btnNV.setSize(70, 20); //tamanho
        btnNV.setLocation(140,370); //localização
        btnNV.setText("Novo"); //definição texto
        form.add(btnNV); //inserindo botão
        
        //Apagar
        JButton btnApagar = new JButton(); //criação botão
        btnApagar.setSize(75, 20); //tamanho
        btnApagar.setLocation(300,370); //localização
        btnApagar.setText("Apagar"); //definição texto
        form.add(btnApagar); //inserindo botão
        
        //Salvar
        JButton btnSave = new JButton(); //criação botão
        btnSave.setSize(70, 20); //tamanho
        btnSave.setLocation(220,370); //localização
        btnSave.setText("Salvar"); //definição texto
        form.add(btnSave); //inserindo botão
        
        String arq_nome = "E:\\Assistente técnico em TI\\Lógica de Programação-Aplicativos\\Java\\TelaCadastro\\src\\telacadastro\\cad.db";
        String dadosForm = "Código: "+jtfCodigoD.getText() + 
                           "\nNome: "+jtfNomeD.getText() +
                           "\nEstado: "+jtfUFD +
                           "\nCidade: "+jtfcityD +
                           "\nBairro: "+jtfBairroD +
                           "\nLogradouro: "+jtfLougraD +
                           "\nComplemento: "+jtfCompD;
        
        //Ação
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.println("Botão Pressionado");
                
                    String arq_nome = "E:\\Assistente técnico em TI\\Lógica de Programação-Aplicativos\\Java\\TelaCadastro\\src\\telacadastro\\cad.db";
                    String dadosForm = "Código: "+jtfCodigoD.getText() + 
                           "\nNome: "+jtfNomeD.getText() +
                           "\nEstado: "+jtfUFD.getText()+ 
                           "\nCidade: "+jtfcityD.getText() +
                           "\nBairro: "+jtfBairroD.getText() +
                           "\nLogradouro: "+jtfLougraD.getText() +
                           "\nComplemento: "+jtfCompD.getText();
                    
                    if(Arquivo.write(arq_nome, dadosForm)){
                        JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso");
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro na Gravação");
                    }
            }
        });
        
        
        btncon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   Arquivo arq = new Arquivo();
              //  String arq_nome = "E:\\Assistente técnico em TI\\Lógica de Programação-Aplicativos\\Java\\TelaCadastro\\src\\telacadastro\\cad.db";
                
              //  String arq_conteudo = Arquivo.read(arq_nome);
                
              //  if(arq_conteudo.isEmpty()){
                    System.out.println("Erro na Leitura do Arquivo");
              //  }
               // else{
                    JOptionPane.showMessageDialog(null,Arquivo.read("E:\\Assistente técnico em TI\\Lógica de Programação-Aplicativos\\Java\\TelaCadastro\\src\\telacadastro\\cad.db"));
                    
               // }                
                 
            }
        });
        form.setVisible(true);
    }
    
}
