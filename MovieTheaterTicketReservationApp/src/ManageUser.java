//control class
//maarya
import java.sql.*;
import java.sql.PreparedStatement;

public class ManageUser extends SQLController
{
    LoginInstance loginInstance;
    Register register;
    String deleteUserEmail;
    private final String TABLE_NAME = "User";
    private Connection dbConnect;
    private ResultSet results;

    //constructor
    public ManageUser()
    {   
        super("jdbc:mysql://localhost/movie_theatres","ensf480","ensf480");
        this.loginInstance = LoginInstance.getInstance();
        initializeDriver();
        initializeConnection();
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
