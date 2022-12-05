import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUISelectTheatreShow {
	
	//Load movie summary
	LoadMovie loadedmoviesum  = new LoadMovie();
	Theater showtheatre;
    // frame for the main window
    private JFrame frame;
    // panel for the main window
    private JPanel mainPanel;

    // button titles
    private String[] buttonTitles = {
        "Movie 1",
        "Movie 2",
        "Movie 3"
    };

    // constructor to initialize GUI
    public GUISelectTheatreShow() {
    	//initializes the movie list
    	loadedmoviesum.loadMovieSummaries();  	
        // initialize frame
        frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        // initialize main panel
        mainPanel = new JPanel(new GridLayout(3, 1));

        // add buttons to the main panel
        for (String title : buttonTitles) {
            JButton button = new JButton(title);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create new JFrame when button is clicked
                	
                	//Finds the showroom for the movie
                	for(int i = 0; i < loadedmoviesum.loadMovieSummaries().size(); i++)
                	{
                		if(loadedmoviesum.loadMovieSummaries().get(i).getMovieName().matches(button.getText()))
                		{
                			showtheatre = loadedmoviesum.selectMovie(loadedmoviesum.loadMovieSummaries().get(i).getMovieID());
                		}
                	}
                	
                	
       
                	GUIShowroom showroom = new GUIShowroom(showtheatre);
                	showroom.main(null);
                	
                    //GUIselectTheatreSeats select  = new GUIselectTheatreSeats(50);

                }
            });
            mainPanel.add(button);
        }

        // add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}