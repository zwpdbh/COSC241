package ADT;

/**
 * Created by zw on 6/3/16.
 */
public interface Heap<T> {
    public T max();

    public T removeMax();

    public boolean add(T element);
}
