/**
 * Created by zw on 3/28/16.
 */
package week05;

import java.util.HashSet;
import java.util.Set;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {

        // int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        // System.out.println(TableauApp.toString(valid));

        int[][] invalid ={{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(invalid));
        System.out.println(rowValuesIncrease(invalid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t) {
        if (isSetOf1toN(t) && rowLengthsDecrease(t) &&
                rowValuesIncrease(t) && columnValuesIncrease(t)) {
            return true;
        }

        return false;
    }

    /**
     * Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * A method that returns true if no row is longer than a preceding
     * row, otherwise false.
     *
     * @param t a two-dimensional array which represent a tableau.
     * @return returns true if no row is longer than a preceding row.
     */
    public static boolean rowLengthsDecrease(int[][] t) {
        int previousNumberOfRow = getNumberOfRow(t, 0);
        for (int i = 1; i < t.length; i++) {
            int currentNumberOfRow = getNumberOfRow(t, i);
            if (currentNumberOfRow > previousNumberOfRow) {
                return false;
            } else {
                previousNumberOfRow = currentNumberOfRow;
            }
        }

        return true;
    }

    /**
     * A helper function which return the number of rows in a specific columns.
     *
     * @param t        a two-dimensional array.
     * @param indexCol the specific column.
     * @return int which is the number of rows in the specific column.
     */
    private static int getNumberOfRow(int[][] t, int indexCol) {
        int maxExpectedRows = t.length;
        int i;
        for (i = 1; i < maxExpectedRows; i++) {
            try {
                int dummy = t[indexCol][i];
            } catch (ArrayIndexOutOfBoundsException ex) {
                break;
            }
        }
        return i;
    }


    /**
     * A method that returns true if the integers are increasing.
     *
     * @param t a two-dimensional array.
     * @return returns true if integers are increasing.
     */
    public static boolean rowValuesIncrease(int[][] t) {
        int numberOfColumn = t[0].length;
        for (int col = 0; col < numberOfColumn; col++) {
            for (int row = 0; row < getNumberOfRow(t, col) - 1; row++) {
                try {
                    int current = t[col][row];
                    int next = t[col][row+1];
                    if (next <= current) {
                        System.out.println("row: " + row + "  col: " + col);
                        System.out.println("current: " + current + "\n" + "next: " + next);
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    break;
                }
            }
        }
        return true;
    }


    /**
     * A method that returns true if from top to bottom in any column,
     * the integers are increasing, otherwise false.
     *
     * @param t a two-dimensional array.
     * @return true if from top to bottom in any column,
     * the integers are increasing, otherwise false.
     */
    public static boolean columnValuesIncrease(int[][] t) {
        for (int[] rows : t) {
            for (int i = 0; i < rows.length - 1; i++) {
                try {
                    int current = rows[i];
                    int next = rows[i + 1];
                    if (next < current) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println(ex);
                }
            }
        }
        return true;
    }

    /**
     * A method that returns true
     * if the set of integers used is {1, 2, . . . , n}
     * where n is the number of cells, otherwise false.
     *
     * @param t a two-dimensional array.
     * @return true if it is.
     */
    public static boolean isSetOf1toN(int[][] t) {
        Set<Integer> myIntSet = new HashSet<Integer>();
        int max = t[0][0];
        for (int[] rows : t) {
            for (int col : rows) {
                myIntSet.add(Integer.valueOf(col));
                if (max <= col) {
                    max = col;
                }
            }
        }
        if (myIntSet.size() != max) {
            return false;
        }

        return true;
    }

}

