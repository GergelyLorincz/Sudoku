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

        for (int i = 0; i < FIELDS.length; i++) {
            String str = FIELDS[i].getText();
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
            int[] coordinates = ManualInputAction.getCoordinates(indexOfHint);
            int[][] matrix = Setup.sudokuTable;
            FIELDS[indexOfHint].setText("" + matrix[coordinates[0]][coordinates[1]]);
        }
    }
}
