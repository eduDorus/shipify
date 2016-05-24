/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ta.prg2.KI;

import ch.hslu.ta.prg2.*;
import ch.hslu.ta.prg2.gui.GUIController;
import ch.hslu.ta.prg2.mediator.Server;
import ch.hslu.ta.prg2.mediator.*;
import ch.hslu.ta.prg2.gui.*;
import ch.hslu.ta.prg2.Gamestate.*;
import java.util.ArrayList;

/**
 *
 * @author comander
 */
public class DemoKI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Server.getInstance().newBotGame("Marco");
        
        ArrayList<Position> ship1 = new ArrayList<>();
        ship1.add(new Position(8, 6));
        ship1.add(new Position(8, 7));
        ship1.add(new Position(8, 8));
        
        ArrayList<Position> ship2 = new ArrayList<>();
        ship2.add(new Position(2, 2));
        ship2.add(new Position(3, 2));
        
        ArrayList<ArrayList<Position>> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        
        Gamestate currentState = Server.getInstance().setShips(ships);
        
        
        for(int i = 0; i < 10; i++){
        KI ki = new KI(currentState);
        
            System.out.println(ki.getX()+", "+ki.getY());
            
        }

        
        
    }

}
