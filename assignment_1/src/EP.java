import java.util.List;

/**
 * Created by zw on 4/17/16.
 */
public class EP implements ExamPile {
    public CircularList<Integer> cirPile = new CircularList();
    private int max;
    private int min;
    private int depth = 1;
    public String steps = "";

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
        if (cirPile.count()==0) {
            return -2;
        }
        if (cirPile.delete(value, depth)) {
            steps += "M";
            return value;
        } else {
            cirPile.moveHeadForward(depth);
            steps += "D";
            return -1;
        }
    }

    @Override
    public void delay(int count) {
        cirPile.moveHeadForward(count);
    }

    public String sortingSteps() {
        int mark = min;
        while (mark<=max) {
            int result = mark(depth, mark);
            if (result == -2) {
                break;
            } else if (result == -1) {
                continue;
            } else {
                mark++;
            }
        }
        return steps;
    }

    public void setDEPTH(int depth) {
        this.depth = depth;
    }
}
