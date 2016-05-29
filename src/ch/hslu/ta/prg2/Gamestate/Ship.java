package ch.hslu.ta.prg2.Gamestate;

import java.util.ArrayList;

public class Ship {

    private final ArrayList<Position> positions;

    public Ship(ArrayList<Position> positions) {
        this.positions = positions;

    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public boolean hasPosition(Position questionPosition) {
        return positions.stream().anyMatch((p) -> (p.equals(questionPosition)));
    }

    boolean isDead(ArrayList<Shoot> shots) {
        int lives = getPositions().size();

        for (Shoot s : shots) {
            if (hasPosition(s.position())) {
                lives = lives - 1;
            }
        }

        return lives <= 0;
    }
}
