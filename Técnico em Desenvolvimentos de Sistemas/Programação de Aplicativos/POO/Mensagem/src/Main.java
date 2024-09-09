import javax.swing.JFrame;


public class Main extends JFrame {

    public Main(){
        setTitle("Titulo");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
