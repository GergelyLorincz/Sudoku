package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static javax.swing.GroupLayout.Alignment.*;


public class SudokuGUI extends JFrame{

    public static JMenuItem easy, medium, hard;
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
        }

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

        JButton erase = new JButton("Erase");
        JButton hint = new JButton("Hint");
        JButton restart = new JButton("Restart");

        newGame.setMinimumSize(new Dimension(225,30));

        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");

        one.setMinimumSize(new Dimension(60,60));
        two.setMinimumSize(new Dimension(60,60));
        three.setMinimumSize(new Dimension(60,60));
        four.setMinimumSize(new Dimension(60,60));
        five.setMinimumSize(new Dimension(60,60));
        six.setMinimumSize(new Dimension(60,60));
        seven.setMinimumSize(new Dimension(60,60));
        eight.setMinimumSize(new Dimension(60,60));
        nine.setMinimumSize(new Dimension(60,60));

        erase.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
        hint.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
        restart.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
        one.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
        two.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
        three.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
        four.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
        five.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
        six.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
        seven.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
        eight.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
        nine.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(grid)
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(erase)
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
                                                .addComponent(nine)))));

        layout.setVerticalGroup(
                layout.createParallelGroup(CENTER)
                        .addComponent(grid)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(erase)
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
                                                .addComponent(nine)))));

        pack();

        SetupAction setupAction = new SetupAction(fields);
        ManualInputAction manualInputAction = new ManualInputAction(num, fields);

        easy.addActionListener(setupAction);
        medium.addActionListener(setupAction);
        hard.addActionListener(setupAction);

        for (int i = 0; i < fields.length; i++) {
            fields[i].addKeyListener(manualInputAction);
            num++;
        }

    }

    private JTextField[] emptyFields() {
        JTextField[] resultArray = new JTextField[81];
        for (int i = 0; i < 81; i++) {
            JTextField jField = new JTextField("");
            jField.setDocument(new JTextFieldLimit(1));
            jField.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if ( ((c < '1') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume();
                    }
                }
            });
            resultArray[i] = jField;
        }
        return resultArray;
    }

    public JMenuItem getEasy() {return easy; }

    public JMenuItem getMedium() {return medium; }

    public JMenuItem getHard() {return hard; }
}
