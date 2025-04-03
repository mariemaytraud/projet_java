/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */
public class FonctionsDessin extends JPanel {

    private Color couleur;

    public FonctionsDessin(ArdoisePanel ardoise) {
        this.setLayout(new GridLayout(0, 1));
        JButton vert = new JButton("Vert");
        vert.setBackground(Color.GREEN);
        vert.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.green);
            ardoise.setTailleStylo(2);
        });
        JButton rouge = new JButton("Rouge");
        rouge.setBackground(Color.RED);
        rouge.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.RED);
            ardoise.setTailleStylo(2);
        });
        JButton bleu = new JButton("Bleu");
        bleu.setBackground(Color.BLUE);
        bleu.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.blue);
            ardoise.setTailleStylo(2);
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
        this.add(vert);
        this.add(bleu);
        this.add(rouge);
        this.add(gomme);
        this.add(effacer);
    }

    public Color getColor() {
        return couleur;
    }
}
