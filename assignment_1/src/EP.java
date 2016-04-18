import java.util.List;

/**
 * Created by zw on 4/17/16.
 */
public class EP implements ExamPile {
    private CircularList<Integer> cirPile = new CircularList();
    private int max;
    private int min;

    @Override
    public void load(List<Integer> items) {
        max = min = items.get(0);
        for (Integer each: items) {
            cirPile.add(each);

            if (each > max) {
                max = each;
            }
            if (each < min) {
                min = each;
            }
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

    public String sortingSteps() {
        return "";
    }
}
