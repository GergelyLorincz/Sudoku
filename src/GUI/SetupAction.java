package GUI;

import service.Difficulty;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupAction implements ActionListener {

    private final JTextField[] FIELDS;

    public SetupAction(JTextField[] fields) {this.FIELDS = fields; }

    Setup setup = new Setup();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SudokuGUI.easy) {
            setup.setDifficulty(Difficulty.EASY);
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    FIELDS[i].setText("" + oneDStarter[i]);
            }
        } else if (e.getSource() == SudokuGUI.medium) {
            setup.setDifficulty(Difficulty.MEDIUM);
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    FIELDS[i].setText("" + oneDStarter[i]);
            }
        } else if (e.getSource() == SudokuGUI.hard) {
            setup.setDifficulty(Difficulty.MEDIUM);
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < FIELDS.length; i++) {
                FIELDS[i].setText("");
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    FIELDS[i].setText("" + oneDStarter[i]);
            }
        }
    }
}