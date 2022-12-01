
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class loginwindow extends JFrame {

	private JPanel contentPane;
	private final JTextField UsernameInput = new JTextField();
	private final JTextPane txtpnInputUsername = new JTextPane();
	private final JTextPane txtpnInputPassword = new JTextPane();
	private final JTextField PasswordInput = new JTextField();
	String username = "";
	String tempusername = "";
	String password = "";
	String temppassword = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginwindow frame = new loginwindow();
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
	public loginwindow() {
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
					System.out.print(username);
					UsernameInput.setText("");
				}
			}
		});
		UsernameInput.setBounds(36, 66, 65, 20);
		UsernameInput.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		addWindowListener(new WindowAdapter() {
			
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		
				setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		contentPane.add(UsernameInput);
		txtpnInputUsername.setBackground(new Color(192, 192, 192));
		txtpnInputUsername.setEditable(false);
		txtpnInputUsername.setText("Input Username");
		txtpnInputUsername.setBounds(26, 35, 106, 20);
		
		contentPane.add(txtpnInputUsername);
		txtpnInputPassword.setBackground(new Color(192, 192, 192));
		txtpnInputPassword.setText("Input Password");
		txtpnInputPassword.setEditable(false);
		txtpnInputPassword.setBounds(26, 97, 106, 20);
		
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
					System.out.print(password);
					PasswordInput.setText("");
				}
			}
		});
		PasswordInput.setColumns(10);
		PasswordInput.setBounds(36, 117, 65, 20);
		
		contentPane.add(PasswordInput);
		

	}
}
