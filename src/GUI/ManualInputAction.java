package GUI;

import service.Checker;
import service.Setup;
import util.MyUtil;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class ManualInputAction implements KeyListener {

    private final int ARRAYINDEX;
    private final JTextField[] FIELDS;

    ManualInputAction(int arrayIndex, JTextField[] fields) {
        this.ARRAYINDEX = arrayIndex;
        this.FIELDS = fields;
    }

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
        } else {column = arrayIndex % 9; }

        resultArray[0] = row;
        resultArray[1] = column;
        return resultArray;
    }

    public static int[] convertStringToInt(JTextField[] jArray) {
        int[] resultArray = new int[81];

        for (int i = 0; i < jArray.length; i++) {
            String text = jArray[i].getText();
            resultArray[i] = text.isBlank() ? 0 : Integer.parseInt(text);
        }

        return resultArray;
    }

    /*public void actionPerformed(KeyEvent e) {

    }*/

    @Override
    public void keyTyped(KeyEvent e) {
        int index = FocusGainedAction.index;
        char c = e.getKeyChar();
        if ( ((c >= '1') && (c <= '9')) ) {
            String text = String.valueOf(c);
            int num = Integer.parseInt(text);
            int[] coordinates = getCoordinates(ARRAYINDEX);
            int[][] matrix = Setup.sudokuTable;
            FIELDS[index].setText("" + num);
            UndoButtonAction.indexes.add(ARRAYINDEX);

            if (SudokuGUI.checkBox) {
                if (Checker.checker(matrix, num, coordinates[0], coordinates[1])) {
                    FIELDS[ARRAYINDEX].setForeground(Color.BLUE);
                } else {
                    FIELDS[ARRAYINDEX].setForeground(Color.RED);
                }
            }

            if (!MyUtil.arrayHasEmptyField(FIELDS)) {
                int[] fieldsOneD = new int[81];
                for (int i = 0; i < FIELDS.length; i++) {
                    fieldsOneD[i] = Integer.parseInt(FIELDS[i].getText());
                }
                int[][] fieldsMatrix = MyUtil.oneDtoTwoD(fieldsOneD);

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[i][j] != fieldsMatrix[i][j]) {
                            SudokuGUI.win.setText("One or more number are wrong.");
                            SudokuGUI.win2.setText("Please try again");
                            break;
                        } else {
                            SudokuGUI.win.setText("Congratulations, You Won!");
                        }
                    }
                }
            }
        }

        if (c == KeyEvent.VK_BACK_SPACE) {
            FIELDS[index].setText("");
            if (MyUtil.arrayHasEmptyField(FIELDS)) {
                SudokuGUI.win.setText("");
                SudokuGUI.win2.setText("");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
