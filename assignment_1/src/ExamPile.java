import java.util.List;

/**
 * Created by zw on 4/17/16.
 */
public interface ExamPile {
    public void load(List<Integer> items);
    public int peek() throws EmptyPileException;
    public int mark(int depth, int value) throws EmptyPileException;
    public void delay(int count) throws EmptyPileException;
}