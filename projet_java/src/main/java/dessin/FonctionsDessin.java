/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessin;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alexis Burgos
 */
public class FonctionsDessin extends JPanel {
    public FonctionsDessin(){
        this.add(new JButton("Vert"));
        this.add(new JButton("Rouge"));
        this.add(new JButton("Bleu"));
        this.add(new JButton("Gomme"));
        this.add(new JButton("Tout effacer"));
    }
    
}
