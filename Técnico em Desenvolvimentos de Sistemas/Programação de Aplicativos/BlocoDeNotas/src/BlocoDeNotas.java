
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author gabriel_piske
 */
public class BlocoDeNotas extends javax.swing.JFrame {
    /*
        1- Definir outros padrões de fonte/cores do blocos de notas ou solicitar para o usuario alterar.
        2- Ao clicar no "Novo", validar se tem algo escrito e sugerir o salvamento ou abrir um novo objeto.
        3- Label que conte o numero de letras/palavras
    */
    
    
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu menuArquivo, menuEditar;
    private JMenuItem menuNovo, menuAbrir, menuSalvar, menuSair, menuClaro, menuEscuro, menuTamanho;

    /**
     * Creates new form BlocoDeNotas
     */
    public BlocoDeNotas() {
        //initComponents();
        setTitle("Bloco de Notas");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //pack(); // ajusta o frame de acordo com seus componentes internos

        //JText instanciada
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        //Barra de menus
        menuBar = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuEditar = new JMenu("Editar");
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);

        menuNovo = new JMenuItem("Novo");
        menuAbrir = new JMenuItem("Abrir");
        menuSalvar = new JMenuItem("Salvar");
        menuSair = new JMenuItem("Sair");

        menuClaro = new JMenuItem("Claro");
        menuEscuro = new JMenuItem("Escuro");
        menuTamanho = new JMenuItem("Tamanho Fonte");

        menuArquivo.add(menuNovo);
        menuArquivo.add(menuAbrir);
        menuArquivo.add(menuSalvar);
        menuArquivo.add(menuSair);
        
        menuEditar.add(menuClaro);
        menuEditar.add(menuEscuro);
        menuEditar.add(menuTamanho);

        setJMenuBar(menuBar);

        menuNovo.addActionListener(e -> novoArquivo());
        menuAbrir.addActionListener(e -> abrirArquivo());
        menuSalvar.addActionListener(e -> salvarArquivo());
        
        menuClaro.addActionListener(e -> menuClaro());
        menuEscuro.addActionListener(e -> menuEscuro());
        menuTamanho.addActionListener(e -> mudarTamanho());
        
        menuSair.addActionListener(e -> System.exit(0));
    }

    private void novoArquivo() {
        textArea.setText("");
    }

    private void menuClaro() {
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        Font font = new Font("Arial", Font.PLAIN, 18);
        revalidate();
        repaint();
    }

    private void menuEscuro() {
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        Font font = new Font("Arial", Font.PLAIN, 18);
        revalidate();
        repaint();
    }

    private void abrirArquivo() {
        JFileChooser arquivo = new JFileChooser();
        int option = arquivo.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File arquivoB = arquivo.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(arquivoB));
                textArea.read(reader, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void salvarArquivo() {
        JFileChooser arquivo = new JFileChooser();
        int option = arquivo.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File arquivoB = arquivo.getSelectedFile();
                BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoB));
                textArea.write(escritor);
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void mudarTamanho(){
        int tam = 18;
        tam = Integer.parseInt(JOptionPane.showInputDialog("Insira o Tamanho Desejado"));
        Font font = new Font("Arial", Font.PLAIN, tam);
        textArea.setFont(font);
        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(BlocoDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlocoDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlocoDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlocoDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlocoDeNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
