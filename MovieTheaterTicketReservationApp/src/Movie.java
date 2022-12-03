import java.util.Date;

public class Movie 
{
    private static int movieID; //changed this to static
    private String movieName;
    private double moviePrice;
    private Date openingDate;

    public Movie (int mvID, String mvName, double mvPrice, Date openDate){
        this.movieID = mvID;
        this.movieName = mvName;
        this.moviePrice = mvPrice;
        this.openingDate = openDate;
    }

	public static int getMovieID() { //changed this to static as well
		return movieID;
	}

	public String getMovieName() {
		return this.movieName;
	}

    public double getMoviePrice() {
		return this.moviePrice;
	}

	public Date getOpeningDate() {
		return this.openingDate;
    }

}
