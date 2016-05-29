package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.GameSituation;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.mediator.Server;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameBoardController {

    public ArrayList<FieldButton> fieldButtonsPlayer;
    public ArrayList<FieldButton> fieldButtonsOpponent;

    private int currentShipSize = 1;
    private boolean directionVertical = true;

    private GameBoardPanel panel;

    public final int GAME_SIZE_X = 10;
    public final int GAME_SIZE_Y = 10;

    public GameBoardPanel startGame(Gamestate state) {

        this.fieldButtonsPlayer = new ArrayList<>();
        this.fieldButtonsOpponent = new ArrayList<>();
        panel = new GameBoardPanel(this);
        loadGameSituation(state);
        return panel;
    }

    private void loadGameSituation(Gamestate state) {
        updateField(state);

        GameSituation currentSituation = state.getSituation(Server.getInstance().getPlayerName());

        panel.changePanelforGameSituation(currentSituation);

        currentShipSize = state.getPlayer(Server.getInstance().getPlayerName()).getShips().size() + 1;

        switch (currentSituation) {
            case SETSHIPS:
                prepareSetShips();
                break;
            case WAITINGFONOPONENT:
                cleanUpAferShipsSet();
                break;
            case WAITINGONOPONENTSHIPS:
                cleanUpAferShipsSet();
                break;
            case SHOOT:
                cleanUpAferShipsSet();
                prepareShoot();
                break;
            case WAIT:
                noShotsAllowed();
                break;
            case LOSS:
                noShotsAllowed();
                break;
            case VICTORY:
                noShotsAllowed();
                break;
            case ERROR:
                break;
        }
    }

    private void prepareSetShips() {
        fieldButtonsPlayer.stream().forEach((FieldButton) -> {

            //Remove all Mouslistner, but not the first one.
            for (MouseListener mou : FieldButton.getMouseListeners()) {
                if (mou != FieldButton.getMouseListeners()[0]) {
                    FieldButton.removeMouseListener(mou);
                }
            }

            if (FieldButton.getFieldstate() != Field.SHIP) {
                FieldButton.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        displayShip(FieldButton);
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        removeAllTempColorAndListener();
                    }
                });
            }

        });
    }

    private void prepareShoot() {

        fieldButtonsOpponent.stream().forEach((FieldButton) -> {

            for (ActionListener act : FieldButton.getActionListeners()) {
                FieldButton.removeActionListener(act);
            }

            if (FieldButton.getFieldstate().isShootable()) {
                FieldButton.addActionListener((ActionEvent e) -> {
                    shot(FieldButton);
                });
            }
        });
    }

    private void noShotsAllowed() {
        fieldButtonsOpponent.stream().forEach((FieldButton) -> {
            for (ActionListener act : FieldButton.getActionListeners()) {
                FieldButton.removeActionListener(act);
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
            if (btn_playerField.getPosition().getY() + currentShipSize > GAME_SIZE_Y) {
                return;
            }
        } else if (btn_playerField.getPosition().getX() + currentShipSize > GAME_SIZE_X) {
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

    private void shot(FieldButton fieldButton) {
        Gamestate gamestate = Server.getInstance().shoot(Server.getInstance().getPlayerName(), fieldButton.getPosition().getX(), fieldButton.getPosition().getY());
        loadGameSituation(gamestate);
    }

    private void updateField(Gamestate state) {
        Field[][] playerFields = state.getPlayer(Server.getInstance().getPlayerName()).getField();

        fieldButtonsPlayer.stream().forEach((button) -> {
            button.setFieldstate(playerFields[button.getPosition().getX()][button.getPosition().getY()]);
        });

        Field[][] oponentFields = state.getOpponent(Server.getInstance().getPlayerName()).getFieldAsOponent();
        fieldButtonsOpponent.stream().forEach((button) -> {
            button.setFieldstate(oponentFields[button.getPosition().getX()][button.getPosition().getY()]);
        });
    }

    private void removeAllTempColorAndListener() {
        fieldButtonsPlayer.stream().forEach((button) -> {
            button.resetTempFieldColor();

            for (ActionListener act : button.getActionListeners()) {
                button.removeActionListener(act);
            }
        });
    }

    private void cleanUpAferShipsSet() {
        removeAllTempColorAndListener();
        fieldButtonsPlayer.stream().forEach((button) -> {
            for (MouseListener mou : button.getMouseListeners()) {
                button.removeMouseListener(mou);
            }
        });
    }

    private void addShipToGameBoard(ArrayList<Position> ship) {
        ArrayList<ArrayList<Position>> ships = new ArrayList<>();

        ships.add(ship);

        Gamestate state = Server.getInstance().setShips(Server.getInstance().getPlayerName(), ships);

        loadGameSituation(state);
    }
}
