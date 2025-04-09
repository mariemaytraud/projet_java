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
import javax.swing.*;
import java.awt.*;
import pendu.PenduPanel;

public class MainFrame extends JFrame {

    private CalculPanel calculPanel;
    private PenduPanel penduPanel;
    private DessinPanel dessinPanel; 
    // Instance de CalculPanel
    private JeuPanel jeuPanel;
    private int niveau;

    public MainFrame() {
        this("Jeu pour enfant");
    }

    public MainFrame(String title) {
        super(title);
        initGui();
    }

    private void initGui() {
        Container root = this.getContentPane();
        root.setLayout(new BorderLayout());

        // Création des composants
        EntetePanel entete = new EntetePanel("Jeux pour enfant", this);
        jeuPanel = new JeuPanel(this);
        NiveauPanel niv = new NiveauPanel();
        calculPanel = new CalculPanel(this);
        penduPanel = new PenduPanel(this);
        dessinPanel = new DessinPanel(this);
        JeuMenuBar menu = new JeuMenuBar(this, calculPanel, penduPanel); // Passer CalculPanel au menu

        // Configuration des tailles des panels
        entete.setPreferredSize(new Dimension(getWidth(), 100));
        jeuPanel.setPreferredSize(new Dimension(getWidth() / 2, getHeight()));
        niv.setPreferredSize(new Dimension(getWidth() / 2, getHeight()));

        // Ajouter les composants
        root.add(entete, BorderLayout.NORTH);

        // Panel contenant les deux parties (Jeu + Niveau)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.add(jeuPanel);
        mainPanel.add(niv);

        root.add(mainPanel, BorderLayout.CENTER);

        this.setJMenuBar(menu);

        // Configuration de la fenêtre
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public CalculPanel getCalculPanel() {
        return calculPanel;
    }

    public PenduPanel getPenduPanel() {
        return penduPanel;
    }
    public DessinPanel getDessinPanel() {
        return dessinPanel;
    }

    public JeuPanel getJeuPanel() {
        return jeuPanel;
    }
}
