
package moveimagecoord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

class ImagePanel extends JPanel implements ActionListener, KeyListener {

    private Image ball;
    private Image player;
    private Image player1;
    private Image player2;
    private Image cesta;
    private Image fundo;
    private int x_ball, y_ball;
    private int x_player, y_player;
    private int px = 0, py = 0;
    private int cestaX = 400, cestaY = 190;
    private int fundoX = 0, fundoY = 0;
    private int pontos = 0;

    private int ang = 45;

    // trajetória
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

    public ImagePanel() {
        ball = new ImageIcon("src/moveimagecoord/ball_noBg_resized.png").getImage();
        player = new ImageIcon("src/moveimagecoord/player1_rev.png").getImage();
        player1 = new ImageIcon("src/moveimagecoord/player1_rev.png").getImage();
        player2 = new ImageIcon("src/moveimagecoord/player2_rev.png").getImage();
        cesta = new ImageIcon("src/moveimagecoord/cesta_basquete.png").getImage();
        fundo = new ImageIcon("src/moveimagecoord/fundo.jpg").getImage();
        x_ball = 115 - 25;
        y_ball = 325 - 25;
        x_player = 50;
        y_player = 300;

        // Timer timer = new Timer(10, this);
        // timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clearImage(g);
        drawImage((Graphics2D) g, x_player, y_player);
        drawCoordinates(g);
        drawScore(g);
    }

    private void bola(int x, int y) {
        px = x + (int) xs[i];
        py = y - (int) ys[i];
    }

    private void drawImage(Graphics2D g, int x, int y) {
        int larguraFundo = getWidth();
        int alturaFundo = getHeight();

        g.drawImage(fundo, fundoX, fundoY, larguraFundo, alturaFundo, this);

        bola(x_ball, y_ball);
        g.drawImage(ball, px, py, this);
        g.drawImage(player, x_player, y_player, this);
        g.drawImage(cesta, cestaX, cestaY, this);
    }

    private void drawCoordinates(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Coordenadas: (" + (x_ball + 25) + ", " + (y_ball + 25) + ")", 10, 20);
        g.drawString("Angulo: " + String.valueOf(ang), 170, 20);
        g.drawString("Força: " + String.valueOf(v0), 250, 20);
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Pontuação: " + pontos, getWidth() - 100, 20);
    }

    private void clearImage(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Atualiza a posição da imagem para animação
        // x++;
        // y++;
        repaint();
        update();
    }

    private void trocarImagem() {
        // Troca entre as imagens
        if (player == player1) {
            player = player2;
        } else {
            player = player1;
            x_ball = 115 - 25;
            y_ball = 325 - 25;
        }
    }

    private void respawCesta() {
        Random random = new Random();
        int cestaWidth = 50;
        int cestaHeight = 50;
        int minX = getWidth() / 2;
        int maxX = getWidth() - cestaWidth;
        int minY = 0;
        int maxY = getHeight() / 2 - cestaHeight;

        // Reduzir area
        int reducaoX = 50;
        int reducaoY = 50;
        minX += reducaoX;
        maxX -= reducaoX;
        minY += reducaoY;
        maxY -= reducaoY;

        cestaX = Math.max(minX, Math.min(random.nextInt(maxX - minX + 1) + minX, maxX));
        cestaY = Math.max(minY, Math.min(random.nextInt(maxY - minY + 1) + minY, maxY));

        repaint();
    }

    private boolean colisaoBolaCesta() {
        return px < cestaX + 50 &&
                px + 25 > cestaX &&
                py < cestaY + 50 &&
                py + 25 > cestaY;
    }

    private void update() {
        if (colisaoBolaCesta()) {
            pontos++;
            respawCesta();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_EQUALS) {
            if (v0 < 100) {
                v0++;
            }
            trajeto();
            repaint();
        } else if (key == KeyEvent.VK_MINUS) {
            if (v0 > 30) {
                v0--;
            }
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

        }
        switch (key) {
            case KeyEvent.VK_LEFT:
                x_ball -= 5;
                break;
            case KeyEvent.VK_RIGHT:
                x_ball += 5;
                break;
            case KeyEvent.VK_UP:
                y_ball -= 5;
                break;
            case KeyEvent.VK_DOWN:
                y_ball += 5;
                break;
            case KeyEvent.VK_SPACE:
                x_ball = 165 - 25;
                y_ball = 290 - 25;
                trocarImagem();
                trajeto();
                break;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
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
                        trocarImagem();
                        trava = false;
                    }
                    update();
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MoveImageCoord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
        }
    }

    private void trajeto() {
        angulo = toRadians(ang);
        a_max = pow(v0, 2.0) * pow(sin(angulo), 2.0) / (2 * vg);
        tempo = 2 * v0 * sin(angulo) / vg;
        dist = 2 * pow(v0, 2.0) * cos(angulo) * sin(angulo) / vg;

        double dt = tempo / pts;
        double v0x = v0 * cos(angulo);
        double v0y = v0 * sin(angulo);
        double ti = 0.0;

        for (int c = 0; c < pts; c++) {
            it[c] = ti;
            ti = ti + dt;
            xs[c] = v0x * it[c];
            ys[c] = v0y * it[c] - 0.5 * vg * pow(it[c], 2.0);
        }
    }
}

public class MoveImageCoord {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Move Image Example");
            ImagePanel panel = new ImagePanel();
            frame.add(panel);
            frame.setSize(1000, 800);
            frame.setLocationRelativeTo(frame);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
