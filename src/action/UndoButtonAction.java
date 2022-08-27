package action;
import GUI.SudokuGUI;
import service.Data;
import util.MyUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoButtonAction implements ActionListener {

    /** Deletes the last user input when the button is clicked. */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Data.getIndexes().size() > 0) {
            Data.userFields[Data.getIndexes().get(Data.getIndexes().size() - 1)].setText("");
            Data.getIndexes().remove(Data.getIndexes().size() - 1);
            if (MyUtil.arrayHasEmptyField(Data.userFields)) {
                SudokuGUI.win.setText("");
                SudokuGUI.win2.setText("");
            }
        }
    }
}
