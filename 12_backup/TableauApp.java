/**
 * Created by zw on 3/28/16.
 */
package week12;

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
        // System.out.println();
        // System.out.println(TableauApp.toString(transpose(valid)));

//        int[][] invalid ={{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
//        System.out.println(TableauApp.toString(invalid));
//        System.out.println(rowValuesIncrease(invalid));

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
        int current = t[0].length;
        for(int i=1; i<t.length; i++) {
            int next = t[i].length;
            if(current<next) {
                return false;
            }
            current = next;
        }
        return true;
    }
    

    /**
     * A method that returns true if the integers are increasing.
     *
     * @param t a two-dimensional array.
     * @return returns true if integers are increasing.
     */
    public static boolean rowValuesIncrease(int[][] t) {
        for(int[] row: t) {
            int current = row[0];
            for(int col: row) {
                int next = col;
                if(next == 0) {
                    break;
                }
                if(current>next) {
                    return false;
                }
                current = next;
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
        int[][] transpose = transfer(t);

        if(rowValuesIncrease(transpose)) {
            return true;
        } else {
            return false;    
        }
    }

    private static int[][] transfer(int[][] t) {
        int[][] tTranspose = new int[t[0].length][t.length];

        for(int i=0; i<t.length; i++) {
            for(int j=0; j<t[i].length; j++) {
                tTranspose[j][i] = t[i][j];
            }
        }

        return tTranspose;
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
        int count = 0;
        for(int[] row: t) {
            count += row.length;
        }

        for(int i=1; i<=count; i++) {
            boolean founded = false;
            for(int[] row: t) {
                for(int col: row) {
                    if(col == i) {
                        founded = true;
                    }
                }
            }
            if(!founded) {
                return false;
            }
        }

        return true;
    }

}

