/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.BorderLayout;
import java.awt.Color;
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
        BorderLayout bl = new BorderLayout(5, 5);
        this.setLayout(bl);
        this.add(new ArdoisePanel(), BorderLayout.CENTER);
        ArdoisePanel ardoise = new ArdoisePanel();
        this.add(ardoise);
        FonctionsDessin boutons = new FonctionsDessin(ardoise);
        this.add(boutons, BorderLayout.EAST);
        Hautdepage haut = new Hautdepage(boutons);
        this.add(haut,BorderLayout.NORTH);
        this.setBackground(new Color(122, 89, 201));
    }

}
