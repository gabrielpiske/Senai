package tesetimagem;

import java.util.Locale;
import javax.swing.JFrame;

/**
 *
 * @author gabriel_piske
 */
public class TesetImagem {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(frame);
        PaneImgFundo painel = new PaneImgFundo("back.jpg");
        frame.add(frame);
        frame.setVisible(true);
    }
}
