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

    private JPanel playerField;
    private JPanel opponentField;
    private JPanel infoField;

    private JButton turnShipButton;

    private ArrayList<FieldButton> fieldButtonsPlayer;
    private ArrayList<FieldButton> fieldButtonsOpponent;

    private int currentShipSize = 1;
    private boolean directionVertical = true;

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
            directionVertical = !directionVertical;
        });
    }

    private void createButtons() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                FieldButton btn_playerField = new FieldButton(x, y, Field.WATER);
                fieldButtonsPlayer.add(btn_playerField);

                btn_playerField.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        displayShip(btn_playerField);
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        removeAllTempColorAndListener();
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

    private void updateField(Gamestate state) {
        Field[][] field = state.getPlayer(Server.getInstance().getPlayerName()).getField();
        fieldButtonsPlayer.stream().forEach((button) -> {
            button.setFieldstate(field[button.getPosition().getX()][button.getPosition().getY()]);
        });
    }

    private void addObjects() {
        this.add(playerField, BorderLayout.WEST);
        this.add(opponentField, BorderLayout.EAST);
        infoField.add(turnShipButton);
        this.add(infoField, BorderLayout.SOUTH);
    }

    private void removeAllTempColorAndListener() {
        fieldButtonsPlayer.stream().forEach((button) -> {
            button.resetTempFieldColor();

            for (ActionListener act : button.getActionListeners()) {
                button.removeActionListener(act);
            }

            if (currentShipSize > 4) {
                for (MouseListener mou : button.getMouseListeners()) {
                    button.removeMouseListener(mou);
                }
            }
        });
    }

    /**
     * Adds temporary Color and ActionListener to add the ship to the field if
     * its a valid ship placement Does not do anything if not
     *
     * @param btn_playerField
     */
    private void displayShip(FieldButton btn_playerField) {
        ArrayList<Position> currentShip = new ArrayList<>();

        //Return if ship is out of bounds
        if (directionVertical) {
            if (btn_playerField.getPosition().getY() + currentShipSize > 10) {
                return;
            }
        } else if (btn_playerField.getPosition().getX() + currentShipSize > 10) {
            return;
        }

        for (int i = 0; i < currentShipSize; i++) {
            Position pos;
            if (directionVertical) {
                pos = new Position(btn_playerField.getPosition().getX(), btn_playerField.getPosition().getY() + i);
            } else {
                pos = new Position(btn_playerField.getPosition().getX() + i, btn_playerField.getPosition().getY());
            }
            currentShip.add(pos);
        }

        ArrayList<FieldButton> buttonsWithShip = new ArrayList<>();

        fieldButtonsPlayer.stream().forEach((FieldButton) -> {
            currentShip.stream().forEach((shipPosition) -> {
                if (FieldButton.getPosition().equals(shipPosition)) {
                    buttonsWithShip.add(FieldButton);
                }
            });
        });

        for (FieldButton button : buttonsWithShip) {
            if (button.getFieldstate() != Field.WATER) {
                return;
            }
        }

        buttonsWithShip.forEach((button) -> {
            button.setTempFieldColor(Color.GREEN);
            button.addActionListener((ActionEvent e) -> {
                addShipToGameBoard(currentShip);
            });
        });
    }

    private void addShipToGameBoard(ArrayList<Position> ship) {
        ArrayList<ArrayList<Position>> ships = new ArrayList<>();

        ships.add(ship);

        Gamestate state = Server.getInstance().setShips(ships);

        updateField(state);

        currentShipSize++;
    }
}
