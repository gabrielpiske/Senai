package jogodanave;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImagePanel extends JPanel implements ActionListener, KeyListener {
    
    private Image nave;
    private Image meteoro;
    private Image bala;
    
    public ImagePanel(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
}

public class JogodaNave {
    
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Jogo da Nave");
            ImagePanel panel = new ImagePanel();
            frame.add(panel);
            frame.setSize(1000, 800);
            frame.setLocationRelativeTo(frame);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
