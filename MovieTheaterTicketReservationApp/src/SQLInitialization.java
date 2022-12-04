import java.sql.*;

public class SQLInitialization 
{
    private final String DBURL = "jdbc:mysql://localhost/movie_theatres";
    private final String USERNAME = "ensf480";
    private final String PASSWORD = "ensf480";
    private String TABLE_NAME;
    private Connection dbConnect;
    private ResultSet results;

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
        }
    }

    
}
