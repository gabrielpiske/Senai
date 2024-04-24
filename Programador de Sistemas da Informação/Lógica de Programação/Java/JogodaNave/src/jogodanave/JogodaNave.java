package jogodanave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class ImagePanel extends JPanel implements KeyListener{
    
    private Image nave;
    private Image meteoro;
    private Image bala;
    private int xNave;
    private int yNave;
    private int xMet;
    private int yMet;
    private int xBala;
    private int yBala;
    
    public ImagePanel(){
        
        nave = new ImageIcon("src/jogodanave/nave_image.png").getImage();
        meteoro = new ImageIcon("src/jogodanave/meteoro.png").getImage();
        bala = new ImageIcon("src/jogodanave/tiro.png").getImage();
        xNave = 200;
        yNave = 200;
        
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        clearImage(g);
        drawImage((Graphics2D) g, xNave, yNave);
    }
    
    public void drawImage(Graphics2D g, int x, int y){
        g.drawImage(nave, xNave, yNave, this);
    }
    
    private void clearImage(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    
    @Override
    public void keyPressed(KeyEvent e){
       int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT:
                xNave -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                xNave += 10;
                break;
            case KeyEvent.VK_UP:
                yNave -= 10;
                break;
            case KeyEvent.VK_DOWN:
                yNave += 10;
                break;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
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
