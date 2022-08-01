package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartButtonAction implements ActionListener {

    private final JTextField[] FIELDS;

    public RestartButtonAction(JTextField[] fields) {this.FIELDS = fields; }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < FIELDS.length; i++) {
            FIELDS[i].setText("");
            FIELDS[i].setForeground(Color.BLACK);
        }

        for (int i = 0; i < SetupAction.copy.length; i++) {
            if (SetupAction.copy[i] != 0)
                FIELDS[i].setText("" + SetupAction.copy[i]);
        }
    }
}
