package appgrafico1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gabriel_piske
 */
public class AppGrafico1 extends JFrame {

    public int fW, fH, vel;
    public int bolaWidth, BolaHeigth;
    public boolean esquerda = false, direita = false, acima = false, abaixo = false, tiro = false;

    //------------ pos. bola--------------
    int bolaX, bolaY;

    //------------ posição da bala --------------
    int balaX, balaY;
    int balaVel;

    public AppGrafico1() {
        super("Exemplo Grafico 1");
        setSize(800, 600);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        fW = getWidth();
        fH = getHeight();
        bolaX = fW / 2;
        bolaY = fH / 2;
        vel = 5;
        balaVel = 10;

        add(new painelGraf());
        movGrafico();
    }

    public void movGrafico() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Tecla Presionada: " + e.getKeyCode());
                if (e.getKeyCode() == 37) { // x-- esquerda
                    esquerda = true;
                }
                if (e.getKeyCode() == 38) { // y-- cima
                    acima = true;
                }
                if (e.getKeyCode() == 39) { // x++ direita
                    direita = true;
                }
                if (e.getKeyCode() == 40) { // y++ baixo
                    abaixo = true;
                }
                if (e.getKeyCode() == 32) { // tecla espaço 
                    tiro = true;
                    balaX = bolaX; 
                    balaY = bolaY;
                }
                ////////////////////////////////////////////////////////////////
                if (esquerda == true) {
                    bolaX -= vel;
                }
                if (acima == true) {
                    bolaY -= vel;
                }
                if (direita == true) {
                    bolaX += vel;
                }
                if (abaixo == true) {
                    bolaY += vel;
                }
                ///////////////////////////////////////////////////////////////
                if (tiro == true) {
                    balaY -= balaVel; // cima
                    if (balaY < 0) {
                        tiro = false; // reinicia 
                    }
                }
                ///////////////////////////////////////////////////////////////
                if (e.getKeyCode() == 109) { // -
                    vel -= 1;
                    if (vel < 1) {
                        vel = 1;
                    }
                }
                if (e.getKeyCode() == 107) { // +
                    vel += 1;
                    if (vel > 50) {
                        vel = 50;
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 37) { // x-- esquerda
                    esquerda = false;
                }
                if (e.getKeyCode() == 38) { // y-- cima
                    acima = false;
                }
                if (e.getKeyCode() == 39) { // x++ direita
                    direita = false;
                }
                if (e.getKeyCode() == 40) { // y++ baixo
                    abaixo = false;
                }
            }

        });
    }

    public static void main(String[] args) {
        AppGrafico1 app = new AppGrafico1();
        app.setVisible(true);
    }

    private class painelGraf extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
//            g.setColor(Color.red);
//            g.drawLine(100, 100, 150, 200);
//            g.setColor(Color.GREEN);
//            g.drawLine(100, 100, 50, 200);
//            g.setColor(Color.BLUE);
//            g.drawLine(50, 200, 150, 200);
//            
//            g.drawRect(250, 250, 150, 100);///contorno retangulo
//            g.fillRect(400, 400, 100, 100);//retangulo preenchido

            g.clearRect(0, 0, fW, fH);
            bolaWidth = 30;
            BolaHeigth = 30;

            g.fillOval(bolaX, bolaY, bolaWidth, BolaHeigth);
            
            if (tiro) {
                int balaWidth = 10;
                int balaHeight = 10;
                g.setColor(Color.RED);
                g.fillOval(balaX, balaY, balaWidth, balaHeight);
            }

            repaint();
        }

    }
}
