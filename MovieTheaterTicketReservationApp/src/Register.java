import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends SQLController {
    String userEmail;
    String userPassword;
    String userFname;
    String userLname;
    String userCardNum = new String("");
    boolean isStaff = false;

    public Register(String uEmail, String uPW, String uFN, String uLN, String uCardNum) {
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        this.userEmail = uEmail;
        this.userPassword = uPW;
        this.userFname = uFN;
        this.userLname = uLN;
        this.userCardNum = uCardNum;
    }

    public boolean isUniqueEmail() {
        initializeConnection();
        try {
            String sql = "SELECT * FROM User WHERE email = ?";
            PreparedStatement p = this.dbConnection.prepareStatement(sql);
            p.setString(1, userEmail);
            ResultSet result = p.executeQuery();
            if(result.next()) {
                disconnectConnection();
                return false;
            } else {
                disconnectConnection();
                return true;
            }
        } catch (Exception e) {
            disconnectConnection();
            e.printStackTrace();
            return false;
        } 
    }

    public void setToStaff() {
        this.isStaff = true;
    }

    public void registerUser() {
        initializeConnection();
        String staff = isStaff ? "true" : "false";
        try {
            String sql = 
            "INSERT INTO User " + 
            "VALUES (?,?,?,?,?,?)";
            PreparedStatement p = this.dbConnection.prepareStatement(sql);
            p.setString(1, userEmail);
            p.setString(2, userPassword);
            p.setString(3, staff);
            p.setString(4, userFname);
            p.setString(5, userLname);
            p.setString(6, userCardNum);

            if(!(p.executeUpdate() > 0)) {
                throw new Exception("database did not register user");
            };
            disconnectConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
