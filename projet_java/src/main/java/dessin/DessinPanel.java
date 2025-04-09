/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import acceuil.EntetePanel;
import acceuil.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alexis Burgos
 */
public class DessinPanel extends JPanel {

    private ArdoisePanel ardoise;
    private Color couleur;
    private int niveau = 1; // Le niveau sera défini par l'extérieur

    private JButton vert;
    private JButton rouge;
    private JButton bleu;
    private JButton palette;
    private JLabel tailleLabel;
    private JButton taille2;
    private JButton taille5;
    private JButton taille10;
    private JButton taille15;
    private JButton gomme;
    private JButton effacer;

    public DessinPanel(MainFrame parentFrame) {
        this.setLayout(new BorderLayout(5, 5));
        ardoise = new ArdoisePanel(); // Initialisation de l'ardoise
        this.add(ardoise, BorderLayout.CENTER);

        creerComposants(); // Créer les composants de contrôle (boutons)
        afficherSelonNiveau(); // Afficher les composants en fonction du niveau initial
        this.setBackground(new Color(122, 89, 201));

        // Ajouter l'entête
        EntetePanel entetePanel = new EntetePanel("Ardoise Magique", parentFrame);
        this.add(entetePanel, BorderLayout.NORTH);
    }

    private void creerComposants() {
        // Initialisation des boutons de couleurs
        vert = new JButton("Vert");
        vert.setBackground(Color.GREEN);
        vert.addActionListener(e -> {
            ardoise.setCouleurStylo(Color.green);
            ardoise.setTailleStylo(2);
        });

        rouge = new JButton("Rouge");
        rouge.setBackground(Color.RED);
        rouge.addActionListener(e -> {
            ardoise.setCouleurStylo(Color.RED);
            ardoise.setTailleStylo(2);
        });

        bleu = new JButton("Bleu");
        bleu.setBackground(Color.BLUE);
        bleu.addActionListener(e -> {
            ardoise.setCouleurStylo(Color.blue);
            ardoise.setTailleStylo(2);
        });

        palette = new JButton("Palette de couleurs");
        palette.setBackground(Color.CYAN);
        palette.addActionListener(e -> {
            Color couleur = JColorChooser.showDialog(null, "Choisir une couleur", ardoise.getcouleurstylo());
            if (couleur != null) {
                ardoise.setCouleurStylo(couleur);
                ardoise.setTailleStylo(2);
            }
        });

        gomme = new JButton("Gomme");
        gomme.setBackground(Color.LIGHT_GRAY);
        gomme.addActionListener(e -> {
            ardoise.setCouleurStylo(Color.white);
            ardoise.setTailleStylo(20);
        });

        effacer = new JButton("Tout effacer");
        effacer.setBackground(Color.LIGHT_GRAY);
        effacer.addActionListener(e -> ardoise.effacer());

        tailleLabel = new JLabel("Taille du stylo:");
        tailleLabel.setForeground(Color.BLACK);

        taille2 = new JButton("2");
        taille2.setBackground(Color.LIGHT_GRAY);
        taille2.addActionListener(e -> ardoise.setTailleStylo(2));

        taille5 = new JButton("5");
        taille5.setBackground(Color.LIGHT_GRAY);
        taille5.addActionListener(e -> ardoise.setTailleStylo(5));

        taille10 = new JButton("10");
        taille10.setBackground(Color.LIGHT_GRAY);
        taille10.addActionListener(e -> ardoise.setTailleStylo(10));

        taille15 = new JButton("15");
        taille15.setBackground(Color.LIGHT_GRAY);
        taille15.addActionListener(e -> ardoise.setTailleStylo(15));
    }

    // Méthode pour afficher les composants en fonction du niveau
    public void afficherSelonNiveau() {
        this.removeAll(); // Supprimer tous les composants précédents

        if (niveau == 1) {
            // Niveau 1 : Configuration pour un simple dessin
            ardoise.setCouleurStylo(Color.BLUE); // Définir la couleur initiale
            this.add(vert);
            this.add(bleu);
            this.add(rouge);
            this.add(gomme); // Ces boutons sont toujours présents
            this.add(effacer);
        } else if (niveau == 2) {
            // Niveau 2 : Configuration avec palette et tailles supplémentaires
            ardoise.setCouleurStylo(Color.BLUE); // Définir la couleur initiale
            this.add(palette);
            this.add(gomme); // Ces boutons sont toujours présents
            this.add(effacer);
            this.add(tailleLabel);
            this.add(taille2);
            this.add(taille5);
            this.add(taille10);
            this.add(taille15);
        }

        revalidate(); // Recalculer la disposition des composants
        repaint();    // Redessiner le panneau
    }

    // Méthode pour changer le niveau
    public void setNiveau(int nouveauNiveau) {
        this.niveau = nouveauNiveau;
        afficherSelonNiveau(); // Mettre à jour les composants en fonction du nouveau niveau
    }
}
