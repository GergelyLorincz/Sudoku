package helper;

import java.util.Arrays;

public class Printer {public static void print(int matrix[][]) {

    for (int [] row : matrix) {
        System.out.println(Arrays.toString(row));
        }
    }
}
