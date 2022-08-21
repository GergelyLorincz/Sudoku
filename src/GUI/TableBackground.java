package GUI;

import javax.swing.*;
import java.awt.*;

public class TableBackground {

    private static boolean[][] boardMatrix;
    private static boolean[] board;

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

        if (boardMatrix == null) {
            boardMatrix = new boolean[9][9];
            board = new boolean[81];

            for (int i = 0; i < boardMatrix.length; i++) {
                for (int j = 0; j < boardMatrix.length; j++) {
                    trueOrFalse(boardMatrix, i, j);
                }
            }
        }
    }


    private static void twoDToOneD() {
        upload();

        for(int i = 0; i < boardMatrix.length; i++) {
            boolean[] row = boardMatrix[i];
            for(int j = 0; j < row.length; j++) {
                boolean value = boardMatrix[i][j];
                board[i * row.length + j] = value;
            }
        }
    }


    public static void color(JTextField[] jTextFields, int index) {
        twoDToOneD();

        if (board[index]) {
            jTextFields[index].setBackground(Color.LIGHT_GRAY);
        } else {
            jTextFields[index].setBackground(Color.WHITE);
        }
    }
}
