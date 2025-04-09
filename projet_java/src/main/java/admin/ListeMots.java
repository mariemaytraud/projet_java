/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author MARIE
 */
//Gestionnaire de la liste de mots (stockée dans un fichier texte) via une ArrayList.

public class ListeMots {
    
    private File file;
    private ArrayList<String> words;

    public ListeMots() {
        this.file = new File("src/main/resources/mots.txt");
        words = new ArrayList<>();
        loadWords();
    }
    public ListeMots(File file) {
        this.file = file;
        words = new ArrayList<>();
        loadWords();
    }
    
 // Charge les mots depuis le fichier dans l'ArrayList.
    
    private void loadWords() {
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        words.add(line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Erreur lors du chargement du fichier : " + e.getMessage());
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
            }
        }
    }
    // Retourne l'ArrayList des mots.
    public ArrayList<String> getWords() {
        return new ArrayList<>(words);
    }

//Ajoute un mot à la liste s'il n'est pas déjà présent.
    
    public boolean addWord(String word) {
        if (!words.contains(word)) {
            words.add(word);
            return true;
        }
        return false;
    }


//Met à jour un mot à l'index donné.
//l'index du mot à modifier
// newWord la nouvelle valeur
// true si la modification a réussi, false sinon.
 
    public boolean updateWord(int index, String newWord) {
        if (index >= 0 && index < words.size()) {
            words.set(index, newWord);
            return true;
        }
        return false;
    }

//Supprime le mot à l'index spécifié.
//l'index du mot à supprimer
// true si la suppression a réussi, false sinon.
   
    public boolean deleteWord(int index) {
        if (index >= 0 && index < words.size()) {
            words.remove(index);
            return true;
        }
        return false;
    }

   // Sauvegarde l'ArrayList de mots dans le fichier.
   
    public void saveWords() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String s : words) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement du fichier : " + e.getMessage());
        }
    }
}


