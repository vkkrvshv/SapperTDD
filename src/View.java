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

    }

    public void update(Cell cell) {

    }

    public void gameOver() {

    }

    public void startGame() {

    }

    public void win()
    {

    }
}
