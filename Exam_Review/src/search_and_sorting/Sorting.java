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

    

    private static void swap(Comparable[] data, int index1, int index2) {
        Comparable tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
     }
}
