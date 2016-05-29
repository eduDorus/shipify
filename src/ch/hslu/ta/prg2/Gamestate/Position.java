package ch.hslu.ta.prg2.Gamestate;

public class Position {

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Position.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Position other = (Position) obj;

        if (this.x != other.getX() || this.y != other.getY()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
        return hash;
    }
}
