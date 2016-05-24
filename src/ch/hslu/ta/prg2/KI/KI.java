/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ta.prg2.KI;

import ch.hslu.ta.prg2.Gamestate.*;
import ch.hslu.ta.prg2.mediator.*;
import java.util.Random;

public class KI {

    private Gamestate state;
    private static int x;
    private static int y;
    private Field[][] field = Server.getInstance().getGamestate().getOpponent(Server.getInstance().getGamestate().getPlayer("bot").getName()).getField();

    public KI(Gamestate state) {

        this.state = state;

        if(x == 0 && y == 0){
            randomShoot();
        }
        
        if (field[x][y] == Field.HIT) {

            randomShoot();

        }

        if (field[x][y] == Field.SHIPHIT) {

            shootAround(x, y);

        }

        if (field[x][y] == Field.SHIPDESTROYED) {

            randomShoot();

        }

    }

    public Gamestate randomShoot() {

        Random randomInt = new Random();

        this.x = randomInt.nextInt(10);
        this.y = randomInt.nextInt(10);

        Server.getInstance().shoot(x, y);

        return state;

    }

    public Gamestate shootAround(int x, int y) {

        Random randomInt = new Random();

        int whichField = randomInt.nextInt(9);

        switch (whichField) {

            case 0:
                Server.getInstance().shoot(x - 1, y);
                break;
            case 1:
                Server.getInstance().shoot(x - 1, y - 1);
                break;
            case 2:
                Server.getInstance().shoot(x - 1, y+1);
                break;
            case 3:
                Server.getInstance().shoot(x + 1, y);
                break;
            case 4:
                Server.getInstance().shoot(x + 1, y - 1);
                break;
            case 5:
                Server.getInstance().shoot(x + 1, y + 1);
                break;
            case 6:
                Server.getInstance().shoot(x, y);
                break;
            case 7:
                Server.getInstance().shoot(x, y - 1);
                break;
            case 8:
                Server.getInstance().shoot(x, y + 1);
                break;

        }

        return state;
    }

    //ONLY USED for DemoKI
    public int getX() {
        return x;
    }

    //ONLY USED for DemoKI
    public int getY() {
        return y;
    }
    
    

}
