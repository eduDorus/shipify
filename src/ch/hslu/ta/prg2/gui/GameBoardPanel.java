package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.mediator.Server;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private JPanel playerfield;
    private JPanel opponentField;
    private JPanel infofield;

    public GameBoardPanel() {

        this.setSize(1227, 800);
        this.setLayout(new GridLayout(1, 2));

        createComponents();

        setOptions();
        createButtons();

        addObjects();

    }

    //CREATE OBJECTS
    private void createComponents() {

        playerfield = new JPanel();
        opponentField = new JPanel();
        infofield = new JPanel();

    }
//       

    private void setOptions() {
        playerfield.setLayout(new GridLayout(10, 10));
        opponentField.setLayout(new GridLayout(10, 10));

    }

    private void createButtons() {

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                FieldButton btn_playerField = new FieldButton(x, y, Field.WATER, null);
                btn_playerField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(btn_playerField.getXCords() + ", " + btn_playerField.getYCords());
                    }
                });

                FieldButton btn_opponentField = new FieldButton(x, y, Field.WATER, null);
                btn_opponentField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(btn_opponentField.getXCords() + ", " + btn_opponentField.getYCords());
                    }
                });

                playerfield.add(btn_playerField);

                opponentField.add(btn_opponentField);
            }
        }
    }

    private void addObjects() {
        this.add(playerfield);
        this.add(opponentField);

    }

}
