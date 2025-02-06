import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TarefaLerArquivo implements Runnable {
    private final String filePath;
    private final JTextArea textArea;

    public TarefaLerArquivo(String filePath, JTextArea textArea) {
        this.filePath = filePath;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String currentLine = line;
                SwingUtilities.invokeLater(() -> textArea.append(currentLine + "\n"));
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            showError("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private void showError(final String message) {
        SwingUtilities.invokeLater(() -> 
            JOptionPane.showMessageDialog(textArea.getParent(), message, "Erro", JOptionPane.ERROR_MESSAGE)
        );
    }
}
