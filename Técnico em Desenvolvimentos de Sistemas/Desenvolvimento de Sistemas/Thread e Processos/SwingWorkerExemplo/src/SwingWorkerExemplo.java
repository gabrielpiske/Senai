import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.*;

public class SwingWorkerExemplo extends JFrame {
    private JProgressBar progressBar;
    private JTextArea textArea;
    private JButton starButton;

    public SwingWorkerExemplo() {
        super("Exemplo completo de uso do SwingWorker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        starButton = new JButton("Iniciar Tarefa");
        starButton.addActionListener(e -> {
            starButton.setEnabled(false);
            starButton.setText("Tarefa em andamento");
            MySwingWorker worker = new MySwingWorker(progressBar, textArea, starButton);
            worker.addPropertyChangeListener(evt -> {
                if ("progress".equals(evt.getPropertyName())) {
                    progressBar.setValue((Integer) evt.getNewValue());
                }
            });
            worker.execute();
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(progressBar, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(starButton, BorderLayout.SOUTH);
        add(panel);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingWorkerExemplo example = new SwingWorkerExemplo();
                example.setVisible(true);
            }
        });
    }
}
