import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadMovie extends SQLController {
    private LoginInstance loginInstance;
    private ArrayList<Theater> theatre;
    private ResultSet movies;

    public LoadMovie(){
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        this.loginInstance = LoginInstance.getInstance();
    }
    
    public void loadMovies(){
        try{
        initializeConnection();
            String query = "SELECT * FROM Movie ";
            PreparedStatement pStatement = dbConnection.prepareStatement(query);
            ResultSet loadedMovies = pStatement.executeQuery();

            if(!loadedMovies.isBeforeFirst()){
               
            } 

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}

class MovieSummary {
    private int movieID;
    private String
}
