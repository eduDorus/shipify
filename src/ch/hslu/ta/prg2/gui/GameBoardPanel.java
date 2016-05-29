package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.GameSituation;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private final GameBoardController controller;

    private JPanel playerField;
    private JPanel opponentField;
    private JPanel infoField;

    private JLabel infoLabel;
    private JButton turnShipButton;

    public GameBoardPanel(GameBoardController controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        this.setSize(1200, 800);
        createComponents();

        setOptions();
        createButtons();
        addObjects();
    }

    private void createComponents() {
        playerField = new JPanel();
        opponentField = new JPanel();
        infoField = new JPanel();
        turnShipButton = new JButton("Turn Ship");
        infoLabel = new JLabel();
    }

    private void setOptions() {

        Font font1 = new Font("SansSerif", 1, 20);

        playerField.setPreferredSize(new Dimension(600, 600));
        playerField.setMinimumSize(new Dimension(600, 600));
        playerField.setLayout(new GridLayout(10, 10));

        opponentField.setPreferredSize(new Dimension(600, 600));
        opponentField.setMinimumSize(new Dimension(600, 600));
        opponentField.setLayout(new GridLayout(10, 10));

        infoField.setPreferredSize(new Dimension(1200, 200));
        infoField.setMinimumSize(new Dimension(1200, 200));
        infoField.setSize(1200, 200);

        infoLabel.setFont(font1);

        turnShipButton.setFont(font1);
        turnShipButton.addActionListener((ActionEvent e) -> {
            controller.ChangeShipDirection();
        });
    }

    private void addObjects() {
        this.add(playerField, BorderLayout.WEST);
        this.add(opponentField, BorderLayout.EAST);
        infoField.add(turnShipButton);
        infoField.add(infoLabel);
        this.add(infoField, BorderLayout.SOUTH);
    }

    private void createButtons() {
        Font fontFieldButton = new Font("SansSerif", 1, 30);
        for (int x = 0; x < controller.GAME_SIZE_X; x++) {
            for (int y = 0; y < controller.GAME_SIZE_Y; y++) {
                FieldButton btn_playerField = new FieldButton(x, y, Field.WATER);
                btn_playerField.setFont(fontFieldButton);

                controller.fieldButtonsPlayer.add(btn_playerField);

                FieldButton btn_opponentField = new FieldButton(x, y, Field.WATER);
                btn_opponentField.setFont(fontFieldButton);
                controller.fieldButtonsOpponent.add(btn_opponentField);

                playerField.add(btn_playerField);
                opponentField.add(btn_opponentField);
            }
        }
    }

    public void changePanelforGameSituation(GameSituation currentSituation) {

        turnShipButton.setVisible(false);
        infoLabel.setText("");
        switch (currentSituation) {
            case SETSHIPS:
                turnShipButton.setVisible(true);
                infoLabel.setText("Bitte plazieren Sie die Schiffe.");
                break;
            case WAITINGONOPONENTSHIPS:
                infoLabel.setText("Das Spiel beginnt, sobald der Gegner die Schiffe plaziert hat.");
                break;
            case SHOOT:
                infoLabel.setText("Feuer frei!");
                break;
            case WAIT:
                infoLabel.setText("Auf das gegnerische Feuer wird gewartet.");
                break;
            case LOSS:
                infoLabel.setText("Leider Verloren");
                break;
            case VICTORY:
                infoLabel.setText("Gratulation. Sie haben gewonnen.");
                break;
        }
    }
}
