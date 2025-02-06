import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class LerArquivos implements Runnable {
    private final String filePath;
    private final JTextArea textArea;
    private final JTextField texto;
    private final int tempo;
    private final int totalLinhas;
    private final JProgressBar progressBar;
    private int linesRead;
    int progresso;

    public LerArquivos(String filePath, JTextArea textArea, JTextField text, int tempo, JProgressBar progress) {
        this.filePath = filePath;
        this.textArea = textArea;
        this.texto = text;
        this.tempo = tempo;
        this.totalLinhas = contaTotalLinhas(filePath);
        this.progressBar = progress;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Thread.sleep(tempo);

                final String finalLinha = linha;
                SwingUtilities.invokeLater(() -> {
                    textArea.append(finalLinha + "\n");
                    texto.setText(finalLinha);
                });

                linesRead++;
                int progresso = (int) ((linesRead / (double) totalLinhas) * 100);
                final int progressoFinal = progresso;
                SwingUtilities.invokeLater(() -> progressBar.setValue(progressoFinal));

            }
        } catch (IOException | InterruptedException e) {
            mostrarErro("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private int contaTotalLinhas(String filePath) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            mostrarErro("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lineCount;
    }

    private void mostrarErro(final String msg) {
        SwingUtilities.invokeLater(
                () -> JOptionPane.showMessageDialog(textArea.getParent(), msg, "Erro", JOptionPane.ERROR_MESSAGE));
    }
}
