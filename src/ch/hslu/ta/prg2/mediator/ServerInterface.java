
package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;

public interface ServerInterface {
    public Gamestate newGame();
    public Gamestate newBotGame();
    public Gamestate setShips();
    public Gamestate shoot();
    
}
