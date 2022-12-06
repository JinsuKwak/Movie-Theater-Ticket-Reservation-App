/**
 * maarya, jinsu, nour, neil
 * ENSF 480 Project
 * ManageMovie.java
 * 
 */

import java.sql.*;
import java.sql.PreparedStatement;

public class ManageMovie  extends SQLController //uses the SQL controller file to get username, and password for connection to jar file
{
    //variables
    private final String TABLE_NAME = "Movie";
    private Connection dbConnect;
    private ResultSet results;

    LoginInstance loginInstance;
    int deleteMovieID;

    //constructor
    /**
     * constructor
     */
    public ManageMovie(){
        super("jdbc:mysql://localhost/movie_theatres","ensf480","ensf480");
        this.loginInstance = LoginInstance.getInstance();
        initializeDriver();
    }


    //adding a movie with parameters so we can insert that movie in to the movie table in the database
    /**
     * 
     * @param mvID
     * @param mvName
     * @param openDate
     * @param moviePrice
     * @param theID
     * @param showRoomID
     * @param showTimeID
     * @param shownAt
     */
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
            //here we need to insert data into the showtime table in our database
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
        //to insert into showroom
        try{
            //inserting into showroom with data passed 
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

    /**
     * removeMovie from database
     * @param movieID
     */
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
    /**
     * 
     * @return
     */
    public String getTableName() {
        return TABLE_NAME;
    }
    /**
     * 
     * @return
     */
    public Connection getDbConnect() {
        return dbConnect;
    }
/**
 * 
 * @return
 */
    public ResultSet getResults() {
        return results;
    }
}