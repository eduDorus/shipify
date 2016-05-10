
package ch.hslu.ta.prg2.Gamestate;

import java.util.ArrayList;

public class Shoot {

    public Shoot(int x, int y) {
        this.position = new Position(x, y);
    }
    
    private Position position;
    
    public Position position(){
        return position;
    }
}
