//control class
//maarya
import java.sql.*;
import java.sql.PreparedStatement;

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
        initializeDriver();
        initializeConnection();
    }

    /**
     * initializing the driver or throws the exception if driver is not found
     */
    public void initializeDriver() {
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println ("Driver not found! Check output console");
            e.printStackTrace ();
        }
    }

    /**
     * initializing the connection and throwing exception if failed
     */
    public void initializeConnection() {
        try {
            dbConnect = DriverManager.getConnection (DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println ("Connection Failed! Check output console");
            e.printStackTrace ();
        }
    }

    /**
     * disconnecting the connection 
     */
    public void disconnectConnection() {
        try {
            dbConnect.close ();
        } catch (SQLException e) {
            System.out.println ("Disconnection Failed! Check output console");
            e.printStackTrace();
        }
    }


    public void addMovie(int mvID, String mvName, String openDate, double moviePrice, int theID, int showRoomID, int showTimeID, String shownAt)
    {
        //to insert into movie
        try{
            String query = "INSERT INTO Movie (movieID, movieName, openingDate, moviePrice,theatreID) VALUES (?,?,?,?,?)"; //for inserting into 
            // String query = "INSERT INTO cats (name, owner, birth) VALUES (?,?,?)";
            //PreparedStatement myStmt = dbConnect.prepareStatement(query);
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
    }

    public void removeMovie(int movieID)
    {
        this.deleteMovieID = movieID;
        if(loginInstance.getIsAdmin())// only executable when already logged as admin
        {  
            // if(Movie.getMovieID() == movieID)
            // {
                try{
                    String query = "DELETE FROM movie_theatres WHERE movieID = " + movieID;

                    PreparedStatement preparedStatement = dbConnect.prepareStatement(query);
                    preparedStatement.executeUpdate(query);
                    preparedStatement.close();

                    /*
                     * Statement statement = dbConnect.createStatement ();
                        statement.executeUpdate ("DELETE FROM AVAILABLE_FOOD WHERE Name = '" + foodName + "'" + " LIMIT 1");
                        initialAvailableFoodsList.remove (foodName);
                     */
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
        }
            //SQL
            // delete if Movie.movieID == deletedMovieID 
        // }        // NO NEED THIS PART
    }

    //getters for sql variables
    public String getDBURL() {
        return DBURL;
    }

    public String getUsername() {
        return USERNAME;
    }

    public String getPassword() {
        return PASSWORD;
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