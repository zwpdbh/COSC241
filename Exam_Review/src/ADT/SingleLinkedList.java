package ADT;

import java.util.Iterator;

/**
 * Created by zw on 6/3/16.
 */
public class SingleLinkedList<T> implements Iterable {
    private Node first;
    private int count;


    public SingleLinkedList() {
        this.first = null;
        this.count = 0;
    }


    public String toString() {
        StringBuilder result = new StringBuilder("");
        Node node = this.first;
        while (node != null) {
            result.append(node.value);
            node = node.next;
        }
        return result.toString();
    }

    public void add(T value) {
        Node newNode = new Node(value, this.first);
        this.first = newNode;
        count++;
    }

    public void addAtEnd(T value) {
        if (first == null) {
            add(value);
            count++;
            return;
        }

        Node currentOne = first;
        while (currentOne.next != null) {
            currentOne = currentOne.next;
        }
        currentOne.next = new Node(value, null);
        count++;
    }

    public Node<T> getNodeAt(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index");
        } else if (index+1 > count) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node curr = first;
        while (curr != null && index >= 0) {
            curr = curr.next;
            index --;
        }
        return curr;
    }

    public T getValueAt(int index) {
        return getNodeAt(index).value;
    }

    public void addAt(int index, T value) {
        if (index == 0) {
            this.add(value);
            return;
        }

        Node prev = this.getNodeAt(index - 1);
        Node newNode = new Node(value, prev.next);
        prev.next = newNode;
    }

    public Node<T> removeFirstNode() {
        Node result = getNodeAt(0);
        count--;
        return result;
    }

    public Node<T> removeLastNode() {
        Node result = getNodeAt(count-1);
        count--;
        return result;
    }

    private class Node<T> {
        private T value;
        private Node next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> curr = first;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T result = curr.value;
                curr = curr.next;
                return result;
            }
        };
    }

}
