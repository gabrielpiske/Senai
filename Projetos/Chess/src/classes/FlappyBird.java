package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
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

    int pipeX = width;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    class Pipe {
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed = false;

        Pipe(Image img) {
            this.img = img;
        }
    }

    Bird bird;
    int velocityX = -4;
    int velocityY = 0;
    int gravity = 1;

    ArrayList<Pipe> pipes;
    Random random = new Random();

    Timer gameLoop;
    Timer placePipesTimer;
    boolean gameOver = false;
    double score = 0;

    FlappyBird() {
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        addKeyListener(this);

        backImage = new ImageIcon(getClass().getResource("/img/flappybirdbg.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("/img/flappybird.png")).getImage();
        bottompipeImage = new ImageIcon(getClass().getResource("/img/bottompipe.png")).getImage();
        toppipeImage = new ImageIcon(getClass().getResource("/img/toppipe.png")).getImage();

        bird = new Bird(birdImage);
        pipes = new ArrayList<Pipe>();

        placePipesTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        placePipesTimer.start();

        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void placePipes() {
        int randomPipeY = (int) (pipeY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openSpaces = height / 4;

        Pipe topPipe = new Pipe(toppipeImage);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottompipeImage);
        bottomPipe.y = topPipe.y + pipeHeight + openSpaces;
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backImage, 0, 0, width, height, null);
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Montserrat", Font.PLAIN, 32));
        if (gameOver) {
            g.drawString("Game Over: " + String.valueOf((int) score), 10, 35);
        } else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    public void move() {
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0);

        // pipes
        if (!gameOver) {
            for (int i = 0; i < pipes.size(); i++) {
                Pipe pipe = pipes.get(i);
                pipe.x += velocityX;

                if (!pipe.passed && bird.x > pipe.x + pipe.width) {
                    pipe.passed = true;
                    score += 0.5;
                }

                if (colisao(bird, pipe)) {
                    gameOver = true;
                }
            }
        }
        if (bird.y > height) {
            gameOver = true;
        }
    }

    public boolean colisao(Bird bird, Pipe pipe) {
        return bird.x < pipe.x + pipe.width &&
                bird.x + bird.width > pipe.x &&
                bird.y < pipe.y + pipe.height &&
                bird.y + bird.height > pipe.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -9;
            if (gameOver) {
                bird.y = birdY;
                velocityY = 0;
                pipes.clear();
                score = 0;
                gameOver = false;
                gameLoop.start();
                placePipesTimer.start();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
