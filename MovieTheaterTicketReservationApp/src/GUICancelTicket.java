
import javax.swing.*;
import java.awt.*;

public class GUICancelTicket {

    public static void main(String[] args) {

        // create a JFrame
        JFrame frame = new JFrame("Cancel Movie Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // create a label and text field for entering email address
        JLabel emailLabel = new JLabel("Email Address:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(emailLabel, c);
        JTextField emailField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(emailField, c);

        // create a label and text field for entering password
        JLabel passwordLabel = new JLabel("Ticket ID:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);
        JTextField passwordField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(passwordField, c);

        // create a cancel movie button
        JButton cancelMovieButton = new JButton("Cancel Movie");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        panel.add(cancelMovieButton, c);

        // add JPanel to JFrame
        frame.add(panel);

        // set size of JFrame and make it visible
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}