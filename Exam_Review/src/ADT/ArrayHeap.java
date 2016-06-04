package ADT;

/**
 * Created by zw on 6/3/16.
 */
public class ArrayHeap<T extends Comparable<T>> implements Heap<T>{
    private int capacity = 10;
    private int heapSize;   // a property which is the total number of valid heap node
    private T[] a;

    public ArrayHeap() {
        a = (T[]) new Comparable[capacity]; // this should be comparable Object
        heapSize = 0;
    }

    @Override
    public T max() throws EmptyCollectionException {
        if (heapSize == 0) {
            throw new EmptyCollectionException("The heap is empty: cannot return maximum value at root");
        }
        return null;
    }

    @Override
    public T removeMax() throws EmptyCollectionException {
        if (heapSize == 0) {
            throw new EmptyCollectionException("The heap is empty: cannot remove root and return root value");
        }
        T result = a[0];
        swap(a, 0, heapSize-1);
        heapSize--;
        heapify(a, 0);
        return result;
    }

    @Override
    public void add(T element) {
        if (heapSize == capacity) {
            expandCapacity();
        }

        a[heapSize] = element;
        heapSize++;

        int index = heapSize - 1;
        while (index >= 0 && a[parent(index)].compareTo(a[index]) < 0) {
            swap(a, parent(index), index);
            index = parent(index);
        }
    }


    /**
     * Method can maintain the property of heap, suppose give the index, its left-subtree and right-subtree are
     * Max-heap already. Maintain the heap property for this uncertain node(root) at given index.
     * */
    private  void heapify(T[] a, int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        int largestIndex;

        if (leftIndex < heapSize && a[leftIndex].compareTo(a[index]) > 0) {
            largestIndex = leftIndex;
        } else {
            largestIndex = index;
        }

        if (rightIndex < heapSize && a[rightIndex].compareTo(a[largestIndex]) > 0) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            swap(a, largestIndex, index);
            heapify(a, largestIndex);
        }
    }

    public void buildHeap() {
        for (int index = ((a.length)/2 -1); index >= 0; index--) {
            heapify(a, index);
        }
    }



    private int parent(int index) {
        return index/2;
    }

    private int leftChild(int index) {
        return 2*index;
    }

    private int rightChild(int index) {
        return 2*index + 1;
    }


    private void swap(T[] data, int index1, int index2) {
        T tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    private void expandCapacity() {
        T[] largerArray = (T[]) new Comparable[capacity * 2];
        System.arraycopy(this.a, 0, largerArray, 0, heapSize);
        this.a = largerArray;
        this.capacity *= 2;
    }

    public String toString() {
        String result = "\n";
        for (int index=0; index < heapSize; index++){
            result += a[index] + " ";
        }
        return result;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public int getCapacity() {
        return capacity;
    }

    public void heapSort() {
        int backupHeapSize = heapSize;
        for (int i = heapSize-1; i>=1; i--) {
            swap(a, 0, heapSize-1);
            heapSize--;
            heapify(a, 0);
        }
        heapSize = backupHeapSize;
    }
}
