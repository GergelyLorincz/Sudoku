package action;

import GUI.SudokuGUI;
import service.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartButtonAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        /** Resets each element of the user sudoku table to an empty field and sets the font to black. */
        for (int i = 0; i < Data.userFields.length; i++) {
            Data.userFields[i].setText("");
            Data.userFields[i].setForeground(Color.BLACK);
        }

        /** Sets up the user sudoku table again with the starting numbers and the empty fields. */
        for (int i = 0; i < Data.oneDTableWithZeros.length; i++) {
            if (Data.oneDTableWithZeros[i] != 0)
                Data.userFields[i].setText("" + Data.oneDTableWithZeros[i]);
        }

        /** Sets the winning texts to empty Strings. */
        SudokuGUI.win.setText("");
        SudokuGUI.win2.setText("");
    }
}
