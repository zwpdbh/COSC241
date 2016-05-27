package search_and_sorting;

import java.util.Scanner;

/**
 * Created by zw on 5/27/16.
 */
public class Sorting {
    /***
     * selection sort
     */
    public static void selectionSort(Comparable[] data) {
        int min;
        for (int index = 0; index < data.length; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min])<0) {
                    min = scan;
                }
            }
            swap(data, min, index);
        }
    }

    /**
     * insertion sort
     * */
    public static void insertionSort(Comparable[] data) {
        for (int index = 1; index < data.length; index++) {
            Comparable key = data[index];
            int position = index;

            // shift the larger element to right
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }
            data[position] = key;
        }

    }

    /**
     * bubble sort
     * */
    public static void bubbleSort(Comparable[] data) {
        for (int count = data.length - 1; count >= 0; count--) {
            for (int scan = 0; scan < count; scan++) {
                if (data[scan].compareTo(scan + 1)>0) {
                    swap(data, scan, scan+1);
                }
            }
        }
    }

    /**
     * quick sort
     * */
    public static void quickSort(Comparable[] data, int left, int right) {
        if (left < right) {
            int pivot = partition(data, left, right);
            quickSort(data, left, pivot-1);
            quickSort(data, pivot+1, right);
        }
    }

    private static int partition(Comparable[] data, int p, int r) {
        int i = p - 1;
        for (int j = p; j<r; j++) {
            if (data[j].compareTo(data[r]) <=0) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i+1, r);
        return i + 1;
    }

    private static void swap(Comparable[] data, int index1, int index2) {
        Comparable tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
     }
}
