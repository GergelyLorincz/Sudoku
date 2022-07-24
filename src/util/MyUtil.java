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

    public static int[] twoDToOneD(int[][] matrix) {
        int[] resultArray = new int[matrix.length * matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for(int j = 0; j < row.length; j++) {
                int number = matrix[i][j];
                resultArray[i*row.length+j] = number;
            }
        }
        return resultArray;
    }

    public static int[][] oneDtoTwoD(int[] array) {
        int[][] resultMatrix = new int[9][9];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                resultMatrix[i][j] = array[i];
            }
        }
        return resultMatrix;
    }

}
