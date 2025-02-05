import javax.swing.SwingUtilities;

public class ProgressBarExemplo {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                MinhaProgressBar example = new MinhaProgressBar();
                example.setVisible(true);
                example.iniciarTask();
            }
        });
    }
}
