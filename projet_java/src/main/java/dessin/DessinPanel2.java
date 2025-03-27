/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */
public class DessinPanel2 extends JPanel {
  public DessinPanel2() {
        initGui();
    }

    private void initGui() {
        BorderLayout b2 = new BorderLayout(5, 5);
        this.setLayout(b2);
        this.add(new ArdoisePanel(), BorderLayout.CENTER);
        ArdoisePanel ardoise = new ArdoisePanel();
        this.add(ardoise);
        BoutonsdessinNiv2 boutons2 = new BoutonsdessinNiv2(ardoise);
        this.add(boutons2, BorderLayout.EAST);
    }  
}
