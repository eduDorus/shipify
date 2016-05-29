package ch.hslu.ta.prg2.Gamestate;

public class Shoot {

    private final Position position;

    public Shoot(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position position() {
        return position;
    }
}
