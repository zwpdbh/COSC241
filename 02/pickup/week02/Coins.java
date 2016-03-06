package week02;

import java.util.*;

public class Coins{
    
    /**main method to do the unit test*/
    public static void main(String[] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        
        Coins c = new Coins(b);
        System.out.println(c.countHeads());
        System.out.println(c);
        System.out.println(c.countRuns());
        
        Coins d = new Coins("HHHHHHHHHHHTT");
        System.out.println();
        System.out.println(d.countHeads());
        System.out.println(d);
        System.out.println(d.countRuns());
        
        Coins e = new Coins(50);
        System.out.println();
        System.out.println(e.countHeads());
        System.out.println(e);
        System.out.println(e.countRuns());
        
        System.out.println();
        Coins f = new Coins("HHTHHHTTT");
        System.out.println(f.countRuns());
        
        System.out.println();
        Coins g = new Coins(1000);
        System.out.println("the runs for tossing 1000 coins is: " + g.countRuns());
    }

    public static final boolean HEADS = true;
    public static final boolean TAILS = false;
	
    // this is my model, an array of boolean to represent the states of each coin
    private boolean[] coins;
	
    /**Constructor: takes [boolean]*/
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    
    /**Constructor: takes a string, such as: "HHTTH"*/
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
    
    /**Constructor: take an int as parameter, and generate an array of boolean to represent the toss of coins*/
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
    
    
    /**return the number of coins with head*/
    public int countHeads() {
        int count = 0;
        for (boolean coin: this.coins) {
            if (coin) {
                count++;
            }
        }
        return count;
    }
    
    /**H represent Head, T represent Tail*/
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
     * there are four runs namely HH, T, HHH, and TTT.*/
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
