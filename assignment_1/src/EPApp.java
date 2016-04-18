/**
 * Created by zw on 4/17/16.
 */
public class EPApp {
    public static void main(String[] args) {
        CircularList<String> cir = new CircularList(new LinkedNode("a"));
        cir.add(new LinkedNode("b"));
        cir.add(new LinkedNode("c"));
        System.out.println(cir);
    }
}
