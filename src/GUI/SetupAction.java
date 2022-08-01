package GUI;

import service.Difficulty;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupAction implements ActionListener {

    private final JTextField[] FIELDS;

    public SetupAction(JTextField[] fields) {this.FIELDS = fields; }

    public static int[] copy = new int[81];

    Setup setup = new Setup();

    @Override
    public void actionPerformed(ActionEvent e) { //TODO generated nums non editable

        if (e.getSource() == SudokuGUI.easy) {
            setup.setDifficulty(Difficulty.EASY);
            setup.setSudokuTable();
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < oneDStarter.length; i++) {
                copy[i] = oneDStarter[i];
            }

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
                FIELDS[i].setForeground(Color.BLACK);
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    FIELDS[i].setText("" + oneDStarter[i]);
            }

        } else if (e.getSource() == SudokuGUI.medium) {
            setup.setDifficulty(Difficulty.MEDIUM);
            setup.setSudokuTable();
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < oneDStarter.length; i++) {
                copy[i] = oneDStarter[i];
            }

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
                FIELDS[i].setForeground(Color.BLACK);
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    FIELDS[i].setText("" + oneDStarter[i]);
            }

        } else if (e.getSource() == SudokuGUI.hard) {
            setup.setDifficulty(Difficulty.MEDIUM);
            setup.setSudokuTable();
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < oneDStarter.length; i++) {
                copy[i] = oneDStarter[i];
            }

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
                FIELDS[i].setForeground(Color.BLACK);
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    FIELDS[i].setText("" + oneDStarter[i]);
            }
        }
    }
}