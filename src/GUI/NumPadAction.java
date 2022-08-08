package GUI;

import service.Checker;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumPadAction implements ActionListener {

    private final JTextField[] FIELDS;

    public NumPadAction(JTextField[] fields) {this.FIELDS = fields; }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = FocusGainedAction.index;
        int number = 0;
        if (e.getSource() == SudokuGUI.one) {
            number = 1;
        } else if (e.getSource() == SudokuGUI.two) {
            number = 2;
        } else if (e.getSource() == SudokuGUI.three) {
            number = 3;
        } else if (e.getSource() == SudokuGUI.four) {
            number = 4;
        } else if (e.getSource() == SudokuGUI.five) {
            number = 5;
        } else if (e.getSource() == SudokuGUI.six) {
            number = 6;
        } else if (e.getSource() == SudokuGUI.seven) {
            number = 7;
        } else if (e.getSource() == SudokuGUI.eight) {
            number = 8;
        } else if (e.getSource() == SudokuGUI.nine) {
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
    }
}



