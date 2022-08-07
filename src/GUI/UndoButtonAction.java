package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UndoButtonAction implements ActionListener {

    private final JTextField[] FIELDS;

    public UndoButtonAction(JTextField[] fields) {this.FIELDS = fields; }

    public static List<Integer> indexes = new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {
        FIELDS[indexes.get(indexes.size() - 1)].setText("");
        indexes.remove(indexes.size() - 1);
    }
}
