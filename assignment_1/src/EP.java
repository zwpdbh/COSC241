import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zw on 4/17/16.
 */
public class EP implements ExamPile {

    public CircularList<Integer> cirPile = new CircularList();

    private int max;
    private int min;
    private int depth = 1;
    public String steps = "";


    public static void main(String[] args) {
        int firstArg = 0;

        if (args.length == 1) {
            try {
                firstArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                firstArg = 0;
            }
        }

        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            if (inputStr.contentEquals("")) {
                return;
            }
            EP ep = new EP();
            // ep.depth = firstArg;
            ep.load(testList(inputStr));
            System.out.println(ep.sortingSteps());
        }
    }


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

    @Override
    public int peek() {
        return (Integer) cirPile.currentOne();
    }

    @Override
    public int mark(int depth, int value) {
        if (cirPile.count()==0) {
            return -2;
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

    @Override
    public void delay(int count) {
        cirPile.moveHeadForward(count);
    }

    public String sortingSteps() {
        int mark = min;
        while (mark<=max) {
            int result = mark(depth, mark);
            if (result == -2) {
                break;
            } else if (result == -1) {
                continue;
            } else {
                mark++;
            }
        }
        return steps;
    }

    public static ArrayList<Integer> testList(String str) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        String[] arrOfNum = str.split(" ");
        for (String each: arrOfNum) {
            test.add(Integer.parseInt(each));
        }
        return test;
    }
}
