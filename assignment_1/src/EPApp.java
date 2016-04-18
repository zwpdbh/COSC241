/**
 * Created by zw on 4/17/16.
 */
public class EPApp {
    public static void main(String[] args) {
        CircularList<Integer> cir = new CircularList();
        for (int i = 0; i<5; i++) {
            cir.add(i);
        }
        System.out.println(cir);

        cir.delete(1, 2);
        System.out.println(cir);


        cir.delete(0, 2);
        System.out.println(cir);

        cir.delete(2, 1);
        System.out.println(cir);

        cir.delete(3, 1);
        System.out.println(cir);

        cir.delete(4, 1);
        System.out.println(cir);

        cir.delete(0, 1);

        for (int i = 0; i<5; i++) {
            cir.add(i);
        }
        System.out.println(cir);
    }
}
