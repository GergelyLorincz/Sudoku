package action;

import GUI.SudokuGUI;
import service.Checker;
import service.Data;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AutoCheck implements ItemListener {

    /** Connected to JCheckBox, which allows the user to see if the entered numbers are correct or not. It also shows
     * the correctness retrospectively. It compares the original generated sudoku table with the one that has been
     * set up with empty fields at the beginning of the game. If the given field is not equal to the one in the
     * original it compares the original again with the user inputs. If the checkbox gets unchecked the method
     * turns the numbers back to gray. It uses the same comparison what is used at the beginning of the method. */
    @Override
    public void itemStateChanged(ItemEvent e) {
        SudokuGUI.checkBox = e.getStateChange() == ItemEvent.SELECTED;

        int length = Data.originalSudokuTable.length;
        Color color = Color.BLACK;

        for (int i = 0; i < Data.originalSudokuTable.length; i++) {
            for (int j = 0; j < Data.originalSudokuTable.length; j++) {
                if (Data.originalSudokuTable[i][j] != Data.originalSudokuTableWithZeros[i][j]) {
                    if (SudokuGUI.checkBox) {

                        if (!String.valueOf(Data.userFields[i * length + j].getText()).equals("")) {

                            String str = Data.userFields[i * length + j].getText();
                            int userNumber = Integer.parseInt(str);

                            if (Checker.checker(Data.originalSudokuTable, userNumber, i, j)) {
                                color = Color.BLUE;
                            } else {
                                color = Color.RED;
                            }
                        }
                    } else {
                        color = Color.GRAY;
                    }
                }
                Data.userFields[i * length + j].setForeground(color);
            }
        }
    }
}
