import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUISelectMovie {
	private Ticket ticket = new Ticket();
	//Load movie summary
	private LoadMovie loadMovie;
    // frame for the main window
    private JFrame frame;
    // panel for the main window
    private JPanel mainPanel;

    // button titles

    // constructor to initialize GUI
    public GUISelectMovie() {
    	//initializes the movie list
        loadMovie = new LoadMovie();
    	ArrayList<Movie> movieSummaries = loadMovie.loadMovieSummaries();  	
        // initialize frame
        frame = new JFrame("Select Movie");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);

        // initialize main panel
        mainPanel = new JPanel(new GridLayout(0, 1, 0, 4));
        mainPanel.setBackground(new Color(49, 59, 114));
        // add buttons to the main panel
        for (Movie movieSummary : movieSummaries) {
            JButton button = new JButton(movieSummary.getMovieName());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create new JFrame when button is clicked
                    Theater theater = loadMovie.selectMovie(movieSummary.getMovieID());
                    Movie movie = movieSummary;
                    ticket.setTheater(theater);
                    ticket.setMovie(movieSummary);
                    GUISelectShowRoom selectShowRoomGUI = new GUISelectShowRoom(ticket);
                }
            });
            mainPanel.add(button);
        }

        // add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}