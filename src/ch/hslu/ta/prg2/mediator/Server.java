
package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import ch.hslu.ta.prg2.Gamestate.Ship;
import java.util.ArrayList;
import java.util.Iterator;

public class Server implements ServerInterface{
    
    Gamestate state;
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
        state = new Gamestate("localplayer");
        return state;
    }

    @Override
    public Gamestate newBotGame() {
        
        this.state = new Gamestate("localplayer", true);
        return state;
    }

    @Override
    public Gamestate setShips(ArrayList<ArrayList<Position>> ships) {
        
        
        Iterator itr1 = ships.iterator();
        
        while(itr1.hasNext()){
            
            ArrayList<ArrayList<Position>> current = (ArrayList<ArrayList<Position>>) itr1.next();
            
            Iterator itr2 = current.iterator();
            
            while(itr2.hasNext()){
                
                Ship current2 =  (Ship)itr2.next();
                
                this.state.getPlayer1().getShips().add(current2);
                
            }
            
        }
        
        
        
        return null;
    }

    @Override
    public Gamestate shoot(int x, int y) {
        state.getPlayer1().addShoot(x, y);
        return state;
    }
}
