package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
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

    private JPanel playerField;
    private JPanel opponentField;
    private JPanel infoField;

    private JButton btn_shipOne;
    private JButton btn_shipTwo;
    private JButton btn_shipThree;
    private JButton btn_shipFour;
    private JButton btn_start;

    private ArrayList<FieldButton> fieldButtonsPlayer;
    private ArrayList<FieldButton> fieldButtonsOpponent;

    private int counter = 1;

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
        btn_start = new JButton("Spiel Speichern");
        btn_shipOne = new JButton("Einer Schiff");
        btn_shipTwo = new JButton("Zweier Schiff");
        btn_shipThree = new JButton("Dreier Schiff");
        btn_shipFour = new JButton("Vierer Schiff");
    }

    private void setOptions() {

        Font font1 = new Font("SansSerif", 1, 20);
        btn_start.setFont(font1);
        btn_shipOne.setFont(font1);
        btn_shipTwo.setFont(font1);
        btn_shipThree.setFont(font1);
        btn_shipFour.setFont(font1);

        btn_shipOne.setBounds(75, 600, 206, 50);
        btn_shipTwo.setBounds(356, 600, 206, 50);
        btn_shipThree.setBounds(631, 600, 206, 50);
        btn_shipFour.setBounds(911, 600, 206, 50);

        playerField.setPreferredSize(new Dimension(600, 600));
        playerField.setMinimumSize(new Dimension(600, 600));
        playerField.setLayout(new GridLayout(10, 10));

        opponentField.setPreferredSize(new Dimension(600, 600));
        opponentField.setMinimumSize(new Dimension(600, 600));
        opponentField.setLayout(new GridLayout(10, 10));

        infoField.setPreferredSize(new Dimension(1200, 200));
        infoField.setMinimumSize(new Dimension(1200, 200));
        infoField.setSize(1200, 200);

        btn_shipOne.addActionListener((ActionEvent e) -> {
            GameBoardController.shipOneButtonActionListener();
        });

        btn_shipTwo.addActionListener((ActionEvent e) -> {
            GameBoardController.shipTwoButtonActionListener();
        });

        btn_shipThree.addActionListener((ActionEvent e) -> {
            GameBoardController.shipThreeButtonActionListener();
        });

        btn_shipFour.addActionListener((ActionEvent e) -> {
            GameBoardController.shipFourButtonActionListener();
        });

        btn_start.addActionListener((ActionEvent e) -> {
            GameBoardController.startButtonActionListener();
        });
    }

    private void createButtons() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                FieldButton btn_playerField = new FieldButton(x, y, Field.WATER);
                fieldButtonsPlayer.add(btn_playerField);
                btn_playerField.addActionListener((ActionEvent e) -> {
                    //GameBoardController.addShipActionListener(btn_playerField, fieldButtonsPlayer);
                    addShipToGameBoard(btn_playerField);
                });
                btn_playerField.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        btn_playerField.setBackground(Color.green);
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        btn_playerField.updateIcon();
                    }
                });

                FieldButton btn_opponentField = new FieldButton(x, y, Field.WATER);
                fieldButtonsOpponent.add(btn_opponentField);
                btn_opponentField.addActionListener((ActionEvent e) -> {
                    GameBoardController.opponentFieldActionListener(btn_opponentField, fieldButtonsOpponent);
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
        this.add(btn_shipOne);
        this.add(btn_shipTwo);
        this.add(btn_shipThree);
        this.add(btn_shipFour);
        this.add(btn_start);
    }

    private void addShipToGameBoard(FieldButton btn_playerField) {
        ArrayList<ArrayList<Position>> ships = new ArrayList<>();
        ArrayList<Position> currentShip = new ArrayList<>();

        for (int i = 0; i < counter; i++) {
            currentShip.add(new Position(btn_playerField.getXCords(), btn_playerField.getYCords() + i));
        }

        ships.add(currentShip);
        Field[][] field = Server.getInstance().setShips(ships).getPlayer(Server.getInstance().getPlayerName()).getField();
        fieldButtonsPlayer.stream().forEach((button) -> {
            button.setFieldstate(field[button.getXCords()][button.getYCords()]);
            button.updateIcon();
        });

        counter++;
        if (counter > 4) {
            fieldButtonsPlayer.stream().forEach((button) -> {
                for (ActionListener act : button.getActionListeners()) {
                    button.removeActionListener(act);
                }
                for (MouseListener ml : button.getMouseListeners()) {
                    button.removeMouseListener(ml);
                }
            });
        }
    }
}
