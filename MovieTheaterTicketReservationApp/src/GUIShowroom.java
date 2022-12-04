import java.awt.*;
import javax.swing.*;
 
public class GUIShowroom {
 
	JButton[] buttons = new JButton[0];
	Theater tobearray = null;
    // Create an array of buttons
	public GUIShowroom(Theater tobearray)
	{
		this.tobearray = tobearray;
		buttons = new JButton[tobearray.getShowRooms().size()];
	}
 
    // Create a panel
    private JPanel panel = new JPanel();
 
    public GUIShowroom() {
        // Set the layout for the panel
        panel.setLayout(new GridLayout(3, 1));
 
        // Add the buttons to the panel
        for (int i = 0; i < buttons.length; i++) {
        	buttons[i].setText(Integer.toString(tobearray.getShowRooms().get(i).getShowtRoomID()));
            panel.add(buttons[i]);
        }
 
        // Create the frame and add the panel
        JFrame frame = new JFrame("GUI");
        frame.add(panel);
 
        // Set the size of the frame and make it visible
        frame.setSize(200, 200);
        frame.setVisible(true);
 
        // Add an action listener to each button
        for (int i = 0; i < buttons.length; i++) {
            final int buttonIndex = i;
            buttons[buttonIndex].addActionListener(e -> {
                for (int x = 0; x < buttons.length; x++)
                {
                	if(Integer.parseInt(buttons[x].getText()) == tobearray.getShowRooms().get(x).getShowtRoomID())
                	{
                		
                		GUIShowtimes showtime = new GUIShowtimes(tobearray.getShowRooms().get(x));
                		showtime.main(null);
                	}
                }
            });
        }
    }
 
    public static void main(String[] args) {
        new GUIShowroom();
    }
 
}