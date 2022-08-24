package service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Data {

    /** This class contains almost every collection or variable that is used in the application. */
    public static int[][] originalSudokuTable = new int[9][9];
    public static int[][] originalSudokuTableWithZeros = new int[9][9];
    public static JTextField[] userFields = new JTextField[81];
    public static int[] oneDTableWithZeros = new int[81];
    private static List<Integer> indexes;
    public static int focusIndex;

    public static List<Integer> getIndexes() {
        if (indexes == null) {
            indexes = new ArrayList<>();
        }
        return indexes;
    }
}
