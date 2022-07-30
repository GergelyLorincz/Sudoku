package GUI;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusGainedAction implements FocusListener {

    private final JTextField[] FIELDS;
    private int index;

    public FocusGainedAction(JTextField[] FIELDS, int index) {
        this.FIELDS = FIELDS;
        this.index = index;
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        for (int i = 0; i < FIELDS.length; i++) {
            if (FIELDS[i].isFocusOwner()) {
                i = index;
            }
        }
    }
}
