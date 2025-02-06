import javax.swing.*;
import java.awt.*;

public class AppLerArquivos extends JFrame {
    private JTextArea textArea1;
    private JTextArea textArea2;

    public AppLerArquivos() {
        setTitle("Leitor de Arquivos Texto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2));

        // Inicializando JTextAreas
        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setFont(new Font("Serif", Font.PLAIN, 16));

        textArea2 = new JTextArea();
        textArea2.setEditable(false);
        textArea2.setFont(new Font("Serif", Font.PLAIN, 16));

        // Adicionando JTextAreas a JScrollPanes
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);

        add(scrollPane1);
        add(scrollPane2);
    }

    public void lerArquivos(String filePath1, String filePath2) {
        Thread thread1 = new Thread(new TarefaLerArquivo(filePath1, textArea1));
        Thread thread2 = new Thread(new TarefaLerArquivo(filePath2, textArea2));

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppLerArquivos gui = new AppLerArquivos();
            gui.setVisible(true);
            gui.lerArquivos("./arquivo1.txt", "./arquivo2.txt");
        });
    }
}
