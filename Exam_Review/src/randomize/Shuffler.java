package randomize;

import java.util.Random;

/**
 * Created by zw on 5/28/16.
 */
public class Shuffler {
    public static void shuffle(Comparable[] data) {
        for (int i=0; i<data.length; i++) {
            Random r = new Random();
            int randomIndex = r.nextInt(data.length - i) + i;
            swap(data, i, randomIndex);
        }
    }

    private static void swap(Comparable[] data, int index1, int index2) {
        Comparable tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }
}
