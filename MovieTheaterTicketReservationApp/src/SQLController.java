import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;


// private final String DBURL = "jdbc:mysql://localhost/movie_theatres";
// private final String USERNAME = "ensf480";
// private final String PASSWORD = "ensf480";

public abstract class SQLController {
    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;
    protected Connection dbConnection;

    public SQLController(String dbURL, String userName, String userPassword){
        this.DBURL = dbURL;
        this.USERNAME = userName;
        this.PASSWORD = userPassword;
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
            dbConnection = DriverManager.getConnection (DBURL, USERNAME, PASSWORD);
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
            dbConnection.close ();
        } catch (SQLException e) {
            System.out.println ("Disconnection Failed! Check output console");
        }
    }

    
}
