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
    private JButton verifierBtn;
    private JButton solutionBtn;
    private JButton nouveauBtn;

    public BoutonPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0)); // Disposition des boutons en ligne
        setBackground(Color.LIGHT_GRAY); // Fond gris clair

        // Création des boutons
        verifierBtn = new JButton("Vérifier");
        solutionBtn = new JButton("Solution");
        nouveauBtn = new JButton("Nouveau");

        verifierBtn.setFont(new Font("Arial", Font.BOLD, 30));
        solutionBtn.setFont(new Font("Arial", Font.BOLD, 30));
        nouveauBtn.setFont(new Font("Arial", Font.BOLD, 30));

        Dimension buttonSize = new Dimension(200, 60);
        verifierBtn.setPreferredSize(buttonSize);
        solutionBtn.setPreferredSize(buttonSize);
        nouveauBtn.setPreferredSize(buttonSize);
        // Ajout des boutons au panel
        add(verifierBtn);
        add(solutionBtn);
        add(nouveauBtn);
        
    }
    public JButton getVerifierBtn() {
        return verifierBtn;
    }

    public JButton getSolutionBtn() {
        return solutionBtn;
    }

    public JButton getNouveauBtn() {
        return nouveauBtn;
    }
}