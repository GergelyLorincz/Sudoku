package action;

import GUI.SudokuGUI;
import service.Checker;
import service.Data;
import util.MyUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ManualInputAction implements KeyListener {

    private final int USERFIELDINDEX;

    public ManualInputAction(int userFieldIndex) {
        this.USERFIELDINDEX = userFieldIndex;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /** Uses a keyevent to put the manually typed number in to the user sudoku table. Uses the FocusGained method
         * to determine where to put the input. Gets the coordinates of the index of the original sudoku table where
         * the input goes. */
        char c = e.getKeyChar();
        if ( ((c >= '1') && (c <= '9')) ) {
            String text = String.valueOf(c);
            int num = Integer.parseInt(text);
            int[] coordinates = MyUtil.getCoordinates(USERFIELDINDEX);
            Data.userFields[Data.focusIndex].setText("" + num);
            Data.getIndexes().add(USERFIELDINDEX);

            /** Only used when the checkbox is checked. Uses the checker method from the Checker class to compare
             * the user input with the number of the original sudoku table on the given index. */
            if (SudokuGUI.checkBox) {
                if (Checker.checker(Data.originalSudokuTable, num, coordinates[0], coordinates[1])) {
                    Data.userFields[USERFIELDINDEX].setForeground(Color.BLUE);
                } else {
                    Data.userFields[USERFIELDINDEX].setForeground(Color.RED);
                }
            }

            /** Checks if any of the fields are empty after every input. If not, it compares the user sudoku table
             * with the original one. If they are equal it changes an empty label with a winning message. If they are
             * not equal it warns the user that one or more inputs are wrong. */
            if (!MyUtil.arrayHasEmptyField(Data.userFields)) {
                SudokuGUI.win.setText("Congratulations, You Won!");
                SudokuGUI.win2.setText("");
                for (int i = 0; i < Data.originalSudokuTable.length; i++) {
                    for (int j = 0; j < Data.originalSudokuTable.length; j++) {
                        String fieldToString =  Data.userFields[i * Data.originalSudokuTable.length + j].getText();
                        int userFieldNum = Integer.parseInt(fieldToString);
                        if (Data.originalSudokuTable[i][j] != userFieldNum) {
                            SudokuGUI.win.setText("One or more numbers are wrong");
                            SudokuGUI.win2.setText("Please try again");
                        }
                    }
                }
            }
        }

        /** If a value of a field is deleted with a backspace, it sets the labels to empty Strings. */
        if (c == KeyEvent.VK_BACK_SPACE) {
            if (!Data.getIndexes().isEmpty()) {
                Data.getIndexes().remove(Data.getIndexes().size() - 1);
                Data.userFields[Data.focusIndex].setText("");
                if (MyUtil.arrayHasEmptyField(Data.userFields)) {
                    SudokuGUI.win.setText("");
                    SudokuGUI.win2.setText("");
                }
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
