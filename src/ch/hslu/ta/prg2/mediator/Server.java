package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.Gamestate.Ship;
import java.util.ArrayList;
import java.util.Iterator;

public class Server implements ServerInterface {

    Gamestate state;

    private Server() {
    }

    public static Server getInstance() {
        return ServerHolder.INSTANCE;
    }

    private static class ServerHolder {

        private static final Server INSTANCE = new Server();
    }

    @Override
    public Gamestate newGame() {
        state = new Gamestate("localplayer");
        return state;
    }

    @Override
    public Gamestate newBotGame() {

        this.state = new Gamestate("localplayer", true);
        return state;
    }

    @Override
    public Gamestate setShips(ArrayList<ArrayList<Position>> ships) {
        
        for(ArrayList<Position> positions : ships){
            Ship s = new Ship(positions);
        };
        return state;
    }

    @Override
    public Gamestate shoot(int x, int y) {
        state.getPlayer1().addShoot(x, y);
        return state;
    }
}
