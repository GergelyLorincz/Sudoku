package action;

import GUI.SudokuGUI;
import GUI.TableBackground;
import service.Data;
import service.Difficulty;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Set;

public class SetupAction implements ActionListener {

    Setup setup = new Setup();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SudokuGUI.easy) {
            setup.setDifficulty(Difficulty.EASY);
        } else if (e.getSource() == SudokuGUI.medium) {
            setup.setDifficulty(Difficulty.MEDIUM);
        } else if (e.getSource() == SudokuGUI.hard) {
            setup.setDifficulty(Difficulty.HARD);
        }
        MyUtil.enableFields(Data.userFields);
        setup.sudokuTableZeroDown();
        setup.setSudokuTable();
        Data.originalSudokuTableWithZeros = setup.setup();
        Data.oneDTableWithZeros = MyUtil.twoDToOneD(Data.originalSudokuTableWithZeros);

        for (int i = 0; i < Data.oneDTableWithZeros.length; i++) {
            TableBackground.color(Data.userFields, i);
            if (Data.oneDTableWithZeros[i] == 0) {
                Data.userFields[i].setText("");
                Data.userFields[i].setEditable(true);
                Data.userFields[i].setForeground(Color.GRAY);
            } else {
                Data.userFields[i].setText("" + Data.oneDTableWithZeros[i]);
                Data.userFields[i].setEnabled(false);
                Data.userFields[i].setDisabledTextColor(Color.BLACK);
            }
        }
    }
}