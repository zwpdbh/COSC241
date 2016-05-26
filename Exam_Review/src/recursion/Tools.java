package recursion;

/**
 * Created by zw on 5/26/16.
 */
public class Tools {
    public static boolean contains(String str, String pattern) {
        if(pattern.length() == 0) {
            return true;
        }
        if (str.length() < pattern.length()) {
            return false;
        }

        int i = str.indexOf(pattern.charAt(0));
        if (i == -1) {
            return false;
        } else {
            return contains(str.substring(i + 1), pattern.substring(1));
        }
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
