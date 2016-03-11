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
        String str = "123456";
        for (int i = 0; i< str.length(); i++) {
            t = t.add(str.charAt(i));
        }
        
        System.out.println("The number of block of 1 is: " + t.count('1'));
        System.out.println("The height of block of tower is: " + t.height());
        System.out.println(t);
        
        t.take(4);
        System.out.println("The top 4 blocks of tower is: " + t);

        System.out.println();
        t.setTower("123456");
        System.out.println("The current tower is:" + t);
        t.remove(3);
        System.out.println("After removing top 3 blocks, the rest tower is:" + t);

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
