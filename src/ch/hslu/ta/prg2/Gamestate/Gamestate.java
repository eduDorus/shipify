package ch.hslu.ta.prg2.Gamestate;

import java.io.Serializable;

public class Gamestate implements Serializable {

    private Player player1;
    private Player player2;

    public Gamestate(String name) {
        if (name.equals("bot")) {
            name = name + "_player";
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

    public Player getOponent(String name) {
        Player whoAmI = this.getPlayer(name);
        if (whoAmI.equals(player1)) {
            return this.player2;
        } else if (whoAmI.equals(player2)) {
            return this.player1;
        }

        return null;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
