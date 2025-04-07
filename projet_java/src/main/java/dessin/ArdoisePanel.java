/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */
public class ArdoisePanel extends JPanel {

    private int xor, yor;
    private Color couleurStylo = Color.BLUE;
    private int tailleStylo = 2;

    public ArdoisePanel() {
        this.setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xor = e.getX();
                yor = e.getY();
            }

        });
        // Ajouter un écouteur de souris pour dessiner en temps réel
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics2D gc = (Graphics2D) getGraphics();
                gc.setColor(couleurStylo);
                gc.setStroke(new BasicStroke(tailleStylo));
                gc.drawLine(xor, yor, e.getX(), e.getY());
                xor = e.getX();
                yor = e.getY();
            }
        });

    }

    public void setCouleurStylo(Color couleur) {
        this.couleurStylo = couleur;
    }

    public void effacer() {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    public Color getcouleurstylo() {
        return couleurStylo;
    }

    public void setTailleStylo(int taille) {
        this.tailleStylo = taille;
    }

}
