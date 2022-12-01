//control class
//maarya
import java.sql.*;


public class ManageMovie 
{

    /**
     * setting the url, username, password and table name to a final value, hard coded it into the fil
     */
    private final String DBURL = "jdbc:mysql://localhost/movie_theatres";
    private final String USERNAME = "ensf480";
    private final String PASSWORD = "ensf480";
    private final String TABLE_NAME = "Movie";
    private Connection dbConnect;
    private ResultSet results;


    LoginInstance loginInstance;
    int deleteMovieID;

    public ManageMovie(){
        this.loginInstance = LoginInstance.getInstance();
    }

    public void addMovie(int mvID, String mvName, String openDate, int thrID, int ShowromID, int showTimeID, String shownAt){
        // SQL 
        // add movie to 
        // theater
        // showroom
        // generate showTime with assigned time and
        // generate seats and reset to all avaliable based on showroom.totalSeatNum
    }

    public void removeMovie(int movieID){
        this.deleteMovieID = movieID;
        if(loginInstance.getIsAdmin()){  // only executable when already logged as admin
            //SQL
            // delete if Movie.movieID == deletedMovieID 
        }
    }
}
