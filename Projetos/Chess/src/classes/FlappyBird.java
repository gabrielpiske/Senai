package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FlappyBird extends JPanel {
    int width = 360;
    int height = 640;

    Image bottompipeImage;
    Image birdImage;
    Image backImage;
    Image toppipeImage;

    int birdX = width / 8;
    int birdY = height / 2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    Bird bird;

    FlappyBird() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLUE);

        backImage = new ImageIcon(getClass().getResource("/img/flappybirdbg.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("/img/flappybird.png")).getImage();
        bottompipeImage = new ImageIcon(getClass().getResource("/img/bottompipe.png")).getImage();
        toppipeImage = new ImageIcon(getClass().getResource("/img/toppipe.png")).getImage();

        bird = new Bird(birdImage);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backImage, 0, 0, width, height, null);
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
    }
}
