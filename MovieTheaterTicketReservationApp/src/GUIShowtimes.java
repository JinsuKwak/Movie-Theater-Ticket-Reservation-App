import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
 
public class GUIShowtimes {
 
	String[] stringtimes = new String[0];
	ArrayList<ShowTime> showtime;
    // Create an array of times
	public GUIShowtimes(ShowRoom showroomwithtime) {
		showtime = showroomwithtime.getShowTimes();
		stringtimes = new String[showroomwithtime.getShowTimes().size()];
		for(int i = 0; i < stringtimes.length;i++)
		{
			stringtimes[i] = showroomwithtime.getShowTimes().get(i).getShownAt();
		}
		
	}
 
    // Create the list
    private JList<String> list = new JList<>(stringtimes);
 
    // Create a panel
    private JPanel panel = new JPanel();
 
    public GUIShowtimes() {
        // Set the layout for the panel
        panel.setLayout(new FlowLayout());
 
        // Add the list to the panel
        panel.add(list);
 
        // Create the frame and add the panel
        JFrame frame = new JFrame("GUI");
        frame.add(panel);
 
        // Set the size of the frame and make it visible
        frame.setSize(200, 200);
        frame.setVisible(true);
 
        // Add an action listener to the list
        list.addListSelectionListener(e -> {
            // Get the selected times
        	showtime.get(list.getSelectedIndex());
        });
    }
 
    public static void main(String[] args) {
        new GUIShowtimes();
    }
 
}