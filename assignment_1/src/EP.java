import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class loads a pile of exams into an instance of CirclularList,
 * and iterates throught the pile marking from integer 0 to n-1. The pile
 * is searched by default with a depth of 1, but this can be set to any
 * value with the <code>setDepth()</code> method. Each search to the
 * specified depth only counts as one step.
 * <p>
 * Every successful mark,an 'M' is added to a string, and every failed mark
 * a 'D' is added to the string. The string is then printed and returned.
 *
 * @author William Sanson <willysanson@hotmail.com>
 * @author Frank Zhao
 */

public class EP implements ExamPile {

    /**
     * The starting point of the program. Main method contains a loops that
     * while there is input, reads one line at a time of integer values which
     * it adds to a List, and then loads it into an instance of <code>EP</code>
     * where sorting steps are perfored.
     *
     * @param args takes input from the command line to set <code>depth</code>
     */
    public static void main(String[] args) {
        int firstArg = 1;

        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                firstArg = 1;
            }
        }

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            List<Integer> exams = new ArrayList<Integer>();
            Scanner scan = new Scanner(scanner.nextLine());
            while (scan.hasNext()) {
                exams.add(scan.nextInt());
            }
            EP ep = new EP();
            ep.setDepth(firstArg);
            if (exams.size() != 0) {
                ep.load(exams);
            } else {
                continue;
            }
            System.out.println(ep.sortingSteps());
        }

    }//end main

    /**
     * Creates an instance of CircularList of type Integer which will represent the exam pile
     */
    public CircularList<Integer> cirPile = new CircularList<Integer>();
    /**
     * The max is the max number in the pile
     */
    private int max;
    /**
     * The min is the min number in the pile
     */
    private int min;
    /**
     * The depth at which the pile is searched per step.
     */
    public int depth = 1;

    /**
     * Initialises the pile of exams to consist of the contents of the list
     * <code>items</code>, adding each value to a new node in cirPile.
     *
     * @param items a list of type Integer representing exams.
     */
    @Override
    public void load(List<Integer> items) {
        try {
            max = min = items.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println(items.toString());
            System.exit(1);
        }
        max = min = items.get(0);
        for (Integer each : items) {
            cirPile.add(each);

            if (each > max) {
                max = each;
            }
            if (each < min) {
                min = each;
            }
        }
    }


    /**
     * Calls the <code>currentOne()</code> method on the CircularList object
     * which returns the value at its head.
     *
     * @return the first element in the pile
     */
    @Override
    public int peek() throws EmptyPileException {

        if (cirPile.currentOne() == null) {
            throw new EmptyPileException("the pile is empty");
        } else {
            return cirPile.currentOne();
        }
    }


    /**
     * Looks throught the pile to a specified <code>depth</code> by
     * calling the <code>delete()</code> method on cirPile. If it
     * succeeds and the <code>value</code> is found within the depth,
     * the value is returned, otherwise it failed and returns -1.
     *
     * @param depth specifies how deep to look within the pile.
     * @param value specifies which value to look for.
     * @return the given value paramerter if found in the pile.
     */
    @Override
    public int mark(int depth, int value) throws EmptyPileException {
        if (cirPile.count() == 0) {
            throw new EmptyPileException("the pile is empty");
        }
        if (cirPile.delete(value, depth)) {
            return value;
        } else {
            return -1;
        }
    }

    /**
     * Moves the current head pointer of the circular list <code>count</code>
     * nodes forawrd, essentially placing them at the bottom of the pile.
     *
     * @param count the number of exams to go to the bottom
     */
    @Override
    public void delay(int count) throws EmptyPileException {
        if (cirPile.count() == 0) {
            throw new EmptyPileException("the pile is empty");
        }
        cirPile.moveHeadForward(count);
    }

    /**
     * Constructs a string of 'M' and 'S' characters that represent
     * steps taken to mark a pile of exams.
     * <p>
     * The method uses a loop to iterate over the  exam pile by calling the
     * method <code>mark()</code> and searching for <code>mark</code> which
     * begins at 0 and up to n-1.
     * <p>
     * If the value is found, an 'M' is added to the string, else a 'D' is
     * added and the exam goes to the bottom of the pile by calling
     * <code>delay()</code> method.
     *
     * @return steps taken to mark pile of exams
     */
    public String sortingSteps() {
        try {
            this.peek();
        } catch (EmptyPileException e) {
            System.out.println(e);
            return "";
        }
        StringBuilder steps = new StringBuilder();
        int mark = min;
        while (mark <=max) {
            try {
                int result = mark(depth, mark);
                if (result == -1) {
                    steps.append("D");
                    delay(depth);
                } else {
                    steps.append("M");
                    mark++;
                }
            } catch (EmptyPileException e) {
                System.out.println(e);
            }
        }
        return steps.toString();
    }

    /**
     * The method setDepth takes an parameter of type int and
     * uses it to set the datafield depth.
     *
     * @param depth input to set datafield
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

}//end class
