//control class
//maarya
import java.sql.*;
import java.sql.PreparedStatement;

public class ManageMovie  extends SQLController
{
    private final String TABLE_NAME = "Movie";
    private Connection dbConnect;
    private ResultSet results;

    LoginInstance loginInstance;
    int deleteMovieID;

    public ManageMovie(){
        super("jdbc:mysql://localhost/movie_theatres","ensf480","ensf480");
        this.loginInstance = LoginInstance.getInstance();
        initializeDriver();
    }


    public void addMovie(int mvID, String mvName, String openDate, double moviePrice, int theID, int showRoomID, int showTimeID, String shownAt)
    {
        //to insert into movie
        initializeConnection();
        try{
            String query = "INSERT INTO Movie (movieID, movieName, openingDate, moviePrice,theatreID) VALUES (?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
            myStmt.setLong(1, mvID);
            myStmt.setString(2, mvName);
            myStmt.setString(3, openDate);
            myStmt.setLong(2, (long) moviePrice);
            myStmt.setLong(3, theID);
            
            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            
            myStmt.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        //to insert into showtime 
        try{
            String query2 = "INSERT INTO ShowTime (showTimeID, shownAt) VALUES (?,?)"; //for inserting into 
    
            PreparedStatement myStmt = dbConnect.prepareStatement(query2);
            
            myStmt.setLong(1, showTimeID);
            myStmt.setString(2, shownAt);
            //myStmt.setString(2, NULL);
            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            
            myStmt.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        //to insert into showtime 
        try{
            String query3 = "INSERT INTO ShowRoom (showRoomID,) VALUES (?)"; //for inserting into showroom
    
            PreparedStatement myStmt = dbConnect.prepareStatement(query3);
            
            myStmt.setLong(1, showRoomID);
            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            
            myStmt.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        // SQL 
        // add movie to 
        // theaterid is fixed
        // showroom
        // generate showTime with assigned time and
        // generate seats and reset to all avaliable based on showroom.totalSeatNum
        disconnectConnection();
    }

    public void removeMovie(int movieID)
    {
        initializeConnection();
        this.deleteMovieID = movieID;
        if(loginInstance.getIsAdmin())// only executable when already logged as admin
        {  
                try{
                    String query = "DELETE FROM movie_theatres WHERE movieID = " + movieID;

                    PreparedStatement preparedStatement = dbConnect.prepareStatement(query);
                    preparedStatement.executeUpdate(query);
                    preparedStatement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
        }
        disconnectConnection();

    }

    public String getTableName() {
        return TABLE_NAME;
    }

    public Connection getDbConnect() {
        return dbConnect;
    }

    public ResultSet getResults() {
        return results;
    }
}