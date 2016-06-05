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

    public static String removeDups(String s) {
        if (s.length() <= 1) return s;
        char c0 = s.charAt(0);
        String r = removeDups(s.substring(1, s.length()));
        if (r.charAt(0) == c0) {
            return r;
        } else {
            return c0 + r;
        }
    }
}
