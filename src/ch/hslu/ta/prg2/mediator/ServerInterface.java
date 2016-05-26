package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import java.util.ArrayList;

public interface ServerInterface {

    public Gamestate newGame();

    public Gamestate newBotGame();

    public Gamestate setShips(String localPlayerName, ArrayList<ArrayList<Position>> ships);

    public Gamestate shoot(String localPlayerName, int x, int y);
}
