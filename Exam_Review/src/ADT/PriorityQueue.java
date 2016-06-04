package ADT;

import java.util.Objects;

/**
 * Created by zw on 6/4/16.
 */
public class PriorityQueue<T> {
    ArrayHeap<QueueNode<T>> heap;
    private static int arrivalNumber = 0;

    public PriorityQueue() {
        heap = new ArrayHeap<>();
    }

    public void add(QueueNode node) {
        heap.add(node);
    }

    public void removeNext() {
        try {
            heap.removeMax();
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    private class QueueNode<T> implements Comparable<QueueNode<T>> {
        private T value;
        private int priority;
        private int arrival;

        private QueueNode(T value, int priority) {
            this.value = value;
            this.priority = priority;
            this.arrival = arrivalNumber;
            arrivalNumber++;
        }

        @Override
        public int compareTo(QueueNode<T> other) {
            if (this.priority > other.priority) return 1;
            if (this.priority < other.priority) return -1;
            return other.arrival - this.arrival;
        }
    }
}
