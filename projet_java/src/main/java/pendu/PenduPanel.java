package pendu;

import acceuil.MainFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PenduPanel extends JPanel {

    private JLabel labelMot;
    private String motADeviner;
    private char[] motAffiche;
    private int erreurs = 0;
    private JLabel labelErreurs;
    private ImagePendu imagePendu;
    private ClavierTestPanel clavier;

    public PenduPanel(MainFrame parentFrame) {
        setLayout(new BorderLayout());

        // Init du mot à deviner
        MotsTest motsTest = new MotsTest();
        motADeviner = motsTest.choisirMot();
        motAffiche = new char[motADeviner.length()];
        for (int i = 0; i < motAffiche.length; i++) {
            motAffiche[i] = '_';
        }

        // Mot affiché
        labelMot = new JLabel(new String(motAffiche));
        labelMot.setFont(new Font("Arial", Font.BOLD, 24));
        labelMot.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelMot, BorderLayout.NORTH);

        // Image pendu
        imagePendu = new ImagePendu();
        add(imagePendu, BorderLayout.WEST);

        // Erreurs
        labelErreurs = new JLabel("Erreurs : 0 / 6");
        labelErreurs.setFont(new Font("Arial", Font.BOLD, 20));
        labelErreurs.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelErreurs, BorderLayout.CENTER);

        // Clavier
        clavier = new ClavierTestPanel(this);
        add(clavier, BorderLayout.SOUTH);
    }

    public void verifierLettre(char lettre) {
        boolean trouve = false;

        for (int i = 0; i < motADeviner.length(); i++) {
            if (motADeviner.charAt(i) == lettre) {
                motAffiche[i] = lettre;
                trouve = true;
            }
        }

        labelMot.setText(new String(motAffiche));

        if (!trouve) {
            erreurs++;
            labelErreurs.setText("Erreurs : " + erreurs + " / 6");
            imagePendu.incrementerErreurs();

            if (erreurs >= 6) {
                JOptionPane.showMessageDialog(this, "Perdu ! Le mot était : " + motADeviner);
                resetGame();
                return;
            }
        }

        if (new String(motAffiche).equals(motADeviner)) {
            JOptionPane.showMessageDialog(this, "Bravo ! Vous avez trouvé le mot : " + motADeviner);
            resetGame();
        }
    }

    private void resetGame() {
        MotsTest motsTest = new MotsTest();
        motADeviner = motsTest.choisirMot();
        motAffiche = new char[motADeviner.length()];
        erreurs = 0;
        imagePendu.resetErreurs();

        for (int i = 0; i < motAffiche.length; i++) {
            motAffiche[i] = '_';
        }

        labelMot.setText(new String(motAffiche));
        labelErreurs.setText("Erreurs : 0 / 6");
        clavier.resetClavier();
    }
}
