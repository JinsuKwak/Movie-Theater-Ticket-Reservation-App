import java.util.Date;

public class Movie 
{
    private int movieID; 
    private String movieName;
    private Date openingDate;
    private double moviePrice;
    private int theatreID;
    

    public Movie (int mvID, String mvName, Date openDate, double mvPrice, int theaID)
    {
        this.movieID = mvID;
        this.movieName = mvName;
        this.openingDate = openDate;
        this.moviePrice = mvPrice;
        this.theatreID = theaID;
    }

	public int getMovieID() { 
		return this.movieID;
	}

	public String getMovieName() {
		return this.movieName;
	}

    public Date getOpeningDate() {
		return this.openingDate;
    }

    public double getMoviePrice() {
		return this.moviePrice;
	}

    public int getTheatreID()
    {
        return this.theatreID;
    }

	

}
