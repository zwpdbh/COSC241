/**
 * Created by zw on 3/11/16.
 * @author zw
 */


public class RecursiveApp {
    public static void main(String[] args) {
        System.out.println(digit(111));
    }

    public static long digit(long n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + digit(n/10);
        }
    }
}
