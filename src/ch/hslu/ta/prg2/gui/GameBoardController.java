package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.mediator.Server;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameBoardController {

    public ArrayList<FieldButton> fieldButtonsPlayer;
    public ArrayList<FieldButton> fieldButtonsOpponent;

    private int currentShipSize = 1;
    private boolean directionVertical = true;

    public GameBoardPanel startGame(Gamestate state) {

        this.fieldButtonsPlayer = new ArrayList<>();
        this.fieldButtonsOpponent = new ArrayList<>();
        GameBoardPanel panel = new GameBoardPanel(this);

        return panel;
    }

    /**
     * Adds temporary Color and ActionListener to add the ship to the field if
     * its a valid ship placement Does not do anything if not
     *
     * @param btn_playerField
     */
    public void displayShip(FieldButton btn_playerField) {
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

    public void ChangeShipDirection() {
        directionVertical = !directionVertical;
    }

    public void opponentFieldActionListener(FieldButton fieldButton) {
        Gamestate gamestate = Server.getInstance().shoot(fieldButton.getPosition().getX(), fieldButton.getPosition().getY());

        Field[][] field = gamestate.getOpponent(Server.getInstance().getPlayerName()).getField();
        fieldButtonsOpponent.stream().forEach((_item) -> {
            _item.setFieldstate(field[_item.getPosition().getX()][_item.getPosition().getY()]);
        });
    }

    private void updateField(Gamestate state) {
        Field[][] field = state.getPlayer(Server.getInstance().getPlayerName()).getField();
        fieldButtonsPlayer.stream().forEach((button) -> {
            button.setFieldstate(field[button.getPosition().getX()][button.getPosition().getY()]);
        });
    }

    public void removeAllTempColorAndListener() {
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

    private void addShipToGameBoard(ArrayList<Position> ship) {
        ArrayList<ArrayList<Position>> ships = new ArrayList<>();

        ships.add(ship);

        Gamestate state = Server.getInstance().setShips(ships);

        updateField(state);

        currentShipSize++;
    }
}
