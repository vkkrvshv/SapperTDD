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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
