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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class ZonePanel extends JPanel {
    private int nombre1;
    private int nombre2;
    private JTextField reponseField;

    public ZonePanel() {
        setBackground(Color.WHITE); // Fond blanc
        setPreferredSize(new Dimension(400, 200)); // Taille fixe
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50)); // Centrage

        // Générer deux nombres aléatoires
        Random rand = new Random();
        nombre1 = rand.nextInt(10) + 1; // Nombre entre 1 et 10
        nombre2 = rand.nextInt(10) + 1;

        // Label affichant l'opération
        JLabel operationLabel = new JLabel(nombre1 + " + " + nombre2 + " = ? ");
        operationLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Champ de saisie pour la réponse
        reponseField = new JTextField(5);
        reponseField.setFont(new Font("Arial", Font.PLAIN, 18));

        // Empêcher la saisie de caractères non numériques
        reponseField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // Si ce n'est pas un chiffre
                    e.consume(); // Bloquer la saisie
                }
            }
        });

        // Ajouter les composants
        add(operationLabel);
        add(reponseField);
    }

    // Méthode pour récupérer la réponse entrée
    public int getReponse() {
        try {
            return Integer.parseInt(reponseField.getText());
        } catch (NumberFormatException e) {
            return -1; // Retourne -1 si aucun nombre valide n'est entré
        }
    }

    // Méthode pour vérifier la réponse
    public boolean isCorrect() {
        return getReponse() == (nombre1 + nombre2);
    }
}

