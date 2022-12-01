//control class
//maarya
import java.sql.*;


public class ManageMovie 
{

    private String TABLE_NAME = "Movie";
    private Connection dbConnect;
    private ResultSet results;

    LoginInstance loginInstance;
    int deleteMovieID;

    public ManageMovie(){
        this.loginInstance = LoginInstance.getInstance();
    }

    
    public void addMovie(int mvID, String mvName, String openDate, int theID, int showRoomID, int showTimeID, String shownAt){
        // SQL 
        // add movie to 
        // theaterid is fixed
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
