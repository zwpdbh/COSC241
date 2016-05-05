import java.util.List;

/**
 * Provids an interface by which ever new pile of
 * exams must contain its assoicated methods.
 *
 * @author William Sanson <willysanson@hotmail.com>
 * @author Frank Zhao
 */
public interface ExamPile {

    /**
     * Initialises the pile of exams to consist of
     * the contents of the list <code>items</code>.
     *
     * @param items a list of type Integer containg  of exams.
     */
    public void load(List<Integer> items);

    /**
     * Looks at the first value in the list and return it.
     * If list is empty, returns null.
     *
     * @return the value at the top of the pile.
     * @throws EmptyPileException if an exam pile is empty.
     */
    public int peek() throws EmptyPileException;

    /**
     * Looks throught the pile to a specified <code>depth</code>, if
     * the <code>value</code> is found within this depth it is returned
     * else -1 is returned.
     *
     * @param depth specifies how deep to look within the pile.
     * @param value specifies which value to look for.
     * @return the given value paramerter if found in the pile.
     * @throws EmptyPileException if an exam pile is empty.
     */
    public int mark(int depth, int value) throws EmptyPileException;

    /**
     * Moves <code>count</code> values from the top of the pile
     * to the bottom.
     *
     * @param count the number of times to delay.
     * @throws EmptyPileException if an exam pile is empty.
     */
    public void delay(int count) throws EmptyPileException;

}
