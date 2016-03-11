//package week03;
/**
 * Created by zw on 3/11/16.
 * @author zw
 */

public class RecursiveApp {
    public static void main(String[] args) {
        System.out.println(digit(1234567));
        System.out.println(sumOfDigit(523));

        System.out.println(digit(-1234567));
        System.out.println(sumOfDigit(-523));
        
        Tower t = new Tower();
        t = t.add('a');
        t = t.add('b');
        t = t.add('c');
        t = t.add('b');
        
        System.out.println("The number of block of b is : " + t.count('b'));
        System.out.println("The height of block of tower is: " + t.height());
        System.out.println(t);

    }

    /**
     * @param n
     * @return long , represent the length of the digital number
     */
    public static long digit(long n) {
        if (n < 0) {
            return digit(-1 * n);
        }

        if (n < 10) {
            return 1;
        } else {
            return 1 + digit(n/10);
        }
    }

    /**
     * @param n
     * @return long , represent the sum of digital number, such as"123" = 6
     */
    public static long sumOfDigit(long n) {
        if (n < 0) {
            return sumOfDigit(-1 * n) * (-1);
        }

        if (n < 10) {
            return n;
        } else {
            return n%10 + sumOfDigit(n/10);
        }
    }
}
