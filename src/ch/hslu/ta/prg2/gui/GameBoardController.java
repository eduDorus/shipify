
package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.mediator.Server;
import java.util.ArrayList;

public class GameBoardController {
 //static void hoverFieldActionListener(FieldButton fieldButton, ArrayList<FieldButton> playerFields)
    
    static void addShipActionListener(FieldButton fieldButton, ArrayList<FieldButton> playerFields) {
        Gamestate gamestate = Server.getInstance().setShips(null);
        
        Field[][] field = gamestate.getOpponentPlayer().getField();
        playerFields.stream().forEach((_item) -> {
            _item.setFieldstate(field[_item.getXCords()][_item.getYCords()]);
            _item.updateIcon();
        });
    }
    
    static void opponentFieldActionListener(FieldButton fieldButton, ArrayList<FieldButton> opponentFields) {
        Gamestate gamestate = Server.getInstance().shoot(fieldButton.getXCords(), fieldButton.getYCords());
        
        Field[][] field = gamestate.getOpponentPlayer().getField();
        opponentFields.stream().forEach((_item) -> {
            _item.setFieldstate(field[_item.getXCords()][_item.getYCords()]);
            _item.updateIcon();
        });
    }
}
