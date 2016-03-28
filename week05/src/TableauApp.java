/**
 * Created by zw on 3/28/16.
 */
package week05;

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
        int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));

        // Test for get number of rows in a specific columns.
        getNumberOfRow(valid, 1);
        getNumberOfRow(valid, 0);

        // Test for method: rowLengthsDecrease
        int [][] invalid = {{1, 2, 3}, {1, 2, 3, 4}, {3, 9, 12}, {7}};
        System.out.println(rowLengthsDecrease(invalid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        return false;
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * A method that returns true if no row is longer than a preceding row, otherwise false.
     * @param t a two-dimensional array which represent a tableau.
     *
     * @return true if the parameter is a valid tableau, otherwise false.
     * */
    public static boolean rowLengthsDecrease(int[][] t) {
        int previousNumberOfRow = getNumberOfRow(t, 0);
        for (int i=1; i<t.length; i++) {
            int currentNumberOfRow = getNumberOfRow(t, i);
            if (currentNumberOfRow>previousNumberOfRow) {
                return false;
            }
        }

        return true;
    }

    /**
     * A helper function which return the number of rows in a specific columns in a two dimensional array.
     * */
    private static int getNumberOfRow(int[][] t, int indexCol) {
        int maxExpectedRows = t.length;
        int i;
        for (i=1; i<maxExpectedRows; i++) {
            try {
                int dummy = t[indexCol][i];
            } catch (ArrayIndexOutOfBoundsException ex) {
                break;
            }
        }
        System.out.println("The number of rows in column: " + indexCol + " is: " + i);
        return i;
    }

}

