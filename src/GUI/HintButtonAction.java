package GUI;

import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HintButtonAction implements ActionListener {

    private final JTextField[] FIELDS;

    public HintButtonAction(JTextField[] fields) {this.FIELDS = fields; }

    private int getNumberOfEmptyFields() {
        int counter = 0;

        for (int i = 0; i < FIELDS.length; i++) {
            String str = FIELDS[i].getText();
            if (str.equals("")) {
                counter++;
            }
        }
        return counter;
    }

    private int getRandomField() {
        int numberOfEmptyFields = getNumberOfEmptyFields();
        return MyUtil.getRandomInt(numberOfEmptyFields, 1);
    }

    private int getIndexOfMatrix() {
        int randomField = getRandomField();
        int indexCounter = 0;
        int counter = 0;

        for (int i = 0; i < FIELDS.length; i++) {
            String str = FIELDS[i].getText();
            if (str.equals("")) {
                counter++;
            }
            if (counter == randomField) {
                indexCounter = i;
            }
        }
        return indexCounter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int indexOfHint = getIndexOfMatrix();
        int[] coordinates = ManualInputAction.getCoordinates(indexOfHint);
        int[][] matrix = Setup.sudokuTable;
        FIELDS[indexOfHint].setText("" + matrix[coordinates[0]][coordinates[1]]); ;
    }
}
