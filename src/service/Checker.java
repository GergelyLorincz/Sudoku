package service;

public class Checker {

    private static final int GRID_SIZE = 9;

    public static int getGridSize() { return GRID_SIZE; }


    private static boolean isNumberInRow(int[][] sudokuBoard, int number, int row) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if (sudokuBoard[row][i] == number) {
                return true;
            }
        }
        return false;
    }


    private static boolean isNumberInColumn(int[][] sudokuBoard, int number, int column) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if (sudokuBoard[i][column] == number) {
                return true;
            }
        }
        return false;
    }


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


    public static boolean isValidPlacement(int[][] sudokuBoard, int number, int row, int column) {
        return !isNumberInRow(sudokuBoard, number, row) &&
                !isNumberInColumn(sudokuBoard, number, column) &&
                !isNumberInBox(sudokuBoard, number, row, column);
    }


    public static boolean checker(int[][] matrix, int number, int row, int column) {
        return matrix[row][column] == number;
    }
}
