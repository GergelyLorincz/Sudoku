package action;

import GUI.SudokuGUI;
import service.Checker;
import service.Data;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AutoCheck implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
        SudokuGUI.checkBox = e.getStateChange() == ItemEvent.SELECTED;

        int length = Data.originalSudokuTable.length;
        Color color = Color.BLACK;

        for (int i = 0; i < Data.originalSudokuTable.length; i++) {
            for (int j = 0; j < Data.originalSudokuTable.length; j++) {
                if (Data.originalSudokuTable[i][j] != Data.originalSudokuTableWithZeros[i][j]) {
                    if (SudokuGUI.checkBox) {

                        if (!String.valueOf(Data.userFields[i * length + j].getText()).equals("")) {

                            String str = Data.userFields[i * length + j].getText();
                            int userNumber = Integer.parseInt(str);

                            if (Checker.checker(Data.originalSudokuTable, userNumber, i, j)) {
                                color = Color.BLUE;
                            } else {
                                color = Color.RED;
                            }
                        }
                    } else {
                        color = Color.GRAY;
                    }
                }
                Data.userFields[i * length + j].setForeground(color);
            }
        }
    }
}
