
package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import java.util.ArrayList;

public interface ServerInterface {
    public Gamestate newGame(String playername);
    public Gamestate newBotGame(String playername);
    public Gamestate setShips(String playername, ArrayList<ArrayList<Position>> ships);
    public Gamestate shoot(String playername, int x, int y);
}
