package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class Layout extends GroupLayout {

    public Layout(Container host) {
        super(host);

    }

    /** The layout of the graphic userface. Grouplayout is used with autoCrateGaps. */
    public void setLayout(JPanel grid, Map<String,JButton> jButtonMap,
                           JCheckBox autoCheckBox, JLabel win, JLabel win2, JLabel hintLabel) {
        setAutoCreateGaps(true);
        setAutoCreateContainerGaps(true);

        setHorizontalGroup(
                createSequentialGroup()
                        .addComponent(grid)
                        .addGroup(createParallelGroup(CENTER)
                                .addComponent(hintLabel)
                                .addGroup(createSequentialGroup()
                                        .addComponent(jButtonMap.get("undo"))
                                        .addComponent(jButtonMap.get("hint"))
                                        .addComponent(jButtonMap.get("restart")))
                                .addGroup(createSequentialGroup()
                                        .addGroup(createParallelGroup()
                                                .addComponent(jButtonMap.get("one"))
                                                .addComponent(jButtonMap.get("four"))
                                                .addComponent(jButtonMap.get("seven")))
                                        .addGroup(createParallelGroup()
                                                .addComponent(jButtonMap.get("two"))
                                                .addComponent(jButtonMap.get("five"))
                                                .addComponent(jButtonMap.get("eight")))
                                        .addGroup(createParallelGroup()
                                                .addComponent(jButtonMap.get("three"))
                                                .addComponent(jButtonMap.get("six"))
                                                .addComponent(jButtonMap.get("nine"))))
                                .addComponent(autoCheckBox)
                                .addComponent(win)
                                .addComponent(win2)));

        setVerticalGroup(
                createParallelGroup(CENTER)
                        .addComponent(grid)
                        .addGroup(createSequentialGroup()
                                .addComponent(hintLabel)
                                .addGroup(createParallelGroup(CENTER)
                                        .addComponent(jButtonMap.get("undo"))
                                        .addComponent(jButtonMap.get("hint"))
                                        .addComponent(jButtonMap.get("restart")))
                                .addGroup(createSequentialGroup()
                                        .addGroup(createParallelGroup()
                                                .addComponent(jButtonMap.get("one"))
                                                .addComponent(jButtonMap.get("two"))
                                                .addComponent(jButtonMap.get("three")))
                                        .addGroup(createParallelGroup()
                                                .addComponent(jButtonMap.get("four"))
                                                .addComponent(jButtonMap.get("five"))
                                                .addComponent(jButtonMap.get("six")))
                                        .addGroup(createParallelGroup()
                                                .addComponent(jButtonMap.get("seven"))
                                                .addComponent(jButtonMap.get("eight"))
                                                .addComponent(jButtonMap.get("nine"))))
                                .addComponent(autoCheckBox)
                                .addComponent(win)
                                .addComponent(win2)));
    }
}
