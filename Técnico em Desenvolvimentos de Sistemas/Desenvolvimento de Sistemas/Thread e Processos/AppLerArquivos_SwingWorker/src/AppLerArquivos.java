import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AppLerArquivos extends JFrame {
    private JTextArea textArea;
    private JTextField jtfArquivo1;
    private JTextField jtfArquivo2;
    private JTextField jtfTempo1;
    private JTextField jtfTempo2;
    private JProgressBar progresso1;
    private JProgressBar progresso2;

    public AppLerArquivos() {
        setTitle("Leitor de Arquivo Texto MultiThreading");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

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

        jtfTempo1 = new JTextField("100");
        jtfTempo1.setBounds(150, 100, 140, 30);

        JLabel arquivo2 = new JLabel("Progresso de leitura do arquivo 2:");
        arquivo2.setBounds(10, 140, 280, 25);

        jtfArquivo2 = new JTextField();
        jtfArquivo2.setBounds(10, 165, 280, 30);

        progresso2 = new JProgressBar(0, 100);
        progresso2.setBounds(10, 200, 280, 20);
        progresso2.setStringPainted(true);

        JLabel tempo2 = new JLabel("Tempo da tarefa 2:");
        tempo2.setBounds(10, 233, 180, 25);

        jtfTempo2 = new JTextField("100");
        jtfTempo2.setBounds(150, 230, 140, 30);

        JButton button = new JButton("Iniciar a leitura");
        button.setBounds(10, 300, 280, 30);
        button.addActionListener(evt -> iniciarLeitura());

        add(jtfTempo1);
        add(jtfTempo2);
        add(progresso1);
        add(progresso2);
        add(tempo1);
        add(tempo2);
        add(arquivo1);
        add(arquivo2);
        add(jtfArquivo1);
        add(jtfArquivo2);
        add(button);
    }

    private void iniciarLeitura() {
        String filePath1 = jtfArquivo1.getText().trim().isEmpty() ? "./arquivo1.txt" : jtfArquivo1.getText().trim();
        MySwingWorker worker1 = new MySwingWorker(filePath1, textArea, progresso1, jtfArquivo1, Integer.parseInt(jtfTempo1.getText()));
    
        worker1.addPropertyChangeListener(evt -> {
            if ("progress".equals(evt.getPropertyName())) {
                progresso1.setValue((int) evt.getNewValue());
            }
        });
    
        worker1.execute();
    
        String filePath2 = jtfArquivo2.getText().trim().isEmpty() ? "./arquivo2.txt" : jtfArquivo2.getText().trim();
        MySwingWorker worker2 = new MySwingWorker(filePath2, textArea, progresso2, jtfArquivo2, Integer.parseInt(jtfTempo2.getText()));
    
        worker2.addPropertyChangeListener(evt -> {
            if ("progress".equals(evt.getPropertyName())) {
                progresso2.setValue((int) evt.getNewValue());
            }
        });
    
        worker2.execute();
    }
    

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            AppLerArquivos gui = new AppLerArquivos();
            gui.setVisible(true);
        });
    }
}
