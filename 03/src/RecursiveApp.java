/**
 * Created by zw on 3/11/16.
 * @author zw
 */


public class RecursiveApp {
    public static void main(String[] args) {
        System.out.println(digit(123456));
        System.out.println(sumOfDigit(123));
    }

    /**
     * @param n
     * @return long
     */
    public static long digit(long n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + digit(n/10);
        }
    }

    /**
     * @param n
     * @return long
     */
    public static long sumOfDigit(long n) {
        int sum = 0;

        if (n<10) {
            return n;
        }

        return sum;
    }
}
