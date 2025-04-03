package pendu;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

   
public class Test extends JFrame {
    private JLabel labelMot;  // Label pour afficher le mot à deviner
    private String motADeviner;  // Le mot à deviner
    private char[] motAffiche;  // Mot sous forme "_ _ _ _"
    private int erreurs = 0 ; // init nb d'erreur 
    private JLabel labelErreurs; 
    private ImagePendu imagePendu ; 
    private ClavierTestPanel clavier ; 
    // Constructeur de la fenêtre
    public Test() {
       
        // Définir le titre de la fenêtre
        setTitle("Jeu du Pendu");

        // Définir la taille de la fenêtre
        setSize(600, 400);  // Taille personnalisée (largeur, hauteur)
       

        // Définir un layout pour la fenêtre (ici, un BorderLayout)
        setLayout(new BorderLayout());

        // Ajouter un panneau d'affichage (on va l'ajouter dans l'étape suivante)
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        
// Initialisation du mot à deviner avec MotsTest
        MotsTest motsTest = new MotsTest();
        motADeviner = motsTest.choisirMot();
        motAffiche = new char[motADeviner.length()];
        
// Remplir le mot affiché avec des underscores
        for (int i = 0; i < motAffiche.length; i++) {
            motAffiche[i] = '_';
        }
     
// Création du label pour afficher le mot sous "_ _ _"
        labelMot = new JLabel(new String(motAffiche));
        labelMot.setFont(new Font("Arial", Font.BOLD, 24));
        labelMot.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Ajout du label à la fenêtre
        add(labelMot, BorderLayout.NORTH);
        
// crea label erreurs 
    labelErreurs = new JLabel("Erreurs : 0 / 6");
    labelErreurs.setFont(new Font("Arial", Font.BOLD, 20));
    labelErreurs.setHorizontalAlignment(SwingConstants.CENTER);
    add(labelErreurs, BorderLayout.CENTER);
   
    // Ajouter le clavier en bas
   // ClavierTestPanel clavier = new ClavierTestPanel(this);
   clavier = new ClavierTestPanel(this);
   add(clavier, BorderLayout.SOUTH);
        
    // Création de l'image du pendu
        imagePendu = new ImagePendu();  // Initialisation de l'objet imagePendu
        add(imagePendu, BorderLayout.CENTER);  // Ajout du label dans le centre
       

// Rendre la fenêtre visible
        setVisible(true);
      
 }

    void verifierLettre(char lettre) {
    boolean trouve = false;
    
   for (int i = 0; i < motADeviner.length(); i++) {
       if (motADeviner.charAt(i) == lettre) {
            motAffiche[i] = lettre;
            trouve = true;
        }
    }

    // Mettre à jour l'affichage du mot
    labelMot.setText(new String(motAffiche));

// pour compter les erreurs ( en ajouter une qd lettre mauvaise) 
 if (!trouve) {
        erreurs++;
        labelErreurs.setText("Erreurs : " + erreurs + " / 6");
       imagePendu.incrementerErreurs();

// si le joueur a perdu 

if (erreurs >= 6) {
            JOptionPane.showMessageDialog(this, "Perdu ! Le mot était : " + motADeviner);
            resetGame();
            return; 
}
    // Si le joueur a trouvé le mot 
    if (new String(motAffiche).equals(motADeviner)) {
        JOptionPane.showMessageDialog(this, "Bravo ! Vous avez trouvé le mot : " + motADeviner);
        resetGame();
                
    }
}
}
    
 //  private JLabel labelPendu;

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
    
   
    
    // Réactiver tous les boutons du clavier
   // for (Component comp : getContentPane().getComponents()) {
     //   if (comp instanceof ClavierTestPanel ) {
     //      (( ClavierTestPanel) comp).resetClavier();
      //  }

    clavier.resetClavier(); 
    }
   public static void main(String[] args) {
      new Test();
    }   
}



    
   
