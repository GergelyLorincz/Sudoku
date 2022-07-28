package GUI;

import service.Checker;
import service.Setup;
import util.MyUtil;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ManualInputAction implements KeyListener {

    private final int ARRAYINDEX;
    private final JTextField[] FIELDS;

    ManualInputAction(int arrayIndex, JTextField[] fields) {
        this.ARRAYINDEX = arrayIndex;
        this.FIELDS = fields;
    }

    private int[] getCoordinates() {
        int[] resultArray = new int[2];
        int row;
        int column;

        row = ARRAYINDEX / 9;

        if (ARRAYINDEX < 9) {
            column = 0;
        } else {column = ARRAYINDEX % 9 - 1; }

        resultArray[0] = row;
        resultArray[1] = column;
        return resultArray;
    }

    private int[] convertStringToInt(JTextField[] jArray) {
        int[] resultArray = new int[81];

        for (int i = 0; i < jArray.length; i++) {
            String text = jArray[i].getText();
            resultArray[i] = text.isBlank() ? 0 : Integer.parseInt(text);
        }

        return resultArray;
    }

    /*public void actionPerformed(KeyEvent e) {

    }*/

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            char c = e.getKeyChar();
            String text = String.valueOf(c);
            int num = Integer.parseInt(text);
            int[] coordinates = getCoordinates();
            int[] array = convertStringToInt(FIELDS);
            int[][] matrix = Setup.sudokuTable;
            MyUtil.print(matrix);

            if (Checker.isValidPlacement(matrix,num,coordinates[0],coordinates[1])) {
                FIELDS[ARRAYINDEX].setForeground(Color.BLUE);
            } else {
                FIELDS[ARRAYINDEX].setForeground(Color.RED);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
