package action;

import GUI.SudokuGUI;
import service.Checker;
import service.Data;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class NumPadAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int number = 0;
        if (e.getSource() == SudokuGUI.JBUTTON.get("one")) {
            number = 1;
        } else if (e.getSource() == SudokuGUI.JBUTTON.get("two")) {
            number = 2;
        } else if (e.getSource() == SudokuGUI.JBUTTON.get("three")) {
            number = 3;
        } else if (e.getSource() == SudokuGUI.JBUTTON.get("four")) {
            number = 4;
        } else if (e.getSource() == SudokuGUI.JBUTTON.get("five")) {
            number = 5;
        } else if (e.getSource() == SudokuGUI.JBUTTON.get("six")) {
            number = 6;
        } else if (e.getSource() == SudokuGUI.JBUTTON.get("seven")) {
            number = 7;
        } else if (e.getSource() == SudokuGUI.JBUTTON.get("eight")) {
            number = 8;
        } else if (e.getSource() == SudokuGUI.JBUTTON.get("nine")) {
            number = 9;
        }
        Data.userFields[Data.focusIndex].setText("" + number);
        Data.getIndexes().add(Data.focusIndex);

        int[] coordinates = MyUtil.getCoordinates(Data.focusIndex);

        if (SudokuGUI.checkBox) {
            if (Checker.checker(Data.originalSudokuTable, number, coordinates[0], coordinates[1])) {
                Data.userFields[Data.focusIndex].setForeground(Color.BLUE);
            } else {
                Data.userFields[Data.focusIndex].setForeground(Color.RED);
            }
        }

        if (!MyUtil.arrayHasEmptyField(Data.userFields)) {
            int[] fieldsOneD = new int[81];
            for (int i = 0; i < Data.userFields.length; i++) {
                fieldsOneD[i] = Integer.parseInt(Data.userFields[i].getText());
            }
            int[][] fieldsMatrix = MyUtil.oneDtoTwoD(fieldsOneD);

            for (int i = 0; i < Data.originalSudokuTable.length; i++) {
                for (int j = 0; j < Data.originalSudokuTable.length; j++) {
                    if (Data.originalSudokuTable[i][j] != fieldsMatrix[i][j]) {
                        SudokuGUI.win.setText("One or more number are wrong. Please try again");
                    } else {
                        SudokuGUI.win.setText("Congratulations, You Won!");
                    }
                }
            }
        }
    }
}



