
package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gamestate setShips() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gamestate shoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
