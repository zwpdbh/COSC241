package ADT;

/**
 * Created by zw on 6/3/16.
 */
public interface Heap<T>  {
    public T max() throws EmptyCollectionException;

    public T removeMax() throws EmptyCollectionException;

    public void add(T element);
}
