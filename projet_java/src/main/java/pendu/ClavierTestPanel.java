package pendu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author MARIE
 */

public class ClavierTestPanel extends JPanel {

    private Test jeu ;  // Référence au jeu principal

    public ClavierTestPanel(Test jeu) {
        this.jeu = jeu;  // Permet de communiquer avec la fenêtre principale

        setLayout(new GridLayout(3, 9, 5, 5));  // 3 lignes, 9 colonnes, avec un espacement

        // Créer les boutons pour chaque lettre de A à Z
        for (char lettre = 'A'; lettre <= 'Z'; lettre++) {
            JButton btnLettre = new JButton(String.valueOf(lettre));
            btnLettre.setFont(new Font("Arial", Font.BOLD, 16));

            // Ajouter un écouteur d'événement pour détecter les clics
            btnLettre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jeu.verifierLettre(btnLettre.getText().charAt(0));  // Appel de la méthode
                    btnLettre.setEnabled(false);  // Désactive le bouton après utilisation
                }
            });

            add(btnLettre);  // Ajouter le bouton au clavier
        }
    }
}


