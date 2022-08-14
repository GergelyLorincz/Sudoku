package GUI;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowAction implements KeyListener {

    private  int index;
    private final JTextField[] FIELDS;

    ArrowAction(int index, JTextField[] fields) {
        this.index = index;
        this.FIELDS = fields;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int index = FocusGainedAction.index;
        if (e.getKeyCode() == KeyEvent.VK_UP && index > 8) {
            FIELDS[index - 9].grabFocus();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && index > 0) {
            FIELDS[index - 1].grabFocus();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && index < 81) {
            FIELDS[index + 1].grabFocus();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && index < 73) {
            FIELDS[index + 9].grabFocus();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
