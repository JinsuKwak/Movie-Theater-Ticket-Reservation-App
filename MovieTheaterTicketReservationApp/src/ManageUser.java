//control class
//maarya
import java.sql.*;
import java.sql.PreparedStatement;

public class ManageUser
{
    LoginInstance loginInstance;
    Register register;
    String deleteUserEmail;
    private final String DBURL = "jdbc:mysql://localhost/movie_theatres";
    private final String USERNAME = "ensf480";
    private final String PASSWORD = "ensf480";
    private final String TABLE_NAME = "Users";
    private Connection dbConnect;
    private ResultSet results;

    //constructor
    public ManageUser()
    {
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
        }
    }

    public void addUser(String uEmail, String uPW, String uFN, String uLN, boolean isStaff, String uCardNum)
    {
        if(loginInstance.getIsAdmin()){  // only executable when already logged as admin
            if(isStaff == true){
                uCardNum = new String("");
                register.setToStaff();
            }
            this.register = new Register(uEmail, uPW, uFN, uLN, uCardNum);
            register.registerUser();
        }
    }

    public void deleteUser(String uEmail) 
    {
        this.deleteUserEmail = uEmail;
        if(loginInstance.getIsAdmin())// only executable when already logged as admin
        {  
            // if(User.getUserEmail() == uEmail)
            // {
                try{
                    String query = "DELETE FROM movie_theatres WHERE email = " + uEmail;

                    PreparedStatement preparedStatement = dbConnect.prepareStatement(query);
                    preparedStatement.executeUpdate(query);
                    preparedStatement.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }}
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
