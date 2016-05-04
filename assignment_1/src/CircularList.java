/**
 * Created by zw on 4/18/16.
 */
public class CircularList<T> {
    
    /**the circular list(used as stack) has three attributes
     * the head is the current node, for this assignment, you keep marking the
     * current node, if need to delay, simply rotate the circle, which make
     * head point to the next several node. That's also why we use circular
     * list to implement this assignment
     * tail, its purpose is to make the list to form a circle, it point to the
     * head
     * The count is a attribue to help to check the size of the list
     * */
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

    /**rotate the circle with number of num, by making the head point to the
     * next num nodes
     * */
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

    /**return the head's element*/
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
    
    /**toString method for troubleshooting*/
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
    /**
     * the node 
     * */
    private class LinkedNode<T> {
        T element;
        LinkedNode<T> next;

        LinkedNode(T element) {
            this.element = element;
        }
    }
}
