import java.util.List;
import java.util.concurrent.ExecutionException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class MySwingWorker extends SwingWorker<Void, String> {
    private final String filePath;
    private final JTextArea textArea;
    private final JProgressBar progressBar;
    private final JTextField statusField; // Novo JTextField para mostrar a linha atual
    private final int tempo;
    private int totalLinhas;
    private int linhasLidas = 0;

    public MySwingWorker(String filePath, JTextArea textArea, JProgressBar progressBar, JTextField statusField,
            int tempo) {
        this.filePath = filePath;
        this.textArea = textArea;
        this.progressBar = progressBar;
        this.statusField = statusField;
        this.tempo = tempo;
        this.totalLinhas = contarLinhas();
    }

    public int contarLinhas() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao contar linhas do arquivo: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return count == 0 ? 1 : count;
    }

    @Override
    protected Void doInBackground() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Thread.sleep(tempo);
                linhasLidas++;
                int progresso = (int) ((linhasLidas / (double) totalLinhas) * 100);
                publish(linha);
                setProgress(progresso);

                final String linhaAtual = linha;
                SwingUtilities.invokeLater(() -> statusField.setText(linhaAtual));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String linha : chunks) {
            textArea.append(linha + "\n");
        }
    }

    @Override
    protected void done() {
        try {
            get();
            progressBar.setValue(100);
        } catch (InterruptedException | ExecutionException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}