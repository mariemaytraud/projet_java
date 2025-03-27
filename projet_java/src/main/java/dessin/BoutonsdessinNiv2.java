/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
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
        });
        JButton effacer = new JButton("Tout effacer");
        effacer.setBackground(Color.LIGHT_GRAY);
        effacer.addActionListener((e) -> {
            ardoise.effacer();
        });
        this.add(palette);
        this.add(gomme);
        this.add(effacer);
    }

    public Color getColor() {
        return couleur;
    }
}
