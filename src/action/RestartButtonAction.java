package action;

import GUI.SudokuGUI;
import service.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartButtonAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < Data.userFields.length; i++) {
            Data.userFields[i].setText("");
            Data.userFields[i].setForeground(Color.BLACK);
        }

        for (int i = 0; i < Data.oneDTableWithZeros.length; i++) {
            if (Data.oneDTableWithZeros[i] != 0)
                Data.userFields[i].setText("" + Data.oneDTableWithZeros[i]);
        }

        SudokuGUI.win.setText("");
        SudokuGUI.win2.setText("");
    }
}
