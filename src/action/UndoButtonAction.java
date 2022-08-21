package action;
import service.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoButtonAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Data.getIndexes().size() > 0) {
            Data.userFields[Data.getIndexes().get(Data.getIndexes().size() - 1)].setText("");
            Data.getIndexes().remove(Data.getIndexes().size() - 1);
        }
    }
}
