import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class GUIManageUser {
    private boolean isStaff = false;
    public GUIManageUser () {

        // create a JFrame
        JFrame frame = new JFrame("Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(49, 59, 114));
        GridBagConstraints c = new GridBagConstraints();

        // create a label and text field for entering username
        JLabel usernameLabel = new JLabel("Email:");
        usernameLabel.setForeground(new Color(225,225,225));
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
        passwordLabel.setForeground(new Color(225,225,225));
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
        firstname.setForeground(new Color(225,225,225));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(firstname, c);
        JTextField firstnamefield = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(firstnamefield, c);

        // create a label and text field for entering Last Name
        JLabel lastname = new JLabel("Last Name:");
        lastname.setForeground(new Color(225,225,225));
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
        cardLabel.setForeground(new Color(225,225,225));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        panel.add(cardLabel, c);
        JTextField cardField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(cardField, c);

        // create a label and text field for entering password
        JLabel deleteUserLabel = new JLabel("Enter User E-mail to Delete:");
        deleteUserLabel.setForeground(new Color(225,225,225));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        panel.add(deleteUserLabel, c);
        JTextField deleteUserEmailField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 7;
        panel.add(deleteUserEmailField, c);

        // create a sign up button
        JButton signUpButton = new JButton("Add User");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        panel.add(signUpButton, c);
        
        // add JPanel to JFrame
        frame.add(panel);

        // set size of JFrame and make it visible
        frame.setSize(600, 400);
        frame.setVisible(true);
        signUpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

                if(usernameField.getText().contains("@")){
                    if(cardField.getText().length() == 6){
                        if((firstnamefield.getText().length() != 0) && (lastnamefield.getText().length() != 0 ) &&(passwordField.getText().length() != 0)){
                            Register user = new Register(usernameField.getText(), passwordField.getText(), firstnamefield.getText(), lastnamefield.getText(), cardField.getText());
                            if(user.isUniqueEmail()){
                                ManageUser manageUser = new ManageUser(); 
                                manageUser.addUser(user, isStaff);
                                showMessageDialog(null, "Register Successful\n"+
                            "New User has been added");
                            } else {
                                showMessageDialog(null, "The E-Mail currently in Use\n"+
                                "Please input another E-mail Address");
                                usernameField.setText("");
                            }
                        } else {
                            showMessageDialog(null, "Please fill all the Input Fields");
                        }
                    } else {
                        showMessageDialog(null, "Card Number must be 6 digit Integer");
						cardField.setText("");
                    }
                } else {
                    showMessageDialog(null, "E-mail Addresss must contain '@'");
                    usernameField.setText("");
                }
			}
		});

        JButton setStaffButton = new JButton("Set User as Staff (toggle)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        panel.add(setStaffButton, c);

        setStaffButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                if(isStaff == false){
                    isStaff = true;
                } else {
                    isStaff = false;
                }
            }
        });

        // create a sign up button
        JButton deleteUserButton = new JButton("Delete User");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        panel.add(deleteUserButton, c);
        deleteUserButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                if(deleteUserEmailField.getText().length() != 0){
                    if(deleteUserEmailField.getText().contains("@")){
                        String uEmail = deleteUserEmailField.getText().trim();
                        ManageUser manageUser = new ManageUser(); 
                        try{
                            manageUser.deleteUser(uEmail);
                        } catch (Exception e1){
                            e1.printStackTrace();
                            showMessageDialog(null, "User not exist, please enter an exisiting User"); 
                            deleteUserEmailField.setText("");
                        }
                    } else {
                        showMessageDialog(null, "E-mail Addresss must contain '@'");
                        deleteUserEmailField.setText("");
                    }
                } else {
                    showMessageDialog(null, "This field cannot be blank");
            }
            }
        });
    }
}
