/**
 * Created by zw on 4/18/16.
 */
public class CircularList<T> {
    private LinkedNode head;
    private LinkedNode tail;
    private int count;


    public CircularList() {
        head = tail;
        count = 0;
    }

    public void add(T element) {
        LinkedNode node = new LinkedNode(element);
        try {
            tail.next = node;
            node.next = head;
            tail = node;
        } catch (NullPointerException e) {
            // if the added node is the first node, need to treat it specially.
            head = node;
            head.next = tail;
            tail = head;
        } finally {
            count++;
        }
    }

    public boolean delete(T element, int range) {
        LinkedNode current = this.head;
        if (head.element == element) {
            System.out.println("In the head");
            this.moveHeadForward(1);
            tail.next = head;
            this.count--;
            return true;
        }
        for (int i=0; i<range; i++) {
            if (current.next.element == element) {
                current.next = current.next.next;
                this.count--;
                return true;
            }
            current = current.next;
        }

        return false;
    }


    public void moveHeadForward(int num) {
        for (int i=0; i<num; i++) {
            try {
                head = head.next;
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }


    public T currentOne() {
        return (T)head.element;
    }


    public String toString() {
        String str = "";
        LinkedNode current = head;
        int nodeNum = count;
        while (nodeNum > 0) {
            str += (current.element + "_");
            current = current.next;
            nodeNum--;
        }
        return "total number of nodes are: " + count + "\n:" + str;
    }
}
