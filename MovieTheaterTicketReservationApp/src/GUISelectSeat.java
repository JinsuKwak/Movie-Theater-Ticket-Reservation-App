import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

public class GUISelectSeat extends JFrame {
    private JPanel mainPanel;
    private JPanel seatPanel;
    private JButton confirmButton;
    private JLabel titleLabel;
    private List seatList;
    private int numSeats;
    static ShowTime showtime;

    public GUISelectSeat(ShowTime incomingshowtime) {
        super("Theatre Seats Selection");
        this.showtime = incomingshowtime;
        this.numSeats = incomingshowtime.getAllSeats().size();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the seatPanel and add it to the mainPanel
        seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(numSeats/5, 5));
        mainPanel.add(seatPanel, BorderLayout.CENTER);

        // Create the buttons and add them to the seatPanel
        for (int i = 0; i < numSeats; i++) {
            JButton seatButton = new JButton("Seat " + i);
            seatButton.addActionListener(new SeatButtonListener());
            seatPanel.add(seatButton);
        }

        // Create the title label and add it to the mainPanel
        titleLabel = new JLabel("Select Your Seats");
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create the confirm button and add it to the mainPanel
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ConfirmButtonListener());
        mainPanel.add(confirmButton, BorderLayout.SOUTH);

        // Create the seat list and add it to the mainPanel
        seatList = new List();
        mainPanel.add(seatList, BorderLayout.EAST);

        // Add the mainPanel to the frame
        this.add(mainPanel);

        // Set the frame size and make it visible
        setSize(500,500);
        setVisible(true);
    }

    class SeatButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (seatList.getItems().length > 0) {
            	int count = 1;
                for (String item : seatList.getItems()) {
                    if (item.equals(source.getText())) {
                        seatList.remove(item);
                        break;
                    } else if(count == seatList.getItemCount()){
                        seatList.add(source.getText());
                        count ++;
                        }
                    count ++;
                    
                }
            } else {
                seatList.add(source.getText());
            }
        }
    }

    class ConfirmButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "You have selected " + seatList.getItemCount() + " seats: " + Arrays.toString(seatList.getItems()));
            for(String item: seatList.getItems())
            {
            	for(int x = 0; x < numSeats; x++)
            	{
            		if(item.matches(Integer.toString(showtime.getAllSeats().get(x).getSeatNum())))
            		{
            			
            			//This is whereI got stuck. I can find the seat array however there are no ticket numbers or tickets associated with those seats.
            			
            		
            			
            			
            			
            			
            			
            			
            			
            			
            			
            			
            		}
            	}
            }
            
            
            GUIPayment pay = new GUIPayment();
        }
    }

    public static void main(String[] args) {
    	 
        new GUISelectSeat(showtime);
    }
}