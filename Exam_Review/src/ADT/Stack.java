package ADT;

/**
 * Created by zw on 6/3/16.
 */
public interface Stack<T> {

    public T pop() throws EmptyCollectionException;

    public void push(T element);

    public T peak() throws EmptyCollectionException;

    public boolean isEmpty();

    public int size();

    public String toString();
}
