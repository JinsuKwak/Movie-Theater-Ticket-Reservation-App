import java.util.ArrayList;

public class Theater {
    private int theaterID;
    private String theaterName;
    private String theaterLocation;
    private ArrayList<Movie> availableMovies;
    private ArrayList<ShowRoom> showRooms;

    public Theater(int thrID, String thrName, String thrLoc, ArrayList<Movie> movies, ArrayList<ShowRoom> showRooms){
        this.theaterID = thrID;
        this.theaterName = thrName;
        this.theaterLocation = thrLoc;
        this.availableMovies = movies;
        this.showRooms = showRooms;
    }

	public int getTheaterID() {
		return this.theaterID;
	}

	public String getTheaterName() {
		return this.theaterName;
	}

	public String getTheaterLocation() {
		return this.theaterLocation;
	}

    public ArrayList<Movie> getAvailableMovies() {
        return this.availableMovies;
    }

	public ArrayList<ShowRoom> getShowRooms() {
		return this.showRooms;
	}

}
