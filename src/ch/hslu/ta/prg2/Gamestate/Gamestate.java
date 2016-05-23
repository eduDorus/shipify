package ch.hslu.ta.prg2.Gamestate;

import java.io.Serializable;

public class Gamestate implements Serializable {

    private Player localPlayer;
    private Player opponentPlayer;

    public Gamestate(String name) {
        if (name.equals("bot")) {
            name = name + "_player";
        }
        localPlayer = new Player(name);

    }

    public Gamestate(String name, boolean againstBot) {

        this(name);

        if (againstBot) {
            opponentPlayer = new Player("bot");
        }
    }

    public Player getLocalPlayer() {
        return localPlayer;
    }

    public Player getOpponentPlayer() {
        return opponentPlayer;
    }
}
