/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcul;

import acceuil.EntetePanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author cleme
 */
public class CalculPanel extends JPanel {
    public CalculPanel(JFrame parentFrame) {
        setLayout(new BorderLayout());

        // Ajouter l'entête avec le bouton retour 
        EntetePanel entete = new EntetePanel("Calcul Mental", parentFrame);
        add(entete, BorderLayout.NORTH);

        // Contenu du panneau
        JLabel label = new JLabel("Bienvenue dans Calcul Mental !", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
