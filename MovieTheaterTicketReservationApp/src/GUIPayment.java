
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUIPayment extends JFrame {
	Ticket ticket;
	ArrayList<Seat> ticketSeats;
	double totalPrice;
	LoginInstance loginInstance = LoginInstance.getInstance();
	// Create components
	JLabel emailLabel, phoneLabel, cardNumberLabel, expirationLabel;
	JTextField emailText, phoneText, cardNumberText, expirationText;
	JButton payButton, confirmButton;
	String email, phone, cardNumber, expiration;

	public GUIPayment(Ticket ticket, ArrayList<Seat> ticketSeats) {
		// Set frame title
		super("Credit Card Payment");

		// Set layout
		setLayout(new GridLayout(6, 2));

		// Create and add components
		emailLabel = new JLabel("Email");
		add(emailLabel);

		emailText = new JTextField(20);
		add(emailText);

		phoneLabel = new JLabel("Phone Number");
		add(phoneLabel);

		phoneText = new JTextField(20);
		add(phoneText);

		cardNumberLabel = new JLabel("Credit Card Number");
		add(cardNumberLabel);

		cardNumberText = new JTextField(20);
		add(cardNumberText);

		expirationLabel = new JLabel("Expiration Date");
		add(expirationLabel);

		expirationText = new JTextField(20);
		add(expirationText);

		//payButton = new JButton("Pay Now");
		//add(payButton);

		this.ticket = ticket;
		this.ticketSeats = ticketSeats;
		totalPrice = ticket.getMovie().getMoviePrice()*ticketSeats.size();
		System.out.println("Per Seats: "+ticket.getMovie().getMoviePrice());
		System.out.println("Total Price: "+totalPrice);
		for(Seat seat: ticketSeats){
			System.out.println(seat.getSeatNum());
		}
		if(loginInstance.getIsLoggedIn()){
			emailText.setText(loginInstance.getUser().getUserEmail());
			cardNumberText.setText(loginInstance.getUser().getcardNumber());
		}

		confirmButton = new JButton("Confirm");
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email = emailText.getText();
				phone = phoneText.getText();
				cardNumber = cardNumberText.getText();
				expiration = expirationText.getText();
				email = email.trim();
				ticket.setUserEmail(email);
				Payment payment = new Payment(ticket,ticketSeats);
				payment.createTickets();
				payment.updateSeat();
				payment.sendEmail(); 
			}
		});

		// Set frame size and make visible
		pack();
		setVisible(true);
	}

}