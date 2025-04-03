package pendu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MARIE
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MotsTest {
    
    private List<String> listeMots;

    public MotsTest() {
        listeMots = new ArrayList<>();
        // Ajouter quelques mots à deviner
        listeMots.add("JAVA");
        listeMots.add("PROGRAMMATION");
        listeMots.add("PENDU");
        listeMots.add("JEUX");
        listeMots.add("ALGORITHME");
        listeMots.add("ORDINATEUR");
    }

    // Méthode pour choisir un mot aléatoirement
    public String choisirMot() {
        Random random = new Random();
        int index = random.nextInt(listeMots.size());
        return listeMots.get(index);
    }
}

