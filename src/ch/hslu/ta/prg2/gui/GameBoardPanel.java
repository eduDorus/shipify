package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private JPanel playerField;
    private JPanel opponentField;
    private JPanel infoField;
    private JButton btn_save;
    private ArrayList<FieldButton> fieldButtonsPlayer;
    private ArrayList<FieldButton> fieldButtonsOpponent;

    public GameBoardPanel() {
        this.setLayout(new BorderLayout());
        this.setSize(1200, 800);
        createComponents();

        this.fieldButtonsPlayer = new ArrayList<>();
        this.fieldButtonsOpponent = new ArrayList<>();

        setOptions();
        createButtons();
        addObjects();
    }

    private void createComponents() {
        playerField = new JPanel();
        opponentField = new JPanel();
        infoField = new JPanel();
        btn_save = new JButton("Spiel Speichern");
    }

    private void setOptions() {
        
        Font font1 = new Font("SansSerif", 1, 20);
        btn_save.setFont(font1);
        
        playerField.setPreferredSize(new Dimension(600, 600));
        playerField.setMinimumSize(new Dimension(600, 600));
        playerField.setLayout(new GridLayout(10, 10));

        opponentField.setPreferredSize(new Dimension(600, 600));
        opponentField.setMinimumSize(new Dimension(600, 600));
        opponentField.setLayout(new GridLayout(10, 10));

        infoField.setPreferredSize(new Dimension(1200, 200));
        infoField.setMinimumSize(new Dimension(1200, 200));
        infoField.setSize(1200, 200);
        
        btn_save.addActionListener((ActionEvent e) -> {
            GUIController.saveButtonActionListener();
        });
    }

    private void createButtons() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                FieldButton btn_playerField = new FieldButton(x, y, Field.WATER);
                fieldButtonsPlayer.add(btn_playerField);
                btn_playerField.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GUIController.playerFieldActionListener(btn_playerField, fieldButtonsPlayer);
                    }
                });

                FieldButton btn_opponentField = new FieldButton(x, y, Field.WATER);
                fieldButtonsOpponent.add(btn_opponentField);
                btn_opponentField.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GUIController.opponentFieldActionListener(btn_opponentField, fieldButtonsOpponent);
                    }
                });

                playerField.add(btn_playerField);
                opponentField.add(btn_opponentField);
            }
        }
    }

    private void addObjects() {
        this.add(playerField, BorderLayout.WEST);
        this.add(opponentField, BorderLayout.EAST);
        this.add(infoField, BorderLayout.SOUTH);
        this.add(btn_save);
    }
}
