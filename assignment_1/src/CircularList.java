/**
 * Created by zw on 4/18/16.
 */
public class CircularList<T> {
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int count;


    public CircularList() {
        head = tail;
        count = 0;
    }

    public void add(T element) {
        LinkedNode<T> node = new LinkedNode<T>(element);
        if (this.count == 0) {
            head = node;
            head.next = tail;
            tail = head;
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }

        count++;
    }

    public boolean delete(T element, int range) {
        if (this.count < 1) {
            head = tail;
            count = 0;
            return false;
        }

        LinkedNode<T> current = this.head;
        if (head.element == element) {
            head = head.next;
            tail.next = head;
            this.count--;
            return true;
        } else {
            for (int i = 0; i < range - 1; i++) {
                if (current.next.element == element) {
                    current.next = current.next.next;
                    this.count--;
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }


    public void moveHeadForward(int num) {
        for (int i = 0; i < num; i++) {
            try {
                head = head.next;
                tail = tail.next;
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }


    public T currentOne() {
        if (count == 0) {
            return null;
        }
        return head.element;
    }

    public T lastOne() {
        if (count == 0) {
            return null;
        }
        return tail.element;
    }

    public String toString() {
        String str = "";
        LinkedNode<T> current = head;
        int nodeNum = count;
        while (nodeNum > 0) {
            str += (current.element + "_");
            //System.out.println(current.element);
            current = current.next;
            nodeNum--;
        }
        return "total number of nodes are: " + count + "\n:" + str + "\n" + "head: " + currentOne()
                + "\n" + "tail: " + lastOne();
    }

    public int count() {
        return this.count;
    }

    private class LinkedNode<T> {
        T element;
        LinkedNode<T> next;

        LinkedNode(T element) {
            this.element = element;
        }
    }
}
