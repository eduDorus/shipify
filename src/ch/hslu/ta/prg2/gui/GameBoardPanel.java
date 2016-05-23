package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.mediator.Server;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private JPanel playerField;
    private JPanel opponentField;
    private JPanel infoField;
    private ArrayList<FieldButton> fieldButtonsPlayer;
    private ArrayList<FieldButton> fieldButtonsOponent;

    public GameBoardPanel() {

        this.setLayout(new BorderLayout());

        this.setSize(1200, 800);
        createComponents();

        this.fieldButtonsPlayer = new ArrayList<>();
        this.fieldButtonsOponent = new ArrayList<>();

        setOptions();

        createButtons();

        addObjects();

    }

    private void createComponents() {

        playerField = new JPanel();
        opponentField = new JPanel();
        infoField = new JPanel();

    }

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
                fieldButtonsPlayer.add(btn_playerField);
                btn_playerField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("shoot");
                        Gamestate gamestate = Server.getInstance().shoot(Server.getInstance().getPlayername(), btn_playerField.getXCords(), btn_playerField.getYCords());
                        updateOponentField(gamestate);
                    }
                });

                FieldButton btn_opponentField = new FieldButton(x, y, Field.WATER);
                fieldButtonsOponent.add(btn_opponentField);
                btn_opponentField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Gamestate gamestate = Server.getInstance().shoot(Server.getInstance().getPlayername(), btn_playerField.getXCords(), btn_playerField.getYCords());
                        updatePlayerField(gamestate);
                    }
                });

                playerField.add(btn_playerField);

                opponentField.add(btn_opponentField);

            }
        }
    }

    private void updatePlayerField(Gamestate gamestate) {
        Field[][] field = gamestate.getPlayer(Server.getInstance().getPlayername()).getField();
        fieldButtonsPlayer.stream().forEach((_item) -> {
            _item.setFieldstate(field[_item.getXCords()][_item.getYCords()]);
            _item.updateIcon();
        });
    }

    private void updateOponentField(Gamestate gamestate) {
        Field[][] field = gamestate.getOponent(Server.getInstance().getPlayername()).getField();
        fieldButtonsPlayer.stream().forEach((_item) -> {
            _item.setFieldstate(field[_item.getXCords()][_item.getYCords()]);
            _item.updateIcon();
        });
    }

    private void addObjects() {
        this.add(playerField, BorderLayout.EAST);
        this.add(opponentField, BorderLayout.WEST);
        this.add(infoField, BorderLayout.SOUTH);

    }

}
