package GUI;

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

    private final JTextField[] FIELDS;

    public SetupAction(JTextField[] fields) {this.FIELDS = fields; }

    public static int[] copy = new int[81];

    Setup setup = new Setup();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SudokuGUI.easy) {
            setup.sudokuTableZeroDown();
            setup.setDifficulty(Difficulty.EASY);
            setup.setSudokuTable();
            MyUtil.print(setup.sudokuTable);
            System.out.println();
            int[][] starterMatrix = setup.setup();
            copy = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
                FIELDS[i].setForeground(Color.BLACK);
                FIELDS[i].setEditable(true);
                TableBackground.color(FIELDS,i);
            }

            for (int i = 0; i < copy.length; i++) {
                if (copy[i] != 0) {
                    FIELDS[i].setText("" + copy[i]);
                    FIELDS[i].setEditable(false);
                }
            }

        } else if (e.getSource() == SudokuGUI.medium) {
            setup.sudokuTableZeroDown();
            setup.setDifficulty(Difficulty.MEDIUM);
            setup.setSudokuTable();
            int[][] starterMatrix = setup.setup();
            copy = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
                FIELDS[i].setForeground(Color.BLACK);
                FIELDS[i].setEditable(true);
            }

            for (int i = 0; i < copy.length; i++) {
                if (copy[i] != 0) {
                    FIELDS[i].setText("" + copy[i]);
                    FIELDS[i].setEditable(false);
                }
            }

        } else if (e.getSource() == SudokuGUI.hard) {
            setup.sudokuTableZeroDown();
            setup.setDifficulty(Difficulty.HARD);
            setup.setSudokuTable();
            int[][] starterMatrix = setup.setup();
            copy = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
                FIELDS[i].setForeground(Color.BLACK);
                FIELDS[i].setEditable(true);
            }

            for (int i = 0; i < copy.length; i++) {
                if (copy[i] != 0) {
                    FIELDS[i].setText("" + copy[i]);
                    FIELDS[i].setEditable(false);
                }
            }
        }
    }
}