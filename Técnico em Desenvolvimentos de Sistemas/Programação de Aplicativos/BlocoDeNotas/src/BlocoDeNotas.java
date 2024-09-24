
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
    private JMenuItem menuNovo, menuAbrir, menuSalvar, menuSair, menuClaro, menuEscuro, menuTamanho, menuFonte, menuCorTexto, menuCorFundo;
    private JLabel statusLabel;

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
        add(scrollPane, BorderLayout.CENTER);

        // Status Label para contar palavras/letras
        statusLabel = new JLabel("Letras: 0 | Palavras: 0");
        add(statusLabel, BorderLayout.SOUTH);
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateStatus();
            }

            public void removeUpdate(DocumentEvent e) {
                updateStatus();
            }

            public void insertUpdate(DocumentEvent e) {
                updateStatus();
            }
        });

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
        menuFonte = new JMenuItem("Fonte");
        menuCorTexto = new JMenuItem("Cor do Texto");
        menuCorFundo = new JMenuItem("Cor do Fundo");

        menuArquivo.add(menuNovo);
        menuArquivo.add(menuAbrir);
        menuArquivo.add(menuSalvar);
        menuArquivo.add(menuSair);

        menuEditar.add(menuClaro);
        menuEditar.add(menuEscuro);
        menuEditar.add(menuTamanho);
        menuEditar.add(menuFonte);
        menuEditar.add(menuCorTexto);
        menuEditar.add(menuCorFundo);

        setJMenuBar(menuBar);

        menuNovo.addActionListener(e -> novoArquivo());
        menuAbrir.addActionListener(e -> abrirArquivo());
        menuSalvar.addActionListener(e -> salvarArquivo());

        menuClaro.addActionListener(e -> menuClaro());
        menuEscuro.addActionListener(e -> menuEscuro());
        menuTamanho.addActionListener(e -> mudarTamanho());
        menuFonte.addActionListener(e -> mudarFonte());
        menuCorTexto.addActionListener(e -> mudarCorTexto());
        menuCorFundo.addActionListener(e -> mudarCorFundo());

        menuSair.addActionListener(e -> System.exit(0));
    }

    private void novoArquivo() {
        if (!textArea.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(this, "Deseja salvar o arquivo antes de criar um novo?", "Salvar", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                salvarArquivo();
            } else if (option == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        textArea.setText("");
    }

    private void menuClaro() {
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        revalidate();
        repaint();
    }

    private void menuEscuro() {
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
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

    private void mudarTamanho() {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Insira o Tamanho Desejado"));
        Font font = new Font(textArea.getFont().getName(), Font.PLAIN, tam);
        textArea.setFont(font);
        revalidate();
        repaint();
    }

    private void mudarFonte() {
        String fonte = JOptionPane.showInputDialog("Digite o nome da fonte desejada:");
        Font font = new Font(fonte, Font.PLAIN, textArea.getFont().getSize());
        textArea.setFont(font);
    }

    private void mudarCorTexto() {
        Color cor = JColorChooser.showDialog(this, "Escolha a cor do texto", textArea.getForeground());
        if (cor != null) {
            textArea.setForeground(cor);
        }
    }

    private void mudarCorFundo() {
        Color cor = JColorChooser.showDialog(this, "Escolha a cor de fundo", textArea.getBackground());
        if (cor != null) {
            textArea.setBackground(cor);
        }
    }

    private void updateStatus() {
        String text = textArea.getText();
        int numLetras = text.length();
        int numPalavras = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
        statusLabel.setText("Letras: " + numLetras + " | Palavras: " + numPalavras);
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
