package ADT;

/**
 * Created by zw on 6/3/16.
 */
public class LinkedStack<T> extends SingleLinkedList<T> implements Stack<T> {

    @Override
    public T pop() throws EmptyCollectionException {
        try {
            return removeFirstNode().getValue();
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyCollectionException("The stack you are popping is empty");
        }
    }

    @Override
    public T peek() throws EmptyCollectionException {
        try {
            return getValueAt(0);
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyCollectionException("The stack you are peaking is empty");
        }
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
