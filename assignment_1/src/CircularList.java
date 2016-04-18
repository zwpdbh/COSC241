/**
 * Created by zw on 4/18/16.
 */
public class CircularList<T> {
    public LinkedNode head;
    public LinkedNode tail;
    private int count;

    public CircularList(LinkedNode node) {
        head = node;
        head.next = tail;
        tail = head;
        count=1;
    }

    public void add(LinkedNode node) {
        tail.next = node;
        node.next=head;
        tail = node;

        count++;
    }

    public String toString() {
        String str = "";
        LinkedNode current = head;
        while (count>0) {
            str += (current.element + "_");
            current = current.next;
            count--;
        }
        return "total number of nodes are: " + count + "\n:" + str;
    }

    public void delete(LinkedNode fromHere, T element) {

    }
}
