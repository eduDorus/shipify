package ch.hslu.ta.prg2.KI;

import ch.hslu.ta.prg2.Gamestate.*;
import ch.hslu.ta.prg2.mediator.*;
import java.util.Random;
import java.util.ArrayList;

public class KI {

    private Gamestate state;
    private Field[][] field;

    public KI(Gamestate state) {

        this.state = state;
        this.field = this.state.getOpponent("bot").getField();
    }

    public void setShips() {
        //Should be dynamic...

        ArrayList<Position> ship1 = new ArrayList<>();
        ship1.add(new Position(1, 2));

        ArrayList<Position> ship2 = new ArrayList<>();
        ship2.add(new Position(3, 4));
        ship2.add(new Position(3, 5));

        ArrayList<Position> ship3 = new ArrayList<>();
        ship3.add(new Position(6, 2));
        ship3.add(new Position(7, 2));
        ship3.add(new Position(8, 2));

        ArrayList<Position> ship4 = new ArrayList<>();
        ship4.add(new Position(8, 4));
        ship4.add(new Position(8, 5));
        ship4.add(new Position(8, 6));
        ship4.add(new Position(8, 7));

        ArrayList<ArrayList<Position>> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);

        Server.getInstance().setShips("bot", ships);
    }

    public void shoot() {
        //Should be more inteligent...

        Shoot s = GetRandomShot();

        while (!isShotValid(s)) {
            s = GetRandomShot();
        }

        Server.getInstance().shoot("bot", s.position().getX(), s.position().getY());
    }

    private boolean isShotValid(Shoot s) {
        int x = s.position().getX();
        int y = s.position().getY();

        return this.field[x][y].isShootable();
    }

    private Shoot GetRandomShot() {

        Random randomInt = new Random();

        int x = randomInt.nextInt(10);
        int y = randomInt.nextInt(10);

        return new Shoot(x, y);
    }
}
