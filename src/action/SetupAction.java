package action;

import GUI.SudokuGUI;
import GUI.TableBackground;
import service.Data;
import service.Difficulty;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Set;

public class SetupAction implements ActionListener {

    Setup setup = new Setup();

    @Override
    public void actionPerformed(ActionEvent e) {

        /** Sets the difficulty depending on what the user chooses. */
        if (e.getSource() == SudokuGUI.easy) {
            setup.setDifficulty(Difficulty.EASY);
        } else if (e.getSource() == SudokuGUI.medium) {
            setup.setDifficulty(Difficulty.MEDIUM);
        } else if (e.getSource() == SudokuGUI.hard) {
            setup.setDifficulty(Difficulty.HARD);
        }

        /** Enables all fields in the table. */
        MyUtil.enableFields(Data.userFields);

        /** Places zeros into every field of the table. */
        setup.sudokuTableZeroDown();

        /** Resets the hint button. */
        Data.hintCounter = 0;
        SudokuGUI.JBUTTON.get("hint").setText("Hint " + "(" + (3 - Data.hintCounter) + ")");
        SudokuGUI.JBUTTON.get("hint").setEnabled(true);
        SudokuGUI.hintLabel.setText("");

        /** Generates the original sudoku table. */
        setup.setSudokuTable();

        /** Places zeros into a copy of the original sudoku table called originalSudokuTableWithZeros. The number
         * of zeros in each row depends on the difficulty setting. */
        Data.originalSudokuTableWithZeros = setup.setup();

        /** Converts the table into a one dimensional array. */
        Data.oneDTableWithZeros = MyUtil.twoDToOneD(Data.originalSudokuTableWithZeros);

        /** Sets the colors. Converts the zeros into empty Strings. Sets the empty fields editable. The fields that
         * have generated numbers in them, are set disabled. */
        for (int i = 0; i < Data.oneDTableWithZeros.length; i++) {
            TableBackground.color(Data.userFields, i);
            if (Data.oneDTableWithZeros[i] == 0) {
                Data.userFields[i].setText("");
                Data.userFields[i].setEditable(true);
                Data.userFields[i].setForeground(Color.GRAY);
            } else {
                Data.userFields[i].setText("" + Data.oneDTableWithZeros[i]);
                Data.userFields[i].setEnabled(false);
                Data.userFields[i].setDisabledTextColor(Color.BLACK);
            }
        }
    }
}