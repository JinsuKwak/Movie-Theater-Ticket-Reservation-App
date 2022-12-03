import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends SQLController {
    String userEmail;
    String userPassword;
    String userFname;
    String userLname;
    String userCardNum = new String("");
    boolean isStaff = false;
    private ResultSet result;

    public Register(String uEmail, String uPW, String uFN, String uLN, String uCardNum) {
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        this.userEmail = uEmail;
        this.userPassword = uPW;
        this.userFname = uFN;
        this.userLname = uLN;
        this.userCardNum = uCardNum;
    }

    public boolean isUniqueEmail() {
        try {
            // SQL
            String sql = "SELECT * FROM Users WHERE email =?";
            PreparedStatement p = this.dbConnection.prepareStatement(sql);
            p.setString(1, userEmail);
            ResultSet result = p.executeQuery();
            if(result.next()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    public void setToStaff() {
        this.isStaff = true;
    }

    public void registerUser() {
        try {
            // SQL
            String sql = 
            "INSERT INTO USERS" + 
            "VALUES (?,?,?,?,?,?)";
            PreparedStatement p = this.dbConnection.prepareStatement(sql);
            p.setString(1, userEmail);
            p.setString(2, userPassword);
            p.setString(3, userFname);
            p.setString(4, userLname);
            p.setString(3, String.valueOf(isStaff));
            p.setString(6, userCardNum);

            if(!(p.executeUpdate() > 0)) {
                throw new Exception("database did not register user");
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
