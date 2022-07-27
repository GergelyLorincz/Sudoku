package GUI;

import service.Checker;
import util.MyUtil;

import javax.swing.*;
import util.MyUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ManualInputAction {

    private int arrayIndex;
    private final JTextField[] fields;

    ManualInputAction(int arrayIndex, JTextField[] fields) {
        this.arrayIndex = arrayIndex;
        this.fields = fields;
    }

    private int[] getCoordinates() {
        int[] resultArray = new int[2];
        int row;
        int column;

        row = arrayIndex / 9;

        if (arrayIndex < 9) {
            column = 0;
        } else {column = arrayIndex % 9 - 1; }

        resultArray[0] = row;
        resultArray[1] = column;
        return resultArray;
    }

    private int[] convertStringToInt(JTextField[] jArray) {
        int[] resultArray = new int[81];

        for (int i = 0; i < jArray.length; i++) {
            String text = jArray[i].getText();
            resultArray[i] = Integer.parseInt(text);
        }

        return resultArray;
    }

    public void actionPerformed(KeyEvent e) {
        int num = e.getKeyChar();
        int[] coordinates = getCoordinates();
        int[] array = convertStringToInt(fields);
        int[][] matrix = MyUtil.oneDtoTwoD(array);

        if (Checker.isValidPlacement(matrix,num,coordinates[0],coordinates[1])) {
            fields[arrayIndex].setForeground(Color.BLUE);
        } else {
            fields[arrayIndex].setForeground(Color.RED);
        }
    }
}
