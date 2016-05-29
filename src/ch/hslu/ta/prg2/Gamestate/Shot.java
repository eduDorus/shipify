package ch.hslu.ta.prg2.Gamestate;

public class Shot {

    private final Position position;

    public Shot(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position position() {
        return position;
    }
}
