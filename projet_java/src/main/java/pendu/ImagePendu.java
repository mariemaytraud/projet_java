/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pendu;

import javax.swing.*;
import java.awt.*;
import java.io.File;
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
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.WHITE);

        try {
//            for (int i = 0; i < 7; i++) {
//                images[i]=ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("/pendu" + i + ".png"));
//            }
            images[0] = ImageIO.read(new File("C:\\Users\\MARIE\\Pictures\\Screenshots\\pendu0.png"));
            images[1] = ImageIO.read(new File("C:\\Users\\MARIE\\Pictures\\Screenshots\\pendu1.png"));
            images[2] = ImageIO.read(new File("C:\\Users\\MARIE\\Pictures\\Screenshots\\pendu2.png"));
            images[3] = ImageIO.read(new File("C:\\Users\\MARIE\\Pictures\\Screenshots\\pendu3.png"));
            images[4] = ImageIO.read(new File("C:\\Users\\MARIE\\Pictures\\Screenshots\\pendu4.png"));
            images[5] = ImageIO.read(new File("C:\\Users\\MARIE\\Pictures\\Screenshots\\pendu5.png"));
            images[6] = ImageIO.read(new File("C:\\Users\\MARIE\\Pictures\\Screenshots\\pendu6.png"));

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
            g.drawImage(img, 475, 115, 500, 400, this);
        }
    }
}

//private JLabel labelPendu;
//   labelPendu = new JLabel(); 
//    labelPendu.setIcon(new ImageIcon("path_to_image.png"));
// void updatePenduImage(int erreurs) {
//   labelPendu = new JLabel();
// labelPendu.setHorizontalAlignment(SwingConstants.CENTER);
// }
//  Component getLabelPendu() {
//   return labelPendu;  // Retourne le label qui contient l'image du pendu
//}
//void updateImagePendu(int erreurs) {
// Mets à jour l'image selon le nombre d'erreurs
//  if (erreurs < 6) {
// Met à jour l'image du pendu
//    labelPendu.setIcon(new ImageIcon("path_to_image_" + erreurs + ".png"));
//}
//   }

