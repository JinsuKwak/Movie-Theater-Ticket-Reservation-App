
public class MovieSummary {
    private int movieID;
    private String movieName;
    private java.util.Date openingDate;
    private double moviePrice;

    public MovieSummary(int movieID, String movieName, java.util.Date openingDate, double moviePrice){
        this.movieID = movieID;
        this.movieName = movieName;
        this.openingDate = openingDate;
        this.moviePrice = moviePrice;
    }

    public int getMovieID(){
        return this.movieID;
    }

    public String getMovieName(){
        return this.movieName;
    }

    public double getMoviePrice(){
        return this.moviePrice;
    }

    public java.util.Date getDate() {
        return this.openingDate;
    }
}
