import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by zw on 4/28/16.
 */
public class TestApp {
    public static void main(String[] args) {
//        int[][] testData = generateExamPapers(10, 10);
//        display(testData);
        neededSteps(1, 100, 100);
    }

    public static int neededSteps(int depth, int numberOfPiles, int numberOfPapersInEachPile) {
        System.out.println("Depth:  " + depth +
                "  Piles:  " + numberOfPiles +
                "  Papers in each Pile:  " + numberOfPapersInEachPile);
        int[][] testData = generateExamPapers(numberOfPiles, numberOfPapersInEachPile);
        int[] stepsForEachPile = new int[numberOfPiles];

        for (int i=0; i<stepsForEachPile.length; i++) {
            EP ep = new EP();
            ep.setDEPTH(depth);
            ep.loadWithArray(testData[i]);
            String result = ep.sortingSteps();
            stepsForEachPile[i] = result.length();
        }

        int totalSteps = 0;
        for (int i=0; i<stepsForEachPile.length; i++) {
            System.out.println("steps for pile " + i  + " = "+ stepsForEachPile[i]);
            totalSteps += stepsForEachPile[i];
        }
        int averageSteps = totalSteps/numberOfPiles;
        System.out.println(totalSteps + "/" + numberOfPiles + " = " + averageSteps);
        return averageSteps;
    }

    private static int[][] generateExamPapers(int numberOfPiles, int numberOfPapersInEachPile) {
        int[][] pilesOfExamPapers = new int[numberOfPiles][numberOfPapersInEachPile];

        for (int i=0; i<numberOfPiles; i++) {
            pilesOfExamPapers[i] = shuffledPaper(numberOfPapersInEachPile);
        }
        return pilesOfExamPapers;
    }


    private static void shuffle(int[] arr) {
        Random r = new Random();
        for (int i = arr.length - 1; i>0; i--) {
            int index = r.nextInt(i + 1);
            // swap
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
    }

    private static int[] shuffledPaper(int length) {
        int[] arr = new int[length];
        for (int i=0; i<length; i++) {
            arr[i] = i + 1;
        }

        shuffle(arr);
        return arr;
    }

    private static void display(int[][] data) {
        for (int[] rows : data) {
            for (int col: rows) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }
    }

}
