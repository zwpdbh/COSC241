package ADT;

/**
 * Created by zw on 6/3/16.
 */
public interface Stack<T> {
    public void add(T element);

    public T pop() throws EmptyCollectionException;

    public T peak() throws EmptyCollectionException;

    public boolean isEmpty();

    public int size();

    public String toString();
}
