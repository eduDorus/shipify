
package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import java.util.ArrayList;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gamestate shoot(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
