

package pendu;

/**
 *
 * @author MARIE
 */


import acceuil.EntetePanel;
import acceuil.MainFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
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
        EntetePanel entete = new EntetePanel("Pendu", parentFrame);
        add(entete, BorderLayout.PAGE_START);


        // Init du mot à deviner
        MotsTest motsTest = new MotsTest();
        motADeviner = motsTest.choisirMot();
        motAffiche = new char[motADeviner.length()];
        for (int i = 0; i < motAffiche.length; i++) {
            motAffiche[i] = '_';
        }
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));
        // Mot affiché
        labelMot = new JLabel(new String(motAffiche));
        labelMot.setFont(new Font("Arial", Font.BOLD, 24));
        labelMot.setHorizontalAlignment(SwingConstants.CENTER);
        labelMot.setAlignmentX(CENTER_ALIGNMENT);  // Centre le label dans le panel
      //  add(labelMot, BorderLayout.EAST);

        // Image pendu
        imagePendu = new ImagePendu();
        add(imagePendu, BorderLayout.WEST);

        // Erreurs
        labelErreurs = new JLabel("Erreurs : 0 / 6");
        labelErreurs.setFont(new Font("Arial", Font.BOLD, 20));
        labelErreurs.setHorizontalAlignment(SwingConstants.CENTER);
        //add(labelErreurs, BorderLayout.CENTER);
         labelErreurs.setAlignmentX(CENTER_ALIGNMENT);
        
         // Ajout des labels dans le centrePanel (le label du mot au-dessus du label des erreurs)
        centrePanel.add(labelMot);
        centrePanel.add(labelErreurs);

        // On ajoute le centrePanel dans la zone centrale du BorderLayout
        add(centrePanel, BorderLayout.CENTER);

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
