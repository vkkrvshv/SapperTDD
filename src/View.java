import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Panel extends JPanel
{
}

public class View extends JFrame implements ActionListener {
    Cell[][] cells = new Cell[Model.FIELD_SIZE][Model.FIELD_SIZE];
    JButton[][] buttons = new JButton[Model.FIELD_SIZE][Model.FIELD_SIZE];

    GridLayout grid = new GridLayout(Model.FIELD_SIZE, Model.FIELD_SIZE);

    View(Model model) {
        setTitle("Сапёр");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);

        setResizable(true);

        Panel panel = new Panel();
        panel.setBackground(Color.white);
        add(BorderLayout.CENTER, panel);
        panel.setLayout(grid);

        for (int j = 0; j < Model.FIELD_SIZE; j++) {
            for (int i = 0; i < Model.FIELD_SIZE; i++) {
                buttons[i][j] = new JButton();
                cells[i][j] = new Cell(j, i);
                buttons[i][j].addActionListener(this);
                panel.add(buttons[i][j]);
            }
        }

        JMenuBar jmb = new JMenuBar();
        JButton buttonNewGame = new JButton("Новая игра");
        buttonNewGame.addActionListener(this);
        jmb.add(buttonNewGame);
        this.setJMenuBar(jmb);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.getJMenuBar().getComponent(0))) {

        }
        for (int j = 0; j < buttons[0].length; j++) {
            for (int i = 0; i < buttons.length; i++) {
                if (e.getSource().equals(buttons[i][j])) {
                    try {

                    }
                    catch (NullPointerException n) {
                        JOptionPane.showMessageDialog(this, "Игра не запущена");
                    }

                    if (cells[i][j].mined) {
                        buttons[i][j].setForeground(Color.red);
                        buttons[i][j].setText("*");
                    }
                    else buttons[i][j].setText(cells[i][j].counter + "");
                    buttons[i][j].setEnabled(false);
                }
            }
        }
    }

    public void update(Cell cell) {
        cells[cell.column][cell.row] = cell;

    }

    public void gameOver() {
        this.setTitle("Игра окончена");
        for (int j = 0; j < buttons.length; j++) {
            for (int i = 0; i < buttons[0].length; i++) {
                if (cells[i][j].mined) {
                    buttons[i][j].setBackground(Color.red);
                    buttons[i][j].setText("*");
                }
                buttons[i][j].setEnabled(false);
            }
        }
        JOptionPane.showMessageDialog(this, "Игра окончена");
    }

    public void startGame() {
        this.setTitle("Игра идёт");
        for (int j = 0; j < buttons.length; j++) {
            for (int i = 0; i < buttons[0].length; i++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setText("");
                buttons[i][j].setBackground((new JButton()).getBackground());
                buttons[i][j].setDisabledIcon((new JButton()).getDisabledIcon());
            }
        }
    }

    public void win()
    {
        this.setTitle("Победа!");
        for (int j = 0; j < buttons.length; j++) {
            for (int i = 0; i < buttons[0].length; i++) {
                buttons[i][j].setEnabled(false);
                if(cells[i][j].mined)
                {
                    buttons[i][j].setText("*");
                    buttons[i][j].setBackground(Color.green);
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Победа!");
    }
}
