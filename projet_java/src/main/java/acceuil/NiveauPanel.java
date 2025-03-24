/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceuil;

import calcul.CalculPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author cleme
 */
public class NiveauPanel extends JPanel {
    public NiveauPanel() {
        GridLayout gl = new GridLayout(0, 1, 3, 3);
        this.setLayout(gl);

        JButton jb1 = new JButton("Niveau 1");
        JButton jb2 = new JButton("Niveau 2");
        jb1.setForeground(java.awt.Color.black);
        jb1.setBackground(java.awt.Color.green);
        this.add(jb1);
        jb2.setForeground(java.awt.Color.black);
        jb2.setBackground(java.awt.Color.red);
        this.add(jb2);
    }
}
