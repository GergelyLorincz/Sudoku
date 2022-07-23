package service;

import util.MyUtil;

public class Setup {

    private Difficulty difficulty;

    public int[][] setup() {
        int[][] sudokuTable = new int[9][9];

        sudokuTable[0] = getRandomArray(9);
        Solver.solver(sudokuTable);

        switch (difficulty) {
            case EASY -> {
                sudokuStarter(sudokuTable, 4, 3);
            }
            case MEDIUM -> {
                sudokuStarter(sudokuTable, 4, 5);
            }
            case HARD -> {
                sudokuStarter(sudokuTable, 5, 6);
            }
        }
        return sudokuTable;
    }



    public static int[][] sudokuStarter(int[][] sudokuTable, int max, int min) {
        int[][] result = sudokuTable;
        int replacedNums = MyUtil.getRandomInt(max, min);

        for (int i = 0; i < result.length; i++) {
            int[] replacedIndexes = getRandomArray(replacedNums);
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < replacedIndexes.length; k++) {
                    if (result[i][j] == replacedIndexes[k]) {
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
}
