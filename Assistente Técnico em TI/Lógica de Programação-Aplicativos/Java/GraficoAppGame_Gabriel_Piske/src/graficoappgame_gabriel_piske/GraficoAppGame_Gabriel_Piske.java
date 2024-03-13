package graficoappgame_gabriel_piske;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GraficoAppGame_Gabriel_Piske extends JFrame {

    int formW, formH;
    int bX = 0, bY = 0;
    private int px = 0, py = 0;
    int vel;

    private int ang = 45;

    //Variavéis da Trajetória da Bala
    private double angulo = 0.0;
    private double a_max = 0.0;
    private double tempo = 0.0;
    private double dist = 0.0;
    private double v0 = 50.0;
    private double vg = 9.81;

    private int i = 0;
    private int pts = 100;
    private double[] it = new double[100];
    private double[] xs = new double[100];
    private double[] ys = new double[100];

    private boolean trava = false;

    private void canhao(Graphics2D g, int x, int y) {
        g.setColor(Color.red);
        AffineTransform oldTransform = g.getTransform();
        g.rotate(Math.toRadians(-ang), x, y);
        g.fillRect(x - 15, y - 5, 30, 10);
        g.setTransform(oldTransform);
    }

    private void bala(int x, int y) {

        px = x + (int) xs[i];
        py = y - (int) ys[i];
    }

    private class pnlGraf extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.red);
            canhao((Graphics2D) g, bX, bY);
            bala(bX, bY);

            if ((px != bX) || (py != bY)) {
                int cor_bala = new Color(0, 0, 0).getRGB();
                g.setColor(new Color(cor_bala));
                g.fillOval(px - 5, py - 5, 10, 10);
            }
            g.setColor(Color.BLACK);
            g.drawString("Angulo: " + String.valueOf(ang), 30, 15);
            g.drawString("Força: " + String.valueOf(v0), 120, 15);

            repaint();
        }
    }

    public GraficoAppGame_Gabriel_Piske() {
        super();
        setTitle("Aplicativo Gráfico - Exemplo 1");
        setSize(800, 600);
        formW = getWidth();
        formH = getHeight();
        bX = formW / 2;
        bY = formH / 2;
        vel = 3;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        add(new pnlGraf());
        movGrafico();
        trajeto();
        setVisible(true);
    }

    public static void main(String[] args) {
        new GraficoAppGame_Gabriel_Piske();
    }

    public void movGrafico() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_EQUALS) {
                    v0++;
                    trajeto();
                    repaint();
                } else if (key == KeyEvent.VK_MINUS) {
                    v0--;
                    trajeto();
                    repaint();
                } else if (key == KeyEvent.VK_R) {
                    if (ang > 0) {
                        ang--;
                    }
                    trajeto();
                    repaint();
                } else if (key == KeyEvent.VK_T) {
                    if (ang < 180) {
                        ang++;
                    }
                    trajeto();
                    repaint();
                } else if (key == KeyEvent.VK_UP) {
                    bY -= vel;
                    repaint();
                } else if (key == KeyEvent.VK_DOWN) {
                    bY += vel;
                    repaint();
                } else if (key == KeyEvent.VK_LEFT) {
                    bX -= vel;
                    repaint();
                } else if (key == KeyEvent.VK_RIGHT) {
                    bX += vel;
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    trava = true;

                    new Thread(() -> {
                        while (trava) {
                            i++;
                            if (i >= pts) {
                                i = 0;
                                trava = false;
                            }
                            repaint();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GraficoAppGame_Gabriel_Piske.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }).start();
                }
            }
        });

    }

    public void trajeto() {
        angulo = Math.toRadians(ang);
        a_max = Math.pow(v0, 2.0) * Math.pow(Math.sin(angulo), 2.0) / (2 * vg);
        tempo = 2 * v0 * Math.sin(angulo) / vg;
        dist = 2 * Math.pow(v0, 2.0) * Math.cos(angulo) * Math.sin(angulo) / vg;

        double dt = tempo / pts;
        double v0x = v0 * Math.cos(angulo);
        double v0y = v0 * Math.sin(angulo);
        double ti = 0.0;

        for (int c = 0; c < pts; c++) {
            it[c] = ti;
            ti = ti + dt;
            xs[c] = v0x * it[c];
            ys[c] = v0y * it[c] - 0.5 * vg * Math.pow(it[c], 2.0);
        }
    }

}
