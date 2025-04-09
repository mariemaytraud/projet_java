/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author MARIE
 */
//Gestionnaire du fichier de configuration de l'administrateur.
 //Le fichier doit contenir la propriété "admin.password" avec le haché du mot de passe.
 
public class AdminGestMdp {

    private static final String CONFIG_FILE = "config.properties";
    private static final String ADMIN_PASSWORD_KEY = "admin.password";
    private Properties proprietes;

    public AdminGestMdp() {
        proprietes = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            proprietes.load(fis);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement du fichier de configuration : " + e.getMessage());
        }
    }

 //Retourne le haché du mot de passe administrateur.
    
 //Retourne le haché ou null si non défini.
   
    public String getAdminHashedPassword() {
        return proprietes.getProperty(ADMIN_PASSWORD_KEY);
    }
// Vérifie le mot de passe administrateur en comparant son haché avec celui enregistré.
//plainPassword le mot de passe saisi en clair
// Retourne true si la vérification est bonne, false sinon.
    
    public boolean verifyAdminPassword(String plainPassword) {
        String storedHash = getAdminHashedPassword();
        if (storedHash == null) {
            System.err.println("Le mot de passe administrateur n'est pas défini dans le fichier de configuration.");
            return false;
        }
        return MdpHash.verifierMdp(plainPassword, storedHash);
    }
}

    

