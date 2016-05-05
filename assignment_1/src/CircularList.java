//package week09;
/**
 * The circular list is implemented similar to a stack and is used as the
 * internal representation of the exam pile.There are three datafields that
 * represent the head, tail and size of the stack as well as well as methods
 * for adding, deleting, delaying, and moving the head pointer to another node.
 *
 * @author Frank Zhao
 * @author William Sanson <willysanson@hotmail.com>
 */
public class CircularList<T> {

    /**
     * Datafield representing the head of the CircularList.
     */
    private LinkedNode<T> head;
    /**
     * Datafield representing the tail of the CircularList.
     */
    private LinkedNode<T> tail;
    /**
     * Datafield representing the size of the CircularList.
     */
    private int count;


    /**
     * Default Constructor sets datafields.
     */
    public CircularList() {
        head = tail;
        count = 0;
    }

    /**
     * This method creates new nodes that will hold the parameter value
     * <code>element</code> and adds them to the tail of the CircularList.
     *
     * @param element to send to the LinkedNode constructor.
     */
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

    /**
     * The delete class has two functions. First it checks to 
     * see if the parameter <code>element</code> is in the CircularList within 
     * the specified <code>depth</code>. 
     * <p>The second is if the parameter value is found, the method removes the 
     * node from the CicularList by moving the pointer 
     * for the <code>head</code> by a 
     * specified <code>depth</code> and then moving the pointer for 
     * <code>tail</code> to the new head. If the desired element is found 
     * then the method returns true, otherwise returns false.
     *
     * @param element to remove from the CircularList.
     * @param depth   the number of elements to remove.
     * @return boolean if delete is successful or not.
     */
    public boolean delete(T element, int depth) {
        if (this.count < 1) { //if the CircularList is empty
            head = tail;
            count = 0;
            return false;
        }

        LinkedNode<T> current = this.head;
        if (head.element == element) { //if depth is 1
            head = head.next;
            tail.next = head;
            this.count--;
            return true;
        } else {
            for (int i = 0; i < depth - 1; i++) { //if depth is greater than 1
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

    /**
     * Rotates the circle <code>num</code> nodes, by making the pointer
     * of the <code>head</code>.
     *
     * @param num the number of nodes to move the head forward
     */
    public void moveHeadForward(int num) {
        for (int i = 0; i < num; i++) {
            try {
                head = head.next;
                tail = tail.next;
            } catch (NullPointerException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * The currentOne method returns the the datafield head's element value.
     *
     * @return head.element the first element in CicularList.
     */
    public T currentOne() {
        if (count == 0) {
            return null;
        }
        return head.element;
    }

    /**
     * The lastOne method returns the tail node element of the CircularList.
     *
     * @return tail.element the last element in CicularList.
     */
    public T lastOne() {
        if (count == 0) {
            return null;
        }
        return tail.element;
    }


    /**
     * Accessor method for getting the length of the CircularList.
     *
     * @return count the number of nodes in the CircularList.
     */
    public int count() {
        return this.count;
    }

    /**
     * Private inner class LinkedNode represents each node in the CircularList.
     */
    private class LinkedNode<T> {
        /**
         * The value represented by the node.
         */
        T element;
        /**
         * A reference the current nodes neighbour.
         */
        LinkedNode<T> next;

        /**
         * Dafualt Constructor Sets the value of the element datafield.
         *
         * @param element value to set datafield.
         */
        LinkedNode(T element) {
            this.element = element;
        }
    }
}
