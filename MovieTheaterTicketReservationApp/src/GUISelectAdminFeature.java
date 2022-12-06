import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUISelectAdminFeature {

    // frame for the main window
    private JFrame frame;
    // panel for the main window
    private JPanel mainPanel;

    // button titles

    // constructor to initialize GUI
    public GUISelectAdminFeature() {
        frame = new JFrame("Select Admin Features");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        // initialize main panel
        mainPanel = new JPanel(new GridLayout(1, 0, 10, 10));
        mainPanel.setBackground(new Color(49, 59, 114));
        // add buttons to the main panel
        JButton button1 = new JButton("Manage User");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIManageUser manageUserGUI = new GUIManageUser();
            }
        });

        JButton button2 = new JButton("Manage Movie");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIManageUser manageUserGUI = new GUIManageUser();
            }
        });

        mainPanel.add(button1);
        mainPanel.add(button2);
        // add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
