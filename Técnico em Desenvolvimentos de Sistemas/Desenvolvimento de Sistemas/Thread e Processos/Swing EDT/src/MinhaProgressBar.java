import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class MinhaProgressBar extends JFrame{
    private JProgressBar progressBar;
    
    public MinhaProgressBar(){
        setTitle("Exemplo de JProgressBar");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(progressBar, BorderLayout.CENTER);
    }

    public void iniciarTask(){
        Thread taskThread = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    for(int i =0; i <= 100; i++){
                        final int progress = i;

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run(){
                                progressBar.setValue(progress);
                            }
                        }); 

                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        taskThread.start();
    }

}