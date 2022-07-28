package service;

import util.MyUtil;

import java.sql.Array;

public class Setup {

    private Difficulty difficulty;

    public static int[][] sudokuTable = new int[9][9];

    public void setSudokuTable() {
        sudokuTable[0] = getRandomArray(9);
        Solver.solver(sudokuTable);
    }

    public int[][] setup() {
        int[][] resultArray = new int[9][9];

        switch (difficulty) {
            case EASY -> {
                resultArray = sudokuStarter(sudokuTable, 4, 3);
            }
            case MEDIUM -> {
                resultArray = sudokuStarter(sudokuTable, 5, 4);
            }
            case HARD -> {
                resultArray = sudokuStarter(sudokuTable, 6, 5);
            }
        }
        return resultArray;
    }

    public static int[][] sudokuStarter(int[][] sudokuTable, int max, int min) { //TODO rework
        int[][] result = new int[9][9];
        for (int i = 0; i < sudokuTable.length; i++) {
            for (int j = 0; j < sudokuTable.length; j++) {
                result[i][j] = sudokuTable[i][j];
            }
        }

        for (int i = 0; i < result.length; i++) {
            int replacedNums = MyUtil.getRandomInt(max, min);
            int[] replacedIndexes = getRandomArray(replacedNums);
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < replacedIndexes.length; k++) {
                    if (j == replacedIndexes[k]) {
                        result[i][j] = 0;
                    }
                }
            }
        }
        return result;
    }

    public static int[] getRandomArray(int num) {
        int[] randomArray = new int[num];

        for (int i = 0; i < num; i++) {
            int random = 0;
            boolean found = false;

            do {
                found = false;
                random = MyUtil.getRandomInt(9, 1);
                for (int j = 0; j < num; j++) {
                    if (randomArray[j] == random) {
                        found = true;
                    }
                }
            } while (found);
            randomArray[i] = random;
        }
        return randomArray;
    }

    public Difficulty getDifficulty() {return difficulty; }

    public void setDifficulty(Difficulty difficulty) {this.difficulty = difficulty; }

    public int[][] getSudokuTable() {return sudokuTable; }
}
