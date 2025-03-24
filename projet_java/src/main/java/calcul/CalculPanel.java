/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcul;

import acceuil.EntetePanel;
import javax.swing.*;
import java.awt.*;

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
        
        BoutonPanel boutonPanel = new BoutonPanel();
        add(boutonPanel, BorderLayout.SOUTH);
        
        ZonePanel zonePanel = new ZonePanel();
        add(zonePanel, BorderLayout.CENTER);
    }
}