package ch.hslu.ta.prg2.Gamestate;

import java.util.ArrayList;

public class Player {

    private final String name;
    private final ArrayList<Ship> ships;
    private final ArrayList<Shoot> shoots;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
        this.shoots = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public ArrayList<Shoot> getShoots() {
        return shoots;
    }

    public void addShoot(int x, int y) {
        if (hasShot(x, y) == false) {
            shoots.add(new Shoot(x, y));
        }
    }

    public Field[][] getField() {
        Field[][] fields = new Field[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (hasShot(x, y)) {
                    if (hasShip(x, y)) {
                        Ship s = getShip(new Position(x, y));
                        if (s.isDead(shoots)) {
                            fields[x][y] = Field.SHIPDESTROYED;
                        } else {
                            fields[x][y] = Field.SHIPHIT;
                        }
                    } else {
                        fields[x][y] = Field.HIT;
                    }
                } else if (hasShip(x, y)) {
                    fields[x][y] = Field.SHIP;
                } else {
                    fields[x][y] = Field.WATER;
                }
            }
        }
        return fields;
    }

    public Field[][] getFieldAsOponent() {
        Field[][] fields = getField();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (fields[x][y] == Field.SHIP) {
                    fields[x][y] = Field.WATER;
                }
            }
        }

        return fields;
    }

    public boolean hasLost() {

        if (shipsAreSet()) {
            for (Ship s : ships) {
                if (!s.isDead(shoots)) {
                    //If one ship is not dead -> player has not lost yet
                    return false;
                }
            }
            //If no ship is alive -> plyer obivously lost
            return true;
        } else {
            //If ships are not set yet -> player has no lost
            return false;
        }
    }

    private boolean hasShip(int x, int y) {
        return ships.stream().anyMatch((s) -> (s.getPositions().stream().anyMatch((p) -> (p.getX() == x && p.getY() == y))));
    }

    private boolean hasShot(int x, int y) {
        return shoots.stream().anyMatch((s) -> (s.position().getX() == x && s.position().getY() == y));
    }

    private Ship getShip(Position p) {
        for (Ship s : ships) {
            if (s.hasPosition(p)) {
                return s;
            }
        }
        return null;
    }

    public boolean shipsAreSet() {
        return ships.size() == 4;
    }
}
