import java.util.ArrayList;

/**
 * Created by zw on 4/17/16.
 */
public class EPApp {
    public static void main(String[] args) {


//        String test1 = "8762105934";
//        String test2 = "1869032754";
//
//        EP ep1 = new EP();
//        ep1.load(testList(test1));
//        System.out.println(ep1.cirPile);
//        System.out.println(ep1.sortingSteps());
//        String expectedResult1 = "DDDDDMDDDDDDDDMDDDDDDDMDDMMDDDMDDDMDDMDMM";
//        if (ep1.sortingSteps().equals(expectedResult1)) {
//            System.out.println(true);
//        }
//
//
//        EP ep2 = new EP();
//        ep2.load(testList(test2));
//        System.out.println(ep2.sortingSteps());
//        String expectedResult2 = "DDDDMDDDDDMDDDDMDDDDDDMDDMDDDDMDMDMMM";
//        if (ep2.sortingSteps().equals(expectedResult2)) {
//            System.out.println(true);
//        }
//
//        EP ep = new EP();
//        ep.setDEPTH(3);

//        ep.load(testList(test2));
//        System.out.println(ep.sortingSteps());
//        if (ep.sortingSteps().equals("DMDDMDMMMMMMMM")) {
//            System.out.println(true);
//        }

//        ep.load(testList(test1));
//        System.out.println(ep.cirPile);
//        System.out.println(ep.sortingSteps());
//        if (ep.sortingSteps().equals("DMMMMMMDMMMM")) {
//            System.out.println(true);
//        }

        EP ep = new EP();

//        ep.load(testList("3102"));
//        System.out.println(ep.cirPile);
//        System.out.println(ep.sortingSteps());
//
//        System.out.println(ep.cirPile);


        ep.cirPile.add(1);
        System.out.println(ep.cirPile);

        ep.cirPile.add(0);
        System.out.println(ep.cirPile);


        ep.cirPile.delete(1, 1);
        System.out.println(ep.cirPile);

        ep.cirPile.add(1);
        System.out.println(ep.cirPile);

        ep.cirPile.moveHeadForward(1);
        System.out.println(ep.cirPile);

        ep.cirPile.delete(1,1);
        System.out.println(ep.cirPile);

        ep.cirPile.delete(0,1);
        System.out.println(ep.cirPile);

        ep.cirPile.add(1);
        System.out.println(ep.cirPile);
    }

    public static ArrayList<Integer> testList(String str) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        for (int i = 0; i<str.length(); i++) {
            test.add(Integer.parseInt("" + str.charAt(i)));
        }

        return test;
    }

}
