package service;

import util.MyUtil;

import java.sql.Array;

public class Setup {

    private Difficulty difficulty;

    /** Used to set every value of the original sudoku table. It is needed so there should be no remainder value
     * when the user sets up a new game. */
    public void sudokuTableZeroDown() {
        for (int i = 0; i < Data.originalSudokuTable.length; i++) {
            for (int j = 0; j < Data.originalSudokuTable.length; j++) {
                Data.originalSudokuTable[i][j] = 0;
            }
        }
    }

    /** Generates the first row of the original sudoku table with the getRandomArray method. Then it uses the solver
     * method from the Solver class to upload the remaining elements based on the first row. */
    public void setSudokuTable() {
        Data.originalSudokuTable[0] = getRandomArray(9);
        Solver.solver(Data.originalSudokuTable);
    }

    /** Uses the sudokuStarter method found below. Sets a random number of elements in each row to zero based on the
     *  difficulty setting. */
    public int[][] setup() {
        int[][] resultArray = new int[9][9];

        switch (difficulty) {
            case EASY -> {
                resultArray = sudokuStarter(Data.originalSudokuTable, 4, 3);
            }
            case MEDIUM -> {
                resultArray = sudokuStarter(Data.originalSudokuTable, 5, 4);
            }
            case HARD -> {
                resultArray = sudokuStarter(Data.originalSudokuTable, 6, 5);
            }
        }
        return resultArray;
    }

    /** Copies the array from the input parameter into the resultArray. Then it iterates through the array. In each row
     * it generates the number of replaced indexes based on the input parameters - max and min. Then it generates the
     * place of the indexes on the given row using the getRandomArray method found below. */
    public static int[][] sudokuStarter(int[][] sudokuTable, int max, int min) {
        int[][] resultArray = new int[9][9];
        for (int i = 0; i < sudokuTable.length; i++) {
            for (int j = 0; j < sudokuTable.length; j++) {
                resultArray[i][j] = sudokuTable[i][j];
            }
        }

        for (int i = 0; i < resultArray.length; i++) {
            int replacedNums = MyUtil.getMaxOrMin(max, min);
            int[] replacedIndexes = getRandomArray(replacedNums);
            for (int j = 0; j < replacedIndexes.length; j++) {
                resultArray[i][replacedIndexes[j] - 1] = 0;
            }
        }
        return resultArray;
    }

    /** Generates an array with non-repetitive numbers. The size of the array is based on the number in the input
     * parameter. In each element it uses the getRandomInt from the MyUtil class to generate a number between 1 and 9.
     * Then it checks if the generated number can be already found in the array. If so it generates new numbers until
     * it brand new number. */
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
}
