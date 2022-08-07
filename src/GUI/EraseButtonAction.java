package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EraseButtonAction implements ActionListener {

    private final JTextField[] FIELDS;

    public EraseButtonAction(JTextField[] fields) {this.FIELDS = fields; }

    private final List<Integer> indexes = new ArrayList<>();
    private int counter = 0;

    @Override
    public void actionPerformed(ActionEvent e) { //TODO make it to Undo button
        int index = FocusGainedAction.index;
        indexes.add(index);
        counter++;
        FIELDS[indexes.get(indexes.size() - counter)].setText("");
    }
}
