import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.WildcardType;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Created by zw on 4/28/16.
 */
public class TestApp {
    public static void main(String[] args) {
//        int[][] testData = generateExamPapers(10, 10);
//        display(testData);

//        String fileName = "/Users/zw/code/COSC241/assignment_1/test_Result_For_EP.txt";
//        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"))) {
//            writer.write("\nColumn for: depth, the size of pile, the sorting steps\n");
//            for (int depth = 1; depth <= 20; depth++) {
//                for (int sizeOfPile = 3; sizeOfPile <= 100; sizeOfPile++) {
//                    writer.write(depth + "\t" + sizeOfPile + "\t" + neededSteps(depth, 50, sizeOfPile) + "\n");
//                }
//            }
//        } catch (Exception e) {
//            return ;
//        }

    }

    public static int neededSteps(int depth, int numberOfPiles, int numberOfPapersInEachPile) {
//        System.out.println("Depth:  " + depth +
//                "  Piles:  " + numberOfPiles +
//                "  Papers in each Pile:  " + numberOfPapersInEachPile);

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
//            System.out.println("steps for pile " + i  + " = "+ stepsForEachPile[i]);
            totalSteps += stepsForEachPile[i];
        }
        int averageSteps = totalSteps/numberOfPiles;
//        System.out.println("Depth = " + depth + ",  papers in each Pile = " +
//                numberOfPapersInEachPile + ", sampling from " +
//                numberOfPiles + " piles");
        System.out.println("Average of Steps: " + totalSteps + "/" + numberOfPiles + " = " + averageSteps);
//        System.out.println(depth + "\t" + numberOfPapersInEachPile + "\t" + averageSteps);
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
