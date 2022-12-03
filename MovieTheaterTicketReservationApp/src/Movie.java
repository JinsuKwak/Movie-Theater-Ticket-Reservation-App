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
<<<<<<< HEAD
		return movieID;
=======
		return this.movieID;
>>>>>>> f120c218babd3a3ca4039dc9839606bb95776af2
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
