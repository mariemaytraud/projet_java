/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import javax.swing.JFrame;

/**
 *
 * @author Alexis Burgos
 */
public class TestDessin {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new DessinPanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
