/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Alexis Burgos
 */
public class TestDessinNiv2 {
   public static void main(String[] args) {
        JFrame frame = new JFrame("Dessin (Niveau 2)");
        frame.add(new DessinPanel2());
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    } 
}
