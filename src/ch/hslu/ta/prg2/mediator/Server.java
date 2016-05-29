package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.Gamestate.Ship;
import ch.hslu.ta.prg2.KI.KI;
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

        KI ki = new KI(this.gamestate);
        ki.setShips();

        return gamestate;
    }

    @Override
    public Gamestate setShips(String name, ArrayList<ArrayList<Position>> ships) {
        ships.stream().map((positions) -> new Ship(positions)).forEach((s) -> {
            this.gamestate.getPlayer(name).getShips().add(s);
        });
        return gamestate;
    }

    @Override
    public Gamestate shot(String name, int x, int y) {
        gamestate.getOpponent(name).addShoot(x, y);
        if (gamestate.getOpponent(name).getName().equals("bot")) {
            KI ki = new KI(this.gamestate);
            ki.shot();
        }
        return gamestate;
    }

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
