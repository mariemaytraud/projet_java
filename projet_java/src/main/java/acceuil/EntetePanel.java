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

public class EntetePanel extends JPanel {
    private JLabel titreLabel; // Label du titre

    public EntetePanel(String titre, JFrame parentFrame) {
        // Définir la disposition de l'en-tête
        setLayout(new BorderLayout());
        setBackground(new Color(30, 144, 255)); // Bleu

        // Bouton de retour / fermeture
        JButton boutonRetour = new JButton("Acceuil");
        boutonRetour.addActionListener(e -> {
            parentFrame.setContentPane(new JeuPanel(parentFrame));
            parentFrame.revalidate();
            parentFrame.repaint();
            });

        // Label du titre
        titreLabel = new JLabel(titre, SwingConstants.CENTER);
        titreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titreLabel.setForeground(Color.WHITE);

        // Ajouter les composants à l'en-tête
        add(boutonRetour, BorderLayout.WEST);
        add(titreLabel, BorderLayout.CENTER);
    }

    // Méthode pour mettre à jour le titre
    public void setTitre(String nouveauTitre) {
        titreLabel.setText(nouveauTitre);
    }
}