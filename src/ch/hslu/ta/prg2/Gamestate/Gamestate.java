package ch.hslu.ta.prg2.Gamestate;

import ch.hslu.ta.prg2.mediator.Server;
import java.io.Serializable;

public class Gamestate implements Serializable {

    private Player player1;
    private Player player2;

    public Gamestate(String name) {
        if (name.equals("bot")) {
            name = name + "_player";
            Server.getInstance().setPlayerName(name);
        }
        player1 = new Player(name);

    }

    public Gamestate(String name, boolean againstBot) {

        this(name);

        if (againstBot) {
            player2 = new Player("bot");
        }
    }

    public Player getPlayer(String name) {
        if (this.player1.getName().equals(name)) {
            return player1;
        } else if (this.player2.getName().equals(name)) {
            return player2;
        }
        return null;
    }

    public Player getOpponent(String name) {
        Player whoAmI = this.getPlayer(name);
        if (whoAmI.equals(player1)) {
            return this.player2;
        } else if (whoAmI.equals(player2)) {
            return this.player1;
        }

        return null;
    }

    public GameSituation getSituation(String playerName) {
        Player player = getPlayer(playerName);
        Player oponent = getOpponent(playerName);

        if (!player.shipsAreSet()) {
            return GameSituation.SETSHIPS;
        }

        if (oponent == null) {
            return GameSituation.WAITINGFONOPONENT;
        }

        if (player.shipsAreSet() && !oponent.shipsAreSet()) {
            return GameSituation.WAITINGONOPONENTSHIPS;
        }

        if (player.hasLost()) {
            return GameSituation.LOSS;
        }

        if (oponent.hasLost()) {
            return GameSituation.VICTORY;
        }

        //Player is allowed to shoot, if he has shoot the same amount or less than his oponent
        if (player.getShoots().size() >= oponent.getShoots().size()) {
            return GameSituation.SHOOT;
        }

        return GameSituation.WAIT;
    }
}
