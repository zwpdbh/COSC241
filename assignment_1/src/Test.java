import java.util.LinkedList;
import java.util.List;

/**
 * Created by zw on 5/5/16.
 */
public class Test {
    public static void main(String[] args) {
        EP ep  = new EP();
        ep.load(new LinkedList<>());
        ep.sortingSteps();
    }
}
