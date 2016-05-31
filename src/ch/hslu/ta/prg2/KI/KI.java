package ch.hslu.ta.prg2.KI;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.Gamestate.Ship;
import ch.hslu.ta.prg2.Gamestate.Shot;
import ch.hslu.ta.prg2.mediator.Server;
import java.util.Random;
import java.util.ArrayList;

public class KI {

    private final Gamestate state;
    private final Field[][] field;
    private final Random random = new Random();

    public KI(Gamestate state) {
        this.state = state;
        this.field = this.state.getOpponent("bot").getField();
    }

    public void setShips() {
        ArrayList<Ship> ships;
        ships = new ArrayList<>();

        for (int size = 4; size > 0; size--) {
            Ship s = getRandomShip(size);

            while (!isShipValid(ships, s)) {
                s = getRandomShip(size);
            }
            ships.add(s);
        }

        ArrayList<ArrayList<Position>> positions = new ArrayList<>();

        ships.forEach((s) -> {
            positions.add(s.getPositions());
        });

        Server.getInstance().setShips("bot", positions);
    }

    private Ship getRandomShip(int size) {
        ArrayList<Position> positions;
        positions = new ArrayList<>();

        Position p;
        Boolean horizontal = getRandomBool();

        if (horizontal) {
            p = getRandomPosition(10 - size, 10);
        } else {
            p = getRandomPosition(10, 10 - size);
        }

        for (int i = 0; i < size; i++) {
            if (horizontal) {

                positions.add(new Position(p.getX() + i, p.getY()));
            } else {

                positions.add(new Position(p.getX(), p.getY() + i));
            }
        }
        return new Ship(positions);
    }

    private boolean isShipValid(ArrayList<Ship> ships, Ship s) {

        for (Position p : s.getPositions()) {
            for (Ship ship : ships) {
                return !ship.hasPosition(p);
            }
        }

        return true;
    }

    public void shot() {

        Shot s = calculateBestShot();

        while (!isShotValid(s)) {
            s = getRandomShot();
        }

        Server.getInstance().shot("bot", s.position().getX(), s.position().getY());
    }

    private boolean isShotValid(Shot s) {
        int x = s.position().getX();
        int y = s.position().getY();

        if (x < 0 || x > 9 || y < 0 || y > 9) {
            return false;
        }

        return this.field[x][y].isShootable();
    }

    private Shot calculateBestShot() {
        ArrayList<Shot> posibleTargets;
        posibleTargets = new ArrayList<>();

        ArrayList<Shot> results;
        results = new ArrayList<>();

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (field[x][y] == Field.SHIPHIT) {
                    posibleTargets.add(new Shot(x + 1, y));
                    posibleTargets.add(new Shot(x - 1, y));
                    posibleTargets.add(new Shot(x, y + 1));
                    posibleTargets.add(new Shot(x, y - 1));
                }
            }
        }

        posibleTargets.stream().filter((s) -> (isShotValid(s))).forEach((s) -> {
            results.add(s);
        });

        if (results.size() > 0) {
            int index = random.nextInt(results.size());
            return results.get(index);
        }

        return getRandomShot();
    }

    private Shot getRandomShot() {
        Position pos = getRandomPosition(10, 10);
        return new Shot(pos.getX(), pos.getY());
    }

    private Position getRandomPosition(int boundsX, int boundsY) {
        int x = random.nextInt(boundsX);
        int y = random.nextInt(boundsY);

        return new Position(x, y);
    }

    private boolean getRandomBool() {
        return random.nextBoolean();
    }
}
