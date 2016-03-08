package week02;

import java.util.*;

/**Coins Class, represent an array of the tossed coins, 
 * each element is represented by boolean value.
 * @author Frank Zhao
 */
public class Coins{
    /**main method to do the unit test.
     * @param args None
     */
    public static void main(String[] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        
        Coins c = new Coins(b);
        System.out.println(c.countHeads());
        System.out.println(c);
        System.out.println(c.countRuns());
        
//        Coins d = new Coins("HHHHHHHHHHHTT");
//        System.out.println();
//        System.out.println(d.countHeads());
//        System.out.println(d);
//        System.out.println(d.countRuns());
//
//        Coins e = new Coins(50);
//        System.out.println();
//        System.out.println(e.countHeads());
//        System.out.println(e);
//        System.out.println(e.countRuns());
//
//        System.out.println();
//        Coins f = new Coins("HHTHHHTTT");
//        System.out.println(f.countRuns());
//
    }

    /**The constent define HEADS as true.*/
    public static final boolean HEADS = true;
    /**The constent define TAILS as true.*/
    public static final boolean TAILS = false;

    /**This is my model, an array of boolean 
     * to represent the states of each coin.*/
    private boolean[] coins;

    /**Constructor: takes [boolean].
     * @param coins */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    
    /**Constructor: takes a string, such as: "HHTTH".
     * @param coinsString */
    public Coins(String coinsString) {
        boolean[] coinsArray = new boolean[coinsString.length()];
        
        for (int i = 0; i < coinsString.length(); i++) {
            char eachCoin = coinsString.toLowerCase().charAt(i);
            if (eachCoin == 'h') {
                coinsArray[i] = true;
            } else if (eachCoin == 't') {
                coinsArray[i] = false;
            }
        }
        this.coins = coinsArray;
    }
    
    /**Constructor: take an int as parameter, and generate an array of boolean.
     * to represent the toss of coins
     * @param length */
    public Coins(int length) {
        boolean[] coinsArray = new boolean[length];
        Random generator = new Random();
        for (int i = 0; i < length; i++) {
            if (generator.nextInt(2) == 1) {
                coinsArray[i] = true;
            } else if (generator.nextInt(2) == 0) {
                coinsArray[i] = false;
            }
        }
        this.coins = coinsArray;
    }
    
    
    /**return the number of coins with head.
     * @param
     * @return int "the count of heads" */
    public int countHeads() {
        int count = 0;
        for (boolean coin: this.coins) {
            if (coin) {
                count++;
            }
        }
        return count;
    }
    
    /**H represent Head, T represent Tail.
     * @param
     * @return String "the description of this" */
    public String toString() {
        String totalCoins = "";
        for (boolean coin: this.coins) {
            if (coin) {
                totalCoins += "H";
            } else {
                totalCoins += "T";
            }
        }
        
        return totalCoins;
    }
    
    /**Returns an int which is the number of runs in this sequence of coins
     * (a run is a block of coins all showing the same face,
     * so for example in HHTHHHTTT
     * there are four runs namely HH, T, HHH, and TTT.
     * @param
     * @return int "the number of runs"
     */
    public int countRuns() {
        int runs = 1;
        boolean sign = this.coins[0];
        for (int i = 1; i< this.coins.length; i++) {
            if (this.coins[i] == sign) {
                runs += 0;
            } else if (this.coins[i] != sign) {
                runs += 1;
            }
            sign = this.coins[i];
        }
        
        return runs;
    }
}
