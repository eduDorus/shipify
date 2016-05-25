package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.mediator.Server;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private GameBoardController controller;

    private JPanel playerField;
    private JPanel opponentField;
    private JPanel infoField;

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

        turnShipButton.setFont(font1);
        turnShipButton.addActionListener((ActionEvent e) -> {
            controller.ChangeShipDirection();
        });
    }

    private void addObjects() {
        this.add(playerField, BorderLayout.WEST);
        this.add(opponentField, BorderLayout.EAST);
        infoField.add(turnShipButton);
        this.add(infoField, BorderLayout.SOUTH);
    }

    private void createButtons() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                FieldButton btn_playerField = new FieldButton(x, y, Field.WATER);
                controller.fieldButtonsPlayer.add(btn_playerField);

                btn_playerField.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        controller.displayShip(btn_playerField);
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        controller.removeAllTempColorAndListener();
                    }
                });

                FieldButton btn_opponentField = new FieldButton(x, y, Field.WATER);
                controller.fieldButtonsOpponent.add(btn_opponentField);
                btn_opponentField.addActionListener((ActionEvent e) -> {
                    controller.opponentFieldActionListener(btn_opponentField);
                });

                playerField.add(btn_playerField);
                opponentField.add(btn_opponentField);
            }
        }
    }
}
