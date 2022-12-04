import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends SQLController {
    private String enteredUserEmail;
    private String enteredUserPW;
    private LoginInstance loginInstance;
    private User user;
    private boolean isAdmin;
    private boolean isLoggedIn = false;
    private ResultSet result;


    public Login(String uEmail, String uPW)
    {
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        this.enteredUserEmail = uEmail;
        this.enteredUserPW = uPW;
        this.loginInstance = LoginInstance.getInstance();
    }

    public boolean validate(){
        try{
            initializeConnection();
            String query = "SELECT * From Users WHERE email = ? AND password = ?";
            PreparedStatement pStatement = dbConnection.prepareStatement(query);
            pStatement.setString(1, enteredUserEmail);
            pStatement.setString(2, enteredUserPW);
            result = pStatement.executeQuery();

            if(!result.isBeforeFirst()){
                return false;
            } 

            isLoggedIn = true;
            while (result.next()){
                if(result.getString("isAdmin").equals("true")){
                    isAdmin = true;
                    user = new AdminUser(
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("userFname"),
                        result.getString("userLname"),
                        isAdmin
                    );
                } else {
                    isAdmin = false;
                    user = new RegisteredUser(
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("userFname"),
                        result.getString("userLname"),
                        isAdmin,
                        result.getString("cardNumber")
                    );
                }

            }
            result.close();
            pStatement.close();
            disconnectConnection();
    
        } catch (SQLException e){
            e.printStackTrace();
        }   
        
        updateInstance();
        return isLoggedIn;
    }


    public void updateInstance(){
        this.loginInstance.changeStatus(user, isAdmin, isLoggedIn);
    }

}
