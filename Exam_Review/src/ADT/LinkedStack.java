package ADT;

/**
 * Created by zw on 6/3/16.
 */
public class LinkedStack<T> extends SingleLinkedList<T> implements Stack<T> {

    @Override
    public T pop() throws EmptyCollectionException {
        return removeFirstNode().getValue();
    }

    @Override
    public T peak() throws EmptyCollectionException {
        return getValueAt(0);
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public void push(T element) {
        add(element);
    }
}
