package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.mediator.Server;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private JPanel playerField;
    private JPanel opponentField;
    private JPanel infoField;

    public GameBoardPanel() {

        this.setSize(1227, 800);

        this.setLayout(new BorderLayout());

        createComponents();

        setOptions();

        createButtons();

        addObjects();

    }

    //CREATE OBJECTS
    private void createComponents() {

        playerField = new JPanel();
        opponentField = new JPanel();
        infoField = new JPanel();

    }
//       

    private void setOptions() {
        playerField.setPreferredSize(new Dimension(600, 600));
        playerField.setMinimumSize(new Dimension(600, 600));
        playerField.setLayout(new GridLayout(10, 10));
        
        opponentField.setPreferredSize(new Dimension(600, 600));
        opponentField.setMinimumSize(new Dimension(600, 600));
        opponentField.setLayout(new GridLayout(10, 10));
        
        infoField.setPreferredSize(new Dimension(1200, 200));
        infoField.setMinimumSize(new Dimension(1200, 200));
        infoField.setSize(1200, 200);
    }

    private void createButtons() {

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                FieldButton btn_playerField = new FieldButton(x, y, Field.WATER);
                btn_playerField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(btn_playerField.getXCords() + ", " + btn_playerField.getYCords());
                    }
                });

                FieldButton btn_opponentField = new FieldButton(x, y, Field.WATER);
                btn_opponentField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(btn_opponentField.getXCords() + ", " + btn_opponentField.getYCords());
                    }
                });

                playerField.add(btn_playerField);

                opponentField.add(btn_opponentField);
            }
        }
    }

    private void addObjects() {
        this.add(playerField, BorderLayout.EAST);
        this.add(opponentField, BorderLayout.WEST);
        this.add(infoField, BorderLayout.SOUTH);

    }

}
