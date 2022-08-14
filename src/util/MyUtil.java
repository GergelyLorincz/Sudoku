package util;

import GUI.ManualInputAction;

import javax.swing.*;
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
        return random.nextInt(max - min + 1) + min;
    }

    public static int getMaxOrMin(int min, int max) {
        Random random = new Random();
        if(random.nextBoolean()) {
            return max;
        } else {
            return min;
        }
    }

    public static int[] twoDToOneD(int[][] matrix) {
        int[] resultArray = new int[matrix.length * matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for(int j = 0; j < row.length; j++) {
                int number = matrix[i][j];
                resultArray[i * row.length + j] = number;
            }
        }
        return resultArray;
    }

    public static int[][] oneDtoTwoD(int[] array) {
        int[][] resultMatrix = new int[9][9];

        for (int i = 0; i < array.length; i++) {
            int[] coordinates = ManualInputAction.getCoordinates(i);
            resultMatrix[coordinates[0]][coordinates[1]] = array[i];

        }
        return resultMatrix;
    }

    public static int[] JtextIntoArray(JTextField[] jTextFields) {
        int[] resultArray = new int[81];
        int num = 0;
        for (int i = 0; i < jTextFields.length; i++) {
            if (jTextFields[i].getText().equals("")) {
                num = 0;
            } else {
                num = Integer.parseInt(jTextFields[i].getText());
            }
            resultArray[i] = num;
        }
        return resultArray;
    }

    public static boolean arrayHasEmptyField(JTextField[] jTextFields) {
        for (int i = 0; i < jTextFields.length; i++) {
            if (jTextFields[i].getText().isBlank()) {
                return true;
            }
        }
        return false;
    }

    public static void enableFields(JTextField[] jTextFields) {
        for (int i = 0; i < jTextFields.length; i++) {
            jTextFields[i].setEnabled(true);
        }
    }

}
