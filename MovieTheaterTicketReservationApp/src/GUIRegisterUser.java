import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIRegisterUser {

    public static void main(String[] args) {

        // create a JFrame
        JFrame frame = new JFrame("Sign Up Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // create a label and text field for entering username
        JLabel usernameLabel = new JLabel("Email:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(usernameLabel, c);
        JTextField usernameField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(usernameField, c);

        // create a label and text field for entering password
        JLabel passwordLabel = new JLabel("Password:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);
        JTextField passwordField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(passwordField, c);
        
        
        // create a label and text field for entering First Name
        JLabel firstname = new JLabel("First Name:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(firstname, c);
        JTextField firstnamefield = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(firstnamefield, c);

        // create a label and text field for entering Last Name
        JLabel lastname = new JLabel("First Name:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(lastname, c);
        JTextField lastnamefield = new JTextField(20);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(lastnamefield, c);

        // create a label and text field for entering credit card info
        JLabel cardLabel = new JLabel("Credit Card Info:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        panel.add(cardLabel, c);
        JTextField cardField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(cardField, c);

        // create a sign up button
        JButton signUpButton = new JButton("Sign Up");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        panel.add(signUpButton, c);

        // add JPanel to JFrame
        frame.add(panel);

        // set size of JFrame and make it visible
        frame.setSize(400, 400);
        frame.setVisible(true);
        signUpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Register user1 = new Register(usernameField.getText(), passwordField.getText(), firstnamefield.getText(), lastnamefield.getText(), cardField.getText());
			}
		});
    }
}