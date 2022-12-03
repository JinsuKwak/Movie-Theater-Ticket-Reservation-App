import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectTheatreShow {
    // frame for the main window
    private JFrame frame;
    // panel for the main window
    private JPanel mainPanel;

    // button titles
    private String[] buttonTitles = {
        "Movie 1",
        "Movie 2",
        "Movie 3"
    };

    // constructor to initialize GUI
    public SelectTheatreShow() {
        // initialize frame
        frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        // initialize main panel
        mainPanel = new JPanel(new GridLayout(3, 1));

        // add buttons to the main panel
        for (String title : buttonTitles) {
            JButton button = new JButton(title);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create new JFrame when button is clicked
                    SelectTheatre select  = new SelectTheatre(50);

                }
            });
            mainPanel.add(button);
        }

        // add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}