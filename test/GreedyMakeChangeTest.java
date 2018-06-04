/*
 * Author: Logan Caraway
 * Date Created: 6/2/2018
 * Purpose: When given a number (in cents) returns 
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GreedyMakeChangeTest {
    
    //tests for when sending null array (desired: throw exception)
    @Test
    public void testMakeChange() {
        GreedyMakeChange mc = new GreedyMakeChange();
        int coins[] = null;
        try {
            mc.makeChange(coins, 115);
            fail();
        } catch (Exception e) {}
    }
    
    //tests for when sending an array containing a zero value coin (desired: return null array)
    @Test
    public void testMakeChange2() {
        GreedyMakeChange mc = new GreedyMakeChange();
        int coins[] = new int[] {0, 2, 3, 4, 5};
        int change[] = mc.makeChange(coins, 115);
        assertNull(change);
    }
    
    //test whether or not change adds up to total
    @Test
    public void testMakeChange3() {
        GreedyMakeChange mc = new GreedyMakeChange();
        int coins[] = new int[] {1, 5, 10, 25, 50};
        int total = 717;
        int sum = 0;
        int change[] = mc.makeChange(coins, total);
        for (int i = 0; i < coins.length; i++)
            sum += (coins[i] * change[i]);
        assertEquals(total, sum);
    }
    
    //tests for when to coins have same value (Desired: return null array)
    @Test
    public void testMakeChange4() {
        GreedyMakeChange mc = new GreedyMakeChange();
        int coins[] = new int[] {1, 10, 10, 25};
        int change[] = mc.makeChange(coins, 117);
        assertNull(change);
    }
}
