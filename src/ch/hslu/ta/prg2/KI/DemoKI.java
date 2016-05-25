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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author comander
 */
public class DemoKI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FileWriter fw = null;
        try {
            // TODO code application logic here

            //Ist einfach so
            Server.getInstance().setPlayerName("Marco");
            Server.getInstance().newBotGame();

            //--------------------------------------------------------
            //Bei einem neuen BOT-GAME MUSS! der x und y Wert im File
            //lastBotShoot.txt auf 0 gesetzt werden, erster Aufruf!
            fw = new FileWriter("lastBotShoot.txt");
            BufferedWriter out = new BufferedWriter(fw);
            out.write(0 + "");
            out.newLine();
            out.write(0 + "");
            out.flush();
            out.close();
            //--------------------------------------------------------
            
            
            //Definieren des ersten Schiffs
            ArrayList<Position> ship1 = new ArrayList<>();
            ship1.add(new Position(8, 6));
            ship1.add(new Position(8, 7));
            ship1.add(new Position(8, 8));

            //Definieren des zweiten Schiffs
            ArrayList<Position> ship2 = new ArrayList<>();
            ship2.add(new Position(2, 2));
            ship2.add(new Position(3, 2));

            //Beide Schiffe in die Schiffliste
            ArrayList<ArrayList<Position>> ships = new ArrayList<>();
            ships.add(ship1);
            ships.add(ship2);

            //Aufruf der Methode setShips des Servers
            Gamestate currentState = Server.getInstance().setShips(ships);
            
            //Aufruf des BOTS, Methode Shoot
            for (int i = 0; i < 10; i++) {
                KI ki = new KI(currentState);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(DemoKI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(DemoKI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
