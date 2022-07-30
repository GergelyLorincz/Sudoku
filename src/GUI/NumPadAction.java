package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumPadAction implements ActionListener {

    private final JTextField[] FIELDS;
    private int index;

    public NumPadAction(JTextField[] fields, int index) {
        this.FIELDS = fields;
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SudokuGUI.one) {
            FIELDS[index].setText("" + 1);
        } else if (e.getSource() == SudokuGUI.two) {
            FIELDS[index].setText("" + 2);
        } else if (e.getSource() == SudokuGUI.three) {
            FIELDS[index].setText("" + 3);
        } else if (e.getSource() == SudokuGUI.four) {
            FIELDS[index].setText("" + 4);
        } else if (e.getSource() == SudokuGUI.five) {
            FIELDS[index].setText("" + 5);
        } else if (e.getSource() == SudokuGUI.six) {
            FIELDS[index].setText("" + 6);
        } else if (e.getSource() == SudokuGUI.seven) {
            FIELDS[index].setText("" + 7);
        } else if (e.getSource() == SudokuGUI.eight) {
            FIELDS[index].setText("" + 8);
        } else if (e.getSource() == SudokuGUI.nine) {
            FIELDS[index].setText("" + 9);
        }
    }
}



