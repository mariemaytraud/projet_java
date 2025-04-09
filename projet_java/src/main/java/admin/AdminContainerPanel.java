/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;
import javax.swing.*;
import java.awt.*;
import java.io.File;
/**
 *
 * @author MARIE
 */
public class AdminContainerPanel extends JPanel {

    private CardLayout cardLayout;
    private AdminGestMdp configManager;
    private ListeMots wordListManager;
    private Authentification authPanel;
    private AdminPanel adminPanel;

    public AdminContainerPanel() {
        configManager = new AdminGestMdp();
        wordListManager = new ListeMots(new File("words.txt"));
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        authPanel = new Authentification(configManager);
        authPanel.setAuthListener(new Authentification.AuthListener() {
            @Override
            public void loginSuccessful() {
                cardLayout.show(AdminContainerPanel.this, "admin");
            }
        });

        adminPanel = new AdminPanel(wordListManager);

        add(authPanel, "login");
        add(adminPanel, "admin");

        cardLayout.show(this, "login");
    }
}

