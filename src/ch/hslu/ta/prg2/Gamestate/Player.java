package ch.hslu.ta.prg2.Gamestate;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Ship> ships;
    private ArrayList<Shoot> shoots;

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
                        //Add ships is dead
                        fields[x][y] = Field.SHIPHIT;
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

    private boolean hasShip(int x, int y) {
        return ships.stream().anyMatch((s) -> (s.getPositions().stream().anyMatch((p) -> (p.getX() == x && p.getY() == y))));
    }

    private boolean hasShot(int x, int y) {
        return shoots.stream().anyMatch((s) -> (s.position().getX() == x && s.position().getY() == y));
    }

    public boolean shipsAreSet() {
        if (ships.size() == 4) {
            return true;
        } else {
            return false;
        }
    }
}
