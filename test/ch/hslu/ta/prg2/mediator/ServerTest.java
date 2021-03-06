package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServerTest {

    public ServerTest() {
    }

    static String myName = "localplayer";

    @BeforeClass
    public static void setUpClass() {
        Server.getInstance().setPlayerName(myName);
        Server.getInstance().newGame();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Server expResult = null;
        Server result = Server.getInstance();
        //assertEquals(expResult, result);
        assertThat(result, not(expResult));
    }

    @Test
    public void testNewGame() {
        System.out.println("newGame");
        Server instance = Server.getInstance();
        Gamestate expResult = null;
        Gamestate result = Server.getInstance().newGame();
        //assertEquals(expResult, result);
        assertThat(result, not(expResult));
    }

    @Test
    public void testNewBotGame() {
        System.out.println("newBotGame");
        Server instance = Server.getInstance();
        Gamestate expResult = null;
        Gamestate result = Server.getInstance().newBotGame();
        //assertEquals(expResult, result);
        assertThat(result, not(expResult));
    }

    @Test
    public void testSetShips() {

        ArrayList<Position> ship1 = new ArrayList<>();
        ship1.add(new Position(6, 6));
        ship1.add(new Position(6, 7));
        ship1.add(new Position(6, 8));

        ArrayList<Position> ship2 = new ArrayList<>();
        ship2.add(new Position(2, 2));
        ship2.add(new Position(2, 3));

        System.out.println("setShips");

        ArrayList<ArrayList<Position>> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);

        Server instance = Server.getInstance();
        //Gamestate expResult = null;
        Gamestate result = instance.setShips(myName, ships);

        assertEquals(result.getPlayer(myName).getShips().get(0).getPositions().get(0).getX(), 6);
        assertEquals(result.getPlayer(myName).getShips().get(0).getPositions().get(0).getY(), 6);
        assertEquals(result.getPlayer(myName).getShips().get(0).getPositions().get(1).getX(), 6);
        assertEquals(result.getPlayer(myName).getShips().get(0).getPositions().get(1).getY(), 7);
        assertEquals(result.getPlayer(myName).getShips().get(0).getPositions().get(2).getX(), 6);
        assertEquals(result.getPlayer(myName).getShips().get(0).getPositions().get(2).getY(), 8);
        
        assertEquals(result.getPlayer(myName).getShips().get(1).getPositions().get(0).getX(), 2);
        assertEquals(result.getPlayer(myName).getShips().get(1).getPositions().get(0).getY(), 2);
        assertEquals(result.getPlayer(myName).getShips().get(1).getPositions().get(1).getX(), 2);
        assertEquals(result.getPlayer(myName).getShips().get(1).getPositions().get(1).getY(), 3);
        
        //fail("The test case is a prototype.");
    }

    @Test
    public void testShoot() {
        int x = 4;
        int y = 3;
        Gamestate result = Server.getInstance().shot(myName, x, y);
        Field f = result.getOpponent(myName).getField()[4][3];
        //assertNotEquals(Field.WATER, f);
        assertThat(f, not(Field.WATER));

    }

    @Test
    public void testGetField() {
        Gamestate testGame = Server.getInstance().newBotGame();
        Field[][] fields = testGame.getPlayer(myName).getField();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                assertEquals(Field.WATER, fields[x][y]);

            }
        }
    }
}
