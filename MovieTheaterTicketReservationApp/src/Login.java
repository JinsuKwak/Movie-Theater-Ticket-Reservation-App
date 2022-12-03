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
            String query = "SELECT * From Users WHERE email = " + enteredUserEmail+" AND password = "+enteredUserPW;
            PreparedStatement pStatement = this.dbConnection.prepareStatement(query);
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
            dbConnection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }   

        // pseudocode

        // result = JDBC.getResult();
        // if(result is notvalid){
        //     return isLoggedIn;
        // }
        
        // isLoggedIn = true;
        // if(result.isAdmin == true){
        //     this.isAdmin = true;
        //     this.user = new AdminUser(eneteredUserEmail, eneteredUserPW, result.fName, result.Lname, isAdmin);
        // } else {
        //     this.user = new RegisteredUser(eneteredUserEmail, eneteredUserPW, result.fName, result.Lname, isAdmin, eneteredUserPW)
        // }
        updateInstance();
        return isLoggedIn;
    }


    public void updateInstance(){
        this.loginInstance.changeStatus(user, isAdmin, isLoggedIn);
    }

}
