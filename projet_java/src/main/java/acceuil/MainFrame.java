/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceuil;


/**
 *
 * @author cleme
 */
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this("Jeu pour enfant");
    }

    public MainFrame(String title) {
        super(title);
        initGui();
    }

    private void initGui() {
    Container root = this.getContentPane(); // On modifie le contenu de la JFrame
    BorderLayout b1 = new BorderLayout(5, 5);
    root.setLayout(b1);EntetePanel entete = new EntetePanel("Jeux pour enfant", this);
    

    // Initialisation des composants
    JeuPanel jeu = new JeuPanel(this);
    NiveauPanel niv = new NiveauPanel();
    JeuMenuBar menu = new JeuMenuBar(this);

    // Ajout des composants
    root.add(entete, BorderLayout.PAGE_START);
    root.add(jeu, BorderLayout.WEST);
    root.add(niv, BorderLayout.CENTER);
    this.setJMenuBar(menu);
        

    // Configuration de la fenêtre
    setSize(500, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);
}


}
