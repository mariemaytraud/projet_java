/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author MARIE
 */
public class MdpHash {
 
    
 // Renvoie le haché SHA-256 du mot de passe fourni sous forme hexadécimale. prends le haché retrouve le vrai mdp 

    
    public static String hashMdp(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("L'algorithme SHA-256 n'a pas été trouvé.", e);
        }
    }

    
 // Vérifie qu'un mot de passe en clair correspond au haché fourni.
//return true si le mot de passe correspond, false sinon.
    
    public static boolean verifierMdp(String plainPassword, String storedHash) {
        return hashMdp(plainPassword).equals(storedHash);
    }

}
 

