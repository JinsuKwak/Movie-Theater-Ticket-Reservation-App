import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.*;

public class GUISelectSeat extends JFrame {
    private JPanel mainPanel;
    private JPanel seatPanel;
    private JButton confirmButton;
    private JLabel titleLabel;
    private Ticket ticket;
    private List seatList;
    private ArrayList<Seat> seats;
    private ShowTime showtime;
    private LoginInstance loginInstance = LoginInstance.getInstance();
    private int numFCF = Integer.MAX_VALUE;

    public GUISelectSeat(Ticket ticket) {
        super("Theatre Seats Selection");
        this.ticket = ticket;
        this.showtime = ticket.getShowTime();
        this.seats = showtime.getAllSeats();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the seatPanel and add it to the mainPanel
        seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(seats.size()/5, 5));
        mainPanel.add(seatPanel, BorderLayout.CENTER);

        // Create the buttons and add them to the seatPanel
        for(Seat seat : seats){
            JButton seatButton = new JButton("Seat " + seat.getSeatNum());
            if(!seat.getAvailablity()){
                seatButton.setBackground(new Color(18,22,43));
                seatButton.setEnabled(false);
            }
            seatButton.addActionListener(new SeatButtonListener());
            seatPanel.add(seatButton);
        }

        if(loginInstance.getIsLoggedIn()){
            Date today = new Date();
            if(ticket.getMovie().getOpeningDate().compareTo(today) > 0){
                SelectSeatFCF fcf = new SelectSeatFCF(ticket);
                numFCF = fcf.possibleNumFCF();
            }
        }

        // Create the title label and add it to the mainPanel
        titleLabel = new JLabel("Select Your Seats");
        titleLabel.setForeground(new Color(255,255,255));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create the confirm button and add it to the mainPanel
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ConfirmButtonListener());
        mainPanel.add(confirmButton, BorderLayout.SOUTH);

        // Create the seat list and add it to the mainPanel
        seatList = new List();
        seatList.setBackground(new Color(30,36,72));
        seatList.setForeground(new Color(225,225,225));
        mainPanel.add(seatList, BorderLayout.EAST);
        mainPanel.setBackground(new Color(49, 59, 114));
        seatPanel.setBackground(new Color(49, 59, 114));
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
                if(seatList.getItems().length > numFCF){
                    seatList.remove(source.getText());
                    showMessageDialog(null, "Currently Remaining FCF Seats :"+numFCF+
                    "\nYour Last Item Will Be REMOVED");
                }  
            } else {
                seatList.add(source.getText());
                if(seatList.getItems().length > numFCF){
                    seatList.remove(source.getText());
                    showMessageDialog(null, "Currently FCF Seats are All full,\n"+
                    "Please Select Another ShowTime");
                }  
            }
        }
    }

    class ConfirmButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "You have selected " + seatList.getItemCount() + " seats: " + Arrays.toString(seatList.getItems()));
            ArrayList<Seat> ticketSeats = new ArrayList<Seat>();
            for(String item: seatList.getItems())
            {
            	for(int x = 0; x < seats.size(); x++)
            	{
            		if(item.matches("Seat "+Integer.toString(showtime.getAllSeats().get(x).getSeatNum())))
            		{	
            			ticketSeats.add(new Seat(x, true));
            		}
            	}
            }
            GUIPayment pay = new GUIPayment(ticket, ticketSeats);
        }
    }

}