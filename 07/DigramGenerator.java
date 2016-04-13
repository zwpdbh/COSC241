package week07;

import java.util.*;
import java.io.*;

/**
* Using DigramGenerator to create word.
* @author Frank Zhao
*/
public class DigramGenerator implements WordGenerator {
    /**for receiving random instance.*/
    private Random random;

    /**Constructor.
    * @param r the random instance.
    */
    public DigramGenerator(Random r) {
        random = r;
    }
    
    /**
    * return the word with length n.
    * @param n the length of word.
    * @return a string as word.
    */
    public String nextWord(int n) {
        try {
            Scanner fileScanner = new Scanner(new File("first-letters.txt"));
            String firstLetterString = fileScanner.next();
            String word = "" + 
                firstLetterString.charAt(
                        this.random.nextInt(firstLetterString.length()));
            for (int i=1; i<n; i++) {
                char lastChar = word.charAt(word.length()-1);
                word += this.nextLetter(lastChar);
            }
            return word;
        } catch (Exception e) {
            return "";
        }
    }
    
    /**
    * Helper function which receive a char and return the a string. 
    * @param c the char. 
    * @return string as char.
    */
    private String nextLetter(char c) {
        String filename = "continuations.txt";
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            String[] letterArray = 
                new String["abcdefghigklmnopqrstuvwxyz".length()];
            int i=0;
            while (fileScanner.hasNext()) {
                letterArray[i]=fileScanner.nextLine();
                i++;
            }
            
            int index = c - 'a';
            String associatedString = letterArray[index];
            return "" + 
            associatedString.charAt(
                    this.random.nextInt(associatedString.length()));
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }
    
    // public static void main(String[] args) {
    //     DigramGenerator d = new DigramGenerator(new Random(241));
    //     System.out.println(d.nextWord(5));
    // }

}
