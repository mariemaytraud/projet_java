/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
/**
 *
 * @author Alexis Burgos
 */
public class ArdoisePanel extends JPanel{
   private ArrayList<Point> points = new ArrayList<>(); // Liste des points dessinés

    public ArdoisePanel() {
        this.setBackground(Color.WHITE);
        // Ajouter un écouteur de souris pour dessiner en temps réel
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint()); // Ajouter le point actuel à la liste
                repaint(); // Redessiner la zone
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK); // Couleur du dessin
        for (int i = 1; i < points.size (); i++) {
            g.drawLine(points.get(i - 1).x, points.get(i - 1).y, points.get(i).x, points.get(i).y);
        }
    }

    public void clear() {
        points.clear(); // Effacer les points
        repaint();
    }
}
