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
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */
public class FonctionsDessin extends JPanel {
    private Color couleur;
    public FonctionsDessin() {
        this.setLayout(new GridLayout(0, 1));
        JButton vert = new JButton("Vert");
        vert.setBackground(Color.GREEN);
        vert.addActionListener((e) -> {
            couleur = vert.getBackground();
        });
        JButton rouge = new JButton("Rouge");
        rouge.setBackground(Color.RED);
        rouge.addActionListener((e) -> {
            couleur = rouge.getBackground();
        });
        JButton bleu = new JButton("Bleu");
        bleu.setBackground(Color.BLUE);
        bleu.addActionListener((e) -> {
            couleur = bleu.getBackground();
        });
        JButton gomme = new JButton("Gomme");
        JButton effacer = new JButton("Tout effacer");

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

