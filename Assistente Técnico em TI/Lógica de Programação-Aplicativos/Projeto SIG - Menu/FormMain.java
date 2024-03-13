/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author gmtci
 */
public class FormMain extends JFrame {
    public static int x, y;
    public FormMain() {
        super();
        setBounds(100, 100, 900, 700);
        setTitle("Sistema Inteligente de Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setLayout(null);
        
        initComponentes();
    }

    private void initComponentes() {

        FormCliente frmCliente = new FormCliente();
        FormProduto frmProduto = new FormProduto();
        //FormLogin frmLogin = new FormLogin();
        
        
        // Inicia a barra de menus
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 900, 30);
        
        // Adiciona o menu Cadastro
        JMenu mCadastro = new JMenu("Cadastro");
        
        // Adiciona o menu Relatório
        JMenu mRelat = new JMenu("Relatório");
        
        // Adiciona a barra de menus ao formulário principal
        this.add(menuBar);
        
        // Adiciona os menus Cadastro e Relatório à barra de menus
        menuBar.add(mCadastro);
        menuBar.add(mRelat);

        // Cria os três itens de menu para o menu Cadastro
        JMenuItem mItemCli = new JMenuItem("Cliente");
        JMenuItem mItemPro = new JMenuItem("Produto");
        JMenuItem mItemFor = new JMenuItem("Fornecedor");
        
        // Adiciona os itens de menu ao menu Cadastro
        mCadastro.add(mItemCli);
        mCadastro.add(mItemPro);
        mCadastro.add(mItemFor);
        
        // Cria as definições do JDeskTopPanel para receber as Janelas internas
        Color pDskTpCor = new Color(100,102,120);       // possível cor de fundo para o JDeskTopPane
        JDesktopPane jDskTop1 = new JDesktopPane();           // cria o JDeskTopPane
        jDskTop1.setBounds(0, 30, 900, 670);   // posiciona e dimensiona o JDeskTopPane
        
        //jDskTop1.setBackground(pDskTpCor);                  // caso deseje adicionar a cor de fundo retire o comentário
        
        
        this.add(jDskTop1);                               // adiciona o JDeskTopPane ao formulário principal

        jDskTop1.setLayout(null);                          // define Layout nulo para o JDeskTopPane
        
        
        // Torna visível o formulário principal
        this.setVisible(true);
        
        // Guarda as dimensões do formulário principal para serem usadas na centralização das janelas internas
        x = this.getWidth();
        y = this.getHeight();
        
        // Evento do menu Cliente para abrir a Janela interna
        mItemCli.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!frmCliente.isVisible()) {
                    frmCliente.setVisible(true);
                    frmCliente.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
                    frmCliente.setIconifiable(true);//Se o frame vai poder ser minimizado.
                    frmCliente.setResizable(true);
                    
                    // Centraliza a Janela interna do Cliente
                    frmCliente.setLocation((x/2) - (frmCliente.getWidth()/2)-10, (y/2)-(frmCliente.getHeight()/2)-50);                    
                    jDskTop1.add(frmCliente);
                }
            }
        });
        
        // Evento do menu Produto para abrir a Janela interna
        mItemPro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!frmProduto.isVisible()) {
                    frmProduto.setVisible(true);
                    frmProduto.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
                    frmProduto.setIconifiable(true);//Se o frame vai poder ser minimizado.
                    frmProduto.setResizable(true);
                    
                    // Centraliza a Janela interna do Cliente                    
                    frmProduto.setLocation((x/2) - (frmProduto.getWidth()/2)-10, (y/2)-(frmProduto.getHeight()/2)-50);                   
                    jDskTop1.add(frmProduto);
                }
            }  
        });
    }

}
