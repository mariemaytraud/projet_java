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
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JeuMenuBar extends JMenuBar{
    private JFrame parentFrame;
    public JeuMenuBar(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        // Les entêtes du menu
        JMenu jeu = new JMenu("Jeux");
        JMenu niv = new JMenu("Niveaux");
        JMenu admin = new JMenu("Compte");
        // Les items du menu calcul
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
        calcul.addActionListener(e -> {
        parentFrame.setContentPane(new CalculPanel(parentFrame));
        parentFrame.revalidate();
        parentFrame.repaint();
        });
        niv1.addActionListener(e -> System.out.println("niv1"));
        niv2.addActionListener(e -> System.out.println("niv2"));
        mdp.addActionListener(e -> System.out.println("admin"));
    }
}