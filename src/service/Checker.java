package service;

public class Checker {

    private static final int GRID_SIZE = 9;

    public static int getGridSize() { return GRID_SIZE; }

    /** Checks if a row in a matrix contains the given number. Returns with a true value if the number is already
     * in the row. */
    private static boolean isNumberInRow(int[][] sudokuBoard, int number, int row) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if (sudokuBoard[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    /** Checks if a column in a matrix contains the given number. Returns with a true value if the number is already
     * in the column. */
    private static boolean isNumberInColumn(int[][] sudokuBoard, int number, int column) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if (sudokuBoard[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    /** Checks if a 3x3 matrix in a matrix contains the given number. The starting point of each nested
     * for cycle is declared by using modulo 3 on the given row and column which is extracted from the row or
     * the column. By doing that we will get the first index of the actual 3x3 matrix where the number is located.
     * Returns with a true value if the number is already in the 3x3 matrix. */
    private static boolean isNumberInBox(int[][] sudokuBoard,int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxCloumn = column - column % 3;

        for(int i = localBoxRow; i < localBoxRow + 3; i++) {
            for(int j = localBoxCloumn; j < localBoxCloumn + 3; j++) {
                if(sudokuBoard[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /** Implements all the methods above to check the given number if it is already in the given row, column or
     * 3x3 matrix. All the methods are negated. The method only returns with a true value if all the methods are false*/
    public static boolean isValidPlacement(int[][] sudokuBoard, int number, int row, int column) {
        return !isNumberInRow(sudokuBoard, number, row) &&
                !isNumberInColumn(sudokuBoard, number, column) &&
                !isNumberInBox(sudokuBoard, number, row, column);
    }

    /** Checks if the given index of the matrix is equal to the given number. */
    public static boolean checker(int[][] matrix, int number, int row, int column) {
        return matrix[row][column] == number;
    }
}
