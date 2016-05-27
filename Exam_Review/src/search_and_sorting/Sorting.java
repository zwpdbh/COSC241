package search_and_sorting;

/**
 * Created by zw on 5/27/16.
 */
public class Sorting {
    /***
     * selection sort
     */
    public static void selectionSort(Comparable[] data) {

    }


    /**
     *  Binary Search
     *  Comparable data type implementing comparable interface
     * */
    public static Comparable binarySearch(Comparable[] data, Comparable target) {
        Comparable result = null;
        int first = 0;
        int last = data.length - 1;
        int mid;
        while (result == null && first < last) {
            mid = (first + last) / 2;
            if (data[mid].compareTo(target) == 0) {
                result = data[mid];
            } else {
                if (target.compareTo(data[mid]) < 0) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }
        }
        return result;
    }
}
