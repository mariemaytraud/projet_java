/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */
public class DessinPanel extends JPanel {

    public DessinPanel() {
        initGui();
    }

    private void initGui() {
        // Créer un conteneur global avec un BorderLayout
        BorderLayout bl = new BorderLayout(5, 5);
        this.setLayout(bl);
        this.setLayout(new GridLayout(1, 2));
        this.add(new ArdoisePanel(), BorderLayout.CENTER);
        ArdoisePanel ardoise = new ArdoisePanel();
        this.add(ardoise);
        FonctionsDessin boutons = new FonctionsDessin();
        this.add(boutons);
    }

}
