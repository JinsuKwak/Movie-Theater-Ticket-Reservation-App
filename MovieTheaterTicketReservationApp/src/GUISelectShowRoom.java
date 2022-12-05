import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUISelectShowRoom {
	private Ticket ticket;

    // frame for the main window
    private JFrame frame;
    // panel for the main window
    private JPanel mainPanel;

    // button titles

    // constructor to initialize GUI
    public GUISelectShowRoom(Ticket ticket) {
    	//initializes the movie list
        ArrayList<ShowRoom> showRooms = ticket.getTheater().getShowRooms();  	
        // initialize frame
        frame = new JFrame("Select Movie");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        // initialize main panel
        mainPanel = new JPanel(new GridLayout(2, 5, 10, 10));
        mainPanel.setBackground(new Color(49, 59, 114));
        // add buttons to the main panel
        for (ShowRoom showRoom : showRooms) {
            JButton button = new JButton(((Integer)showRoom.getShowtRoomID()).toString());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create new JFrame when button is clicked
                    ticket.setShowRoom(showRoom);
                    // GUISelectTheater selectTheaterGUI = new GUISelectTheater(ticket);
                }
            });
            mainPanel.add(button);
        }

        // add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}