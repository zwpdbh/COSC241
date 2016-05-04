import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zw on 4/17/16.
 * The EP class is implemented by CircularList which is a List its tail is
 * pointed to its head.
 */
public class EP implements ExamPile {

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

        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            if (inputStr.contentEquals("")) {
                return;
            }
            EP ep = new EP();
            ep.setDEPTH(firstArg);
            ep.load(testList(inputStr));
            System.out.println(ep.sortingSteps());
        }
    }

    public CircularList<Integer> cirPile = new CircularList<Integer>();
    
    /**
     *The max is the max number in the pile
     *The min is the min number in the pile
     *So the difference is the the size of the cirPile
     * */
    private int max;
    private int min;
    public int depth = 1;
    public String steps = "";

    /**
     * load a List of Integer to get ready to mark
     * */
    @Override
    public void load(List<Integer> items) {
        max = min = items.get(0);
        for (Integer each: items) {
            cirPile.add(each);

            if (each > max) {
                max = each;
            }
            if (each < min) {
                min = each;
            }
        }
        steps = "";
    }
    
    
    /**
     * another method which can load a array of Integer to get to mark
     * */
    public void loadWithArray(int[] data) {
        max = min = data[0];
        for (int each: data) {
            cirPile.add(each);
            if (each > max) {
                max = each;
            }
            if (each < min) {
                min = each;
            }
        }
        steps = "";
    }
    

    /**
     * return the current element in the CircularList, which is the head of the
     * CircularList.
     * */
    @Override
    public int peek() throws EmptyPileException  {

        if (cirPile.currentOne() == null) {
            throw new EmptyPileException("the pile is empty");
        } else {
            return cirPile.currentOne();
        }
    }
    
    /**
     * This method try to mark a certain paper within depth
     * It returen the an int as shown the result of it.
     * If succeed, return marked value, otherwise return -1, means failed and
     * moved to the next several papers, controled by depth
     * */
    @Override
    public int mark(int depth, int value) throws EmptyPileException{
        if (cirPile.count()==0) {
            throw new EmptyPileException("the pile is empty");
        }
        if (cirPile.delete(value, depth)) {
            steps += "M";
            return value;
        } else {
            cirPile.moveHeadForward(depth);
            steps += "D";
            return -1;
        }
    }
    
    /**
     * It makes the current pointer which is the head move to the next several
     * nodes, controled by count.
     * */
    @Override
    public void delay(int count) throws EmptyPileException{
        if (cirPile.count()==0) {
            throw new EmptyPileException("the pile is empty");
        }
        cirPile.moveHeadForward(count);
    }

    /**
     * Constructs a string if 'M' and 'S' characters that represent
     * steps taken to mark a pile of exams.
     * <p>
     * The method uses a loop iterate over the  exam pile by calling the
     * method <code>mark()</code> and searching for a <code>currExam</code>.
     * <p>
     * If the value is found, an 'M' is added to the string, else a 'D' is
     * added and the exam goes to the bottom of the pile by calling
     * <code>delay()</code> method.
     *
     * @return the steps taken, represented by M's and D's to mark the pile.
     */
    public String sortingSteps() {
        int mark = min;
        while (mark<=max) {
            try {
                int result = mark(depth, mark);
                if (result == -1) {
                    continue;
                } else {
                    mark++;
                }
            } catch (EmptyPileException e) {
                System.out.println(e);
            }
        }
        return steps;
    }
    
    /**
     * setter method for set the depth
     * */
    public void setDEPTH(int depth) {
        this.depth = depth;
    }
    
    /**
     * a method for testing result in main method
     * */
    public static ArrayList<Integer> testList(String str) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        String[] arrOfNum = str.split(" ");
        for (String each: arrOfNum) {
            test.add(Integer.parseInt(each));
        }
        return test;
    }
}
