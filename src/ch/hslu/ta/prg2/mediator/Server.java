package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.Gamestate.Ship;
import java.util.ArrayList;

public class Server implements ServerInterface {

    Gamestate gamestate;
    String playerName;

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
        gamestate = new Gamestate(this.playerName);
        return gamestate;
    }

    @Override
    public Gamestate newBotGame() {
        this.gamestate = new Gamestate(this.playerName, true);
        return gamestate;
    }

    @Override
    public Gamestate setShips(ArrayList<ArrayList<Position>> ships) {
        ships.stream().map((positions) -> new Ship(positions)).forEach((s) -> {
            this.gamestate.getPlayer(playerName).getShips().add(s);
        });
        return gamestate;
    }

    @Override
    public Gamestate shoot(int x, int y) {
        gamestate.getOpponent(playerName).addShoot(x, y);
        return gamestate;
    }

    @Override
    public Gamestate getGamestate() {
        return gamestate;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
