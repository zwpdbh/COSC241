package ADT;

/**
 * Created by zw on 6/3/16.
 */
public class LinkedStack<T> extends SingleLinkedList implements Stack {
    @Override
    public Object pop() throws EmptyCollectionException {
        return null;
    }

    @Override
    public Object peak() throws EmptyCollectionException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
