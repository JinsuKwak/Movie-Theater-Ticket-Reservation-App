
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIPaymentpage extends JFrame {

	// Create components
	JLabel emailLabel, phoneLabel, cardNumberLabel, expirationLabel;
	JTextField emailText, phoneText, cardNumberText, expirationText;
	JButton payButton, confirmButton;
	String email, phone, cardNumber, expiration;

	public GUIPaymentpage() {
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

		confirmButton = new JButton("Confirm");
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email = emailText.getText();
				phone = phoneText.getText();
				cardNumber = cardNumberText.getText();
				expiration = expirationText.getText();
			}
		});

		// Set frame size and make visible
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new GUIPaymentpage();
	}

}