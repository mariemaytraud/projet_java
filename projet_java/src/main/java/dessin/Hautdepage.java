/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Alexis Burgos
 */
public class Hautdepage extends JPanel {

    public Hautdepage() {
        Color rouge = new Color(122, 89, 201);
        Color blanc = new Color(255, 255, 250);
        BorderLayout bl = new BorderLayout(5, 5);
        this.setLayout(bl);
        JButton acceuil = new JButton("acceuil");
        this.add(acceuil, BorderLayout.WEST);
        acceuil.setBackground(blanc);
        JLabel titre = new JLabel();
        titre.setText("Dessin");
        titre.setForeground(Color.WHITE);
        this.add(titre, BorderLayout.EAST);
        this.setBackground(rouge);
    }

}
