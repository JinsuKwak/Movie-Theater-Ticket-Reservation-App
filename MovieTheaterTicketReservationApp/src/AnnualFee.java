import java.sql.Date;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;

public class AnnualFee {
    private static int ANNUAL_FEE = 20;
    private ArrayList<User> allRegisteredUsers;


    public AnnualFee(ArrayList<User> allRegisteredUsers) {
        this.allRegisteredUsers = allRegisteredUsers;
    }

    public void startAnnualFee(int fee, Date date) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            // load all RU, check user != Admin
            @Override
            public void run() {
                processPayment();
            }
        };
        Long duration = yearsToMillisSeconds(1); //convert 1 year into milliseconds
        timer.scheduleAtFixedRate(task, date, duration );
    }

    private long yearsToMillisSeconds(int year) {
        long convertion = 31536000000L;
        return year * convertion;
    }


    private void processPayment() {
        for(User user : allRegisteredUsers) {
            Email.sendSubscription(username, amount);
        }
    }



}
