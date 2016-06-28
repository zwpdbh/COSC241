import ADT.*;
import recursion.Recursion;
import search_and_sorting.Sorting;
import randomize.Shuffler;

import java.util.*;
import java.util.Stack;

/**
 * Created by zw on 5/26/16.
 */

public class Test {
    public static void main(String[] args) {
//        // Test sorting algorithms
//
//        // test recursion method contain
//        System.out.println(Recursion.contains("hello", "ee"));
//
//        // test quickSort method
//        Integer[] testArray = {2, 8, 7, 1, 5, 3, 6, 4};
//        Sorting.quickSort(testArray, 0, testArray.length-1);
//        printArray(testArray);
//
//        // test mergeSort method
//        Integer[] testArray1 = {2, 8, 7, 1, 5, 3, 6, 4};
//        Sorting.mergeSort(testArray1, 0, testArray1.length-1);
//        printArray(testArray1);
//
//        // test bubbleSort method
//        Integer[] testArray2 = {2, 8, 7, 1, 5, 3, 6, 4};
//        Sorting.bubbleSort(testArray2);
//        printArray(testArray2);
//
//        // test bubbleSort method
//        Integer[] testArray3 = {1, 2, 3, 4};
//        Sorting.insertionSort(testArray3);
//        printArray(testArray3);
//
//        Shuffler.shuffle(testArray);
//        printArray(testArray);


        // Test on Stack
//        LinkedStack<Integer> myStack = new LinkedStack<Integer>();
//        for (Integer each: testArray) {
//            myStack.add(each);
//        }
//
//        System.out.println(myStack.toString());
//        try {
//            myStack.pop();
//            System.out.println(myStack.toString());
//
//            myStack.push(9);
//            System.out.println(myStack.toString() + " size: " + myStack.getSize());
//
//            for (int i=8; i>=1; i--) {
//                int tmp = myStack.pop();
//                System.out.println(myStack.toString() + " " + tmp);
//            }
//        } catch (EmptyCollectionException e) {
//            System.out.println(e);
//        }

//        for (Integer each: myStack) { // why?
//            System.out.println(each);
//        }


        // Test on Heap
//        System.out.println("<Heap testing>");
//        ArrayHeap<Integer> myHeap = new ArrayHeap<>();
//        Shuffler.shuffle(testArray3);
//        printArray(testArray3);
//        for (Integer each: testArray3) {
//            myHeap.add(each);
//        }
//        System.out.println("myHeap: " + myHeap.toString());
//        for (int i=myHeap.getHeapSize(); i>0; i--) {
//            try {
//                //System.out.print("available heap node: " + myHeap.getHeapSize());
//                System.out.println(myHeap.removeMax());
//            } catch (EmptyCollectionException e) {
//                System.out.println(e);
//            }
//        }
//
//        // add 50 elements into the heap
//        ArrayHeap<Integer> secondHeap = new ArrayHeap<>();
//        for (int i=1; i<=50; i++){
//            Random random = new Random();
//            secondHeap.add(random.nextInt(20) + 1);
//        }
//        System.out.println("Heap: " + secondHeap.toString());
//
//        // testing removing 50 element from heap
//        for (int i=secondHeap.getHeapSize() + 1; i>0; i--) {
//            try {
//                //System.out.print("available heap node: " + myHeap.getHeapSize());
//                System.out.println(secondHeap.removeMax() + "\t heapsize: " + secondHeap.getHeapSize());
//            } catch (EmptyCollectionException e) {
//                System.out.println(e);
//            }
//        }
//
//        // add 50 elements into heap and sort them.
//        for (int i=1; i<=50; i++){
//            Random random = new Random();
//            secondHeap.add(random.nextInt(20) + 1);
//        }
//        System.out.println("Heap: " + secondHeap.toString());
//
//        secondHeap.heapSort();
//        System.out.println("Heapsort result: " + secondHeap.toString());
//        secondHeap.buildHeap();
//        System.out.println("Restore sorted array back to heap: " + secondHeap.toString());
//
//        secondHeap.heapSort();
//        System.out.println("Heapsort result: " + secondHeap.toString());
//        secondHeap.buildHeap();
//        System.out.println("Restore sorted array back to heap: " + secondHeap.toString());
//
//        secondHeap.heapSort();
//        System.out.println("Heapsort result: " + secondHeap.toString());
//        secondHeap.buildHeap();
//        System.out.println("Restore sorted array back to heap: " + secondHeap.toString());
//
//        String test = Recursion.removeDups("aabbcc");
//        System.out.print(test);
//
//        boolean[] a = new boolean[6];
//        System.out.println();
//        while (!a[a.length-1]) {
//            int i = 0;
//            while (a[i]) {
//                a[i] = false;
//                i++;
//            }
//            a[i] = true;
//            System.out.print(i + " ");
//        }

        int[] testa = {2, 4, 1, 5, 7, 6, 3};

        Stack<Integer> s = new Stack<>();
        int i = 0;
        while (i < testa.length) {
            try {
                if (s.isEmpty() || testa[i] < s.peek()) {
                    s.push(testa[i]);
                    i++;
                } else {
                    System.out.print(s.pop() + "_");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

        while (!s.isEmpty()) {
            try {
                System.out.print(s.pop() + " ");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();

    }


    private static void printArray(Comparable[] n) {
        for (Comparable each : n) {
            System.out.print(each + " ");
        }
        System.out.println();
    }

}
