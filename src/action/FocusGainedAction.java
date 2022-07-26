package action;

import service.Data;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusGainedAction implements FocusListener {

    /** Provides the number of index where the focus is placed on the sudoku table by the user. */
    @Override
    public void focusGained(FocusEvent e) {
        for (int i = 0; i < Data.userFields.length; i++) {
            if (Data.userFields[i].isFocusOwner()) {
                Data.focusIndex = i;
                break;
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {}
}
