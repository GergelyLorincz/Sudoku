package service;

public class Solver {

    /** Iterates through the sudoku board. Tries every number from one to nine for every field. Uses the
     * isValidPlacement from the Checker class if the given number can be placed into that field. If not it starts
     * all over again recursively. */
    public static boolean solver(int[][] sudokuBoard) {
        for(int row = 0; row < Checker.getGridSize(); row++) {
            for(int column = 0; column < Checker.getGridSize(); column++) {
                if(sudokuBoard[row][column] == 0) {
                    for(int numberToTry = 1; numberToTry <= Checker.getGridSize(); numberToTry++) {
                        if (Checker.isValidPlacement(sudokuBoard, numberToTry, row, column)) {
                            sudokuBoard[row][column] = numberToTry;

                            if(solver(sudokuBoard)) {
                                return true;
                            }
                            else {
                                sudokuBoard[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
