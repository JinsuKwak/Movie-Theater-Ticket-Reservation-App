
import javax.swing.*;
import java.awt.*;

public class GUICancelMovie {

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
        JLabel passwordLabel = new JLabel("Password:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);
        JTextField passwordField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(passwordField, c);

        // create a list of available seats
        String[] availableSeats = {"A1", "A2", "A3", "B1", "B2", "B3"};
        JList<String> seatList = new JList<>(availableSeats);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(seatList, c);

        // create a select seat button
        JButton selectSeatButton = new JButton("Select Seat");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        panel.add(selectSeatButton, c);

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