/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */
public class ArdoisePanel extends JPanel {

    private int xor, yor;
    private Color couleurStylo = Color.BLACK;
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
                var gc = ArdoisePanel.this.getGraphics();
                gc.setColor(couleurStylo);
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
}
