/**
 * Created by zw on 5/26/16.
 */
import recursion.Recursion;
import search_and_sorting.Sorting;
public class Test {
    public static void main(String[] args) {
        // test recursion method contain
        System.out.println(Recursion.contains("bcabaebdefg", "aeb"));

        // test quickSort method
        Integer[] testArray = {2, 8, 7, 1, 5, 3, 6, 4};
        Sorting.quickSort(testArray, 0, testArray.length-1);
        printArray(testArray);

        // test mergeSort method
        Integer[] testArray1 = {2, 8, 7, 1, 5, 3, 6, 4};
        Sorting.mergeSort(testArray1, 0, testArray1.length-1);
        printArray(testArray1);
    }


    private static void printArray(Comparable[] n) {
        for (Comparable each : n) {
            System.out.print(each + " ");
        }
        System.out.println();
    }

}
