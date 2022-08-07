package GUI;

import service.Checker;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AutoCheck implements ItemListener {

    private final JTextField[] FIELDS;

    public AutoCheck(JTextField[] fields) {this.FIELDS = fields; }

    @Override
    public void itemStateChanged(ItemEvent e) { //TODO total chaos, make it work
        if (e.getStateChange() == 1) {
            SudokuGUI.checkBox = true;

            int[][] matrix = Setup.sudokuTable;

            int[] matrixWithZerosOneD = SetupAction.copy;
            int[][] matrixWithZeros = MyUtil.oneDtoTwoD(matrixWithZerosOneD);

            int counter = 0;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] != matrixWithZeros[i][j]) {
                        if (!String.valueOf(FIELDS[counter].getText()).equals("")) {
                            if (Checker.checker(matrix, Integer.parseInt(String.valueOf(FIELDS[counter].getText())), i, j)) {
                                FIELDS[counter].setForeground(Color.BLUE);
                            } else {
                                FIELDS[counter].setForeground(Color.RED);
                            }
                        }
                    }
                    counter++;
                }
            }
        } else {
            SudokuGUI.checkBox = false;

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setForeground(Color.BLACK);
            }
        }
    }
}
