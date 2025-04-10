/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceuil;

/**
 *
 * @author cleme
 */
import calcul.CalculPanel;
import dessin.DessinPanel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pendu.PenduPanel;
import admin.AdminContainerPanel;

public class JeuMenuBar extends JMenuBar {
    private final JFrame parentFrame;
    private final CalculPanel calculPanel;
    private final PenduPanel penduPanel;
    private final DessinPanel dessinPanel;
    private final AdminContainerPanel adminPanel;
    
    private int niveau;

    public JeuMenuBar(JFrame parentFrame, CalculPanel calculPanel, PenduPanel penduPanel,DessinPanel dessinPanel, AdminContainerPanel adminPanel) {
        this.parentFrame = parentFrame;
        this.calculPanel = calculPanel;
        this.penduPanel = penduPanel;
        this.dessinPanel = dessinPanel;
        this.adminPanel = adminPanel ; 
        // Les entêtes du menu
        JMenu jeu = new JMenu("Jeux");
        JMenu niv = new JMenu("Niveaux");
        JMenu admin = new JMenu("Administrateur");

        // Les items du menu
        JMenuItem dessin = new JMenuItem("Ardoise Magique");
        JMenuItem calcul = new JMenuItem("Calcul Mental");
        JMenuItem pendu = new JMenuItem("Pendu");
        JMenuItem niv1 = new JMenuItem("Niveau 1");
        JMenuItem niv2 = new JMenuItem("Niveau 2");
        JMenuItem mdp = new JMenuItem("Mot de passe");

        jeu.add(dessin);
        jeu.add(calcul);
        jeu.add(pendu);
        niv.add(niv1);
        niv.add(niv2);
        admin.add(mdp);
        
       
        this.add(jeu);
        this.add(niv);
        this.add(admin);

        // Action : Ouvrir le jeu de calcul mental
        calcul.addActionListener(e -> {
            parentFrame.setContentPane(calculPanel);
            parentFrame.revalidate();
            parentFrame.repaint();
        });
        pendu.addActionListener(e -> {
            parentFrame.setContentPane(penduPanel);
            parentFrame.revalidate();
            parentFrame.repaint();
        });
        dessin.addActionListener(e -> {
            parentFrame.setContentPane(dessinPanel);
            parentFrame.revalidate();
            parentFrame.repaint();
        });
        

        mdp.addActionListener(e-> {
            parentFrame.setContentPane(adminPanel);
            parentFrame.revalidate();
            parentFrame.repaint();
        }
        );
        // Action : Modifier le niveau
        niv1.addActionListener(e -> {
            dessinPanel.setNiveau(1);
            if (calculPanel != null) {
                calculPanel.setNiveau(1);
            }
        });

        niv2.addActionListener(e -> {
            dessinPanel.setNiveau(2);
            if (calculPanel != null) {
                calculPanel.setNiveau(2);
            }
        });
    }
}
