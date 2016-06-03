package ADT;

/**
 * Created by zw on 6/3/16.
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] stack;
    private int count;
    private int Current_Capacity = 10;

    public ArrayStack() {
        stack = (T[]) (new Object[Current_Capacity]);
        count = 0;
    }

    @Override
    public void push(T element) {
        if (count == Current_Capacity) {
            expandCapacity();
        }

        stack[count] = element;
        count++;
    }

    @Override
    public T pop() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException("The stack you are trying to pop is empty");
        } else {
            T tmp = stack[count];
            stack[count] = null;
            count--;
            return tmp;
        }
    }

    @Override
    public T peak() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The stack you are peaking is empty");
        }
        return stack[count];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return stack.length;
    }

    private void expandCapacity() {
        T[] larger = (T[]) (new Object[Current_Capacity*2]);
        System.arraycopy(stack, 0, larger, 0, Current_Capacity);
        stack = larger;
    }

    public String toString() {
        String result = "<top of stack>\n";
        for (int index=count-1; index >= 0; index--){
            result += stack[index] + "\n";
        }
        return result + "<bottom of stack>";
    }
}
