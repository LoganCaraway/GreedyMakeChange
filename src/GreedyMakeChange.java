/*
 * Author: Logan Caraway
 * Date Created: 6/2/2018
 * Purpose: When given a number (in cents) returns 
 */
import java.lang.NullPointerException;

public class GreedyMakeChange {
    
    public GreedyMakeChange() {}
    
    //returns an array representing the number of coins in change where each number represents
    //the number of coins in its equivalent index from the coin[] sent in
    public int[] makeChange(int[] coins, int amount) {
        int change[] = null;
        
        //if coins array is null, throw exception
        if (coins == null)
            throw new NullPointerException();
        
        //if coins contains a coin with zero value, return a null aray
        if (coins[0] == 0)
            return change;
        
        //coins must be in increasing order, else return null array
        //if coins has different coins with the same value, return null array
        for (int i = 0; i < coins.length -1; i++)
            for (int j = i +1; j < coins.length; j++)
                if (coins[j] <= coins[i])
                    return change;
        
        change = new int[coins.length];
        for (int i = coins.length -1; i >= 0; i--)
            if (amount >= coins[i]) {
                change[i]++;
                amount -= coins[i];
                i = coins.length;
            }
        return change;
    }
}
