package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;

public class GameBoardController {

    public void updateGameGameboard(Gamestate gamestate, String playername) {
        Field[][] playerField = gamestate.getPlayer(playername).getField();
        Field[][] oponentField = gamestate.getOponent(playername).getField();
        updatePlayerField(playerField);
        updateOponentField(oponentField);
    }

    public void updatePlayerField(Field[][] fields) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                //TODO: Update gridView in BoardPanel 
            }
        }
    }

    public void updateOponentField(Field[][] fields) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                //TODO: Update gridView in BoardPanel 
            }
        }
    }
}
