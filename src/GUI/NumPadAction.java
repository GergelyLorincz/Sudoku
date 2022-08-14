package GUI;

import service.Checker;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class NumPadAction implements ActionListener {

    private final JTextField[] FIELDS;

    public NumPadAction(JTextField[] fields) {this.FIELDS = fields; }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = FocusGainedAction.index;
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
        FIELDS[index].setText("" + number);
        UndoButtonAction.indexes.add(index);

        int[] coordinates = ManualInputAction.getCoordinates(index);
        int[] array = ManualInputAction.convertStringToInt(FIELDS);
        int[][] matrix = Setup.sudokuTable;

        if (SudokuGUI.checkBox) {
            if (Checker.checker(matrix, number, coordinates[0], coordinates[1])) {
                FIELDS[index].setForeground(Color.BLUE);
            } else {
                FIELDS[index].setForeground(Color.RED);
            }
        }

        System.out.println(Arrays.toString(MyUtil.JtextIntoArray(FIELDS)));
        System.out.println(MyUtil.arrayHasEmptyField(FIELDS));
        if (!MyUtil.arrayHasEmptyField(FIELDS)) {
            int[] fieldsOneD = new int[81];
            for (int i = 0; i < FIELDS.length; i++) {
                fieldsOneD[i] = Integer.parseInt(FIELDS[i].getText());
            }
            int[][] fieldsMatrix = MyUtil.oneDtoTwoD(fieldsOneD);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] != fieldsMatrix[i][j]) {
                        SudokuGUI.win.setText("One or more number are wrong. Please try again");
                    } else {
                        SudokuGUI.win.setText("Congratulations, You Won!");
                    }
                }
            }
        }
    }
}



