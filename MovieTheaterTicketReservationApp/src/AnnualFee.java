import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AnnualFee {
    //class variables
    private static int ANNUAL_FEE = 20;
    private ArrayList<User> allRegisteredUsers = new ArrayList<>();
    private final String DBURL = "jdbc:mysql://localhost/movie_theatres";
    private final String USERNAME = "ensf480";
    private final String PASSWORD = "ensf480";
    private Connection dbConnect;

    /**
     * send an annual Email to registered users about the annual fee
     * @param fee - fee annual fee to be paid by registered users
     * @param date - date to send the first email 
     */
    public void startAnnualFee(int fee, Date date) {
        AnnualFee.ANNUAL_FEE = fee;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
                    String sql = "SELECT * FROM User WHERE isAdmin=false";
                    PreparedStatement p = dbConnect.prepareStatement(sql);
                    ResultSet result = p.executeQuery();
                    while (result.next()) {
                        RegisteredUser user = new RegisteredUser(
                                result.getString("email"),
                                result.getString("password"),
                                result.getString("userFname"),
                                result.getString("userLname"),
                                Boolean.parseBoolean(result.getString("isAdmin")),
                                result.getString("cardNumber"));
                        allRegisteredUsers.add(user);
                    }
                    for (User user : allRegisteredUsers) {
                        String recipient = user.getUserEmail();
                        String subject = "Annual Fee";
                        String message = "Dear " + user.getUserFname() + user.getUserLname() + "\n"
                                + "your annual fee that is due at the beginning of each year is $" + ANNUAL_FEE;
                        Email.sendSubscription(recipient, subject, message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            };
        };
        Long duration = yearsToMillisSeconds(1); // convert 1 year into milliseconds
        timer.scheduleAtFixedRate(task, date, duration);
    }

    /**
     * a helper method to convert years to milli-seonds
     * @param year - the number of years to convert to milliseconds
     * @return - returns a long that represents the year in milliseconds
     */
    private long yearsToMillisSeconds(int year) {
        final long CONVERSION = 31536000000L; //1 year = 315360...L milliseconds
        return year * CONVERSION;
    }
}
