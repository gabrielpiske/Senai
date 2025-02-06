import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppLerArquivo extends JFrame {
    private JTextArea textArea;
    private JTextField jtfArquivo1;
    private JTextField jtfArquivo2;
    private JTextField jtfTempo1;
    private JTextField jtfTempo2;
    private JProgressBar progresso1;
    private JProgressBar progresso2;

    public AppLerArquivo() {
        // Configurando o JFrame
        setTitle("Leitor de Arquivo Texto MultiThreading");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Inicializando o JTextArea
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        // Adicionando o JTextArea a um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(310, 10, 260, 340);
        add(scrollPane);

        Border gray = BorderFactory.createLineBorder(Color.GRAY);

        scrollPane.setBorder(gray);

        JLabel arquivo1 = new JLabel("Progresso de leitura do arquivo 1:");
        arquivo1.setBounds(10, 10, 280, 25);

        jtfArquivo1 = new JTextField();
        jtfArquivo1.setBounds(10, 35, 280, 30);

        progresso1 = new JProgressBar(0, 100);
        progresso1.setBounds(10, 70, 280, 20);
        progresso1.setStringPainted(true);

        JLabel tempo1 = new JLabel("Tempo da tarefa 1:");
        tempo1.setBounds(10, 103, 180, 25);

        jtfTempo1 = new JTextField();
        jtfTempo1.setBounds(150, 100, 140, 30);
        jtfTempo1.setText("100");

        JLabel arquivo2 = new JLabel("Progresso de leitura do arquivo 2:");
        arquivo2.setBounds(10, 140, 280, 25);

        jtfArquivo2 = new JTextField();
        jtfArquivo2.setBounds(10, 165, 280, 30);

        progresso2 = new JProgressBar(0, 100);
        progresso2.setBounds(10, 200, 280, 20);
        progresso2.setStringPainted(true);

        JLabel tempo2 = new JLabel("Tempo da tarefa 2:");
        tempo2.setBounds(10, 233, 180, 25);

        jtfTempo2 = new JTextField();
        jtfTempo2.setBounds(150, 230, 140, 30);
        jtfTempo2.setText("100");

        JLabel texto = new JLabel("Texto de Entrada:");
        texto.setBounds(10, 345, 200, 25);

        JTextField jTfTexto = new JTextField();
        jTfTexto.setBounds(10, 370, 560, 30);

        add(jtfTempo1);
        add(jtfTempo2);
        add(progresso1);
        add(progresso2);
        add(tempo1);
        add(tempo2);

        add(arquivo1);
        add(arquivo2);
        add(texto);
        // add(scrollPane, null);
        add(jtfArquivo1);
        add(jtfArquivo2);
        add(jTfTexto);
    }

    public void LerArquivosSimultaneo(String filePath1, String filePath2) {
        LerArquivos task1 = new LerArquivos(filePath1, textArea, jtfArquivo1, Integer.parseInt(jtfTempo1.getText()),
                progresso1);
        LerArquivos task2 = new LerArquivos(filePath2, textArea, jtfArquivo2, Integer.parseInt(jtfTempo2.getText()),
                progresso2);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppLerArquivo gui = new AppLerArquivo();
                JButton button = new JButton("Iniciar a leitura");
                button.setBounds(10, 300, 280, 30);
                gui.add(button);
    
                gui.setVisible(true);
    
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        // Obtém os caminhos dos arquivos dos campos de texto
                        String filePath1 = gui.jtfArquivo1.getText().trim();
                        String filePath2 = gui.jtfArquivo2.getText().trim();
    
                        // Se os campos estiverem vazios, usa os valores padrão
                        if (filePath1.isEmpty()) {
                            filePath1 = "./arquivo1.txt";
                        }
                        if (filePath2.isEmpty()) {
                            filePath2 = "./arquivo2.txt";
                        }
    
                        gui.LerArquivosSimultaneo(filePath1, filePath2);
                    }
                });
            }
        });
    }
}
