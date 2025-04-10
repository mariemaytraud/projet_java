/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author MARIE
 */
// Panel d'authentification pour l'administrateur.

public class Authentification extends JPanel {
    private AdminGestMdp configManager;
    private JPasswordField passwordField;
    private JButton loginButton;
    private AuthListener authListener;

    public Authentification(AdminGestMdp configManager) {
        this.configManager = configManager;
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Mot de passe administrateur:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        loginButton = new JButton("Se connecter");
        add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pwd = new String(passwordField.getPassword());
                if (configManager.verifyAdminPassword(pwd)) {
                    if (authListener != null) {
                        authListener.loginSuccessful();
                    }
                } else {
                    JOptionPane.showMessageDialog(Authentification.this,
                            "Mot de passe incorrect.",
                            "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void setAuthListener(AuthListener listener) {
        this.authListener = listener;
    }
    
 // Interface pour notifier le succès de la connexion.
   
    public interface AuthListener {
        void loginSuccessful();
    }
}


