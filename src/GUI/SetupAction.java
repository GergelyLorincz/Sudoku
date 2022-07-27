package GUI;

import service.Difficulty;
import service.Setup;
import util.MyUtil;
import GUI.SudokuGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupAction implements ActionListener {

    private final JTextField[] fields;

    public SetupAction(JTextField[] fields) {this.fields = fields; }

    Setup setup = new Setup();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SudokuGUI.easy) {
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
        } else if (e.getSource() == SudokuGUI.medium) {
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
        } else if (e.getSource() == SudokuGUI.hard) {
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