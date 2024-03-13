package appgrafico2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author gabriel_piske
 */

class PanelGraf extends JPanel implements ActionListener, KeyListener{
        
        private Image img1;
        private int img1X, img1Y;
        
        public PanelGraf(){
            img1 = new ImageIcon("src/img1.png").getImage();
            img1X = 300;
            img1Y = 250;
            
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(true);
        }
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            clearImage(g);
            drawImage(g);
        }
        
        private void drawImage(Graphics g){
            g.drawImage(img1, img1X, img1Y, this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }

        private void clearImage(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        
    }

public class AppGrafico2 {

    
    public static void main(String[] args) {
        JFrame appGraf2 = new JFrame();
        
        appGraf2.setSize(600, 500);
        appGraf2.setLocationRelativeTo(appGraf2);
        PanelGraf painel = new PanelGraf();
        appGraf2.add(painel);
        
        appGraf2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appGraf2.setVisible(true);
    }
    
}
