import java.util.Date;

public class Movie 
{
    private int movieID; 
    private String movieName;
    private Date openingDate;
    private double moviePrice;
    private int theatreID;
    

    public Movie (int mvID, String mvName, double mvPrice, Date openDate){
        this.movieID = mvID;
        this.movieName = mvName;
        this.moviePrice = mvPrice;
        this.openingDate = openDate;
    }

	public int getMovieID() { 
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
