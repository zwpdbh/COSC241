import java.util.List;

/**
 * Created by zw on 4/17/16.
 */
public interface ExamPile {
    public void load(List<Integer> items);
    public int peek();
    public int mark(int depth, int value);
    public void delay(int count);
}