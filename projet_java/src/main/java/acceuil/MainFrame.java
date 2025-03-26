/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceuil;


/**
 *
 * @author cleme
 */
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this("Jeu pour enfant");
    }

    public MainFrame(String title) {
        super(title);
        initGui();
    }

    private void initGui() {
        Container root = this.getContentPane();
        root.setLayout(new BorderLayout()); // Utiliser BorderLayout

        // Création des composants
        EntetePanel entete = new EntetePanel("Jeux pour enfant", this);
        JeuPanel jeu = new JeuPanel(this);
        NiveauPanel niv = new NiveauPanel();
        JeuMenuBar menu = new JeuMenuBar(this);

        // Configuration des tailles des panels
        entete.setPreferredSize(new Dimension(getWidth(), 100)); // Hauteur fixe pour l'entête
        jeu.setPreferredSize(new Dimension(getWidth() / 2, getHeight())); // 50% de la largeur
        niv.setPreferredSize(new Dimension(getWidth() / 2, getHeight())); // 50% de la largeur

        // Ajouter les composants
        root.add(entete, BorderLayout.NORTH);

        // Panel contenant les deux parties (Jeu + Niveau)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2)); // 1 ligne, 2 colonnes (chacun 50%)
        mainPanel.add(jeu);
        mainPanel.add(niv);

        root.add(mainPanel, BorderLayout.CENTER);

        this.setJMenuBar(menu);

        // Configuration de la fenêtre
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Plein écran
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}