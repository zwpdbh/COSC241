
/**
 * Created by zw on 3/1/16.
 */

package week01;
import java.util.Scanner;

/**
 * It read a file and return the number of words and lines.
 * @author Frank zhao
*/

public class Counter {
/**
 * It read a file and return the number of words and lines.
 * @param args fajkshdgfasdj
*/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lines = 0;
        int words = 0;
        while (input.hasNextLine()) {
            lines++;
            Scanner eachLine = new Scanner(input.nextLine());
            while (eachLine.hasNext()) {
                words++;
                eachLine.next();
            }
        }


        System.out.println("lines: " + lines + "\nwords: " + words);
    }
}
