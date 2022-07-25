package GUI;

import service.Difficulty;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupAction implements ActionListener {

    private final JTextField[] fields;

    public SetupAction(JTextField[] fields) {this.fields = fields; }

    Setup setup = new Setup();
    SudokuGUI sudokuGUI = new SudokuGUI();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sudokuGUI.easy) {
            setup.setDifficulty(Difficulty.EASY);
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < fields.length; i++) {
                fields[i].setText("");
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    fields[i].setText("" + oneDStarter[i]);
            }
        } else if (e.getSource() == sudokuGUI.medium) {
            setup.setDifficulty(Difficulty.MEDIUM);
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < fields.length; i++) {
                fields[i].setText("");
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    fields[i].setText("" + oneDStarter[i]);
            }
        } else if (e.getSource() == sudokuGUI.hard) {
            setup.setDifficulty(Difficulty.MEDIUM);
            int[][] starterMatrix = setup.setup();
            int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

            for (int i = 0; i < fields.length; i++) {
                fields[i].setText("");
            }

            for (int i = 0; i < oneDStarter.length; i++) {
                if (oneDStarter[i] != 0)
                    fields[i].setText("" + oneDStarter[i]);
            }
        }
    }
}
