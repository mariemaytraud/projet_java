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

    public Hautdepage(FonctionsDessin fonctions) {
        Color rouge = new Color(122, 89, 201);
        Color blanc = new Color(255, 255, 250);
        BorderLayout bl = new BorderLayout(5, 5);
        this.setLayout(bl);
        JButton acceuil = new JButton("acceuil");
        acceuil.addActionListener((e) -> {
            
        });
        this.add(acceuil, BorderLayout.WEST);
        acceuil.setBackground(blanc);
        JLabel titre = new JLabel();
        titre.setText("Dessin");
        titre.setForeground(Color.WHITE);
        this.add(titre, BorderLayout.EAST);
        this.setBackground(rouge);
        JMenuBar m= new JMenuBar();
        JMenu niveau = new JMenu("niveau");
        JMenuItem n1 =new JMenuItem("niveau 1");
        niveau.add(n1);
        n1.addActionListener((e) -> {
            fonctions.setNiveau(1);
        });
        JMenuItem n2 =new JMenuItem("niveau 2");
        niveau.add(n2);
        n2.addActionListener((e) -> {
            fonctions.setNiveau(2);
        });
        m.add(niveau);
        this.add(m,BorderLayout.NORTH);
    }
}