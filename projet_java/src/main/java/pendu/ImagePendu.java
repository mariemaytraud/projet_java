/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pendu;

import javax.swing.*;
import java.awt.*;
//import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author MARIE
 */
public class ImagePendu extends JPanel {

    private int erreurs = 0;
    private Image[] images = new Image[7];

    public ImagePendu() {
     
        setPreferredSize(new Dimension(150, 150));
        setBackground(Color.WHITE);

        try {
            for (int i = 0; i < 7; i++) {
                images[i]=ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("pendu" + i + ".png"));
            }


        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des images : " + e.getMessage());
        }
    }

    public void incrementerErreurs() {
        if (erreurs < images.length) {
            erreurs++;
            repaint();
        }
    }

    public void resetErreurs() {
        erreurs = 0;
        revalidate();
        repaint();
    }

    public int getErreurs() {
        return erreurs;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image img = images[erreurs];
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        }
    }
}

