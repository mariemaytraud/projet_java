/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
/**
 *
 * @author MARIE
 */
//Panel d'administration pour visualiser et modifier la liste de mots.

public class AdminPanel extends JPanel {
        private ListeMots listemots;
    private DefaultListModel<String> listModel;
    private JList<String> wordList;
    private JTextField wordField;
    private JButton enregistrerButton;
    private JButton nouveauButton;
    private JButton effacerButton;

    public AdminPanel(ListeMots listemots) {
        this.listemots = listemots;
        initializeComponents();
        loadWords();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        // Titre
        JLabel titleLabel = new JLabel("Administration - Liste de mots");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Panel central regroupant la liste et la zone d'édition
        JPanel centerPanel = new JPanel(new BorderLayout());

        listModel = new DefaultListModel<>();
        wordList = new JList<>(listModel);
        wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(wordList);
        scrollPane.setPreferredSize(new Dimension(200, 300));
        centerPanel.add(scrollPane, BorderLayout.WEST);

        JPanel editorPanel = new JPanel();
        editorPanel.setLayout(new BoxLayout(editorPanel, BoxLayout.Y_AXIS));
        editorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        editorPanel.add(new JLabel("Mot:"));
        wordField = new JTextField(20);
        editorPanel.add(wordField);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.setEnabled(false);
        nouveauButton = new JButton("Nouveau");
        effacerButton = new JButton("Supprimer");
        effacerButton.setEnabled(false);
        buttonsPanel.add(enregistrerButton);
        buttonsPanel.add(nouveauButton);
        buttonsPanel.add(effacerButton);
        editorPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        editorPanel.add(buttonsPanel);

        centerPanel.add(editorPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Activation dynamique du bouton "Enregistrer"
        wordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkField(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkField(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkField(); }
            private void checkField() {
                enregistrerButton.setEnabled(!wordField.getText().trim().isEmpty());
            }
        });

        // Remplissage du champ d'édition lors de la sélection d'un mot dans la liste
        wordList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = wordList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    wordField.setText(listModel.getElementAt(selectedIndex));
                    effacerButton.setEnabled(true);
                } else {
                    effacerButton.setEnabled(false);
                }
            }
        });

        // Action "Enregistrer" (ajout ou modification)
        enregistrerButton.addActionListener(e -> {
            String text = wordField.getText().trim();
            if (text.isEmpty()) return;

            int selectedIndex = wordList.getSelectedIndex();
            if (selectedIndex >= 0) {
                // Modification
                listemots.updateWord(selectedIndex, text);
                listModel.set(selectedIndex, text);
            } else {
                if (!listModel.contains(text)) {
                    listemots.addWord(text);
                    listModel.addElement(text);
                } else {
                    JOptionPane.showMessageDialog(AdminPanel.this,
                            "Le mot est déjà présent dans la liste.",
                            "Doublon", JOptionPane.WARNING_MESSAGE);
                }
            }
            listemots.saveWords();
            wordField.setText("");
            wordList.clearSelection();
        });

        nouveauButton.addActionListener(e -> {
            wordField.setText("");
            wordList.clearSelection();
        });

        effacerButton.addActionListener(e -> {
            int selectedIndex = wordList.getSelectedIndex();
            if (selectedIndex >= 0) {
                int confirm = JOptionPane.showConfirmDialog(AdminPanel.this,
                        "Voulez-vous supprimer ce mot ?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    listemots .deleteWord(selectedIndex);
                    listModel.remove(selectedIndex);
                    listemots.saveWords();
                    wordField.setText("");
                    wordList.clearSelection();
                }
            }
        });
    }

    /**
     * Charge les mots de l'ArrayList dans le modèle de la liste.
     */
    private void loadWords() {
        listModel.clear();
        for (String word : listemots.getWords()) {
            listModel.addElement(word);
        }
    }
}

    

