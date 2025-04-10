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

/**
 * Gestionnaire de la liste de mots stockée dans un fichier texte.
 * Dans cette version, le fichier utilisé est "src/main/resources/mots.txt".
 * Attention : cette solution fonctionne pour la phase de développement,
 * mais en production (packagé en jar), les ressources du jar sont généralement en lecture seule.
 */
public class ListeMots {
    
    private File file;            // Fichier contenant la liste des mots
    private ArrayList<String> words;  // Liste des mots en mémoire

    /**
     * Constructeur par défaut qui utilise "src/main/resources/mots.txt".
     */
    public ListeMots() {
        // Utilisation du chemin relatif vers le dossier des ressources
        this.file = new File("src/main/resources/mots.txt");
        words = new ArrayList<>();
        loadWords();
    }

    /**
     * Constructeur permettant de spécifier un autre fichier.
     *
     * @param file Le fichier contenant les mots.
     */
    public ListeMots(File file) {
        this.file = file;
        words = new ArrayList<>();
        loadWords();
    }
    
    /**
     * Charge les mots depuis le fichier dans l'ArrayList.
     * Si le fichier n'existe pas, il est créé.
     */
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
                if (file.createNewFile()) {
                    System.out.println("Fichier créé : " + file.getAbsolutePath());
                } else {
                    System.err.println("Impossible de créer le fichier : " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
            }
        }
    }
    
    /**
     * Retourne une copie de l'ArrayList des mots.
     *
     * @return La liste des mots.
     */
    public ArrayList<String> getWords() {
        return new ArrayList<>(words);
    }

    /**
     * Ajoute un mot à la liste s'il n'est pas déjà présent.
     *
     * @param word Le mot à ajouter.
     * @return true si le mot a été ajouté, false sinon.
     */
    public boolean addWord(String word) {
        if (!words.contains(word)) {
            words.add(word);
            return true;
        }
        return false;
    }

    /**
     * Met à jour le mot situé à l'indice spécifié.
     *
     * @param index   L'indice du mot à mettre à jour.
     * @param newWord La nouvelle valeur du mot.
     * @return true si la modification a réussi, false sinon.
     */
    public boolean updateWord(int index, String newWord) {
        if (index >= 0 && index < words.size()) {
            words.set(index, newWord);
            return true;
        }
        return false;
    }

    /**
     * Supprime le mot à l'indice donné.
     *
     * @param index L'indice du mot à supprimer.
     * @return true si le mot a été supprimé, false sinon.
     */
    public boolean deleteWord(int index) {
        if (index >= 0 && index < words.size()) {
            words.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Sauvegarde l'ArrayList de mots dans le fichier.
     */
    public void saveWords() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String s : words) {
                bw.write(s);
                bw.newLine();
            }
            System.out.println("Les mots ont bien été sauvegardés dans le fichier : " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement du fichier : " + e.getMessage());
        }
    }
}


//   // private File file;
//    private ArrayList<String> words;
//    private static final String FILENAME = "mots.txt";
//
//    public ListeMots() {
//       // this.file = new File("data/mots.txt");
//        words = new ArrayList<>();
//        loadWords();
//    }
//   // public ListeMots(File file) {
//     //   this.file = file;
//       // words = new ArrayList<>();
//        //loadWords();
//    }
//    
// // Charge les mots depuis le fichier dans l'ArrayList.
//    
//    private void loadWords() {
//      //  if (file.exists()) {
//            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
//                String line;
//                while ((line = br.readLine()) != null) {
//                   // line = line.trim();
//                    //if (!line.isEmpty()) {
//                        words.add(line);
//                    }
//                }
//            } catch (IOException e) {
//                System.err.println("Erreur lors du chargement du fichier : " + e.getMessage());
//                words.addAll(Arrays.asList("JAVA", "PROGRAMMATION", "ORDINATEUR", "CLAVIER", "SOURIS"));
//            }
//        } //else {
//           // try {
//             //   file.createNewFile();
//           // } catch (IOException e) {
//            //    System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
//            }
//        }
//    }
//    // Retourne l'ArrayList des mots.
//    public ArrayList<String> getWords() {
//        return new ArrayList<>(words);
//    }
//
////Ajoute un mot à la liste s'il n'est pas déjà présent.
//    
//    public boolean addWord(String word) {
//        if (!words.contains(word)) {
//            words.add(word);
//            return true;
//        }
//        return false;
//    }
//
//
////Met à jour un mot à l'index donné.
////l'index du mot à modifier
//// newWord la nouvelle valeur
//// true si la modification a réussi, false sinon.
// 
//    public boolean updateWord(int index, String newWord) {
//        if (index >= 0 && index < words.size()) {
//            words.set(index, newWord);
//            return true;
//        }
//        return false;
//    }
//
////Supprime le mot à l'index spécifié.
////l'index du mot à supprimer
//// true si la suppression a réussi, false sinon.
//   
//    public boolean deleteWord(int index) {
//        if (index >= 0 && index < words.size()) {
//            words.remove(index);
//            return true;
//        }
//        return false;
//    }
//
//   // Sauvegarde l'ArrayList de mots dans le fichier.
//   
//    public void saveWords() {
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
//            for (String s : words) {
//                bw.write(s);
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            System.err.println("Erreur lors de l'enregistrement du fichier : " + e.getMessage());
//        }
//    }
//


