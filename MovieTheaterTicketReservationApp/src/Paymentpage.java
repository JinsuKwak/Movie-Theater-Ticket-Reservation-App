//Import the necessary packages 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paymentpage extends JFrame {

    //Declare GUI components
    private JLabel lblPayment;
    private JLabel lblName;
    private JLabel lblCardType;
    private JLabel lblCardNumber;
    private JLabel lblExpiryDate;
    private JLabel lblCVV;
    private JTextField txtName;
    private JTextField txtCardNumber;
    private JTextField txtExpiryDate;
    private JTextField txtCVV;
    private JComboBox cmbCardType;
    private JButton btnSubmit;
 
    //Constructor
    public Paymentpage(int totalowed) {
        //Set the frame title
        super("Payment Page");
        
        //Set the layout
        setLayout(new FlowLayout());

        //Initialize the components
        lblPayment = new JLabel("Please fill in the details below to make a payment of a total of " + Integer.toString(totalowed) +"$:");
        lblName = new JLabel("Name:");
        lblCardType = new JLabel("Card Type:");
        lblCardNumber = new JLabel("Card Number:");
        lblExpiryDate = new JLabel("Expiry Date:");
        lblCVV = new JLabel("CVV:");
        txtName = new JTextField(20);
        txtCardNumber = new JTextField(20);
        txtExpiryDate = new JTextField(20);
        txtCVV = new JTextField(20);
        cmbCardType = new JComboBox();
        cmbCardType.addItem("Visa");
        cmbCardType.addItem("Mastercard");
        cmbCardType.addItem("American Express");
        btnSubmit = new JButton("Submit");
        
        //Add the components to the frame
        add(lblPayment);
        add(lblName);
        add(txtName);
        add(lblCardType);
        add(cmbCardType);
        add(lblCardNumber);
        add(txtCardNumber);
        add(lblExpiryDate);
        add(txtExpiryDate);
        add(lblCVV);
        add(txtCVV);
        add(btnSubmit);

        //Set the size and visibility of the frame
        setSize(500, 500);
        setVisible(true);
    }
    
}