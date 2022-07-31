package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EraseButtonAction implements ActionListener {

    private final JTextField[] FIELDS;

    public EraseButtonAction(JTextField[] fields) {this.FIELDS = fields; }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = FocusGainedAction.index;
        FIELDS[index].setText("");
    }
}
