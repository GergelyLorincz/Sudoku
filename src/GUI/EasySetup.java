package GUI;

import service.Difficulty;
import service.Setup;
import util.MyUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EasySetup implements ActionListener {

    private final JTextField[] fields;

    public EasySetup(JTextField[] fields) {this.fields = fields; }

    Setup setup = new Setup();

    @Override
    public void actionPerformed(ActionEvent e) {
        setup.setDifficulty(Difficulty.EASY);
        int[][] starterMatrix = setup.setup();
        int[] oneDStarter = MyUtil.twoDToOneD(starterMatrix);

        for (int i = 0; i < oneDStarter.length; i++) {
            if (oneDStarter[i] != 0)
            fields[i].setText("" + oneDStarter[i]);
        }
    }
}
