
package ch.hslu.ta.prg2.Gamestate;

import java.util.ArrayList;

public class Ship {
    
    private ArrayList<Position> positions;

    public Ship(ArrayList<Position> positions) {
        this.positions = new ArrayList<>();
        this.positions.addAll(positions);
    }
    
    public ArrayList<Position> getPositions() {
        return positions;
    }
    
}
