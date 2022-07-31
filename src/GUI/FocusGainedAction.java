package GUI;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusGainedAction implements FocusListener {

    private final JTextField[] FIELDS;
    public static int index;

    public FocusGainedAction(JTextField[] FIELDS) {
        this.FIELDS = FIELDS;
    }

    @Override
    public void focusGained(FocusEvent e) {
        for (int i = 0; i < FIELDS.length; i++) {
            if (FIELDS[i].isFocusOwner()) {
                index = i;
                break;
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
