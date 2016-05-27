package recursion;

/**
 * Created by zw on 5/26/16.
 */
public class Recursion {
    public static boolean contains(String str, String pattern) {
        if(pattern.length() == 0) {
            return true;
        }
        if (str.length() < pattern.length()) {
            return false;
        }

        int i = str.indexOf(pattern.charAt(0));
        if (i == -1) {
            return false;
        } else {
            return contains(str.substring(i + 1), pattern.substring(1));
        }
    }
}
