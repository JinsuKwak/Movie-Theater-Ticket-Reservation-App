import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIframe {

    public static void start() {

        // create a JFrame
        JFrame frame = new JFrame("Start Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JPanel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 59, 114));
        panel.setLayout(new GridLayout(7,1,6,5));
        GridBagConstraints c = new GridBagConstraints();

        // create a login status label
        JLabel loginStatusLabel = new JLabel("Login status:");
        loginStatusLabel.setForeground(new Color(255, 255, 255));
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(loginStatusLabel, c);

        // create a text field for displaying login status
        JTextField loginStatusField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        loginStatusField.setEnabled(false);
        panel.add(loginStatusField, c);
        // create three buttons
        JButton button1 = new JButton("Login");
        button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUILogin loginWindowGUI = new GUILogin();	
                loginWindowGUI.loginWindow();			
			}
		});
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(button1, c);
        JButton button2 = new JButton("Select Movie");
        button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUISelectMovie selectMovieGUI = new GUISelectMovie();
			}
		});
        c.gridx = 1;
        c.gridy = 1;
        panel.add(button2, c);
        JButton button3 = new JButton("Cancel Ticket");
        button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GUICancelTicket cancelTicektGUI = new GUICancelTicket();
			}
		});
        c.gridx = 2;
        c.gridy = 1;
        panel.add(button3, c);

        
        JButton button4 = new JButton("Register User");
        button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUIRegisterUser registerUserGUI = new GUIRegisterUser();
			}
		});
        c.gridx = 3;
        c.gridy = 1;
        panel.add(button4, c);
        
        // add JPanel to JFrame
        frame.add(panel);

        // set size of JFrame and make it visible
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}