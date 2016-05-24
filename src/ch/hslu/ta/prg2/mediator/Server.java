package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.Gamestate.Ship;
import java.util.ArrayList;

public class Server implements ServerInterface {

    Gamestate gamestate;
    String localPlayerName;

    private Server() {
    }

    public static Server getInstance() {
        return ServerHolder.INSTANCE;
    }

    private static class ServerHolder {

        private static final Server INSTANCE = new Server();
    }

    @Override
    public Gamestate newGame(String localPlayerName) {
        this.localPlayerName = localPlayerName;
        gamestate = new Gamestate(localPlayerName);
        return gamestate;
    }

    @Override
    public Gamestate newBotGame(String localPlayerName) {
        this.localPlayerName = localPlayerName;
        this.gamestate = new Gamestate(localPlayerName, true);
        return gamestate;
    }

    @Override
    public Gamestate setShips(ArrayList<ArrayList<Position>> ships) {
        ships.stream().map((positions) -> new Ship(positions)).forEach((s) -> {
            this.gamestate.getPlayer(localPlayerName).getShips().add(s);
        });
        return gamestate;
    }

    @Override
    public Gamestate shoot(int x, int y) {
        gamestate.getOpponent(localPlayerName).addShoot(x, y);
        return gamestate;
    }

    @Override
    public Gamestate getGamestate() {
        return gamestate;
    }
}
