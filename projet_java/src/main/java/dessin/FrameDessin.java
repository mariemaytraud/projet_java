/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import acceuil.MainFrame;
import javax.swing.JFrame;

/**
 *
 * @author Alexis Burgos
 */
public class FrameDessin {

    public FrameDessin() {
        JFrame frame = new JFrame("dessin (niveau 1)");
        //frame.add(new DessinPanel());
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
