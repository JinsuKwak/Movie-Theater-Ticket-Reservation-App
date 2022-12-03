import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JToggleButton;

public class SelectTheatre extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Cancel");
	private final JButton btnNewButton_1 = new JButton("Confrim");
	JToggleButton[][] buttonGrid = new JToggleButton[5][10];
	Boolean[][] toggled = new Boolean[5][10];

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectTheatre frame = new SelectTheatre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectTheatre() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 10));
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(10, 168, 209, 92);
		//contentPane.add(btnNewButton);
		for(int x = 0; x < 5; x++)
		{
			for (int i = 0; i < 10; i++)
			{
				buttonGrid[x][i] = new JToggleButton(Integer.toString(i));
				contentPane.add(buttonGrid[x][i]);
			}
		}
		
		Color col = buttonGrid[0][0].getBackground();
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(217, 168, 216, 92);
		//contentPane.add(btnNewButton_1);
	}
}
