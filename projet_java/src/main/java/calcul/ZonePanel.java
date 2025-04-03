/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcul;

/**
 *
 * @author cleme
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ZonePanel extends JPanel {
    
    public JTextField reponseField;
    public JLabel operationLabel;
    public JLabel messageLabel;

    public ZonePanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400, 200));
        setLayout(new BorderLayout());

        JPanel operationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        operationLabel = new JLabel();
        operationLabel.setFont(new Font("Arial", Font.BOLD, 30));

        reponseField = new JTextField(5);
        reponseField.setFont(new Font("Arial", Font.PLAIN, 18));
        reponseField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        operationPanel.add(operationLabel);
        operationPanel.add(reponseField);

        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        messageLabel.setForeground(Color.RED);
        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel.add(messageLabel);
        add(messagePanel, BorderLayout.CENTER);

        add(operationPanel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.AFTER_LAST_LINE);
    }

    public int getReponse() throws NumberFormatException {
        String texte = reponseField.getText().trim();
        if (texte.isEmpty()) {
            throw new NumberFormatException("Le champ de réponse est vide");
        }
        return Integer.parseInt(texte);
    }

    public void afficherSolution(int resultatAttendu) {
        
        messageLabel.setText("La solution est : " + resultatAttendu);
        messageLabel.setForeground(Color.BLUE);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void afficherQuestion(int nombre1, int nombre2, String operation) {
        operationLabel.setText(nombre1 + " " + operation + " " + nombre2 + " = ? ");
    }
}