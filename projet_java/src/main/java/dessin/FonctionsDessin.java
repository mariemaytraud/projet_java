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
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */


public class FonctionsDessin extends JPanel {

    private Color couleur;
    private int niveau = 1; // Le niveau sera défini par l'extérieur
    private ArdoisePanel ardoise; // Référence à votre panneau de dessin

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

    public FonctionsDessin(ArdoisePanel ardoise) {
        this.ardoise = ardoise;
        this.setLayout(new GridLayout(0, 1));
        creerComposants(); // Créer les composants une seule fois
        afficherSelonNiveau(); // Afficher les composants en fonction du niveau initial (par défaut)
    }

    private void creerComposants() {
        vert = new JButton("Vert");
        vert.setBackground(Color.GREEN);
        vert.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.green);
            ardoise.setTailleStylo(2);
        });

        rouge = new JButton("Rouge");
        rouge.setBackground(Color.RED);
        rouge.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.RED);
            ardoise.setTailleStylo(2);
        });

        bleu = new JButton("Bleu");
        bleu.setBackground(Color.BLUE);
        bleu.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.blue);
            ardoise.setTailleStylo(2);
        });

        palette = new JButton("Palette de couleurs");
        palette.setBackground(Color.CYAN);
        palette.addActionListener((e) -> {
            Color couleur = JColorChooser.showDialog(null, "Choisir une couleur", ardoise.getcouleurstylo());
            if (couleur != null) {
                ardoise.setCouleurStylo(couleur);
                ardoise.setTailleStylo(2);
            }
        });

        gomme = new JButton("Gomme");
        gomme.setBackground(Color.LIGHT_GRAY);
        gomme.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.white);
            ardoise.setTailleStylo(20);
        });

        effacer = new JButton("Tout effacer");
        effacer.setBackground(Color.LIGHT_GRAY);
        effacer.addActionListener((e) -> {
            ardoise.effacer();
        });

        tailleLabel = new JLabel("Taille du stylo:");
        tailleLabel.setForeground(Color.BLACK);

        taille2 = new JButton("2");
        taille2.setBackground(Color.LIGHT_GRAY);
        taille2.addActionListener((e) -> {
            ardoise.setTailleStylo(2);
        });

        taille5 = new JButton("5");
        taille5.setBackground(Color.LIGHT_GRAY);
        taille5.addActionListener((e) -> {
            ardoise.setTailleStylo(5);
        });

        taille10 = new JButton("10");
        taille10.setBackground(Color.LIGHT_GRAY);
        taille10.addActionListener((e) -> {
            ardoise.setTailleStylo(10);
        });

        taille15 = new JButton("15");
        taille15.setBackground(Color.LIGHT_GRAY);
        taille15.addActionListener((e) -> {
            ardoise.setTailleStylo(15);
        });
    }

    // Méthode pour afficher les composants en fonction du niveau
    public void afficherSelonNiveau() {
        this.removeAll(); // Supprimer tous les composants

        if (niveau == 1) {
            ardoise.setCouleurStylo(Color.BLUE);
            this.add(vert);
            this.add(bleu);
            this.add(rouge);
            this.add(gomme); // Ces boutons sont toujours présents
            this.add(effacer);
        } else if (niveau == 2) {
            ardoise.setCouleurStylo(Color.BLUE);
            this.add(palette);
            this.add(gomme); // Ces boutons sont toujours présents
            this.add(effacer);
            this.add(tailleLabel);
            this.add(taille2);
            this.add(taille5);
            this.add(taille10);
            this.add(taille15);
        }

        revalidate(); // Indiquer au gestionnaire de mise en page de recalculer la disposition
        repaint();    // Redessiner le panneau
    }

    public Color getColor() {
        return couleur;
    }

    public int getNiveau() {
        return niveau;
    }

    // Setter pour changer le niveau et mettre à jour l'affichage
    public final void setNiveau(int nouveauNiveau) {
        this.niveau = nouveauNiveau;
        System.out.println("FonctionsDessin - Nouveau niveau : " + this.niveau);
        afficherSelonNiveau(); // Appeler la méthode pour réafficher les composants
    }
}
