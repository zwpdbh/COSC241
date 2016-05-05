/**
 * The EmptyPileException class extends the Exception class and
 * will be used whenever the program has a chance of operating
 * on an instance of EP with an empty pile.
 *
 * @author William Sanson <willysanson@hotmail.com>
 * @author Frank Zhao
 */
public class EmptyPileException extends Exception {

    private static final long serialVersionUID = 42L;

    /**
     * Takes a string <code>message</code> and uses it as input
     * to its parent class to be printed to screen.
     *
     * @param message the thrown instance to be output
     */
    public EmptyPileException(String message) {
        super(message);
    }
}
