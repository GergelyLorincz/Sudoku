package GUI;

import action.*;
import service.Data;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;


public class SudokuGUI extends JFrame{

    public static JMenuItem easy, medium, hard;
    public static JButton one, two, three, four, five, six, seven, eight, nine;
    public static JButton undo, hint, restart;
    public static boolean checkBox = false;
    public static JCheckBox autoCheckBox;
    public static JLabel win;
    public static JLabel win2;

    public static final Map<String, JButton> JBUTTON = new HashMap<>();

    public SudokuGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Data.userFields = emptyFields();
        JPanel grid = jPanelSetup(Data.userFields);

        NumPadAction numPadAction = new NumPadAction();
        SetupAction setupAction = new SetupAction();
        FocusGainedAction focusGainedAction = new FocusGainedAction();
        UndoButtonAction undoButtonAction = new UndoButtonAction();
        HintButtonAction hintButtonAction = new HintButtonAction();
        RestartButtonAction restartButtonAction = new RestartButtonAction();
        AutoCheck autoCheck = new AutoCheck();

        ImageIcon img = new ImageIcon("src/resource/icon.png");
        setIconImage(img.getImage());

        JMenuBar menuBar = new JMenuBar();
        JMenu newGame = new JMenu("New game");
        easy = new JMenuItem("Easy");
        medium = new JMenuItem("Medium");
        hard = new JMenuItem("Hard");
        menuBar.add(newGame);
        newGame.add(easy);
        newGame.add(medium);
        newGame.add(hard);
        setJMenuBar(menuBar);

        autoCheckBox = new JCheckBox("Auto-check", false);
        win = new JLabel("");
        win2 = new JLabel("");

        autoCheckBox.setFont(new Font("MonoLisa",Font.BOLD,15));
        win.setFont(new Font("MonoLisa",Font.BOLD,15));
        win2.setFont(new Font("MonoLisa",Font.BOLD,15));

        JBUTTON.put("undo", createButton("Undo", false));
        JBUTTON.put("hint", createButton("Hint", false));
        JBUTTON.put("restart", createButton("Restart", false));
        JBUTTON.put("one", createButton("1", true));
        JBUTTON.put("two", createButton("2", true));
        JBUTTON.put("three", createButton("3", true));
        JBUTTON.put("four", createButton("4", true));
        JBUTTON.put("five", createButton("5", true));
        JBUTTON.put("six", createButton("6", true));
        JBUTTON.put("seven", createButton("7", true));
        JBUTTON.put("eight", createButton("8", true));
        JBUTTON.put("nine", createButton("9", true));

        Layout layout = new Layout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setLayout(grid,JBUTTON,autoCheckBox,win,win2);

        pack();

        easy.addActionListener(setupAction);
        medium.addActionListener(setupAction);
        hard.addActionListener(setupAction);

        JBUTTON.get("undo").addActionListener(undoButtonAction);
        JBUTTON.get("hint").addActionListener(hintButtonAction);
        JBUTTON.get("restart").addActionListener(restartButtonAction);

        numPadActionSetup(numPadAction, JBUTTON.get("one"), JBUTTON.get("two"), JBUTTON.get("three"),
                JBUTTON.get("four"), JBUTTON.get("five"), JBUTTON.get("six"), JBUTTON.get("seven"),
                JBUTTON.get("eight"), JBUTTON.get("nine"));

        autoCheckBox.addItemListener(autoCheck);

        for (int i = 0; i < Data.userFields.length; i++) {
            ManualInputAction manualInputAction = new ManualInputAction(i);
            Data.userFields[i].addKeyListener(manualInputAction);
        }

       for (int i = 0; i < Data.userFields.length; i++) {
           Data.userFields[i].addFocusListener(focusGainedAction);
       }
    }


    private JTextField[] emptyFields() {
        JTextField[] resultArray = new JTextField[81];
        for (int i = 0; i < 81; i++) {
            JTextField jField = new JTextField("");
            jField.setHorizontalAlignment(JTextField.CENTER);
            jField.setBorder(new LineBorder(Color.GRAY,1));
            jField.setFont(new Font("MonoLisa",Font.BOLD,17));
            jField.setDocument(new JTextFieldLimit(1));
            jField.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if ((c < '1') || (c > '9')) {
                        e.consume();
                    }
                }
            });
            resultArray[i] = jField;
        }
        return resultArray;
    }


    private JPanel jPanelSetup(JTextField[] fields) {
        JPanel grid = new JPanel();
        GridLayout gridLayout = new GridLayout(9,9);
        grid.setLayout(gridLayout);
        grid.setPreferredSize(new Dimension(350,350));

        for (int i = 0; i < fields.length; i++) {
            grid.add(fields[i]);
            TableBackground.color(fields,i);
        }

        return grid;
    }


    private JButton createButton(String name, boolean isNumberButton) {
        JButton jButton = new JButton(name);
        if (isNumberButton) {
            jButton.setFont(new Font("MonoLisa", Font.BOLD, 35));
            jButton.setMinimumSize(new Dimension(60,60));
        } else {
            jButton.setFont(new Font("MonoLisa", Font.BOLD, 15));
        }
        return jButton;
    }


    private void numPadActionSetup(NumPadAction numPadAction, JButton... jButtons) {
        for (JButton jButton : jButtons) {
            jButton.addActionListener(numPadAction);
        }
    }
}
