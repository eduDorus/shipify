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
                } else {
                    fields[x][y] = Field.WATER;
                }
            }
        }
        return fields;
    }

    private boolean hasShip(int x, int y) {
        for (Ship s : ships) {
            for (Position p : s.getPositions()) {
                if (p.getX() == x && p.getY() == y) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasShot(int x, int y) {
        for (Shoot s : shoots) {
            if (s.position().getX() == x && s.position().getY() == y) {
                return true;
            }
        }
        return false;
    }
}
