package testeimagem;

import java.util.Locale;
import javax.swing.JFrame;
import telas.FormLogin;
//import img.*;

/**
 *
 * @author gabriel_piske
 */
public class TesteImagem {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(frame);
        PaneImgFundo painel = new PaneImgFundo("back.jpg");
        //frame.add(painel);
        frame.setVisible(true);
        
        FormLogin telaLogin = new FormLogin();
        telaLogin.add(painel);
        telaLogin.setVisible(true);
    }
}
