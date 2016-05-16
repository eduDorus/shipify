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

    public Player getPlayer(String name){
        if(this.player1.getName().equals(name)){
            return player1;
        }
        else if(this.player2.getName().equals(name)){
            return player2;
        }
        return null;
    }
    
    public Player getOponent(String name){
        Player whoAmI = this.getPlayer(name);
        if(whoAmI.equals(player1)){
            return this.player2;
        }
        else if(whoAmI.equals(player2)){
            return this.player1;
        }
        
        return null;
    }
    
    
    
}
