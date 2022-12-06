
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUILogin extends JFrame {

	private JPanel contentPane;
	private final JTextField UsernameInput = new JTextField();
	private final JTextPane txtpnInputUsername = new JTextPane();
	private final JTextPane txtpnInputPassword = new JTextPane();
	private final JTextField PasswordInput = new JTextField();
	private LoginInstance loginInstance = LoginInstance.getInstance();
	private String username = "";
	private String tempusername = "";
	private String password = "";
	private String temppassword = "";
	private Login login;
	private JTextField InputedUsername;
	private JTextField InputedPassword;
	private GUILogin frame;

	/**
	 * Launch the application.
	 */
	public void loginWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUILogin();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUILogin() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		UsernameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				tempusername += e.getKeyChar();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					username = tempusername;
					tempusername = "";
					InputedUsername.setText(username);
					UsernameInput.setText("");
				}
			}
		});
		UsernameInput.setBounds(36, 66, 160, 20);
		UsernameInput.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		addWindowListener(new WindowAdapter() {
			
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(49, 59, 114));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		contentPane.add(UsernameInput);
		txtpnInputUsername.setBackground(new Color(49, 59, 114));
		txtpnInputUsername.setEditable(false);
		txtpnInputUsername.setForeground(new Color(255, 255, 255));
		txtpnInputUsername.setText("Input Username");
		txtpnInputUsername.setBounds(40, 46, 106, 20);
		
		contentPane.add(txtpnInputUsername);
		txtpnInputPassword.setBackground(new Color(49, 59, 114));
		txtpnInputPassword.setText("Input Password");
		txtpnInputPassword.setForeground(new Color(255, 255, 255));
		txtpnInputPassword.setEditable(false);
		txtpnInputPassword.setBounds(40, 97, 106, 20);
		
		contentPane.add(txtpnInputPassword);
		PasswordInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				temppassword += e.getKeyChar();

			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					password = temppassword;
					temppassword = "";
					InputedPassword.setText(password);
					PasswordInput.setText("");
				}
			}
		});
		PasswordInput.setColumns(10);
		PasswordInput.setBounds(36, 117, 160, 20);
		
		contentPane.add(PasswordInput);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					loginInstance.resetLoginStatus();
					username = username.trim();
					password = password.trim();
					if(username.contains("@")){
						login = new Login(username, password);
						login.validate();
						if(loginInstance.getIsLoggedIn()){
							if(loginInstance.getIsAdmin()){
								showMessageDialog(null, "Logged In Successfuly as Admin: "+
								loginInstance.getUser().getUserFname()+" "+loginInstance.getUser().getUserLname());
								username = "";
								tempusername= "";
								password = "";
								temppassword = "";
								PasswordInput.setText("");
								UsernameInput.setText("");
								InputedPassword.setText(username);
								InputedUsername.setText(password);
								GUISelectAdminFeature adminFeatureGUI = new GUISelectAdminFeature();
							} else {
								showMessageDialog(null, "Wellcome Back: "+
								loginInstance.getUser().getUserFname()+" "+loginInstance.getUser().getUserLname());
								username = "";
								tempusername= "";
								password = "";
								temppassword = "";
								PasswordInput.setText("");
								UsernameInput.setText("");
								InputedPassword.setText(username);
								InputedUsername.setText(password);
								GUISelectMovie selectMovieGUI = new GUISelectMovie();
							}
						} else {
							showMessageDialog(null, "Wrong Credentials. Please Try again");
							username = "";
							tempusername= "";
							password = "";
							temppassword = "";
							PasswordInput.setText("");
							UsernameInput.setText("");
							InputedPassword.setText(username);
							InputedUsername.setText(password);
						}
					} else {
						showMessageDialog(null, "E-mail Addresss must contain '@'");
						username = "";
						tempusername= "";
						password = "";
						temppassword = "";
						PasswordInput.setText("");
						UsernameInput.setText("");
						InputedPassword.setText(username);
						InputedUsername.setText(password);
					}
					username = "";
					tempusername= "";
					password = "";
					temppassword = "";
					PasswordInput.setText("");
					UsernameInput.setText("");
					InputedPassword.setText(username);
					InputedUsername.setText(password);
			}
		});
		btnNewButton.setBounds(170, 180, 96, 23);
		contentPane.add(btnNewButton);
		
		InputedUsername = new JTextField();
		InputedUsername.setEditable(false);
		InputedUsername.setBounds(310, 66, 96, 20);
		contentPane.add(InputedUsername);
		InputedUsername.setColumns(10);
		
		InputedPassword = new JTextField();
		InputedPassword.setEditable(false);
		InputedPassword.setBounds(310, 117, 96, 20);
		contentPane.add(InputedPassword);
		InputedPassword.setColumns(10);
		
		
		

	}
}
