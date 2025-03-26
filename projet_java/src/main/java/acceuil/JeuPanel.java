/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceuil;

import calcul.CalculPanel;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author cleme
 */
import java.awt.GridLayout;
import javax.swing.*;

public class JeuPanel extends JPanel {
    private JFrame parentFrame;
    public JeuPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridLayout(0, 1, 30, 30));

        JButton jb1 = new JButton("Ardoise Magique");
        JButton jb2 = new JButton("Calcul Mental");
        JButton jb3 = new JButton("Pendu");
        
        Dimension buttonSize = new Dimension(120, 40);
        jb1.setPreferredSize(buttonSize);
        jb2.setPreferredSize(buttonSize);
        jb3.setPreferredSize(buttonSize);


        setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        jb1.setBackground(new java.awt.Color(0xA962A4));
        jb2.setBackground(new java.awt.Color(0xEFF397));
        jb3.setBackground(new java.awt.Color(0xB1D8E4));

        add(jb1);
        add(jb2);
        add(jb3);
        jb2.addActionListener(e -> {
        parentFrame.setContentPane(new CalculPanel(parentFrame));
        parentFrame.revalidate();
        parentFrame.repaint();
        });
    }
}