import java.util.ArrayList;

/**
 * Created by zw on 4/17/16.
 */
public class EPApp {
    public static void main(String[] args) {


//
//        ArrayList<Integer> test = new ArrayList<Integer>();
//        test.add(1);
//        test.add(0);
//        test.add(2);
//
//        EP ep = new EP();
//        ep.load(test);
//        System.out.println(ep.sortingSteps());

        CircularList<Integer> cir = new CircularList<Integer>();

        String test = "102";
        for (int i = 0; i<test.length(); i++) {
            cir.add(Integer.parseInt("" + test.charAt(i)));
        }

        System.out.println(cir);
        cir.delete(0, 1);

        System.out.println(cir);

        cir.moveHeadForward(1);
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());

        System.out.println("Before delete");
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());
        cir.delete(0, 1);
        System.out.println("After delete");
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());

        cir.delete(1, 1);
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());

//        cir.moveHeadForward(1);
//        System.out.println(cir);
//        System.out.println(cir.currentOne());
//        System.out.println(cir.lastOne());

        cir.add(4);
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());

        cir.moveHeadForward(1);
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());

        cir.add(3);
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());

        cir.delete(2, 1);
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());

        cir.moveHeadForward(1);
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());

        cir.delete(4, 1);
        System.out.println(cir);
        System.out.println(cir.currentOne());
        System.out.println(cir.lastOne());


    }


}
