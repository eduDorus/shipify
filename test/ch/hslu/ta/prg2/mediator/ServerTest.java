
package ch.hslu.ta.prg2.mediator;

import ch.hslu.ta.prg2.Gamestate.Field;
import ch.hslu.ta.prg2.Gamestate.Gamestate;
import ch.hslu.ta.prg2.Gamestate.Position;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServerTest {

    public ServerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNewGame() {
        System.out.println("newGame");
        Server instance = null;
        Gamestate expResult = null;
        Gamestate result = instance.newGame();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNewBotGame() {
        System.out.println("newBotGame");
        Server instance = null;
        Gamestate expResult = null;
        Gamestate result = instance.newBotGame();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetShips() {
        System.out.println("setShips");
        ArrayList<ArrayList<Position>> ships = null;
        Server instance = null;
        Gamestate expResult = null;
        Gamestate result = instance.setShips(ships);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testShoot() {
        int x = 4;
        int y = 3;
        Gamestate result = Server.getInstance().shoot(x, y);
        Field f = result.getPlayer1().getField()[4][3];
        assertNotEquals(Field.WATER, f);
    }
    
    @Test
    public void testGetField() {
        Gamestate testGame =  Server.getInstance().newBotGame();
        Field[][] fields = testGame.getPlayer1().getField();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                assertEquals(Field.WATER, fields[x][y]);

            }
        }
        
        
    }
}
