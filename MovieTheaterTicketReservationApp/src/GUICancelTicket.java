
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class GUICancelTicket {

    public GUICancelTicket() {
        // create a JFrame
        JFrame frame = new JFrame("Cancel Ticket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a JPanel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 59, 114));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // create a label and text field for entering email address
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setForeground(new Color(255,255,255));
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
        passwordLabel.setForeground(new Color(255,255,255));
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

        cancelMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if((passwordField.getText().length()!= 0) && (emailField.getText().length() != 0)){
                    String email = emailField.getText().trim();
                    String ticketID = passwordField.getText().trim();
                    CancelTicket cancelTicket = new CancelTicket(ticketID, email);
                    if(cancelTicket.verifyTicket()) {
                        cancelTicket.deleteTicket();
                        cancelTicket.updateSeat();
                        cancelTicket.sendEmail();
                        showMessageDialog(null, "Your Ticket is Cancelled, Check your E mail for Credit");
                    } else {
                        passwordField.setText("");
                        emailField.setText("");
                        showMessageDialog(null, "Invalid Ticket/E-mail please Try again");
                    }
            } else {
                passwordField.setText("");
                emailField.setText("");
                showMessageDialog(null, "Please fill all the Input Fields");
            }
        }
        });
        
    }
}