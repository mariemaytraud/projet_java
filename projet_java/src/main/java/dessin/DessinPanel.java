/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import acceuil.EntetePanel;
import acceuil.MainFrame;
import java.awt.BorderLayout;
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
public class DessinPanel extends JPanel {
    
    private Color couleur;
    private int niveau = 1;
    private ArdoisePanel ardoise;
    private MainFrame parentFrame;
    
    // Boutons de dessin
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
    private JPanel fonctionsPanel;

    public DessinPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        initGui();
    }

    private void initGui() { 
        // Configuration du layout principal
        BorderLayout bl = new BorderLayout(5, 5);
        this.setLayout(bl);
        
        // Création de l'ardoise (zone de dessin)
        EntetePanel entete = new EntetePanel("Ardoise Magique", parentFrame);
        add(entete, BorderLayout.NORTH);
        ardoise = new ArdoisePanel();
        this.add(ardoise, BorderLayout.CENTER);
        
        // Création du panneau de fonctions (boutons)
        fonctionsPanel = createFonctionsPanel();
        this.add(fonctionsPanel, BorderLayout.EAST);
                
        // Couleur de fond
        this.setBackground(new Color(122, 89, 201));
    }
    
    private JPanel createFonctionsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        
        // Création des composants
        creerComposants();        
        // Afficher les composants selon le niveau
        afficherSelonNiveau(panel);
        
        return panel;
    }
    
    private void creerComposants() {
        vert = new JButton("Vert");
        vert.setBackground(Color.GREEN);
        vert.addActionListener((e) -> {
            ardoise.setCouleurStylo(Color.GREEN);
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
            ardoise.setCouleurStylo(Color.BLUE);
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
            ardoise.setCouleurStylo(Color.WHITE);
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
    private void afficherSelonNiveau(JPanel panel) {
        panel.removeAll(); // Supprimer tous les composants

        if (niveau == 1) {
            
            ardoise.setCouleurStylo(Color.BLUE);
            panel.add(vert);
            panel.add(bleu);
            panel.add(rouge);
            panel.add(gomme);
            panel.add(effacer);
        } else if (niveau == 2) {
            
            ardoise.setCouleurStylo(Color.BLUE);
            panel.add(palette);
            panel.add(gomme);
            panel.add(effacer);
            panel.add(tailleLabel);
            panel.add(taille2);
            panel.add(taille5);
            panel.add(taille10);
            panel.add(taille15);
        }

        panel.revalidate();
        panel.repaint();
    }
    
    // Méthode pour mettre à jour le niveau et rafraîchir l'interface
    public void setNiveau(int nouveauNiveau) {
        this.niveau = nouveauNiveau;
        System.out.println("DessinPanel - Nouveau niveau : " + this.niveau);
        afficherSelonNiveau(fonctionsPanel);
    }
    
    public int getNiveau() {
        return niveau;
    }
    
    public Color getColor() {
        return couleur;
    }
    
    // Méthode pour accéder à l'ardoise
    public ArdoisePanel getArdoise() {
        return ardoise;
    }
}
