
package ch.hslu.ta.prg2.gui;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.mediator.Server;
import java.util.ArrayList;

public class GameBoardController {
    
    int shipOneAmount = 4;
    int shipTwoAmount = 3;
    int shipThreeAmount = 2;
    int shipFourAmount = 1;
        
    static void addShipActionListener(FieldButton fieldButton, ArrayList<FieldButton> playerFields) {
        
    }
    
    static void opponentFieldActionListener(FieldButton fieldButton, ArrayList<FieldButton> opponentFields) {
        Gamestate gamestate = Server.getInstance().shoot(fieldButton.getXCords(), fieldButton.getYCords());
        
        Field[][] field = gamestate.getOpponent(Server.getInstance().getPlayerName()).getField();
        opponentFields.stream().forEach((_item) -> {
            _item.setFieldstate(field[_item.getXCords()][_item.getYCords()]);
        });
    }
    
    static void startButtonActionListener() {
        
    }
    
    static void shipOneButtonActionListener() {
        
    }
    
    static void shipTwoButtonActionListener() {
        
    }
    
    static void shipThreeButtonActionListener() {
        
    }
    
    static void shipFourButtonActionListener() {
        
    }
}
