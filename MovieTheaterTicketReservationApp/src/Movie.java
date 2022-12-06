/**
 * maarya, jinsu, nour, neil
 * ENSF 480 Project
 * Movie.java
 * 
 */
import java.util.Date;

public class Movie 
{
    //class variables
    private int movieID; 
    private String movieName;
    private Date openingDate;
    private double moviePrice;
    private int theatreID;
    
    /**
     * 
     * @param mvID
     * @param mvName
     * @param openDate
     * @param mvPrice
     * @param theaID
     */
    public Movie (int mvID, String mvName, Date openDate, double mvPrice, int theaID)
    {
        this.movieID = mvID;
        this.movieName = mvName;
        this.openingDate = openDate;
        this.moviePrice = mvPrice;
        this.theatreID = theaID;
    }
    /**
     * 
     * @return
     */
	public int getMovieID() { 
		return this.movieID;
	}
    /**
     * 
     * @return
     */
	public String getMovieName() {
		return this.movieName;
	}
    /**
     * 
     * @return
     */
    public Date getOpeningDate() {
		return this.openingDate;
    }
    /**
     * 
     * @return
     */
    public double getMoviePrice() {
		return this.moviePrice;
	}
    /**
     * 
     * @return
     */
    public int getTheatreID()
    {
        return this.theatreID;
    }

	

}
