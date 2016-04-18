import java.util.List;

/**
 * Created by zw on 4/17/16.
 */
public class EP implements ExamPile {
    private CircularList<Integer> cirPile = new CircularList();
    private int max;
    private int min;
    private int DEPTH = 1;
    private String steps = "";

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
        System.out.println(this.cirPile + "\n");
        this.mark(1, 0);
        System.out.println(this.cirPile);

        this.mark(1, 0);
        System.out.println(this.cirPile);

        this.mark(1, 1);
        System.out.println(this.cirPile);

        return steps;
    }
}
