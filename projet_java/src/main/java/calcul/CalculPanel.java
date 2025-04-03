/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcul;

import acceuil.EntetePanel;
import acceuil.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 *
 * @author cleme
 */
public class CalculPanel extends JPanel {

    private int nombre1;
    private int nombre2;
    private int resultatAttendu;
    private String operation;
    private int niveau;
    private ZonePanel zonePanel;
    private final BoutonPanel boutonPanel;

    public CalculPanel(MainFrame parentFrame) {
        this.niveau = 1;
        setLayout(new BorderLayout());
        EntetePanel entete = new EntetePanel("Calcul Mental", parentFrame);
        add(entete, BorderLayout.NORTH);

        // Ajouter l'entête avec le bouton retour
        // Création des panneaux ZonePanel et BoutonPanel
        zonePanel = new ZonePanel(); // On passe le niveau
        boutonPanel = new BoutonPanel();

        // Ajout des panneaux au CalculPanel
        add(zonePanel, BorderLayout.CENTER);
        add(boutonPanel, BorderLayout.SOUTH);
        boutonPanel.getNouveauBtn().addActionListener(e -> nouveauCalcul());
        boutonPanel.getVerifierBtn().addActionListener(e -> checkAnswer());
        boutonPanel.getSolutionBtn().addActionListener(e -> zonePanel.afficherSolution(resultatAttendu));
        nouveauCalcul();

    }    

    // Getter pour récupérer le niveau
    public int getNiveau() {
        return niveau;
    }

    // Setter pour changer le niveau
    public final void setNiveau(int niveau) {
        this.niveau = niveau;
        System.out.println("CalculPanel - Nouveau niveau : " + this.niveau); // Debug
        nouveauCalcul();
    }

    public final void nouveauCalcul() {
        tirage();
        zonePanel.afficherQuestion(nombre1, nombre2, operation);
        zonePanel.messageLabel.setText("");
    }

    private void tirage() {
        Random rand = new Random();
        if (niveau == 1) {
            String[] signes = {"+", "-"};
            operation = signes[rand.nextInt(signes.length)];
            int maxRange = 10;
            nombre1 = rand.nextInt(maxRange) + 1;
            nombre2 = rand.nextInt(maxRange) + 1;
            if (operation.equals("-") && nombre1 < nombre2) {
                int temp = nombre1;
                nombre1 = nombre2;
                nombre2 = temp;
            }
        } else {
            String[] signes = {"+", "-", "*"};
            operation = signes[rand.nextInt(signes.length)];
            final int maxRange = operation.equals("*") ? 10 : 1000;
            nombre1 = rand.nextInt(maxRange) + 1;
            nombre2 = rand.nextInt(maxRange) + 1;
            if (operation.equals("-") && nombre1 < nombre2) {
                int temp = nombre1;
                nombre1 = nombre2;
                nombre2 = temp;
            }
        }
        resultatAttendu = switch (operation) {
            case "+" ->
                nombre1 + nombre2;
            case "-" ->
                nombre1 - nombre2;
            case "*" ->
                nombre1 * nombre2;
            default ->
                0;
        };
    }

    public void checkAnswer() {
        try {
            if (isCorrect()) {
                zonePanel.messageLabel.setText("Bravo ! Bonne réponse ");
                zonePanel.messageLabel.setForeground(Color.GREEN);
                zonePanel.messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                zonePanel.messageLabel.setText("Mauvaise réponse, Essayez encore !");
                zonePanel.messageLabel.setForeground(Color.RED);
                zonePanel.messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            }
        } catch (NumberFormatException e) {
            zonePanel.messageLabel.setText("Veuillez entrer une réponse valide avant de valider !");
            zonePanel.messageLabel.setForeground(Color.RED);
            zonePanel.messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    public boolean isCorrect() {
        int reponseUtilisateur;
        try {
            reponseUtilisateur = zonePanel.getReponse();
        } catch (NumberFormatException e) {
            return false;
        }
        return reponseUtilisateur == resultatAttendu;
    }
}