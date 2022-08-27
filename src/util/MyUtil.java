package util;

import action.ManualInputAction;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MyUtil {

    /** Helper method to check what is in the matrix. It was used during writing the project. */
    public static void print(int matrix[][]) {

    for (int [] row : matrix) {
        System.out.println(Arrays.toString(row));
        }
    }

    /** Returns a random int between tha max and min numbers. */
    public static int getRandomInt(int max, int min) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /** Returns the max or the min value. */
    public static int getMaxOrMin(int min, int max) {
        Random random = new Random();
        if(random.nextBoolean()) {
            return max;
        } else {
            return min;
        }
    }

    /** Converts a two dimensional array into a one dimensional. */
    public static int[] twoDToOneD(int[][] matrix) {
        int[] resultArray = new int[matrix.length * matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                int number = matrix[i][j];
                resultArray[i * matrix.length + j] = number;
            }
        }
        return resultArray;
    }

    /** Converts a one dimensional array into a two dimensional. */
    public static int[][] oneDtoTwoD(int[] array) {
        int[][] resultMatrix = new int[9][9];

        for (int i = 0; i < array.length; i++) {
            int[] coordinates = getCoordinates(i);
            resultMatrix[coordinates[0]][coordinates[1]] = array[i];

        }
        return resultMatrix;
    }

    /** Converts a JTextField array into an int array. Not used, but a neat method. */
    public static List<Integer> convertStringToInt(JTextField[] jArray) {
        List<Integer> resultList = Arrays.stream(jArray)
                .map(field -> field.getText().isBlank() ? 0 : Integer.parseInt(field.getText()))
                .toList();

        /*int[] resultArray = new int[81];

        for (int i = 0; i < jArray.length; i++) {
            String text = jArray[i].getText();
            resultArray[i] = text.isBlank() ? 0 : Integer.parseInt(text);
        }*/
        return resultList;
    }

    /** Checks if JTextField array has an empty field. */
    public static boolean arrayHasEmptyField(JTextField[] jTextFields) {
        for (int i = 0; i < jTextFields.length; i++) {
            if (jTextFields[i].getText().isBlank()) {
                return true;
            }
        }
        return false;
    }

    /** Iterates through a JTextField array and enables all fields. */
    public static void enableFields(JTextField[] jTextFields) {
        for (int i = 0; i < jTextFields.length; i++) {
            jTextFields[i].setEnabled(true);
        }
    }

    /** Converts an index of a one dimensional array to the coordinates of a matrix in order of its indexes. */
    public static int[] getCoordinates(int arrayIndex) {
        int[] resultArray = new int[2];
        int row;
        int column;

        if (arrayIndex < 9) {
            row = 0;
        } else {
            row = arrayIndex / 9;
        }

        if (arrayIndex < 9) {
            column = arrayIndex;
        } else {
            column = arrayIndex % 9;
        }

        resultArray[0] = row;
        resultArray[1] = column;
        return resultArray;
    }

}
