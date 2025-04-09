package pendu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * @author MARIE
 */

public class ClavierTestPanel extends JPanel {

    private PenduPanel jeu;  // changé de Test à PenduPanel
    ArrayList<JButton> boutons;

    public ClavierTestPanel(PenduPanel jeu) {
        this.jeu = jeu;
        this.boutons = new ArrayList<>();
        setLayout(new GridLayout(3, 9, 5, 5));

        for (char lettre = 'A'; lettre <= 'Z'; lettre++) {
            JButton btnLettre = new JButton(String.valueOf(lettre));
            boutons.add(btnLettre);
            btnLettre.setFont(new Font("Arial", Font.BOLD, 16));

            btnLettre.addActionListener(e -> {
                btnLettre.setEnabled(false);
                jeu.verifierLettre(btnLettre.getText().charAt(0));
            });

            add(btnLettre);
        }
    }

    public void resetClavier() {
        for (var bouton : boutons) {
            bouton.setEnabled(true);
        }
    }
}
