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
        char c = e.getKeyChar();
        if ( ((c >= '1') && (c <= '9')) ) {
            String text = String.valueOf(c);
            int num = Integer.parseInt(text);
            int[] coordinates = MyUtil.getCoordinates(USERFIELDINDEX);
            Data.userFields[Data.focusIndex].setText("" + num);
            Data.getIndexes().add(USERFIELDINDEX);

            if (SudokuGUI.checkBox) {
                if (Checker.checker(Data.originalSudokuTable, num, coordinates[0], coordinates[1])) {
                    Data.userFields[USERFIELDINDEX].setForeground(Color.BLUE);
                } else {
                    Data.userFields[USERFIELDINDEX].setForeground(Color.RED);
                }
            }

            if (!MyUtil.arrayHasEmptyField(Data.userFields)) {
                for (int i = 0; i < Data.originalSudokuTable.length; i++) {
                    for (int j = 0; j < Data.originalSudokuTable.length; j++) {
                        String fieldToString =  Data.userFields[i * Data.originalSudokuTable.length + j].getText();
                        int userFieldNum = Integer.parseInt(fieldToString);
                        if (Data.originalSudokuTable[i][j] != userFieldNum) {
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
            Data.getIndexes().remove(Data.getIndexes().size() - 1);
            Data.userFields[Data.focusIndex].setText("");
            if (MyUtil.arrayHasEmptyField(Data.userFields)) {
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
