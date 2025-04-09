/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

/**
 *
 * @author MARIE
 */
public class TestHash {
  
    public static void main(String[] args) {
        String motDePasse = "admin123"; // Remplacez par le mot de passe souhaité
        String hash = MdpHash.hashMdp(motDePasse);
        System.out.println("Le haché pour le mot de passe est : " + hash);
        System.out.println("Répertoire de travail : " + System.getProperty("user.dir"));

    }
}

