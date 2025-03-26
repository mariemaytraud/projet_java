/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcul;

/**
 *
 * @author cleme
 */
import javax.swing.*;
import java.awt.*;

public class BoutonPanel extends JPanel {
    public BoutonPanel() {
        setLayout(new FlowLayout()); // Disposition des boutons en ligne
        setBackground(Color.LIGHT_GRAY); // Fond gris clair

        // Création des boutons
        JButton verifierBtn = new JButton("Vérifier");
        JButton solutionBtn = new JButton("Solution");
        JButton nouveauBtn = new JButton("Nouveau");

        Dimension buttonSize = new Dimension(120, 40);
        verifierBtn.setPreferredSize(buttonSize);
        solutionBtn.setPreferredSize(buttonSize);
        nouveauBtn.setPreferredSize(buttonSize);
        // Ajout des boutons au panel
        add(verifierBtn);
        add(solutionBtn);
        add(nouveauBtn);
        nouveauBtn.addActionListener(e -> System.out.println("new"));
    }
}