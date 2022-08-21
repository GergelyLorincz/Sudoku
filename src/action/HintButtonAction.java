package action;

import GUI.SudokuGUI;
import service.Data;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HintButtonAction implements ActionListener {

    private int getNumberOfEmptyFields() {
        int counter = 0;

        for (JTextField field : Data.userFields) {
            String str = field.getText();
            if (str.equals("")) {
                counter++;
            }
        }
        return counter;
    }


    private int getRandomField() {
        int numberOfEmptyFields = getNumberOfEmptyFields();
        if (numberOfEmptyFields == 0) {
            return -1;
        }
        return MyUtil.getRandomInt(numberOfEmptyFields, 1);
    }


    private int getIndexOfMatrix() {
        int randomField = getRandomField();

        if(randomField == -1) {
            return -1;
        }

        int indexCounter = 0;
        int counter = 0;

        for (int i = 0; i < Data.userFields.length; i++) {
            String str = Data.userFields[i].getText();
            if (str.equals("")) {
                counter++;
            }
            if (counter == randomField) {
                indexCounter = i;
                break;
            }
        }
        return indexCounter;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int indexOfHint = getIndexOfMatrix();

        if (indexOfHint != -1) {
            int[] coordinates = MyUtil.getCoordinates(indexOfHint);
            Data.userFields[indexOfHint].setText("" + Data.originalSudokuTable[coordinates[0]][coordinates[1]]);
            if (SudokuGUI.checkBox) {
                Data.userFields[indexOfHint].setForeground(Color.BLUE);
            }
        }
    }
}
