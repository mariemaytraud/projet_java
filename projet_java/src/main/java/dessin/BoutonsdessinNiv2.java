/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */
public class BoutonsdessinNiv2 extends JPanel {

    private Color couleur;

    public BoutonsdessinNiv2(ArdoisePanel ardoise) {
        this.setLayout(new GridLayout(0, 1));
        JButton palette = new JButton("Palette de couleurs");
        palette.setBackground(Color.CYAN);
        palette.addActionListener((e) -> {
           Color couleur = JColorChooser.showDialog(null,"aaaa",ardoise.getcouleurstylo());
           if (couleur != null){
           ardoise.setCouleurStylo(couleur);
           }
        });
        JButton gomme = new JButton("Gomme");
        gomme.setBackground(Color.LIGHT_GRAY);
        gomme.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.white);
            ardoise.setTailleStylo(20);
        });
        JButton effacer = new JButton("Tout effacer");
        effacer.setBackground(Color.LIGHT_GRAY);
        effacer.addActionListener((e) -> {
            ardoise.effacer();
        });
        JLabel taille = new JLabel();
        taille.setText("Taille du stylo:");
        taille.setForeground(Color.WHITE);
        JButton a = new JButton("2");
        a.setBackground(Color.LIGHT_GRAY);
        a.addActionListener((e) -> {
            ardoise.setTailleStylo(2);
        });
        JButton d = new JButton("5");
        d.setBackground(Color.LIGHT_GRAY);
        d.addActionListener((e) -> {
            ardoise.setTailleStylo(5);
        });
        JButton b = new JButton("10");
        b.setBackground(Color.LIGHT_GRAY);
        b.addActionListener((e) -> {
            ardoise.setTailleStylo(10);
        });
        JButton c = new JButton("15");
        c.setBackground(Color.LIGHT_GRAY);
        c.addActionListener((e) -> {
            ardoise.setTailleStylo(15);
        });
        this.add(palette);
        this.add(gomme);
        this.add(effacer);
        this.add(taille);
        this.add(a);
        this.add(d);
        this.add(b);
        this.add(c);
        this.setBackground(new Color(122, 89, 201));
    }

    public Color getColor() {
        return couleur;
    }
}