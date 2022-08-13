package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static javax.swing.GroupLayout.Alignment.*;


public class SudokuGUI extends JFrame{

    public static JMenuItem easy, medium, hard;
    public static JButton one, two, three, four, five, six, seven, eight, nine;
    public static JButton undo, hint, restart;
    public static boolean checkBox = false;
    public static JCheckBox autoCheckBox;
    public static JLabel win;
    public static JLabel win2;
    int num = 0;

    public SudokuGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel grid = new JPanel();
        GridLayout gridLayout = new GridLayout(9,9);
        grid.setLayout(gridLayout);
        grid.setPreferredSize(new Dimension(350,350));

        JTextField[] fields = emptyFields();


        for (int i = 0; i < fields.length; i++) {
            grid.add(fields[i]);
            TableBackground.color(fields,i);
        }

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

        undo = new JButton("Undo");
        hint = new JButton("Hint");
        restart = new JButton("Restart");
        autoCheckBox = new JCheckBox("Auto-check", false);
        win = new JLabel("");
        win2 = new JLabel("");

        autoCheckBox.setFont(new Font("MonoLisa",Font.BOLD,15));
        win.setFont(new Font("MonoLisa",Font.BOLD,15));
        win2.setFont(new Font("MonoLisa",Font.BOLD,15));
        newGame.setMinimumSize(new Dimension(225,30));

        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");

        one.setMinimumSize(new Dimension(60,60));
        two.setMinimumSize(new Dimension(60,60));
        three.setMinimumSize(new Dimension(60,60));
        four.setMinimumSize(new Dimension(60,60));
        five.setMinimumSize(new Dimension(60,60));
        six.setMinimumSize(new Dimension(60,60));
        seven.setMinimumSize(new Dimension(60,60));
        eight.setMinimumSize(new Dimension(60,60));
        nine.setMinimumSize(new Dimension(60,60));

        undo.setFont(new Font("MonoLisa", Font.BOLD, 15));
        hint.setFont(new Font("MonoLisa", Font.BOLD, 15));
        restart.setFont(new Font("MonoLisa", Font.BOLD, 15));
        one.setFont(new Font("MonoLisa", Font.BOLD, 35));
        two.setFont(new Font("MonoLisa", Font.BOLD, 35));
        three.setFont(new Font("MonoLisa", Font.BOLD, 35));
        four.setFont(new Font("MonoLisa", Font.BOLD, 35));
        five.setFont(new Font("MonoLisa", Font.BOLD, 35));
        six.setFont(new Font("MonoLisa", Font.BOLD, 35));
        seven.setFont(new Font("MonoLisa", Font.BOLD, 35));
        eight.setFont(new Font("MonoLisa", Font.BOLD, 35));
        nine.setFont(new Font("MonoLisa", Font.BOLD, 35));


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(grid)
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(undo)
                                        .addComponent(hint)
                                        .addComponent(restart))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup()
                                                .addComponent(one)
                                                .addComponent(four)
                                                .addComponent(seven))
                                        .addGroup(layout.createParallelGroup()
                                                .addComponent(two)
                                                .addComponent(five)
                                                .addComponent(eight))
                                        .addGroup(layout.createParallelGroup()
                                                .addComponent(three)
                                                .addComponent(six)
                                                .addComponent(nine)))
                                .addComponent(autoCheckBox)
                                .addComponent(win)
                                .addComponent(win2)));

        layout.setVerticalGroup(
                layout.createParallelGroup(CENTER)
                        .addComponent(grid)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(undo)
                                        .addComponent(hint)
                                        .addComponent(restart))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup()
                                                .addComponent(one)
                                                .addComponent(two)
                                                .addComponent(three))
                                        .addGroup(layout.createParallelGroup()
                                                .addComponent(four)
                                                .addComponent(five)
                                                .addComponent(six))
                                        .addGroup(layout.createParallelGroup()
                                                .addComponent(seven)
                                                .addComponent(eight)
                                                .addComponent(nine)))
                                .addComponent(autoCheckBox)
                                .addComponent(win)
                                .addComponent(win2)));

        pack();

        SetupAction setupAction = new SetupAction(fields);
        FocusGainedAction focusGainedAction = new FocusGainedAction(fields);
        NumPadAction numPadAction = new NumPadAction(fields);
        UndoButtonAction undoButtonAction = new UndoButtonAction(fields);
        HintButtonAction hintButtonAction = new HintButtonAction(fields);
        RestartButtonAction restartButtonAction = new RestartButtonAction(fields);
        AutoCheck autoCheck = new AutoCheck(fields);

        easy.addActionListener(setupAction);
        medium.addActionListener(setupAction);
        hard.addActionListener(setupAction);

        undo.addActionListener(undoButtonAction);
        hint.addActionListener(hintButtonAction);
        restart.addActionListener(restartButtonAction);

        one.addActionListener(numPadAction);
        two.addActionListener(numPadAction);
        three.addActionListener(numPadAction);
        four.addActionListener(numPadAction);
        five.addActionListener(numPadAction);
        six.addActionListener(numPadAction);
        seven.addActionListener(numPadAction);
        eight.addActionListener(numPadAction);
        nine.addActionListener(numPadAction);

        autoCheckBox.addItemListener(autoCheck);

        for (int i = 0; i < fields.length; i++) {
            ManualInputAction manualInputAction = new ManualInputAction(i, fields);
            fields[i].addKeyListener(manualInputAction);
        }

        for (int i = 0; i < fields.length; i++) {
            ArrowAction arrowAction = new ArrowAction(i, fields);
                fields[i].addKeyListener(arrowAction);
            }


       for (int i = 0; i < fields.length; i++) {
            fields[i].addFocusListener(focusGainedAction);
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
                    if (((c < '1') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) &&
                            (c != KeyEvent.VK_UP) && (c != KeyEvent.VK_LEFT) &&
                            (c != KeyEvent.VK_RIGHT) && (c != KeyEvent.VK_DOWN)) {
                        e.consume();
                    }
                }
            });
            resultArray[i] = jField;
        }
        return resultArray;
    }
}
