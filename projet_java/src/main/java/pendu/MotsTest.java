package pendu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MARIE
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MotsTest {
    private List<String> listeMots;

    public MotsTest() {
        listeMots = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream("/mots.txt")))) {
            
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                listeMots.add(ligne.trim().toUpperCase()); // On met en majuscules pour standardiser
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Erreur lors du chargement du fichier de mots : " + e.getMessage());
        }
    }

    public String choisirMot() {
        if (listeMots.isEmpty()) {
            throw new IllegalStateException("La liste de mots est vide !");
        }
        Random random = new Random();
        int index = random.nextInt(listeMots.size());
        return listeMots.get(index);
    }
}



