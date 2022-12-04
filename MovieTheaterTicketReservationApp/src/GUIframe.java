import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIframe {

    public static void main(String[] args) {

        // create a JFrame
        JFrame frame = new JFrame("Selection Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // create a login status label
        JLabel loginStatusLabel = new JLabel("Login status:");
        c.fill = GridBagConstraints.HORIZONTAL;
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
				GUIloginwindow login = new GUIloginwindow();				
				login.main(args);
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
				// TODO Auto-generated method stub
				GUISelectTheatreShow select = new GUISelectTheatreShow();
				
			}
		});
        c.gridx = 1;
        c.gridy = 1;
        panel.add(button2, c);
        JButton button3 = new JButton("Cancel Movie");
        button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GUICancelMovie cancel = new GUICancelMovie();
				cancel.main(args);
				
				
			}
		});
        c.gridx = 2;
        c.gridy = 1;
        panel.add(button3, c);

        // add JPanel to JFrame
        frame.add(panel);

        // set size of JFrame and make it visible
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}