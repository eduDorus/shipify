/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ta.prg2.Gamestate;

import java.io.Serializable;

/**
 *
 *
 */
public class Gamestate implements Serializable {

    private Player player1;
    private Player player2;

    public Gamestate(String name) {

        player1 = new Player(name);

    }

    public Gamestate(String name, boolean againstBot) {

        this(name);

        if (againstBot) {
            player2 = new Player("bot");
        }

    }

}
