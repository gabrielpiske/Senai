/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testeimagem;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author gabriel_piske
 */
public class PaneImgFundo extends JPanel {

    private Image image;
    private String imgPath;

    public PaneImgFundo(String img) {
        imgPath = img;
        this.initialize();
    }

    protected void initialize() {
        this.image = this.getImage(imgPath);

        this.setLayout(null);
    }

    public Image getImage(String path) {
        URL imageURL = getClass().getResource(path);
        if (imageURL == null) {
            return null;
        }
        return new ImageIcon(imageURL).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dDesktop = this.getSize();

        double width = dDesktop.getWidth();
        double height = dDesktop.getHeight();

        Image background = new ImageIcon(this.image.getScaledInstance((int) width, (int) height, 1)).getImage();

        g.drawImage(background, 0, 0, this);
    }
}
