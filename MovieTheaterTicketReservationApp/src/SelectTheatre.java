import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectTheatre {
    // Variables
    private static ArrayList<JButton> buttons = new ArrayList<>();
    private static ArrayList<JButton> clickedButtons = new ArrayList<>();
    private static Color originalColor = Color.WHITE;
    private static Color newColor = Color.RED;

    // Main Method
    public void createpage() {
        // Create Frame
        JFrame frame = new JFrame("Button Grid");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 5));

        // Create Buttons
        for (int i = 0; i < 50; i++) {
            JButton button = new JButton("Button " + (i + 1));
            button.setBackground(originalColor);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    if (button.getBackground() == originalColor) {
                        button.setBackground(newColor);
                        clickedButtons.add(button);
                    } else {
                        button.setBackground(originalColor);
                        clickedButtons.remove(button);
                    }
                }
            });
            panel.add(button);
            buttons.add(button);
        }

        // Add Panel to Frame
        frame.add(panel);
        frame.setVisible(true);

        // Create Confirm/Deny Frame
        JFrame confirmFrame = new JFrame("Confirm/Deny");
        confirmFrame.setSize(300, 200);
        confirmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Confirm/Deny Panel
        JPanel confirmPanel = new JPanel();
        confirmPanel.setLayout(new GridLayout(1, 2));

        // Create Confirm/Deny Buttons
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buttons clicked: ");
                for (JButton button : clickedButtons) {
                    System.out.println(button.getText());
                }
            }
        });
        JButton denyButton = new JButton("Deny");
        denyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton button : clickedButtons) {
                    button.setBackground(originalColor);
                }
                clickedButtons.clear();
            }
        });
        confirmPanel.add(confirmButton);
        confirmPanel.add(denyButton);

        // Add Confirm/Deny Panel to Frame
        confirmFrame.add(confirmPanel);
        confirmFrame.setVisible(true);
    }
}