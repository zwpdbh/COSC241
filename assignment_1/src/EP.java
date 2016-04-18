import java.util.List;

/**
 * Created by zw on 4/17/16.
 */
public class EP implements ExamPile {
    CircularList<Integer> cirPile = new CircularList();

    @Override
    public void load(List<Integer> items) {
        for (Integer each: items) {
            cirPile.add(each);
        }
    }

    @Override
    public int peek() {
        return (Integer) cirPile.currentOne();
    }

    @Override
    public int mark(int depth, int value) {
        if (cirPile.delete(value, depth)) {
            return value;
        } else {
            return -1;
        }
    }

    @Override
    public void delay(int count) {
        cirPile.moveHeadForward(count);
    }
}
