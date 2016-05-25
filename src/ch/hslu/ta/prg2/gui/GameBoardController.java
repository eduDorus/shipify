
package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.mediator.Server;
import java.util.ArrayList;

public class GameBoardController {
    
    static void addShipActionListener(FieldButton fieldButton, ArrayList<FieldButton> playerFields) {
        
    }
    
    static void opponentFieldActionListener(FieldButton fieldButton, ArrayList<FieldButton> opponentFields) {
        Gamestate gamestate = Server.getInstance().shoot(fieldButton.getPosition().getX(), fieldButton.getPosition().getY());
        
        Field[][] field = gamestate.getOpponent(Server.getInstance().getPlayerName()).getField();
        opponentFields.stream().forEach((_item) -> {
            _item.setFieldstate(field[_item.getPosition().getX()][_item.getPosition().getY()]);
        });
    }
}
