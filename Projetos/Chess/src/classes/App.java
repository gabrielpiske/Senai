package classes;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        int width = 360;
        int height = 640;

        JFrame frame = new JFrame("Flappy Bird");
        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        frame.setVisible(true);
        
    }
}