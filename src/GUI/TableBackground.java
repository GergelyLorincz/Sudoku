package GUI;

import javax.swing.*;
import java.awt.*;

public class TableBackground {

    private static boolean[][] boardMatrix = new boolean[9][9];
    private static boolean[] board = new boolean[81];

    private static void trueOrFalse(boolean[][] sudokuBoard, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxCloumn = column - column % 3;

        for(int i = localBoxRow; i < localBoxRow + 3; i++) {
            for(int j = localBoxCloumn; j < localBoxCloumn + 3; j++) {
                if(localBoxRow + localBoxCloumn == 3 || localBoxRow + localBoxCloumn == 9) {
                    sudokuBoard[i][j] = true;
                } else {sudokuBoard[i][j] = false;}
            }
        }
    }

    private static void upload() {

        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix.length; j++) {
                trueOrFalse(boardMatrix,i,j);
            }
        }
    }

    private static void twoDToOneD(boolean[][] matrix) {
        upload();

        for(int i = 0; i < matrix.length; i++) {
            boolean[] row = matrix[i];
            for(int j = 0; j < row.length; j++) {
                boolean value = matrix[i][j];
                board[i * row.length + j] = value;
            }
        }
    }

    public static void color(JTextField[] jTextFields, int index) {
        twoDToOneD(boardMatrix);

            if (board[index]) {
                jTextFields[index].setBackground(Color.LIGHT_GRAY);
            } else {
                jTextFields[index].setBackground(Color.WHITE);
            }
        }

}
