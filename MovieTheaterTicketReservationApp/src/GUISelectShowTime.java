import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUISelectShowTime {
	private Ticket ticket;

    // frame for the main window
    private JFrame frame;
    // panel for the main window
    private JPanel mainPanel;

    // button titles

    // constructor to initialize GUI
    public GUISelectShowTime(Ticket ticket) {
    	//initializes the movie list
        ArrayList<ShowTime> showTimes = ticket.getShowRoom().getShowTimes();  	
        // initialize frame
        frame = new JFrame("Select Movie");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        // initialize main panel
        mainPanel = new JPanel(new GridLayout(1, 0, 10, 10));
        mainPanel.setBackground(new Color(49, 59, 114));
        // add buttons to the main panel
        for (ShowTime showTime : showTimes) {
            JButton button = new JButton((showTime.getShownAt()));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create new JFrame when button is clicked
                    ticket.setShowTime(showTime);
                    GUISelectSeat selectSeatGUI = new GUISelectSeat(ticket);
                }
            });
            mainPanel.add(button);
        }

        // add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}