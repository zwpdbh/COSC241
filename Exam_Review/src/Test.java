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
        for (Integer each: testArray) {
            System.out.print(each + " ");
        }
        System.out.println();
    }
}
