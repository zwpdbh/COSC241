package week07;

import java.util.*;
import java.io.*;

/**
 * Useing simple 26 letter's frequency to generate word.
 * @author Frank Zhao, 4-13
 */
public class FrequencyGenerator implements WordGenerator {
//    public static void main(String[] args) {
//        FrequencyGenerator f = new FrequencyGenerator(new Random(241));
//        
//        for (int i=0; i<5; i++) {
//            System.out.println(f.nextWord(10));
//        }
//
//    }
    /**used for receiving Random instance.*/
    private Random random;

    /**Constructor.
     * @param r for Random instance.
     */
    public FrequencyGenerator(Random r) {
        random = r;
    }
    
    /** Create a word.
    * @param n for specify the length of word will be created.
    * @return result is the word.
    */
    public String nextWord(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += (char)('a' + chooseIndex());
        }

        return result;
    }

    /**
    * helper method for return index for indexing 26 letters.
    * @return i. 
    */
    private int chooseIndex() {
        int i=0;
        String fileName = "letter-frequencies.txt";
        double[] weights = new double["abcdefghigklmnopqrstuvwxyz".length()];
        double r = this.random.nextDouble();
        try {
            Scanner scan = new Scanner(new File(fileName));
            while(scan.hasNext()) {
                try {
                    weights[i] = Double.parseDouble(scan.nextLine());
                } catch (Exception errorArr) {
                    System.out.println(errorArr);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    
        i=0;
        while (r>weights[i]) {
            r = r - weights[i];
            i++;
        }
        return i;
    }    
}
