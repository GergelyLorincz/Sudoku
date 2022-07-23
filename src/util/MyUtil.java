package util;

import java.util.Arrays;
import java.util.Random;

public class MyUtil {

    public static void print(int matrix[][]) {

    for (int [] row : matrix) {
        System.out.println(Arrays.toString(row));
        }
    }

    public static int getRandomInt(int max, int min) {
        Random random = new Random();
        return random.nextInt(max) + min;
    }

}
