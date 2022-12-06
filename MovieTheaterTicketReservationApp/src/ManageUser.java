/**
 * maarya, jinsu, nour, neil
 * ENSF 480 Project
 * ManageUser.java
 * 
 */
import java.sql.*;
import java.sql.PreparedStatement;

public class ManageUser extends SQLController
{
    //class variables
    LoginInstance loginInstance;
    Register register;
    String deleteUserEmail;
    private final String TABLE_NAME = "User";
    private ResultSet results;

    //constructor
    public ManageUser()
    {   
        super("jdbc:mysql://localhost/movie_theatres","ensf480","ensf480");
        this.loginInstance = LoginInstance.getInstance();
    }

    /**
     * addUser method
     * @param register
     * @param isStaff
     */
    public void addUser(Register register, boolean isStaff)
    {       
        this.register = register;   
        initializeConnection();
        if(loginInstance.getIsAdmin()){  // only executable when already logged as admin
            if(isStaff == true){
                register.setToStaff();
            }
            register.registerUser();
        }
        disconnectConnection();
    }

    /**
     * deleteUser
     * @param uEmail
     * @throws SQLException
     */
    public void deleteUser(String uEmail) throws SQLException
    {
        initializeConnection();
        if(loginInstance.getIsAdmin())// only executable when already logged as admin
        {  
            String query = "DELETE FROM User WHERE email = ?";
            PreparedStatement pStatement = dbConnection.prepareStatement(query);
            pStatement.setString(1, uEmail);
            pStatement.executeUpdate(query);

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
        return dbConnection;
    }
    /**
     * 
     * @return
     */
    public ResultSet getResults() {
        return results;
    }

}
