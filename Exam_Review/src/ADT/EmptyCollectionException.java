package ADT;

/**
 * Created by zw on 6/3/16.
 */
public class EmptyCollectionException extends Exception {
    private static final long serialVersionUID = 42L;

    /**
     * Takes a string <code>message</code> and uses it as input
     * to its parent class to be printed to screen.
     *
     * @param message the thrown instance to be output
     */
    public EmptyCollectionException(String message) {
        super(message);
    }
}
